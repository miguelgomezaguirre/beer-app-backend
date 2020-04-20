package com.beerapp.models.dao;

import com.beerapp.models.entity.Cerveza;
import org.springframework.data.repository.CrudRepository;

public interface ICervezaDao extends CrudRepository<Cerveza, Long> {
}
