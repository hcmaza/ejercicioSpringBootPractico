package ar.edu.universidad.ejercicio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Persona implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String apellido;
    private String nombre;
    private Date fechanacimiento;

   private Direccion direccionid;
   private List<Alumno> listadoAlumno;

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
    @Column(name = "apellido", nullable = true, length = 25)
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Basic
    @Column(name = "nombre", nullable = true, length = 50)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "fechanacimiento", nullable = true)
    public Date getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return Objects.equals(id, persona.id) &&
                Objects.equals(apellido, persona.apellido) &&
                Objects.equals(nombre, persona.nombre) &&
                Objects.equals(fechanacimiento, persona.fechanacimiento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, apellido, nombre, fechanacimiento);
    }


    @ManyToOne
    @JoinColumn(name = "direccionid", referencedColumnName = "id")
    public Direccion getDireccionid() {
        return direccionid;
    }

    public void setDireccionid(Direccion direccionid) {
        this.direccionid = direccionid;
    }

    @OneToMany(mappedBy = "personaid")
    public List<Alumno> getListadoAlumno() {
        return listadoAlumno;
    }

    public void setListadoAlumno(List<Alumno> listadoAlumno) {
        this.listadoAlumno = listadoAlumno;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", apellido='" + apellido + '\'' +
                ", nombre='" + nombre + '\'' +
                ", fechanacimiento=" + fechanacimiento +
                ", direccionid=" + direccionid +
                '}';
    }
}
