package org.arespejel.clinicadental.pacientes.repository;

import org.arespejel.clinicadental.pacientes.models.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {

}
