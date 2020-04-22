package com.beerapp.controllers;

import com.beerapp.models.entity.Fabricante;
import com.beerapp.models.entity.Pais;
import com.beerapp.services.interfaces.IFabricanteService;
import com.beerapp.services.interfaces.IPaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/fabricante")
public class FabricanteController {

    @Autowired
    private IFabricanteService fabricanteService;

    @Autowired
    private IPaisService paisService;

    @GetMapping
    public Collection<Fabricante> getAll() {
        return fabricanteService.findAll();
    }

    @PostMapping
        public ResponseEntity<?> save(@Valid @RequestBody Fabricante fabricante) {
        Map<String, Object> response = new HashMap<>();

        Optional<Pais> pais = paisService.findById(fabricante.getPais().getId());

        if (!pais.isPresent()) {
            response.put("mensaje", "no se encontro el pais");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        try{
            fabricante.setPais(pais.get());
            Fabricante fabricanteNew = fabricanteService.save(fabricante);
            response.put("fabricante", fabricanteNew);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            response.put("mensaje", "no se pudo insertar el fabricante");
            response.put("error", e.getMessage().concat(":").concat(e.getCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
