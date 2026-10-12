package com.trabajo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class EmpresaModelo {
    
    private final File archivo = new File("proyecto.xml");

    public Empresa cargarEmpresa() throws JAXBException {

    }

    private void guardarEmpresa(Empresa empresa) throws JAXBException, IOException {
    
    }

    public void anadirCliente(Cliente nuevoCliente) throws JAXBException, IOException {

    }

    public void anadirEmpleado(Empleado nuevoEmpleado) throws JAXBException, IOException {

    }

    public boolean borrarCliente(String idCliente) throws JAXBException, IOException {

    }

    public boolean borrarEmpleado(String idEmpleado) throws JAXBException, IOException {

    }

    public boolean modificarCliente(Cliente clienteModificado) throws JAXBException, IOException {

    }

    public boolean modificarEmpleado(Empleado empleadoModificado) throws JAXBException, IOException {

    }

}