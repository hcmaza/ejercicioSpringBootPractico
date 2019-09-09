package ar.edu.universidad.ejercicio.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Alumno implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer matricula;
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp fechaalta;
    private Persona personaid;

    @Id
    @Column(name = "matricula", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    @Basic
    @Column(name = "fechaalta", nullable = true)
    public Timestamp getFechaalta() {
        return fechaalta;
    }

    public void setFechaalta(Timestamp fechaalta) {
        this.fechaalta = fechaalta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Alumno alumno = (Alumno) o;
        return Objects.equals(matricula, alumno.matricula) &&
                Objects.equals(fechaalta, alumno.fechaalta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matricula, fechaalta);
    }

    @ManyToOne
    @JoinColumn(name = "personaid", referencedColumnName = "id")
    public Persona getPersonaid() {
        return personaid;
    }

    public void setPersonaid(Persona personaid) {
        this.personaid = personaid;
    }
}
