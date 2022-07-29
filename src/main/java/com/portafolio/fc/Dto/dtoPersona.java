package com.portafolio.fc.Dto;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author Fran
 */
public class dtoPersona {
    private String img;
    @NotBlank
    private String nombre;
    @NotBlank
    private String apellido;
    @NotBlank
    private String descripcion;
    //Constructores

    public dtoPersona() {
    }

    public dtoPersona(String img, String nombre, String apellido, String descripcion) {
        this.img = img;
        this.nombre = nombre;
        this.apellido = apellido;
        this.descripcion = descripcion;
    }
    //Getters && Setters

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
