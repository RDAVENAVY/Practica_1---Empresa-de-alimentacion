package com.trabajo;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAttribute;

@XmlRootElement(name = "empresa")

public class Empresa {

	//Creo atributos clase empresa
	private int id;
    private String nombre;
    private String servicio;
    private String telefono;

	//Atributo de la etiqueta id de la empresa
	@XmlAttribute(name = "id")
	public int getId() {
		return id;
	}

	public void setId( int id) {
		this.id = id;
	}

	//Elemento nombre de la empresa
	@XmlElement(name = "nombre")
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	//Elemento Servicio
	@XmlElement(name = "servicio")
	public String getServicio() {
		return servicio;
	}

	public void setServicio(String servicio) {
		this.servicio = servicio;
	}

	//Elemento teléfono
	@XmlElement(name = "telefono")
	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	//Listado de clientes
	@XmlElementWrapper(name = "clientes")
    @XmlElement(name = "cliente")
    private List<Cliente> clientes;

	//Listado de empleados
    @XmlElementWrapper(name = "empleados")
    @XmlElement(name = "empleado")
    private List<Empleado> empleados;

	//Constructor vacío de empresa
    public Empresa() {
    }

}
	

