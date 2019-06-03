/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.dev13.dao;

import fr.dev13.model.Administrateur;
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
    public static Administrateur getByLoginPass(String login, String mdp) throws SQLException {
        Administrateur a = null;
        String sql = "select * from admin where mail=? AND password=?";
        Connection connexion = ConnectDb.getConnection();
        PreparedStatement requette = connexion.prepareStatement(sql);
        requette.setString(1, login);
        requette.setString(2, mdp);
        
        ResultSet rs = requette.executeQuery();
        
        if(rs.next()){
                a = new Administrateur();
                a.setId(rs.getInt("idAdmin"));
                a.setNom(rs.getString("nom"));
                a.setPrenom(rs.getString("prenom"));
                a.setMail(rs.getString("mail"));
        }
        
        return a;
    }
    
    public static void insert(Administrateur a) throws SQLException{
        String sql = "insert into admin (nom, prenom, mail, password) VALUES (?,?,?,?)";
        Connection connexion = ConnectDb.getConnection();
        
        PreparedStatement requette = connexion.prepareStatement(sql);
        
        requette.setString(1, a.getNom());
        requette.setString(1, a.getPrenom());
        requette.setString(1, a.getMail());
        requette.setString(1, a.getMdp());
        
        requette.execute();
  
    }
    
    public static List<Administrateur> getAllAdministrateurs() throws SQLException {
        List<Administrateur> admins = new ArrayList<>();
        Connection connexion = ConnectDb.getConnection();
        String sql = "select * from admin";
        Statement requette = connexion.createStatement();
        ResultSet rs = requette.executeQuery(sql);
        
        
        while(rs.next()){
            Administrateur a = new Administrateur();
            a.setId(rs.getInt("idAdmin"));
            a.setNom(rs.getString("nom"));
            a.setPrenom(rs.getString("prenom"));
            a.setMail(rs.getString("mail"));
            admins.add(a);
        }
        return admins;
    }
}
