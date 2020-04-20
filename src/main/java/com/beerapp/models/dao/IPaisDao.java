package com.beerapp.models.dao;

import com.beerapp.models.entity.Pais;
import org.springframework.data.repository.CrudRepository;

public interface IPaisDao extends CrudRepository<Pais, Long> {
}
