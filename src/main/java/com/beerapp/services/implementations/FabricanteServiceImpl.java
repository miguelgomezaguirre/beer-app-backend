package com.beerapp.services.implementations;

import com.beerapp.models.dao.IFabricanteDao;
import com.beerapp.models.dao.IPaisDao;
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

    @Autowired
    private IPaisDao paisDao;

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
        paisDao.findById(fabricante.getPais().getId())
                .map(pais -> {
                    fabricante.setPais(pais);
                    return fabricante;
                }).orElseThrow(() -> new RuntimeException("Pais no encontrado para el ID dado"));
        return fabricanteDao.save(fabricante);
    }
}
