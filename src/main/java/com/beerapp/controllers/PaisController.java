package com.beerapp.controllers;

import com.beerapp.models.entity.Pais;
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

@RestController
@RequestMapping("api/pais")
public class PaisController {

    @Autowired
    private IPaisService paisService;

    @GetMapping
    public Collection<Pais> findAll() {
        return paisService.findAll();
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody Pais pais) {
        Map<String, Object> response = new HashMap<>();
        try {
            Pais paisNew = paisService.save(pais);
            response.put("pais", paisNew);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (DataAccessException e) {
            response.put("mensaje", "no se pudo insertar el pais");
            response.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
