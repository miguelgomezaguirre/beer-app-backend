package com.beerapp.services.interfaces;

import com.beerapp.models.entity.Pais;

import java.util.Collection;
import java.util.Optional;

public interface IPaisService {

    Collection<Pais> findAll();
    Pais save(Pais pais);
    Optional<Pais> findById(Long id);
}
