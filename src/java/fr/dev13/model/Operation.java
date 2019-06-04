/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.dev13.model;

import java.util.Date;

/**
 *
 * @author ESIC
 */
public class Operation {
    
    private int id;
    private String libelle;
    private double montantOperation;
    private Date dateOperation;
    private int idCompteBancaire;
    private int idBeneficiaire;

    public Operation() {
    }

    public Operation(int id, String libelle, double montantOperation, Date dateOperation, int idCompteBancaire, int idBeneficiaire) {
        this.id = id;
        this.libelle = libelle;
        this.montantOperation = montantOperation;
        this.dateOperation = dateOperation;
        this.idCompteBancaire = idCompteBancaire;
        this.idBeneficiaire = idBeneficiaire;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public double getMontantOperation() {
        return montantOperation;
    }

    public void setMontantOperation(double montantOperation) {
        this.montantOperation = montantOperation;
    }

    public Date getDateOperation() {
        return dateOperation;
    }

    public void setDateOperation(Date dateOperation) {
        this.dateOperation = dateOperation;
    }

    public int getIdCompteBancaire() {
        return idCompteBancaire;
    }

    public void setIdCompteBancaire(int idCompteBancaire) {
        this.idCompteBancaire = idCompteBancaire;
    }

    public int getIdBeneficiaire() {
        return idBeneficiaire;
    }

    public void setIdBeneficiaire(int idBeneficiaire) {
        this.idBeneficiaire = idBeneficiaire;
    }
    
    
}
