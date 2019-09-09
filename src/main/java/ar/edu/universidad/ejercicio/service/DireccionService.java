package ar.edu.universidad.ejercicio.service;

import ar.edu.universidad.ejercicio.dto.Response;
import ar.edu.universidad.ejercicio.model.Direccion;
import ar.edu.universidad.ejercicio.repository.DireccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class DireccionService {

    @Autowired
    private DireccionRepository direccionRepository;

    public Response findAll() {
        Response response = new Response();
        response.getMessaje();
        List<Direccion> direccionList = direccionRepository.findAll();
        System.out.println("lllllllllllllllllllllllllllllllll"+direccionList.size());
        response.setData(direccionList);
        return response;
    }

    public Response findOne(Integer id) throws Exception {
        Response response = new Response();
        System.out.println("mmmmmmmmmmmmmmmmmmmmmmm"+direccionRepository.findById(id).get().getCalle());
        Direccion direccion = direccionRepository.findById(id).get();
        response.setData(direccion);
        return response;
    }

    public Response delete(Integer id) {
        Response response = new Response();
        direccionRepository.delete(direccionRepository.getOne(id));
        response.setData("ok");
        return response;
    }

    public Response update(Direccion input) {
        Response response = new Response();
        direccionRepository.save(input);
        response.setData("ok");
        return response;
    }

    public Response save(Direccion r) {
        Response response = new Response();
        response.setData(direccionRepository.save(r));
        return response;
    }


}
