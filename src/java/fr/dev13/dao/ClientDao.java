/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.dev13.dao;
import fr.dev13.model.Client;
import fr.dev13.model.Operation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ESIC
 */
public class ClientDao {
    public static Client getByLoginPass(String login, String mdp) throws SQLException {
        Client cl = null;
        String sql = "select * from client where mail=? AND mdp=?";
        Connection connexion = ConnectDb.getConnection();
        PreparedStatement requette = connexion.prepareStatement(sql);
        requette.setString(1, login);
        requette.setString(2, mdp);
        
        ResultSet rs = requette.executeQuery();
        
        if(rs.next()){
                cl = new Client();
                cl.setId(rs.getInt("idclient"));
                cl.setNom(rs.getString("nom"));
                cl.setPrenom(rs.getString("prenom"));
                cl.setMail(rs.getString("mail"));
                java.sql.Date dateSql = rs.getDate("derniereConnexion");
                cl.setDerniereConnexion(dateSql);
                cl.setIdCompteBancaire(rs.getInt("idcompteBancaire"));
                cl.setIdConseiller(rs.getInt("idconseiller"));
        }
        
        return cl;
    }
    
    public static Client creerClient(Client cl, double solde) throws SQLException{
        String sql = "insert into client (nom, prenom, mail, mdp, idconseiller, idcompteBancaire) VALUES (?,?,?,?,?)"; // le mail est unique donc si le client existe déjà la bd renverra une exception
        Connection connexion = ConnectDb.getConnection();
        
        PreparedStatement requette = connexion.prepareStatement(sql);
        
        requette.setString(1, cl.getNom());
        requette.setString(2, cl.getPrenom());
        requette.setString(3, cl.getMail());
        requette.setString(4, cl.getMdp());
        requette.setInt(5, cl.getIdConseiller());
        requette.setInt(5, 0);
        
        requette.execute();
        
        sql = "insert into compte_bancaire (solde, compteActif, carteActive, demandeDecouvert) VALUES (?,?,?,?)";
        requette = connexion.prepareStatement(sql);
        requette.setDouble(1,solde);
        requette.setInt(2, 1);
        requette.setInt(3, 0);
        requette.setDouble(4, 0);
        
        sql = "SELECT idcompteBancaire FROM compte_bancaire WHERE idcompteBancaire = LAST_INSERT_ID()";
        Statement requete2 = connexion.createStatement();
        ResultSet rs = requete2.executeQuery(sql);
        
        int idcompteBancaire= rs.getInt("idcompteBancaire");
        sql = "UPDATE client SET idcompteBancaire = ? WHERE mail = ?;";
        requette = connexion.prepareStatement(sql);
        requette.setInt(1, idcompteBancaire);
        requette.setString(2, cl.getMail());
        requette.execute();
        
        cl.setIdCompteBancaire(idcompteBancaire);
        return(cl);

    }
    
    public static void deconnexion(Client cl) throws SQLException{
        
        String sql = "UPDATE client SET derniereConnexion = CURRENT_TIMESTAMP WHERE idclient = ?";
        Connection connexion = ConnectDb.getConnection();
        PreparedStatement requete = connexion.prepareStatement(sql);
        requete.setInt(1, cl.getId());
        requete.executeQuery();
        
    }
    
    public static java.util.Date getDerniereConnexion(Client cl) throws SQLException{
        String sql = "select derniereConnexion from client WHERE idclient = ?";
        Connection connexion = ConnectDb.getConnection();
        PreparedStatement requete = connexion.prepareStatement(sql);
        requete.setInt(1, cl.getId());
        ResultSet rs = requete.executeQuery();
        
        java.sql.Date dateSql = rs.getDate("derniereConnexion");
        java.util.Date dateJava = DateManagement.dateSql2Java(dateSql);
        return(dateJava);
    }
    
