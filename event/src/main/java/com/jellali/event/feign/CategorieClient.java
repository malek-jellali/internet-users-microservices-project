package com.jellali.event.feign;

import com.jellali.event.Entity.Categorie;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "categorie-service", url = "http://localhost:8084/api/categories")
public interface CategorieClient {

    @GetMapping("/{idCategorie}")
    Categorie getCategorieById(@PathVariable Long idCategorie);

    @PostMapping
    Categorie createCategorie(@RequestBody Categorie categorie);

    @GetMapping
    List<Categorie> getAllCategories();
}

