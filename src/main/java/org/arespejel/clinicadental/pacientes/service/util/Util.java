package org.arespejel.clinicadental.pacientes.service.util;

import org.arespejel.clinicadental.pacientes.models.Paciente;

public class Util {

    public static Paciente update(Paciente existente){
        Paciente nuevo = new Paciente();
        nuevo.setPNombre(existente.getPNombre());
        nuevo.setSNombre(existente.getSNombre());
        nuevo.setAPaterno(existente.getAPaterno());
        nuevo.setAMaterno(existente.getAMaterno());
        nuevo.setEdad(existente.getEdad());
        nuevo.setFechaNacimiento(existente.getFechaNacimiento());
        nuevo.setTelefono(existente.getTelefono());
        nuevo.setGenero(existente.getGenero());
        nuevo.setEstado(existente.getEstado());
        nuevo.setMunicipio(existente.getMunicipio());
        nuevo.setDomicilio(existente.getDomicilio());
        nuevo.setCodigoPostal(existente.getCodigoPostal());
        return nuevo;
    }
}
