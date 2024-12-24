package com.jellali.ticket.Repository;


import com.jellali.ticket.Entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    // Custom query to find tickets by Internaute ID
    List<Ticket> findByInternauteId(Long internauteId);

    // Custom query to find tickets by Evenement ID
    List<Ticket> findByEvenementId(Long evenementId);

    // You can add more custom queries as needed, such as:
    // List<Ticket> findByInternauteAndEvenement(Internaute internaute, Evenement evenement);
}
