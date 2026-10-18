package com.trabajo;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "cliente")
@XmlType(propOrder = { "dni", "nombre", "telefono", "localidad", "edad", "premium" })
public class Cliente {

    // Atributos del cliente
    private int id;
    private String dni;
    private String nombre;
    private String telefono;
    private String localidad;
    private int edad;
    private int premium;

    // Constructor 
    public Cliente(int id, String dni, String nombre, String telefono, String localidad, int edad, int premium) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.telefono = telefono;
        this.localidad = localidad;
        this.edad = edad;
        this.premium = premium;
    }

    // Constructor vacío exigido por JAXB
    public Cliente() {
    }

    // Atributo id como atributo XML
    @XmlAttribute(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Elemento DNI
    @XmlElement(name = "dni")
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    // Elemento nombre
    @XmlElement(name = "nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Elemento teléfono
    @XmlElement(name = "telefono")
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    // Elemento localidad
    @XmlElement(name = "localidad")
    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    // Elemento edad
    @XmlElement(name = "edad")
    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    // Elemento premium
    @XmlElement(name = "premium")
    public int getPremium() {
        return premium;
    }

    public void setPremium(int premium) {
        this.premium = premium;
    }
}