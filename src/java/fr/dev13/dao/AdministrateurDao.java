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
        Administrateur u = null;
        String sql = "select * from personne where mail=? AND password=?";
        Connection connexion = ConnectDb.getConnection();
        PreparedStatement requette = connexion.prepareStatement(sql);
        requette.setString(1, login);
        requette.setString(2, mdp);
        
        ResultSet rs = requette.executeQuery();
        
        if(rs.next()){
                u = new Administrateur();
                u.setId(rs.getInt("idpersonne"));
                u.setNom(rs.getString("nom"));
                u.setPrenom(rs.getString("prenom"));
                u.setMail(rs.getString("mail"));
        }
        
        return u;
    }
    
    public static void insert(Administrateur u) throws SQLException{
        String sql = "insert into person (nom, prenom, mail, mdp) VALUES (?,?,?,?)";
        Connection connexion = ConnectDb.getConnection();
        
        PreparedStatement requette = connexion.prepareStatement(sql);
        
        requette.setString(1, u.getNom());
        requette.setString(1, u.getPrenom());
        requette.setString(1, u.getMail());
        requette.setString(1, u.getMdp());
        
        requette.execute();
  
    }
    
    public static List<Administrateur> getAllAdministrateurs() throws SQLException {
        List<Administrateur> users = new ArrayList<>();
        Connection connexion = ConnectDb.getConnection();
        String sql = "select * from personne";
        Statement requette = connexion.createStatement();
        ResultSet rs = requette.executeQuery(sql);
        
        
        while(rs.next()){
            Administrateur u = new Administrateur();
            u.setId(rs.getInt("idpersonne"));
            u.setNom(rs.getString("nom"));
            u.setPrenom(rs.getString("prenom"));
            u.setMail(rs.getString("mail"));
            users.add(u);
        }
        return users;
    }
}
