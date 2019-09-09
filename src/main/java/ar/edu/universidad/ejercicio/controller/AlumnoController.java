package ar.edu.universidad.ejercicio.controller;

import ar.edu.universidad.ejercicio.dto.Response;
import ar.edu.universidad.ejercicio.model.Alumno;
import ar.edu.universidad.ejercicio.model.Persona;
import ar.edu.universidad.ejercicio.service.AlumnoService;
import ar.edu.universidad.ejercicio.service.PersonaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/alumnos")
public class AlumnoController {

    private static final Logger LOG = LoggerFactory.getLogger(AlumnoController.class);

    @Autowired
    private AlumnoService alumnoService;

    @GetMapping
    public ResponseEntity<Response> list() {
        Response response = alumnoService.findAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // Consulto solo uno por identificador
    @GetMapping("/{id}")
    public ResponseEntity<Response> getAlumnoById(@PathVariable(value = "id") Integer alumnoId) throws Exception {
        System.out.println("-------"+alumnoService.findOne(alumnoId).getMessaje());
        Response response = alumnoService.findOne(alumnoId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // crea
    @PostMapping()
    public ResponseEntity<Response> create(@Valid @RequestBody Alumno alumno) {
        Response response = alumnoService.save(alumno);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // Actualiza
    @PutMapping("/{id}")
    public ResponseEntity<Response> update(@PathVariable(value = "id") Integer alumnoId,
                                           @Valid @RequestBody Alumno input) {
        Response response = alumnoService.update(input);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // borra
    @DeleteMapping("/{id}")
    public ResponseEntity<Response> delete(@PathVariable(value = "id") Integer alumnoId) {
        Response response = alumnoService.delete(alumnoId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
