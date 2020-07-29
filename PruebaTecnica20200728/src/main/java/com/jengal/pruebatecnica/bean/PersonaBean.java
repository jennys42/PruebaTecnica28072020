/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jengal.pruebatecnica.bean;

import com.jengal.pruebatecnica.model.entities.Persona;
import com.jengal.pruebatecnica.model.entities.TipoDocumento;
import com.jengal.pruebatecnica.model.service.ServiceLocal;
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

    @EJB
    private ServiceLocal srv;

    private Persona persona;
    private Integer idTipoDoc;
    private List<TipoDocumento> tipoDocumetoList;
    private List<Persona> personasList;
    private boolean esEditar;

    /**
     * Creates a new instance of PersonaBean
     */
    public PersonaBean() {
    }

    @PostConstruct
    public void init() {
        persona = new Persona();
        tipoDocumetoList = srv.listarTiposDocumento();
        personasList = srv.listarPersona(personasList);
    }

    public void guardarPersona() {
        TipoDocumento get = tipoDocumetoList.stream().filter(tip -> Objects.equals(tip.getId(), idTipoDoc)).findFirst().get();
        persona.setTipoDocumento(get);
        srv.guardarPersona(persona, personasList);
        init();
    }

    public void eliminarPersona(Persona persona) {
        srv.eliminarPersona(persona, personasList);
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

    public Integer getIdTipoDoc() {
        return idTipoDoc;
    }

    public void setIdTipoDoc(Integer idTipoDoc) {
        this.idTipoDoc = idTipoDoc;
    }
    
    

}
