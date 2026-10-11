package com.trabajo;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "clientes")
public class Clientes {
	
	ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();

	public Clientes(ArrayList<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

	public Clientes() {
	}

	@XmlElement(name = "cliente")
	public ArrayList<Cliente> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(ArrayList<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}
}