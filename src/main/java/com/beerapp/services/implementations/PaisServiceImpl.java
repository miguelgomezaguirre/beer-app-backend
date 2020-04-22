package com.beerapp.services.implementations;

import com.beerapp.models.dao.IPaisDao;
import com.beerapp.models.entity.Pais;
import com.beerapp.services.interfaces.IPaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class PaisServiceImpl implements IPaisService {

    @Autowired
    private IPaisDao paisDao;

    @Override
    public Collection<Pais> findAll() {
        return (Collection<Pais>) paisDao.findAll();
    }

    @Override
    public Pais save(Pais pais) {
        return paisDao.save(pais);
    }

    @Override
    public Optional<Pais> findById(Long id) {
        return paisDao.findById(id);
    }
}
