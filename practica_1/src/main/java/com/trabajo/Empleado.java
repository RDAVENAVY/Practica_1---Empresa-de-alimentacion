package com.trabajo;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "empleado")
@XmlType(propOrder = { "dni", "nombre", "telefono", "localidad", "edad", "puesto", "salario" })
public class Empleado {

    // Atributos del empleado
    private int id;
    private String dni;
    private String nombre;
    private String telefono;
    private String localidad;
    private int edad;
    private String puesto;
    private double salario;

    // Constructor 
    public Empleado(int id, String dni, String nombre, String telefono, String localidad, int edad, String puesto, double salario) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.telefono = telefono;
        this.localidad = localidad;
        this.edad = edad;
        this.puesto = puesto;
        this.salario = salario;
    }

    // Constructor vacío exigido por JAXB
    public Empleado() {
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

    // Elemento puesto
    @XmlElement(name = "puesto")
    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    // Elemento salario
    @XmlElement(name = "salario")
    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}