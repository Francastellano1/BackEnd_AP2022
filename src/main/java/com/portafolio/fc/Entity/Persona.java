package com.portafolio.fc.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/*Persona es una entidad*/
@Entity
public class Persona {
    @Id /*el 1er campo va a ser un id, primary key*/
    @GeneratedValue(strategy = GenerationType.IDENTITY) /*el 2do campo va a ser autogenerado automatico*/
    private int id;
    private String nombre;
    private String apellido; 
    private String img;
    private String descripcion;
    
    //Constructores

    public Persona() {
    }

    public Persona(String nombre, String apellido, String img, String descripcion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.img = img;
        this.descripcion = descripcion;
    }
    //Getters && Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
}
