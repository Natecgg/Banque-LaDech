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
public class CompteBancaire {
    
    private int id;
    private double solde;
    private double demandeDecouvert;
    private boolean carteActive;
    private boolean compteActif;

    public CompteBancaire() {
    }

    public CompteBancaire(int id, double solde, double demandeDecouvert, boolean carteActive, boolean compteActif) {
        this.id = id;
        this.solde = solde;
        this.demandeDecouvert = demandeDecouvert;
        this.carteActive = carteActive;
        this.compteActif = compteActif;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public double getDemandeDecouvert() {
        return demandeDecouvert;
    }

    public void setDemandeDecouvert(double demandeDecouvert) {
        this.demandeDecouvert = demandeDecouvert;
    }

    public boolean isCarteActive() {
        return carteActive;
    }

    public void setCarteActive(boolean carteActive) {
        this.carteActive = carteActive;
    }

    public boolean isCompteActif() {
        return compteActif;
    }

    public void setCompteActif(boolean compteActif) {
        this.compteActif = compteActif;
    }
  
    
}
