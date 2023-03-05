package org.arespejel.clinicadental.pacientes.service;

import org.arespejel.clinicadental.pacientes.models.Paciente;

import java.util.List;

public interface PacienteService {
    List<Paciente> findAll();
    Paciente finById(Long id);
    void delete(Long id);
    Paciente save(Paciente paciente);
}
