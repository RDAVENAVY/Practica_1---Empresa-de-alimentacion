package com.trabajo;


import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAttribute;

@XmlRootElement(name = "empresa")
public class Empresa {

    // Atributos de la clase Empresa
    private int id;
    private String nombre;
    private String servicio;
    private String telefono;

    // Listados de clientes y empleados
    private List<Cliente> clientes = new ArrayList<>();
    private List<Empleado> empleados = new ArrayList<>();

    // Atributo id de la empresa
    @XmlAttribute(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Elemento nombre
    @XmlElement(name = "nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Elemento servicio
    @XmlElement(name = "servicio")
    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    // Elemento teléfono
    @XmlElement(name = "telefono")
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    // Listado de clientes
    @XmlElementWrapper(name = "clientes")
    @XmlElement(name = "cliente")
    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    // Listado de empleados
    @XmlElementWrapper(name = "empleados")
    @XmlElement(name = "empleado")
    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    // Constructor vacío
    public Empresa() {
    }
}
	

