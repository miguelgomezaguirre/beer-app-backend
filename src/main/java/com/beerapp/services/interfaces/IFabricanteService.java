package com.beerapp.services.interfaces;

import com.beerapp.models.entity.Fabricante;

import java.util.Collection;
import java.util.Optional;

public interface IFabricanteService {

    Collection<Fabricante> findAll();
    Optional<Fabricante> findById(Long id);
    Fabricante save(Fabricante fabricante);

}
