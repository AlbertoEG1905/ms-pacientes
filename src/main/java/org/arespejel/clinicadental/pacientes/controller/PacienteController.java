package org.arespejel.clinicadental.pacientes.controller;

import org.arespejel.clinicadental.pacientes.models.Paciente;
import org.arespejel.clinicadental.pacientes.service.PacienteService;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("${paciente-controller.path}")
public class PacienteController {

    @Autowired
    private PacienteService service;

    @GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Paciente>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Paciente> finById(@PathVariable Long id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.finById(id));
        }catch (ObjectNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage(),e.getCause());
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage(),e.getCause());
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        try {
            service.delete(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }catch (ObjectNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e.getCause());
        }catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e.getCause());
        }
    }

    @PostMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> save(@RequestBody Paciente paciente){
        service.save(paciente);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Paciente> update(@RequestBody Paciente paciente){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(paciente));
    }
}
