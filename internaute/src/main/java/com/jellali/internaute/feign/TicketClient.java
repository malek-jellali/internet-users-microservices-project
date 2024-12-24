package com.jellali.internaute.feign;
import com.example.internaute.dto.TicketDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "ticket-service", url = "http://localhost:8082/api/tickets")
public interface TicketClient {

    @GetMapping("/internautes/{idInternaute}")
    List<TicketDTO> getTicketsByInternaute(@PathVariable Long idInternaute);

    @PostMapping
    TicketDTO createTicket(@RequestBody TicketDTO ticket);

    @DeleteMapping("/{ticketId}")
    void deleteTicket(@PathVariable Long ticketId);
}

