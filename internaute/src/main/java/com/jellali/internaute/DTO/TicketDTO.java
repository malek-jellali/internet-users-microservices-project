package com.example.internaute.dto;

import java.time.LocalDate;

public class TicketDTO {
    private Long idTicket;
    private Long idInternaute;
    private Long idEvenement;
    private LocalDate dateAchat;

    // Getters and Setters
    public Long getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(Long idTicket) {
        this.idTicket = idTicket;
    }

    public Long getIdInternaute() {
        return idInternaute;
    }

    public void setIdInternaute(Long idInternaute) {
        this.idInternaute = idInternaute;
    }

    public Long getIdEvenement() {
        return idEvenement;
    }

    public void setIdEvenement(Long idEvenement) {
        this.idEvenement = idEvenement;
    }

    public LocalDate getDateAchat() {
        return dateAchat;
    }

    public void setDateAchat(LocalDate dateAchat) {
        this.dateAchat = dateAchat;
    }

    public void setInternauteId(Long internauteId) {
        this.idInternaute = internauteId ;
    }
}
