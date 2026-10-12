package com.trabajo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class EmpresaModelo {
    
    private final File archivo = new File("proyecto.xml");

    public Empresa cargarEmpresa() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Empresa.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (Empresa) unmarshaller.unmarshal(archivo);
    }

    private void guardarEmpresa(Empresa empresa) throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(Empresa.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
        marshaller.marshal(empresa, new FileWriter(archivo, StandardCharsets.UTF_8));
    }

    public void anadirCliente(Cliente nuevoCliente) throws JAXBException, IOException {
        Empresa empresa = cargarEmpresa();
        empresa.getClientes().add(nuevoCliente);
        guardarEmpresa(empresa);
    }

    public void anadirEmpleado(Empleado nuevoEmpleado) throws JAXBException, IOException {
        Empresa empresa = cargarEmpresa();
        empresa.getEmpleados().add(nuevoEmpleado);
        guardarEmpresa(empresa);
    }

    public boolean borrarCliente(String idCliente) throws JAXBException, IOException {
        Empresa empresa = cargarEmpresa();
        boolean eliminado = empresa.getClientes().removeIf(c -> c.getId().equals(idCliente));
        if (eliminado) {
            guardarEmpresa(empresa);
        }
        return eliminado;
    }

    public boolean borrarEmpleado(String idEmpleado) throws JAXBException, IOException {
        Empresa empresa = cargarEmpresa();
        boolean eliminado = empresa.getEmpleados().removeIf(e -> e.getId().equals(idEmpleado));
        if (eliminado) {
            guardarEmpresa(empresa);
        }
        return eliminado;
    }

    public boolean modificarCliente(Cliente clienteModificado) throws JAXBException, IOException {
        Empresa empresa = cargarEmpresa();
        boolean modificado = false;
        
        for (Cliente c : empresa.getClientes()) {
            if (c.getId().equals(clienteModificado.getId())) {
                c.setDni(clienteModificado.getDni());
                c.setNombre(clienteModificado.getNombre());
                c.setTelefono(clienteModificado.getTelefono());
                c.setLocalidad(clienteModificado.getLocalidad());
                c.setEdad(clienteModificado.getEdad());
                c.setPremium(clienteModificado.getPremium());
                modificado = true;
                break;
            }
        }
        
        if (modificado) {
            guardarEmpresa(empresa);
        }
        return modificado;
    }

    public boolean modificarEmpleado(Empleado empleadoModificado) throws JAXBException, IOException {
        Empresa empresa = cargarEmpresa();
        boolean modificado = false;
        
        for (Empleado e : empresa.getEmpleados()) {
            if (e.getId().equals(empleadoModificado.getId())) {
                e.setDni(empleadoModificado.getDni());
                e.setNombre(empleadoModificado.getNombre());
                e.setTelefono(empleadoModificado.getTelefono());
                e.setLocalidad(empleadoModificado.getLocalidad());
                e.setEdad(empleadoModificado.getEdad());
                e.setPuesto(empleadoModificado.getPuesto());
                e.setSalario(empleadoModificado.getSalario());
                modificado = true;
                break;
            }
        }
        
        if (modificado) {
            guardarEmpresa(empresa);
        }
        return modificado;
    }

}