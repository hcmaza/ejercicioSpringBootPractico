package ar.edu.universidad.ejercicio.service;

import ar.edu.universidad.ejercicio.dto.Response;
import ar.edu.universidad.ejercicio.model.Persona;
import ar.edu.universidad.ejercicio.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    public Response findAll() {
        Response response = new Response();
        response.getMessaje();
        List<Persona> personaList = personaRepository.findAll();
        response.setData(personaList);
        return response;
    }

    public Response findOne(Integer id) throws Exception {
        Response response = new Response();
        System.out.println("mmmmmmmmmmmmmmmmmmmmmmm"+personaRepository.findById(id).get().getApellido());
        Persona persona = personaRepository.findById(id).get();
        response.setData(persona);
        return response;
    }

    public Response delete(Integer id) {
        Response response = new Response();
        personaRepository.delete(personaRepository.getOne(id));
        response.setData("ok");
        return response;
    }

    public Response update(Persona input) {
        Response response = new Response();
        System.out.println("--------------"+input);
        personaRepository.save(input);
        response.setData("ok");
        return response;
    }

    public Response save(Persona r) {
        Response response = new Response();
        response.setData(personaRepository.save(r));
        return response;
    }


}
