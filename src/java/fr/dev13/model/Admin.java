/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.dev13.model;

import java.sql.Date;

/**
 *
 * @author ESIC
 */
public class Admin {
    
    private int id;
    private String mail;
    private String mdp;
    private Date derniereConnexion;
    

    public Admin() {
    }

    public Admin(int id, String mail, String mdp, Date derniereConnexion) {
        this.id = id;
        this.mail = mail;
        this.mdp = mdp;
        this.derniereConnexion = derniereConnexion;
       
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public Date getDerniereConnexion() {
        return derniereConnexion;
    }

    public void setDerniereConnexion(Date derniereConnexion) {
        this.derniereConnexion = derniereConnexion;
    }
    
    
}
