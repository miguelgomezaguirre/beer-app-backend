package com.beerapp.services.implementations;

import com.beerapp.models.dao.IFabricanteDao;
import com.beerapp.models.entity.Fabricante;
import com.beerapp.services.interfaces.IFabricanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class FabricanteServiceImpl implements IFabricanteService {

    @Autowired
    private IFabricanteDao fabricanteDao;

    @Override
    public Collection<Fabricante> findAll() {
        return (Collection<Fabricante>) fabricanteDao.findAll();
    }

    @Override
    public Optional<Fabricante> findById(Long id) {
        return fabricanteDao.findById(id);
    }

    @Override
    public Fabricante save(Fabricante fabricante) {
        return fabricanteDao.save(fabricante);
    }
}
