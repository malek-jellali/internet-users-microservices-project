package com.jellali.ticket.Service;

import com.jellali.ticket.Entity.Ticket;
import com.jellali.ticket.Repository.TicketRepository;
import com.jellali.ticket.feign.EvenementClient;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private EvenementClient evenementClient;

    public Evenement getEvenement(Long evenementId) {
        return evenementClient.getEvenementById(evenementId);
    }

    public Ticket createTicketForEvent(Ticket ticket, Long evenementId) {
        Evenement evenement = evenementClient.getEvenementById(evenementId);
        if (evenement.getNbPlacesRestantes() > 0) {
            evenement.setNbPlacesRestantes(evenement.getNbPlacesRestantes() - 1);
            evenementClient.createEvenement(evenement); // Update the event
            ticket.setEvenementId(evenementId);
            // Sauvegarde du ticket dans la base
            return ticketRepository.save(ticket);
        }
        throw new RuntimeException("No remaining places for this event");
    }
    public Ticket saveTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    public Ticket updateTicket(Long id, Ticket updatedTicket) {
        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Ticket not found"));

        ticket.setCodeTicket(updatedTicket.getCodeTicket());
        ticket.setPrixTicket(updatedTicket.getPrixTicket());
        ticket.setTypeTicket(updatedTicket.getTypeTicket());
        return ticketRepository.save(ticket);
    }
}
