/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.dev13.dao;

import fr.dev13.model.Admin;
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
public class AdministrateurDao {
    public static Admin getByLoginPass(String login, String mdp) throws SQLException {
        Admin a = null;
        String sql = "select * from admin where mail=? AND mdp=?";
        Connection connexion = ConnectDb.getConnection();
        PreparedStatement requette = connexion.prepareStatement(sql);
        requette.setString(1, login);
        requette.setString(2, mdp);
        
        ResultSet rs = requette.executeQuery();
        
        if(rs.next()){
                a = new Admin();
                a.setId(rs.getInt("idadmin"));
                a.setMail(rs.getString("mail"));
        }
        
        return a;
    }
    
    public static void insert(Admin a) throws SQLException{
        String sql = "insert into admin (mail, mdp) VALUES (?,?,?,?)";
        Connection connexion = ConnectDb.getConnection();
        
        PreparedStatement requette = connexion.prepareStatement(sql);
       
        requette.setString(1, a.getMail());
        requette.setString(2, a.getMdp());
        
        requette.execute();
  
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
    
    public static void deconnexion(Admin a) throws SQLException{
        
        String sql = "UPDATE admin SET derniereConnexion = CURRENT_TIMESTAMP WHERE idadmin = ?";
        Connection connexion = ConnectDb.getConnection();
        PreparedStatement requete = connexion.prepareStatement(sql);
        requete.setInt(1, a.getId());
        requete.executeQuery();
        
    }
    
    public static java.util.Date getDerniereConnexion(Admin a) throws SQLException{
        String sql = "select derniereConnexion from admin WHERE idadmin = ?";
        Connection connexion = ConnectDb.getConnection();
        PreparedStatement requete = connexion.prepareStatement(sql);
        requete.setInt(1, a.getId());
        ResultSet rs = requete.executeQuery();
        
        java.sql.Date dateSql = rs.getDate("derniereConnexion");
        java.util.Date dateJava = DateManagement.dateSql2Java(dateSql);
        return(dateJava);
    }
    
    public static List<Admin> getAllAdministrateurs() throws SQLException {
        List<Admin> admins = new ArrayList<>();
        Connection connexion = ConnectDb.getConnection();
        String sql = "select * from admin";
        Statement requette = connexion.createStatement();
        ResultSet rs = requette.executeQuery(sql);
        
        
        while(rs.next()){
            Admin a = new Admin();
            a.setId(rs.getInt("idadmin"));
            a.setMail(rs.getString("mail"));
            admins.add(a);
        }
        return admins;
    }
}
