/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.dev13.dao;
import fr.dev13.model.Client;
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
        }
        
        return cl;
    }
    
    public static void insert(Client cl) throws SQLException{
        String sql = "insert into client (nom, prenom, mail, mdp) VALUES (?,?,?,?)";
        Connection connexion = ConnectDb.getConnection();
        
        PreparedStatement requette = connexion.prepareStatement(sql);
        
        requette.setString(1, cl.getNom());
        requette.setString(2, cl.getPrenom());
        requette.setString(3, cl.getMail());
        requette.setString(4, cl.getMdp());
        
        requette.execute();
  
    }
    
    
    
    public static void virement(int idCompteCrediteur, Client debiteur, double montant) throws SQLException{
        String sql1 = "SELECT compteActif, solde, demandeDecouvert FROM compte_bancaire WHERE idcompteBancaire ?;";
        String sql2 = "SELECT solde FROM compte_bancaire WHERE idcompteBancaire = ?;";
        String sql3 = "UPDATE compte_bancaire SET solde = ? WHERE (idcompteBancaire = ?); UPDATE compte_bancaire SET solde = ? WHERE (idcompteBancaire = ?);";

        Connection connexion = ConnectDb.getConnection();
        
        PreparedStatement requette = connexion.prepareStatement(sql1);
        
        requette.setInt(1, debiteur.getIdCompteBancaire());     
        requette.execute();
        
        double soldeDebiteur=0;
        double decouvertDebiteur=0;
        double soldeCrediteur=0;
        int actifDebiteur=0;
        
        ResultSet rs = requette.executeQuery();
        
        if(rs.next()){
                soldeDebiteur = rs.getDouble("solde");
                decouvertDebiteur = rs.getDouble("demandeDecouvert");
                actifDebiteur = rs.getInt("compteActif");
        }
        
        if(actifDebiteur==0){
            
        }
        else if (soldeDebiteur-montant<-decouvertDebiteur){
            
        }
        else{
            requette = connexion.prepareStatement(sql2);
            requette.setInt(1, idCompteCrediteur); 
            requette.execute();
            if(rs.next()){
                soldeCrediteur = rs.getDouble("solde");
            }
            requette = connexion.prepareStatement(sql3);
            requette.setDouble(1, soldeDebiteur-montant); 
            requette.setInt(2, debiteur.getId());
            requette.setDouble(3, soldeCrediteur+montant);
            requette.setInt(4, idCompteCrediteur);
            requette.execute();
        }

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
}
