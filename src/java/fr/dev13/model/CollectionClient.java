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
public class CollectionClient {
    public String nom;
    public String prenom;
    public String mail;
    public Double solde;
    public int idcompteBancaire;

    public CollectionClient(String nom, String prenom, String mail, Double solde, int idcompteBancaire) {
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.solde = solde;
        this.idcompteBancaire = idcompteBancaire;
    }

}