    public static int virement(int idCompteCrediteur, Client debiteur, double montant) throws SQLException{
        // la fonction renvoie 0 si le virement a bien été effectué, renvoie 1 si le compte du client est bloqué, renvoie 2 si le client ne dsipose pas de suffisamment de fonds
        // renvoie 3 si le com)pte à créditer n'a pas été trouvé
        String sql1 = "SELECT compteActif, solde, demandeDecouvert FROM compte_bancaire WHERE idcompteBancaire ?;";
        String sql2 = "SELECT solde FROM compte_bancaire WHERE idcompteBancaire = ?;";
        String sql3 = "UPDATE compte_bancaire SET solde = ? WHERE idcompteBancaire = ?; UPDATE compte_bancaire SET solde = ? WHERE idcompteBancaire = ?;";

        Connection connexion = ConnectDb.getConnection();
        
        PreparedStatement requette = connexion.prepareStatement(sql1);
        
        requette.setInt(1, debiteur.getIdCompteBancaire());     
        requette.execute();
        
        double soldeDebiteur=0;
        double decouvertDebiteur=0;
        double soldeCrediteur=0;
        int actifDebiteur=0;
        
        ResultSet rs = requette.executeQuery();
        
        soldeDebiteur = rs.getDouble("solde");
        decouvertDebiteur = rs.getDouble("demandeDecouvert");
        actifDebiteur = rs.getInt("compteActif");

        
        if(actifDebiteur==0){
            return 1;
        }
        else if (soldeDebiteur-montant<-decouvertDebiteur){
            return 2;
        }
        else{
            requette = connexion.prepareStatement(sql2);
            requette.setInt(1, idCompteCrediteur); 
            requette.execute();
            if (rs.next()){  
            soldeCrediteur = rs.getDouble("solde");
            requette = connexion.prepareStatement(sql3);
            requette.setDouble(1, soldeDebiteur-montant); 
            requette.setInt(2, debiteur.getIdCompteBancaire());
            requette.setDouble(3, soldeCrediteur+montant);
            requette.setInt(4, idCompteCrediteur);
            requette.execute();
            
            sql1 = "INSERT INTO operation (libelle, beneficiaire, montant-operation, idcompte_bancaire) VALUES" +
                  "(virement, ?, ?, ?)" ;
            requette = connexion.prepareStatement(sql1);
            requette.setInt(1, idCompteCrediteur); 
            requette.setDouble(2, montant); 
            requette.setInt(3, debiteur.getIdCompteBancaire()); 
            
            return 0;
            }
            else{
                return 3;
            }
        }

    }
    
    public static int retrait(Client debiteur, double montant) throws SQLException{
        // la fonction renvoie 0 si le virement a bien été effectué, renvoie 1 si le compte du client est bloqué, renvoie 2 si le client ne dsipose pas de suffisamment de fonds
        String sql1 = "SELECT compteActif, solde, demandeDecouvert FROM compte_bancaire WHERE idcompteBancaire ?;";
        String sql2 = "UPDATE compte_bancaire SET solde = ? WHERE idcompteBancaire = ?";

        Connection connexion = ConnectDb.getConnection();
        
        PreparedStatement requette = connexion.prepareStatement(sql1);
        
        requette.setInt(1, debiteur.getIdCompteBancaire());     
        requette.execute();
        
        double soldeDebiteur=0;
        double decouvertDebiteur=0;
        int actifDebiteur=0;
        
        ResultSet rs = requette.executeQuery();
        
        soldeDebiteur = rs.getDouble("solde");
        decouvertDebiteur = rs.getDouble("demandeDecouvert");
        actifDebiteur = rs.getInt("compteActif");

        if(actifDebiteur==0){
            return 1;
        }
        else if (soldeDebiteur-montant<-decouvertDebiteur){
            return 2;
        }
        else{ 
            requette = connexion.prepareStatement(sql2);
            requette.setDouble(1, soldeDebiteur-montant); 
            requette.setInt(2, debiteur.getIdCompteBancaire());
            requette.execute();
            
            sql1 = "INSERT INTO operation (libelle, montant-operation, idcompte_bancaire) VALUES" +
                  "(retrait, ?, ?, ?)" ;
            requette = connexion.prepareStatement(sql1); 
            requette.setDouble(1, montant); 
            requette.setInt(2, debiteur.getIdCompteBancaire()); 
            
            return 0;
            }

    }
    
