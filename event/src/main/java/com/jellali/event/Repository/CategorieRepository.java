package com.jellali.event.Repository;

import com.jellali.event.Entity.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepository extends JpaRepository<Categorie, Long> {
    // Additional query methods can be added here if needed
}

