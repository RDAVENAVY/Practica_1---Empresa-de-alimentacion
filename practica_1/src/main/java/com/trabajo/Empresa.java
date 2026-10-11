package com.trabajo;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAttribute;

@XmlRootElement(name = "empresa")

public class Empresa {

	//Atributo id de la empresa
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

	

}
	

