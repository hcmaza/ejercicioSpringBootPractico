package ar.edu.universidad.ejercicio.service;

import ar.edu.universidad.ejercicio.dto.Response;
import ar.edu.universidad.ejercicio.model.Alumno;
import ar.edu.universidad.ejercicio.repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;

    public Response findAll() {
        Response response = new Response();
        response.getMessaje();
        List<Alumno> alumnoList = alumnoRepository.findAll();
        response.setData(alumnoList);
        return response;
    }

    public Response findOne(Integer id) throws Exception {
        Response response = new Response();
        System.out.println("mmmmmmmmmmmmmmmmmmmmmmm"+alumnoRepository.findById(id).get().getMatricula());
        Alumno alumno = alumnoRepository.findById(id).get();
        response.setData(alumno);
        return response;
    }

    public Response delete(Integer id) {
        Response response = new Response();
        alumnoRepository.delete(alumnoRepository.getOne(id));
        response.setData("ok");
        return response;
    }

    public Response update(Alumno input) {
        Response response = new Response();
        alumnoRepository.save(input);
        response.setData("ok");
        return response;
    }

    public Response save(Alumno r) {
        Response response = new Response();
        response.setData(alumnoRepository.save(r));
        return response;
    }


}
