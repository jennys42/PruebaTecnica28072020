/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jengal.service;

import com.jengal.entities.Persona;
import com.jengal.entities.TipoDocumento;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Remote;

/**
 *
 * @author JENNY G
 */
@Local
public interface PruebaServiceLocal {
    
    List<TipoDocumento> listarTiposDocumento();
    List<Persona> listarPersona(List<Persona> personas);
    void guardarPersona(Persona per, List<Persona> personas);
    void eliminarPersona(Persona per, List<Persona> personas);
    
}
