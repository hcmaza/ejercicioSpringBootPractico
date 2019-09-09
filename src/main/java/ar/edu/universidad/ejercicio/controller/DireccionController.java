package ar.edu.universidad.ejercicio.controller;

import ar.edu.universidad.ejercicio.dto.Response;
import ar.edu.universidad.ejercicio.model.Direccion;
import ar.edu.universidad.ejercicio.service.DireccionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/direcciones")
public class DireccionController {

    private static final Logger LOG = LoggerFactory.getLogger(DireccionController.class);

    @Autowired
    private DireccionService direccionService;

    @GetMapping
    public ResponseEntity<Response> list() {
        Response response = direccionService.findAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // Consulto solo uno por identificador
    @GetMapping("/{id}")
    public ResponseEntity<Response> getDireccionById(@PathVariable(value = "id") Integer direccionId) throws Exception {
        System.out.println("-------"+direccionService.findOne(direccionId).getMessaje());
        Response response = direccionService.findOne(direccionId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // crea
    @PostMapping()
    public ResponseEntity<Response> create(@Valid @RequestBody Direccion direccion) {
        Response response = direccionService.save(direccion);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // Actualiza
    @PutMapping("/{id}")
    public ResponseEntity<Response> update(@PathVariable(value = "id") Integer direccionId,
                                           @Valid @RequestBody Direccion input) {
        Response response = direccionService.update(input);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // borra
    @DeleteMapping("/{id}")
    public ResponseEntity<Response> delete(@PathVariable(value = "id") Integer direccionId) {
        Response response = direccionService.delete(direccionId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
