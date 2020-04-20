package com.beerapp.models.dao;

import com.beerapp.models.entity.Familia;
import org.springframework.data.repository.CrudRepository;

public interface IFamiliaDao extends CrudRepository<Familia, Long> {
}