    public static void depot(Client debiteur, double montant) throws SQLException{
        String sql = "UPDATE compte_bancaire SET solde = solde + ? WHERE idcompteBancaire = ?";

        Connection connexion = ConnectDb.getConnection();
        
        PreparedStatement requette = connexion.prepareStatement(sql);
        
        requette.setDouble(1, montant);     
        requette.setInt(2, debiteur.getIdCompteBancaire());  
        requette.execute();
        
        sql = "INSERT INTO operation (libelle, montant-operation, idcompte_bancaire) VALUES" +
                  "(dépôt, ?, ?)" ;
        requette = connexion.prepareStatement(sql);
        requette.setDouble(1, montant); 
        requette.setInt(2, debiteur.getIdCompteBancaire()); 

    }
    
    public static List<Operation> getHistorique(Client cl) throws SQLException {
        List<Operation> historique = new ArrayList<>();
        Connection connexion = ConnectDb.getConnection();
        String sql = "SELECT * FROM operation WHERE idcompteBancaire=? ORDER BY date_operation";
        PreparedStatement requette = connexion.prepareStatement(sql);
        requette.setInt(1, cl.getIdCompteBancaire());
        ResultSet rs = requette.executeQuery(sql);
        
        while(rs.next()){
            Operation o = new Operation();
            o.setId(rs.getInt("idoperation"));    
            o.setLibelle(rs.getString("libelle"));
            o.setIdCompteBancaire(rs.getInt("idcompteBancaire"));
            java.sql.Date dateSql = rs.getDate("date_operation");
            o.setDateOperation(dateSql);
            o.setMontantOperation(rs.getDouble("montant_operation"));
            o.setIdBeneficiaire(rs.getInt("beneficiaire"));
            historique.add(o);
        }
        return historique;
    }
 
    
    public static List<Client> getAllClients() throws SQLException {
        List<Client> clients = new ArrayList<>();
        Connection connexion = ConnectDb.getConnection();
        String sql = "select * from client";
        Statement requette = connexion.createStatement();
        ResultSet rs = requette.executeQuery(sql);
        
        
        while(rs.next()){
            Client cl = new Client();
            cl.setId(rs.getInt("idclient"));
            cl.setNom(rs.getString("nom"));
            cl.setPrenom(rs.getString("prenom"));
            cl.setMail(rs.getString("mail"));
            clients.add(cl);
        }
        return clients;
    }

    public static double solde(Client cl) throws SQLException {
        String sql = "SELECT solde FROM compte_bancaire WHERE idcompteBancaire = ?";

        Connection connexion = ConnectDb.getConnection();
        
        PreparedStatement requette = connexion.prepareStatement(sql);
        
        requette.setInt(1, cl.getIdCompteBancaire());      
        
        cl.getIdCompteBancaire();
        
        ResultSet rs = requette.executeQuery();
        double solde = rs.getDouble("solde");
        
        return solde;
        
    }

}

//User u = null;
//        String sql = "select * from personne where login=? AND password=?";
//        Connection connexion = ConnectDb.getConnection();
//        PreparedStatement requette = connexion.prepareStatement(sql);
//        requette.setString(1, login);
//        requette.setString(2, mdp);
//        
//        ResultSet rs = requette.executeQuery();
//        
//        if(rs.next()){
//                u = new User();
//                u.setId(rs.getInt("idpersonne"));
//                u.setNom(rs.getString("nom"));
//                u.setPrenom(rs.getString("prenom"));
//                u.setMail(rs.getString("mail"));
//        }
//        
//        return u;
