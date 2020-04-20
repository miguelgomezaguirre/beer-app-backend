package com.beerapp.services.interfaces;

import com.beerapp.models.entity.Pais;

import java.util.Collection;

public interface IPaisService {

    Collection<Pais> findAll();
    Pais save(Pais pais);

}
