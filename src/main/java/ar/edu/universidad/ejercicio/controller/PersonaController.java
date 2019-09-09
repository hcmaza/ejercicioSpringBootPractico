package ar.edu.universidad.ejercicio.controller;

import ar.edu.universidad.ejercicio.dto.Response;
import ar.edu.universidad.ejercicio.model.Persona;
import ar.edu.universidad.ejercicio.service.PersonaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/personas")
public class PersonaController {

    private static final Logger LOG = LoggerFactory.getLogger(PersonaController.class);

    @Autowired
    private PersonaService personaService;

    @GetMapping
    public ResponseEntity<Response> list() {
        Response response = personaService.findAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // Consulto solo uno por identificador
    @GetMapping("/{id}")
    public ResponseEntity<Response> getPersonaById(@PathVariable(value = "id") Integer personaId) throws Exception {
        System.out.println("-------"+personaService.findOne(personaId).getMessaje());
        Response response = personaService.findOne(personaId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // crea
    @PostMapping()
    public ResponseEntity<Response> create(@Valid @RequestBody Persona persona) {
        Response response = personaService.save(persona);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // Actualiza
    @PutMapping("/{id}")
    public ResponseEntity<Response> update(@PathVariable(value = "id") Integer personaId,
                                           @Valid @RequestBody Persona input) {
        Response response = personaService.update(input);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // borra
    @DeleteMapping("/{id}")
    public ResponseEntity<Response> delete(@PathVariable(value = "id") Integer personaId) {
        Response response = personaService.delete(personaId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
