package org.arespejel.clinicadental.pacientes.service;

import jakarta.persistence.EntityManager;
import org.arespejel.clinicadental.pacientes.models.Paciente;
import org.arespejel.clinicadental.pacientes.exceptions.ObjectNotFoundException;
import org.arespejel.clinicadental.pacientes.repository.PacienteRepository;
import org.arespejel.clinicadental.pacientes.service.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteServiceImpl implements PacienteService{

    @Autowired
    private PacienteRepository repository;

    @Override
    public List<Paciente> findAll() {
        return (List<Paciente>) repository.findAll();
    }

    @Override
    public Paciente finById(Long id) {
        Optional<Paciente> pacienteOptional = repository.findById(id);
        if(pacienteOptional.isPresent()){
            return pacienteOptional.get();
        } else{
            throw new ObjectNotFoundException("No se encontro un paciente con el id "+id);
        }
    }

    @Override
    public void delete(Long id) {
        Optional<Paciente> pacienteOptional = repository.findById(id);
        if(pacienteOptional.isPresent()){
            repository.delete(pacienteOptional.get());
        } else{
            throw new ObjectNotFoundException("No se encontro un paciente con el id "+id);
        }
    }

    @Override
    public Paciente save(Paciente paciente) {
        if(paciente.getId()==null){
            return repository.save(paciente);
        }else{
            Optional<Paciente> pacienteExistente = repository.findById(paciente.getId());
            pacienteExistente.get().setPNombre(paciente.getPNombre());
            pacienteExistente.get().setSNombre(paciente.getSNombre());
            pacienteExistente.get().setAPaterno(paciente.getAPaterno());
            pacienteExistente.get().setAMaterno(paciente.getAMaterno());
            pacienteExistente.get().setEdad(paciente.getEdad());
            pacienteExistente.get().setFechaNacimiento(paciente.getFechaNacimiento());
            pacienteExistente.get().setTelefono(paciente.getTelefono());
            pacienteExistente.get().setGenero(paciente.getGenero());
            pacienteExistente.get().setEstado(paciente.getEstado());
            pacienteExistente.get().setMunicipio(paciente.getMunicipio());
            pacienteExistente.get().setDomicilio(paciente.getDomicilio());
            pacienteExistente.get().setCodigoPostal(paciente.getCodigoPostal());
            return repository.save(pacienteExistente.get());
        }
    }
}
