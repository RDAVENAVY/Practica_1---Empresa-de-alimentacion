package com.trabajo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import javax.xml.bind.JAXBException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class Manipulador {

    // Lee el archivo XML y lo convierte en un objeto Empresa para ser leido
    public static Empresa leerEmpresa(File f) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Empresa.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (Empresa) unmarshaller.unmarshal(f);
    }

    // Añade un nuevo empleado a la lista de la empresa y guarda el XML
    public static boolean crearEmpleado(Empleado eNuevo, File f) throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(Empresa.class);
        Empresa empresa = leerEmpresa(f);
        empresa.getEmpleados().add(eNuevo);
        guardarXML(empresa, f, context);
        return true;
    }

    // Añade un nuevo cliente a la lista de la empresa y guarda el XML
    public static boolean crearCliente(Cliente cNuevo, File f) throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(Empresa.class);
        Empresa empresa = leerEmpresa(f);
        empresa.getClientes().add(cNuevo);
        guardarXML(empresa, f, context);
        return true;
    }

    // Busca un empleado por su ID y lo devuelve si lo encuentra
    public static Empleado leerEmpleado(int id, File f) throws JAXBException {
        Empresa empresa = leerEmpresa(f);
        for (Empleado e : empresa.getEmpleados()) {
            if (e.getId() == id) { // Comparación de enteros
                return e;
            }
        }
        return null;
    }

    // Busca un cliente por su ID y lo devuelve si lo encuentra
    public static Cliente leerCliente(int id, File f) throws JAXBException {
        Empresa empresa = leerEmpresa(f);
        for (Cliente c : empresa.getClientes()) {
            if (c.getId() == id) { // Comparación de enteros
                return c;
            }
        }
        return null;
    }

    // Devuelve la lista completa de empleados
    public static List<Empleado> leerEmpleados(File f) throws JAXBException {
        Empresa empresa = leerEmpresa(f);
        return empresa.getEmpleados();
    }

    // Devuelve la lista completa de clientes
    public static List<Cliente> leerClientes(File f) throws JAXBException {
        Empresa empresa = leerEmpresa(f);
        return empresa.getClientes();
    }

    // Elimina un empleado por su ID y actualiza el archivo XML
    public static boolean borrarEmpleado(int id, File f) throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(Empresa.class);
        Empresa empresa = leerEmpresa(f);

        Empleado aBorrar = null;
        for (Empleado e : empresa.getEmpleados()) {
            if (e.getId() == id) { // Comparación de enteros
                aBorrar = e;
                break;
            }
        }

        if (aBorrar != null) {
            empresa.getEmpleados().remove(aBorrar);
            guardarXML(empresa, f, context);
            return true;
        }
        return false;
    }

    // Elimina un cliente por su ID y actualiza el archivo XML
    public static boolean borrarCliente(int id, File f) throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(Empresa.class);
        Empresa empresa = leerEmpresa(f);

        Cliente aBorrar = null;
        for (Cliente c : empresa.getClientes()) {
            if (c.getId() == id) { // Comparación de enteros
                aBorrar = c;
                break;
            }
        }

        if (aBorrar != null) {
            empresa.getClientes().remove(aBorrar);
            guardarXML(empresa, f, context);
            return true;
        }
        return false;
    }

    // Busca un empleado por su ID, actualiza sus datos y guarda el XML
    public static boolean modificarEmpleado(int id, Empleado eModificar, File f) throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(Empresa.class);
        Empresa empresa = leerEmpresa(f);

        for (Empleado e : empresa.getEmpleados()) {
            if (e.getId() == id) { // Comparación de enteros
                e.setDni(eModificar.getDni());
                e.setNombre(eModificar.getNombre());
                e.setTelefono(eModificar.getTelefono());
                e.setLocalidad(eModificar.getLocalidad());
                e.setEdad(eModificar.getEdad());
                e.setPuesto(eModificar.getPuesto());
                e.setSalario(eModificar.getSalario());
                guardarXML(empresa, f, context);
                return true;
            }
        }
        return false;
    }

    // Busca un cliente por su ID, actualiza sus datos y guarda el XML
    public static boolean modificarCliente(int id, Cliente cModificar, File f) throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(Empresa.class);
        Empresa empresa = leerEmpresa(f);

        for (Cliente c : empresa.getClientes()) {
            if (c.getId() == id) { // Comparación de enteros
                c.setDni(cModificar.getDni());
                c.setNombre(cModificar.getNombre());
                c.setTelefono(cModificar.getTelefono());
                c.setLocalidad(cModificar.getLocalidad());
                c.setEdad(cModificar.getEdad());
                c.setPremium(cModificar.getPremium());
                guardarXML(empresa, f, context);
                return true;
            }
        }
        return false;
    }

    // Método auxiliar privado para guardar el objeto Empresa en el archivo XML
    private static void guardarXML(Empresa empresa, File f, JAXBContext context) throws JAXBException, IOException {
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
        marshaller.setProperty(Marshaller.JAXB_FRAGMENT, false);
        marshaller.marshal(empresa, new FileWriter(f, StandardCharsets.UTF_8));
    }
}