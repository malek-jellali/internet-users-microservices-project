package com.jellali.internaute.Service;
import com.example.internaute.dto.TicketDTO ;
import com.jellali.internaute.Entity.Internaute;
import com.jellali.internaute.Repository.InternauteRepository;
import com.jellali.internaute.feign.TicketClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class InternauteService {

    @Autowired
    private InternauteRepository internauteRepository;
    @Autowired
    private TicketClient ticketClient;

    // Method to add a new Internaute
    public Internaute ajouterInternaute(Internaute internaute) {
        return internauteRepository.save(internaute);
    }

    // Method to get an Internaute by ID, returning null if not found
    public Internaute getInternaute(Long id) {
        return internauteRepository.findById(id).orElse(null);  // Handles the Optional
    }

    // Method to get an Internaute by ID, throwing an exception if not found
    public Internaute getInternauteById(Long id) {
        return internauteRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Internaute not found with ID: " + id));
    }


    public List<TicketDTO> getInternauteTickets(Long internauteId) {
        return ticketClient.getTicketsByInternaute(internauteId);
    }

    public TicketDTO buyTicket(Long internauteId, TicketDTO ticket) {
        ticket.setInternauteId(internauteId); // Associer l'internaute
        return ticketClient.createTicket(ticket);
    }
}
