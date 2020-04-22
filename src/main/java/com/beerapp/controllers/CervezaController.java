package com.beerapp.controllers;

import com.beerapp.models.entity.Cerveza;
import com.beerapp.models.entity.Fabricante;
import com.beerapp.services.interfaces.ICervezaService;
import com.beerapp.services.interfaces.IFabricanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping("/api/cerveza")
public class CervezaController {

    @Autowired
    private ICervezaService cervezaService;

    @GetMapping
    public Collection<Cerveza> findAll() {
        return cervezaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCervezaById(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        Optional<Cerveza> cerveza = cervezaService.findById(id);

        if (!cerveza.isPresent()){
            response.put("mensaje", "No se pudo encontrar la cerveza con el ID:" +id.toString()+ " en la base de datos");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(cerveza.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody Cerveza cerveza) {
        Map<String, Object> response = new HashMap<>();
        response.put("cerveza", cervezaService.save(cerveza));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
