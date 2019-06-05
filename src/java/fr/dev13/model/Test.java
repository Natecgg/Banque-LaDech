/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.dev13.model;
import fr.dev13.model.Client;
import fr.dev13.dao.ClientDao;
import javax.swing.JOptionPane;

/**
 *
 * @author ESIC
 */
public class Test {

String login="marie@gmail.com";
String mdp="marie";
    
Client c = ClientDao.getByLoginPass(login,mdp);
   
if (c!=null){
            System.out.println(c.infoClient());
    
} else {
    System.out.println("La BD ne marche pas");
}
}
