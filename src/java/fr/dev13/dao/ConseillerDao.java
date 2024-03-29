/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.dev13.dao;

import fr.dev13.model.CollectionClient;
import fr.dev13.model.Conseiller;
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
public class ConseillerDao {
    
 /*Récupère les données lors de la connexion d'un conseiller*/
    public static Conseiller getByLoginPass(String login, String mdp) throws SQLException {
        Conseiller c = null;
        String sql = "select * from conseiller where mail=? AND mdp=?";
        Connection connexion = ConnectDb.getConnection();
        PreparedStatement requette = connexion.prepareStatement(sql);
        requette.setString(1, login);
        requette.setString(2, mdp);
        
        ResultSet rs = requette.executeQuery();
        
        if(rs.next()){
                c = new Conseiller();
                c.setId(rs.getInt("idconseiller"));
                c.setNom(rs.getString("nom"));
                c.setPrenom(rs.getString("prenom"));
                c.setMail(rs.getString("mail"));
                java.sql.Date dateSql = rs.getDate("derniereConnexion");
                c.setDerniereConnexion(dateSql);
        }
        
        return c;
    }
 
    
    
    public static void activerDesactiverCompte(int idClient, int actif) throws SQLException{
        String sql = "UPDATE compte_bancaire SET compteActif = ? WHERE idcompteBancaire = (SELECT idCompteBancaire FROM client WHERE idclient=?) as a;";
        Connection connexion = ConnectDb.getConnection();
        
        PreparedStatement requette = connexion.prepareStatement(sql);
        
        requette.setInt(1, actif);
        requette.setInt(2, idClient);
        
        requette.execute();
  
    }
    
    public static void activerDesactiverCarte(int idClient, int actif) throws SQLException{
        String sql = "UPDATE compte_bancaire SET carteActive = ? WHERE idcompteBancaire = (SELECT idCompteBancaire FROM client WHERE idclient=?) as a;";
        Connection connexion = ConnectDb.getConnection();
        
        PreparedStatement requette = connexion.prepareStatement(sql);
        
        requette.setInt(1, actif);
        requette.setInt(2, idClient);
        
        requette.execute();
  
    }
    
    public static void deconnexion(Conseiller c) throws SQLException{
        
        String sql = "UPDATE conseiller SET derniereConnexion = CURRENT_TIMESTAMP WHERE idconseiller = ?";
        Connection connexion = ConnectDb.getConnection();
        PreparedStatement requete = connexion.prepareStatement(sql);
        requete.setInt(1, c.getId());
        requete.executeQuery();
        
    }
    
    public static java.util.Date getDerniereConnexion(Conseiller c) throws SQLException{
        String sql = "select derniereConnexion from conseiller WHERE idconseiller = ?";
        Connection connexion = ConnectDb.getConnection();
        PreparedStatement requete = connexion.prepareStatement(sql);
        requete.setInt(1, c.getId());
        ResultSet rs = requete.executeQuery();
        
        java.util.Date dateJava = null;
        
        if (rs.next()){
            java.sql.Date dateSql = rs.getDate("derniereConnexion");
            dateJava = DateManagement.dateSql2Java(dateSql);
        }
            
        return(dateJava);
    }
    
    public static void autoriserDecouvert(int idClient, double montantAutorise) throws SQLException{
        String sql = "UPDATE compte_bancaire SET demandeDecouvert = ? WHERE idcompteBancaire = (SELECT idCompteBancaire FROM client WHERE idclient=?) as a;";
        Connection connexion = ConnectDb.getConnection();
        
        PreparedStatement requette = connexion.prepareStatement(sql);
        
        requette.setDouble(1, montantAutorise);
        requette.setInt(2, idClient);
        
        requette.execute();
  
    }
    
    public static void creerConseiller(Conseiller c) throws SQLException{
        String sql = "insert into conseiller (nom, prenom, mail, mdp) VALUES (?,?,?,?)";
        Connection connexion = ConnectDb.getConnection();
        
        PreparedStatement requette = connexion.prepareStatement(sql);
        
        requette.setString(1, c.getNom());
        requette.setString(2, c.getPrenom());
        requette.setString(3, c.getMail());
        requette.setString(4, c.getMdp());
        
        requette.execute();
  
    }
  
/*Récupère la liste de tous les conseillers*/
    public static List<Conseiller> getAllConseillers() throws SQLException {
        List<Conseiller> conseillers = new ArrayList<>();
        Connection connexion = ConnectDb.getConnection();
        String sql = "select * from conseiller";
        Statement requette = connexion.createStatement();
        ResultSet rs = requette.executeQuery(sql);
        
        
        while(rs.next()){
            Conseiller c = new Conseiller();
            c.setId(rs.getInt("idconseiller"));
            c.setNom(rs.getString("nom"));
            c.setPrenom(rs.getString("prenom"));
            c.setMail(rs.getString("mail"));
            conseillers.add(c);
        }
        return conseillers;
    }
    
        public static List<CollectionClient> getClientsOfConseiller(Conseiller c) throws SQLException {
        List<CollectionClient> collectionClients = new ArrayList<>();
        Connection connexion = ConnectDb.getConnection();
        String sql = "SELECT nom, prenom, solde, mail, idcompteBancaire FROM client INNER JOIN compte_bancaire ON client.idcompteBancaire=compte_bancaire.idcompteBancaire";
        Statement requette = connexion.createStatement();
        ResultSet rs = requette.executeQuery(sql);
        
        while(rs.next()){
            CollectionClient cl = new CollectionClient(rs.getString("nom"), rs.getString("prenom"), rs.getString("mail"), rs.getDouble("solde"), rs.getInt("idcompteBancaire"));
            collectionClients.add(cl);
        }
        
        return collectionClients;
        
        }
}
