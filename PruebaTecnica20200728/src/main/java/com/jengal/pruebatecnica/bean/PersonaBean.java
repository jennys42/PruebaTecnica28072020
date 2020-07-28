/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jengal.pruebatecnica.bean;

import com.jengal.entities.Persona;
import com.jengal.entities.TipoDocumento;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author JENNY G
 */
@Named(value = "personaBean")
@ViewScoped
public class PersonaBean implements Serializable {

    private Persona persona;
    private List<TipoDocumento> tipoDocumetoList;
    private List<Persona> personasList;
    private boolean esEditar;
    @EJB(name = "PersonaServiceLocal")
    private PersonaServiceLocal srv;

    /**
     * Creates a new instance of PersonaBean
     */
    public PersonaBean() {
    }

    @PostConstruct
    public void init() {
        persona = new Persona();
        tipoDocumetoList = srv.listarTiposDocumento();
        personasList = srv.listarPersona();
    }

    public void guardarPersona() {
        srv.guardarPersona(persona, personasList);
        init();
    }

    public void eliminarPersona(Persona persona) {
        srv.guardarPersona(persona, personasList);
        init();
    }

    public void editarPersona(Persona perSele) {
        persona = perSele;
        esEditar = true;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<TipoDocumento> getTipoDocumetoList() {
        return tipoDocumetoList;
    }

    public void setTipoDocumetoList(List<TipoDocumento> tipoDocumetoList) {
        this.tipoDocumetoList = tipoDocumetoList;
    }

    public List<Persona> getPersonasList() {
        return personasList;
    }

    public void setPersonasList(List<Persona> personasList) {
        this.personasList = personasList;
    }

}
