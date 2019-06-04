/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.dev13.dao;

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
                java.sql.Date dateSql = rs.getDate("derniereconnexion");
                c.setDerniereConnexion(dateSql);
        }
        
        return c;
    }
    
    public static java.util.Date dateSql2Java(java.sql.Date dateSql){
        java.util.Date dateJava;
        if (dateSql==null)
             dateJava = null;
        else{
            dateJava = new java.util.Date(dateSql.getTime());
        }
        return dateJava;
    }
    
    
    public static void activerDesactiverCompte(int idClient, int actif) throws SQLException{
        String sql = "UPDATE compte_bancaire SET compteActif = ? WHERE (idcompteBancaire = (SELECT idCompteBancaire FROM client WHERE idclient=?;";
        Connection connexion = ConnectDb.getConnection();
        
        PreparedStatement requette = connexion.prepareStatement(sql);
        
        requette.setInt(1, actif);
        requette.setInt(2, idClient);
        
        requette.execute();
  
    }
    
    public static void activerDesactiverCarte(int idClient, int actif) throws SQLException{
        String sql = "UPDATE compte_bancaire SET carteActive = ? WHERE (idcompteBancaire = (SELECT idCompteBancaire FROM client WHERE idclient=?;";
        Connection connexion = ConnectDb.getConnection();
        
        PreparedStatement requette = connexion.prepareStatement(sql);
        
        requette.setInt(1, actif);
        requette.setInt(2, idClient);
        
        requette.execute();
  
    }
    
    public static void insert(Conseiller c) throws SQLException{
        String sql = "insert into conseiller (nom, prenom, mail, mdp) VALUES (?,?,?,?)";
        Connection connexion = ConnectDb.getConnection();
        
        PreparedStatement requette = connexion.prepareStatement(sql);
        
        requette.setString(1, c.getNom());
        requette.setString(2, c.getPrenom());
        requette.setString(3, c.getMail());
        requette.setString(4, c.getMdp());
        
        requette.execute();
  
    }
    
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
}
