package com.jellali.ticket.Entity;

import jakarta.persistence.*;

@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTicket;

    private String codeTicket;
    private double prixTicket;

    @Enumerated(EnumType.STRING)
    private TypeTicket typeTicket; // Enum stored as String

    @ManyToOne
    private Internaute internaute;

    @ManyToOne
    private Evenement evenement;

    public void setCodeTicket(String codeTicket) {
        this.codeTicket = codeTicket;
    }

    public String getCodeTicket() {
        return this.codeTicket;
    }

    public TypeTicket getPrixTicket() {
        return  this.prixTicket;
    }

    public void setPrixTicket(TypeTicket typeTicket) {
        this.typeTicket =  typeTicket;
    }

    public TypeTicket getTypeTicket() {
        return  this.typeTicket;
    }

    public void setTypeTicket(TypeTicket prixTicket) {
        this.typeTicket =  typeTicket;
    }


    // Getters and Setters
    // ... (similar to Internaute getters and setters)
}
