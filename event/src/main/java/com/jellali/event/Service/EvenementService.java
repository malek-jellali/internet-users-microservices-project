package com.jellali.event.Service;

import com.jellali.event.Entity.Categorie;
import com.jellali.event.Entity.Evenement;
import com.jellali.event.Repository.EvenementRepository;
import com.jellali.event.feign.CategorieClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvenementService {

    @Autowired
    private CategorieClient categorieClient;
    private EvenementRepository evenementRepository ;

    public Evenement addCategoriesToEvent(Long evenementId, List<Long> categorieIds) {
        Evenement evenement = evenementRepository.findById(evenementId)
                .orElseThrow(() -> new RuntimeException("Evenement not found"));

        List<Categorie> categories = categorieIds.stream()
                .map(categorieClient::getCategorieById)
                .toList();

        evenement.setCategories(categories);
        return evenementRepository.save(evenement);
    }
}

