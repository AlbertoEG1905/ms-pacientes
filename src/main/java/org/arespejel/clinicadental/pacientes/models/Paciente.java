package org.arespejel.clinicadental.pacientes.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "pacientes")
@Data
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "primer_nombre", length = 20, nullable = false)
    private String pNombre;

    @Column(name = "segundo_nombre", length = 20, nullable = true)
    private String sNombre;

    @Column(name = "apellido_paterno", length = 20, nullable = false)
    private String aPaterno;

    @Column(name = "apellido_materno", length = 20, nullable = false)
    private String aMaterno;

    @Column(nullable = false)
    private Integer edad;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_nacimiento", nullable = false)
    private Date fechaNacimiento;

    @Column(length = 10, nullable = true)
    private String telefono;

    @Column(length = 1, nullable = false)
    private String genero;

    @Column(nullable = false)
    private String estado;

    @Column(nullable = false)
    private String municipio;

    @Column(nullable = false)
    private String domicilio;

    @Column(name = "codigo_postal", length = 6, nullable = false)
    private String codigoPostal;


}
