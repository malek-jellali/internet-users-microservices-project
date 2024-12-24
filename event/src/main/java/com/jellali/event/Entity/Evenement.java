package com.jellali.event.Entity;

import com.jellali.event.Entity.Categorie;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Evenement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEvenement;

    private String nomEvenement;
    private Long nbPlacesRestantes;
    private LocalDate dateEvenement;

    @ManyToMany
    @JoinTable(
            name = "evenement_categorie",
            joinColumns = @JoinColumn(name = "id_evenement"),
            inverseJoinColumns = @JoinColumn(name = "id_categorie")
    )
    private List<Categorie> categories = new ArrayList<>();

    // Constructors
    public Evenement() {
    }

    public Evenement(String nomEvenement, Long nbPlacesRestantes, LocalDate dateEvenement) {
        this.nomEvenement = nomEvenement;
        this.nbPlacesRestantes = nbPlacesRestantes;
        this.dateEvenement = dateEvenement;
    }

    // Getters and Setters
    public Long getIdEvenement() {
        return idEvenement;
    }

    public void setIdEvenement(Long idEvenement) {
        this.idEvenement = idEvenement;
    }

    public String getNomEvenement() {
        return nomEvenement;
    }

    public void setNomEvenement(String nomEvenement) {
        this.nomEvenement = nomEvenement;
    }

    public Long getNbPlacesRestantes() {
        return nbPlacesRestantes;
    }

    public void setNbPlacesRestantes(Long nbPlacesRestantes) {
        this.nbPlacesRestantes = nbPlacesRestantes;
    }

    public LocalDate getDateEvenement() {
        return dateEvenement;
    }

    public void setDateEvenement(LocalDate dateEvenement) {
        this.dateEvenement = dateEvenement;
    }

    public List<Categorie> getCategories() {
        return categories;
    }

    public void setCategories(List<Categorie> categories) {
        this.categories = categories;
    }

    // Add helper methods if needed
    public void addCategorie(Categorie categorie) {
        this.categories.add(categorie);
    }

    public void removeCategorie(Categorie categorie) {
        this.categories.remove(categorie);
    }
}
