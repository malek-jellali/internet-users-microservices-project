package com.jellali.ticket.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "evenement-service", url = "http://localhost:8083/api/evenements")
public interface EvenementClient {

    @GetMapping("/{evenementId}")
    Evenement getEvenementById(@PathVariable Long evenementId);

    @PostMapping
    Evenement createEvenement(@RequestBody Evenement evenement);
}
