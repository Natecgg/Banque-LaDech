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
        String sql = "select * from client where mail=? AND password=?";
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
        String sql = "insert into client (nom, prenom, mail, password) VALUES (?,?,?,?)";
        Connection connexion = ConnectDb.getConnection();
        
        PreparedStatement requette = connexion.prepareStatement(sql);
        
        requette.setString(1, cl.getNom());
        requette.setString(1, cl.getPrenom());
        requette.setString(1, cl.getMail());
        requette.setString(1, cl.getMdp());
        
        requette.execute();
  
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
