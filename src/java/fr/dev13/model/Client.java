/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.dev13.model;

/**
 *
 * @author ESIC
 */
public class Client {

    private String nom;
    private String prenom;
    private String mail;
    private int id;
    private String mdp;
    private int idConseiller;
    
    public Client(){
    }
    
    public Client(int id, String nom, String prenom, String mail, int idConseiller){
        this.id=id;
        this.mail=mail;
        this.nom=nom;
        this.prenom=prenom;
        this.idConseiller=idConseiller;
    }
    
    
    public Client(String nom, String prenom, String mail, String mdp){
        this.mdp=mdp;
        this.mail=mail;
        this.nom=nom;
        this.prenom=prenom;
    }

    public int getIdConseiller() {
        return idConseiller;
    }

    public void setIdConseiller(int idConseiller) {
        this.idConseiller = idConseiller;
    }
     
    public void setMail(String string) {
        mail = string;
    }

    public void setNom(String string) {
        nom = string;
    }

    public void setPrenom(String string) {
        prenom = string;
    }

    public void setId(int aInt) {
        id = aInt;
    }

    public String getNom() {
        return nom;
    }
    
    public void setMdp(String string) {
        mdp = string;
    }

    public String getMdp() {
        return mdp;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getMail() {
        return mail;
    }

    public int getId() {
        return id;
    }
    
    public String infoCleint() {
        return("Je m'appelle "+prenom+" "+nom+".");
    }
    
}
