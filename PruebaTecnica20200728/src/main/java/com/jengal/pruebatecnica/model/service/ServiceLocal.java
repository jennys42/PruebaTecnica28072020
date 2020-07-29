/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jengal.pruebatecnica.model.service;

import com.jengal.pruebatecnica.model.entities.Persona;
import com.jengal.pruebatecnica.model.entities.TipoDocumento;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author JENNY G
 */
@Local
public interface ServiceLocal {
        
    List<TipoDocumento> listarTiposDocumento();
    List<Persona> listarPersona(List<Persona> personas);
    void guardarPersona(Persona per, List<Persona> personas);
    void eliminarPersona(Persona per, List<Persona> personas);
    
}

