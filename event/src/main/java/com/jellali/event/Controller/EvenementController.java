package com.jellali.event.Controller;

import com.jellali.event.Entity.Evenement;
import com.jellali.event.Repository.EvenementRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/evenements")
public class EvenementController {
    @Autowired
    private EvenementRepository evenementRepository;

    @PostMapping
    public Evenement ajouterEvenement(@RequestBody Evenement evenement) {
        return evenementRepository.save(evenement);
    }

    @GetMapping
    public List<Evenement> getAllEvenements() {
        return evenementRepository.findAll();
    }

    @GetMapping("/{id}")
    public Evenement getEvenementById(@PathVariable Long id) {
        return evenementRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Evenement not found"));
    }

    @PutMapping("/{id}")
    public Evenement updateEvenement(@PathVariable Long id, @RequestBody Evenement updatedEvenement) {
        Evenement evenement = evenementRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Evenement not found"));
        evenement.setNomEvenement(updatedEvenement.getNomEvenement());
        evenement.setNbPlacesRestantes(updatedEvenement.getNbPlacesRestantes());
        evenement.setDateEvenement(updatedEvenement.getDateEvenement());
        evenement.setCategories(updatedEvenement.getCategories());
        return evenementRepository.save(evenement);
    }

    @DeleteMapping("/{id}")
    public void deleteEvenement(@PathVariable Long id) {
        evenementRepository.deleteById(id);
    }
}

