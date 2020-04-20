package com.beerapp.services.interfaces;

import com.beerapp.models.entity.Cerveza;

import java.util.Collection;
import java.util.Optional;

public interface ICervezaService {

    Collection<Cerveza> findAll();
    Optional <Cerveza> findById(Long id);
    Cerveza save(Cerveza cerveza);
    void deleteById(Long id);

}

