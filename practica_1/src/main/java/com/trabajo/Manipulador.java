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

    //Establecemos ruta al archivo proyecto.xml y creamos una instancia Vista.
    private  File archivo = new File("proyecto.xml");
    private  Vista vista;

    public Manipulador(Vista vista) {
        this.vista = vista;
    }

    // Lee el archivo XML y lo convierte en un objeto Empresa
    public Empresa leerEmpresa() throws JAXBException {
    JAXBContext context = JAXBContext.newInstance(Empresa.class);
    Unmarshaller unmarshaller = context.createUnmarshaller();

    return (Empresa) unmarshaller.unmarshal(archivo);
    }
    

    // Añade un nuevo empleado a la lista de la empresa y guarda el XML
    public boolean crearEmpleado(Empleado eNuevo) throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(Empresa.class);
        Empresa empresa = leerEmpresa();

        empresa.getEmpleados().add(eNuevo);

        guardarXML(empresa, context);
        return true;
    }

  
    // Añade un nuevo cliente a la lista de la empresa y guarda el XML
    public boolean crearCliente(Cliente cNuevo) throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(Empresa.class);
        Empresa empresa = leerEmpresa();

        empresa.getClientes().add(cNuevo);

        guardarXML(empresa, context);
        return true;
    }
   

   // Busca un empleado por su ID y lo devuelve si lo encuentra. Usamos pedirId() y mostrarMensaje()
    public Empleado leerEmpleado() throws JAXBException {
        vista.mostrarMensaje("Introduce el ID del empleado:");
        int id = vista.pedirId();

        Empresa empresa = leerEmpresa();

        for (Empleado e : empresa.getEmpleados()) {
            if (e.getId() == id) {
                return e;
            }
        }

        vista.mostrarMensaje("No se ha encontrado ningún empleado con ese ID.");
        return null;
    }

   // Busca un cliente por su ID y lo devuelve si lo encuentra
    public Cliente leerCliente() throws JAXBException {
        vista.mostrarMensaje("Introduce el ID del cliente:");
        int id = vista.pedirId();

        Empresa empresa = leerEmpresa();

        for (Cliente c : empresa.getClientes()) {
            if (c.getId() == id) {
                return c;
            }
        }

        vista.mostrarMensaje("No se ha encontrado ningún cliente con ese ID.");
        return null;
    }

    // Devuelve la lista completa de empleados
    public List<Empleado> leerEmpleados() throws JAXBException {
        Empresa empresa = leerEmpresa();
        return empresa.getEmpleados();
    }

   // Devuelve la lista completa de clientes
    public List<Cliente> leerClientes() throws JAXBException {
        Empresa empresa = leerEmpresa();
        return empresa.getClientes();
    }

   // Elimina un empleado por su ID y actualiza el archivo XML
    public boolean borrarEmpleado() throws JAXBException, IOException {
        vista.mostrarMensaje("Introduce el ID del empleado que quieres borrar:");
        int id = vista.pedirId();

        JAXBContext context = JAXBContext.newInstance(Empresa.class);
        Empresa empresa = leerEmpresa();

        Empleado aBorrar = null;

        for (Empleado e : empresa.getEmpleados()) {
            if (e.getId() == id) {
                aBorrar = e;
                break;
            }
        }

        if (aBorrar != null) {
            empresa.getEmpleados().remove(aBorrar);
            guardarXML(empresa, context);
            vista.mostrarMensaje("Empleado eliminado correctamente.");
            return true;
        }

        vista.mostrarMensaje("No se ha encontrado ningún empleado con ese ID.");
        return false;
    }

    // Elimina un cliente por su ID y actualiza el archivo XML
    public boolean borrarCliente() throws JAXBException, IOException {
        vista.mostrarMensaje("Introduce el ID del cliente que quieres borrar:");
        int id = vista.pedirId();

        JAXBContext context = JAXBContext.newInstance(Empresa.class);
        Empresa empresa = leerEmpresa();

        Cliente aBorrar = null;

        for (Cliente c : empresa.getClientes()) {
            if (c.getId() == id) {
                aBorrar = c;
                break;
            }
        }

        if (aBorrar != null) {
            empresa.getClientes().remove(aBorrar);
            guardarXML(empresa, context);
            vista.mostrarMensaje("Cliente eliminado correctamente.");
            return true;
        }

        vista.mostrarMensaje("No se ha encontrado ningún cliente con ese ID.");
        return false;
    }

    // Busca un empleado por su ID, actualiza sus datos y guarda el XML
    public boolean modificarEmpleado(Empleado eModificar)
            throws JAXBException, IOException {

        int id = eModificar.getId();

        JAXBContext context = JAXBContext.newInstance(Empresa.class);
        Empresa empresa = leerEmpresa();

        for (Empleado e : empresa.getEmpleados()) {
            if (e.getId() == id) {
                e.setDni(eModificar.getDni());
                e.setNombre(eModificar.getNombre());
                e.setTelefono(eModificar.getTelefono());
                e.setLocalidad(eModificar.getLocalidad());
                e.setEdad(eModificar.getEdad());
                e.setPuesto(eModificar.getPuesto());
                e.setSalario(eModificar.getSalario());

                guardarXML(empresa, context);
                vista.mostrarMensaje("Empleado modificado correctamente.");
                return true;
            }
        }

        vista.mostrarMensaje("No se ha encontrado ningún empleado con ese ID.");
        return false;
    }
        
    // Busca un cliente por su ID, actualiza sus datos y guarda el XML
    public boolean modificarCliente(Cliente cModificar)
            throws JAXBException, IOException {

        int id = cModificar.getId();

        JAXBContext context = JAXBContext.newInstance(Empresa.class);
        Empresa empresa = leerEmpresa();

        for (Cliente c : empresa.getClientes()) {
            if (c.getId() == id) {
                c.setDni(cModificar.getDni());
                c.setNombre(cModificar.getNombre());
                c.setTelefono(cModificar.getTelefono());
                c.setLocalidad(cModificar.getLocalidad());
                c.setEdad(cModificar.getEdad());
                c.setPremium(cModificar.getPremium());

                guardarXML(empresa, context);
                vista.mostrarMensaje("Cliente modificado correctamente.");
                return true;
            }
        }

        vista.mostrarMensaje("No se ha encontrado ningún cliente con ese ID.");
        return false;
    }

    // Guarda el objeto Empresa en el archivo XML
    private void guardarXML(Empresa empresa, JAXBContext context)
            throws JAXBException, IOException {

        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
        marshaller.setProperty(Marshaller.JAXB_FRAGMENT, false);

        try (FileWriter writer =
                new FileWriter(archivo, StandardCharsets.UTF_8)) {
            marshaller.marshal(empresa, writer);
        }
    }


}