package com.beerapp.models.dao;

import com.beerapp.models.entity.Fabricante;
import org.springframework.data.repository.CrudRepository;

public interface IFabricanteDao extends CrudRepository<Fabricante, Long> {
}
