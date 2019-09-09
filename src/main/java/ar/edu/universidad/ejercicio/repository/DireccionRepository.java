package ar.edu.universidad.ejercicio.repository;

import ar.edu.universidad.ejercicio.model.Direccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DireccionRepository extends JpaRepository<Direccion, Integer> {

}
