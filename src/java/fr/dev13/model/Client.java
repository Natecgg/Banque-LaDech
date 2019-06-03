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
public class Client {

    private int id;
    private String nom;
    private String prenom;
    private String mail;
    private String mdp;
    private int idConseiller;
    private int idCompteBancaire;
    private Date derniereConnexion;
    
    
    public Client(){
    }
    
    public Client(int id, String nom, String prenom, String mail, int idConseiller,int idCompteBancaire, Date derniereConnexion){
        this.id=id;
        this.mail=mail;
        this.nom=nom;
        this.prenom=prenom;
        this.idConseiller=idConseiller;
        this.idCompteBancaire = idCompteBancaire;
        this.derniereConnexion=derniereConnexion;
        
    }
    
    
    public Client(String nom, String prenom, String mail, String mdp){
        this.mdp=mdp;
        this.mail=mail;
        this.nom=nom;
        this.prenom=prenom;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getNom() {
        return nom;
    }
    
    public void setNom(String string) {
        nom = string;
    }
    
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String string) {
        prenom = string;
    }
    
    public String getMail() {
        return mail;
    }
    
    public void setMail(String string) {
        mail = string;
            
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

    public int getIdCompteBancaire() {
        return idCompteBancaire;
    }

    public void setIdCompteBancaire(int idCompteBancaire) {
        this.idCompteBancaire = idCompteBancaire;
    }
    public int getIdConseiller() {
        return idConseiller;
    }

    public void setIdConseiller(int idConseiller) {
        this.idConseiller = idConseiller;
    }
     
    
    public String infoClient() {
        return("Je m'appelle "+prenom+" "+nom+".");
    }

    
    
}
