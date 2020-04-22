package com.beerapp.services.implementations;

import com.beerapp.models.dao.ICervezaDao;
import com.beerapp.models.dao.IFabricanteDao;
import com.beerapp.models.entity.Cerveza;
import com.beerapp.services.interfaces.ICervezaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;

@Service
public class CervezaServiceImpl implements ICervezaService {

    @Autowired
    private ICervezaDao cervezaDao;

    @Autowired
    private IFabricanteDao fabricanteDao;

    @Override
    @Transactional(readOnly = true)
    public Collection<Cerveza> findAll() {
        return (Collection<Cerveza>) cervezaDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Cerveza> findById(Long id) {
        return cervezaDao.findById(id);
    }

    @Override
    public Cerveza save(Cerveza cerveza) {
        fabricanteDao.findById(cerveza.getFabricante().getId())
                .map(fabricante -> {
                    cerveza.setFabricante(fabricante);
                    return cerveza;
                }).orElseThrow(() -> new RuntimeException("no se encontro el Fabricante para el ID dado"));
        return cervezaDao.save(cerveza);
    }

    @Override
    public void deleteById(Long id) {
        cervezaDao.deleteById(id);
    }
}
