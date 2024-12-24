package com.jellali.internaute.Repository;

import com.jellali.internaute.Entity.Internaute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InternauteRepository extends JpaRepository<Internaute, Long> {
    // Vous pouvez ajouter des méthodes personnalisées ici si nécessaire
}
