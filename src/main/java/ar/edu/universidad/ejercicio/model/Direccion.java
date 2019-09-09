package ar.edu.universidad.ejercicio.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
public class Direccion implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String calle;
    private String nrocalle;
    @JsonIgnore
    private List<Persona> listadoPersona;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "calle", nullable = true, length = 100)
    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    @Basic
    @Column(name = "nrocalle", nullable = true, length = 10)
    public String getNrocalle() {
        return nrocalle;
    }

    public void setNrocalle(String nrocalle) {
        this.nrocalle = nrocalle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Direccion direccion = (Direccion) o;
        return Objects.equals(id, direccion.id) &&
                Objects.equals(calle, direccion.calle) &&
                Objects.equals(nrocalle, direccion.nrocalle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, calle, nrocalle);
    }

    @OneToMany(mappedBy = "direccionid",fetch = FetchType.EAGER)
    public List<Persona> getListadoPersona() {
        return listadoPersona;
    }

    public void setListadoPersona(List<Persona> listadoPersona) {
        this.listadoPersona = listadoPersona;
    }
}
