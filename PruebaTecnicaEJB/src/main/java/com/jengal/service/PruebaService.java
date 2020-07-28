/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jengal.service;

import com.jengal.entities.Persona;
import com.jengal.entities.TipoDocumento;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import javax.ejb.Stateless;

/**
 *
 * @author JENNY G
 */
@Stateless(name = "PruebaService")
public class PruebaService implements PruebaServiceLocal {

    @Override
    public List<Persona> listarPersona(List<Persona> personas) {
        if (personas == null) {
            personas = new ArrayList<>();
        }
        return personas;
    }

    @Override
    public void guardarPersona(Persona persona, List<Persona> personas) {
        if (persona.getId() == null) {
            Random r = new Random();
            int valorDado = r.nextInt(1000000) + 1;
            persona.setId(valorDado);
            personas.add(persona);
        } else {
            Persona perencontrada = personas.stream().filter(per -> Objects.equals(per.getId(), persona.getId())).findFirst().get();
            personas.remove(perencontrada);
            personas.add(persona);
        }
    }

    @Override
    public void eliminarPersona(Persona per, List<Persona> personas) {
        if (personas.contains(per)) {
            personas.remove(per);
        }
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public List<TipoDocumento> listarTiposDocumento() {
        List<TipoDocumento> tipos = new ArrayList<>();
        tipos.add(new TipoDocumento(1, "CEDULA DE CIUDADANIA"));
        tipos.add(new TipoDocumento(2, "TARJETA DE INDENTIDAD"));
        return tipos;
    }
}
