package com.jellali.internaute.Controller;

import com.jellali.internaute.Entity.Internaute;
import com.jellali.internaute.Repository.InternauteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/internautes")
public class InternauteController {
    @Autowired
    private InternauteRepository internauteRepository;

    @PostMapping
    public Internaute ajouterInternaute(@RequestBody Internaute internaute) {
        return internauteRepository.save(internaute);
    }

    @GetMapping
    public List<Internaute> getAllInternautes() {
        return internauteRepository.findAll();
    }

    @GetMapping("/{id}")
    public Internaute getInternauteById(@PathVariable Long id) {
        return internauteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Internaute not found"));
    }

    @PutMapping("/{id}")
    public Internaute updateInternaute(@PathVariable Long id, @RequestBody Internaute updatedInternaute) {
        Internaute internaute = internauteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Internaute not found"));
        internaute.setIdentifiant(updatedInternaute.getIdentifiant());
        internaute.setTrancheAge(updatedInternaute.getTrancheAge());
        return internauteRepository.save(internaute);
    }

    @DeleteMapping("/{id}")
    public void deleteInternaute(@PathVariable Long id) {
        internauteRepository.deleteById(id);
    }
}
