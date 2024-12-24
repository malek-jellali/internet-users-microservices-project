package com.jellali.event.Entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Categorie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategorie;

    private String codeCategorie;
    private String nomCategorie;

    @ManyToMany(mappedBy = "categories")
    private List<Evenement> evenements = new ArrayList<>();

    // Constructors
    public Categorie() {
    }

    public Categorie(String codeCategorie, String nomCategorie) {
        this.codeCategorie = codeCategorie;
        this.nomCategorie = nomCategorie;
    }

    // Getters and Setters
    public Long getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(Long idCategorie) {
        this.idCategorie = idCategorie;
    }

    public String getCodeCategorie() {
        return codeCategorie;
    }

    public void setCodeCategorie(String codeCategorie) {
        this.codeCategorie = codeCategorie;
    }

    public String getNomCategorie() {
        return nomCategorie;
    }

    public void setNomCategorie(String nomCategorie) {
        this.nomCategorie = nomCategorie;
    }

    public List<Evenement> getEvenements() {
        return evenements;
    }

    public void setEvenements(List<Evenement> evenements) {
        this.evenements = evenements;
    }
}
