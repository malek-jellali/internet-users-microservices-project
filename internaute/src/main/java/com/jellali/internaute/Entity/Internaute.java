package com.jellali.internaute.Entity;

import com.jellali.internaute.Entity.TrancheAge;
import jakarta.persistence.*;

@Entity
public class Internaute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idInternaute;

    private String identifiant;

    @Enumerated(EnumType.STRING)
    private TrancheAge trancheAge; // Enum stored as String

    // Getters and Setters
    public Long getIdInternaute() {
        return idInternaute;
    }

    public void setIdInternaute(Long idInternaute) {
        this.idInternaute = idInternaute;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public TrancheAge getTrancheAge() {
        return trancheAge;
    }

    public void setTrancheAge(TrancheAge trancheAge) {
        this.trancheAge = trancheAge;
    }
}
