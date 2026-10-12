package com.trabajo; 

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.xml.bind.JAXBException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;


public class Manipulador {
    public static void main(String[] args) throws JAXBException, IOException{
        
        File f=new File("proyecto.xml");
        
        leerEmpresa(f);
        leerClientes(f);
        leerEmpleados(f);
        
    }

    public static void leerEmpresa(File f) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Empresa.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Empresa empresa = (Empresa) unmarshaller.unmarshal(f);

        System.out.println("DATOS DE LA EMPRESA");
        System.out.println("ID: " + empresa.getId());
        System.out.println("Nombre: " + empresa.getNombre());
        System.out.println("Servicio: " + empresa.getServicio());
        System.out.println("Telefono: " + empresa.getTelefono());
        System.out.println("-----------------------------------");
    }

    public static void crearEmpleado(Empleado Enuevo, File f) throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(Empresa.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Empresa empresa = (Empresa) unmarshaller.unmarshal(f);

        empresa.getEmpleados().add(Enuevo);

        guardarXML(empresa, f, context);
        System.out.println("Empleado creado y guardado con exito.");
    }

    public static void crearCliente(Cliente Cnuevo, File f) throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(Empresa.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Empresa empresa = (Empresa) unmarshaller.unmarshal(f);

        empresa.getClientes().add(Cnuevo);

        guardarXML(empresa, f, context);
        System.out.println("Cliente creado y guardado con exito.");
    }

    public static void leerEmpleado(Empleado Eleer, File f) throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(Empresa.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Empresa empresa = (Empresa) unmarshaller.unmarshal(f);

        boolean encontrado = false;
        for (Empleado e : empresa.getEmpleados()) {
            if (e.getId().equals(Eleer.getId()) || e.getDni().equals(Eleer.getDni())) {
                System.out.println("EMPLEADO ENCONTRADO");
                System.out.println("ID: " + e.getId() + " | DNI: " + e.getDni() + " | Nombre: " + e.getNombre() +
                        " | Tel: " + e.getTelefono() + " | Loc: " + e.getLocalidad() + " | Edad: " + e.getEdad() +
                        " | Puesto: " + e.getPuesto() + " | Salario: " + e.getSalario());
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontro el empleado especificado.");
        }
    }

    public static void leerCliente(Cliente Cleer, File f) throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(Empresa.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Empresa empresa = (Empresa) unmarshaller.unmarshal(f);

        boolean encontrado = false;
        for (Cliente c : empresa.getClientes()) {
            if (c.getId().equals(Cleer.getId()) || c.getDni().equals(Cleer.getDni())) {
                System.out.println("CLIENTE ENCONTRADO");
                System.out.println("ID: " + c.getId() + " | DNI: " + c.getDni() + " | Nombre: " + c.getNombre() +
                        " | Tel: " + c.getTelefono() + " | Loc: " + c.getLocalidad() + " | Edad: " + c.getEdad() +
                        " | Premium: " + c.getPremium());
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontro el cliente especificado.");
        }
    }

    public static void leerEmpleados(File f) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Empresa.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Empresa empresa = (Empresa) unmarshaller.unmarshal(f);

        System.out.println("LISTA DE EMPLEADOS");
        for (Empleado e : empresa.getEmpleados()) {
            System.out.println("ID: " + e.getId() + " | Nombre: " + e.getNombre() + " | Puesto: " + e.getPuesto() + " | Salario: " + e.getSalario());
        }
        System.out.println("-----------------------------------");
    }

    public static void leerClientes(File f) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Empresa.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Empresa empresa = (Empresa) unmarshaller.unmarshal(f);

        System.out.println("LISTA DE CLIENTES");
        for (Cliente c : empresa.getClientes()) {
            System.out.println("ID: " + c.getId() + " | Nombre: " + c.getNombre() + " | Localidad: " + c.getLocalidad() + " | Premium: " + c.getPremium());
        }
        System.out.println("-----------------------------------");
    }

    public static void borrarEmpleado(Empleado Eborrar, File f) throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(Empresa.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Empresa empresa = (Empresa) unmarshaller.unmarshal(f);

        boolean eliminado = empresa.getEmpleados().removeIf(e -> 
            e.getId().equals(Eborrar.getId()) || e.getDni().equals(Eborrar.getDni())
        );
        
        if (eliminado) {
            guardarXML(empresa, f, context);
            System.out.println("Empleado borrado correctamente.");
        } else {
            System.out.println("No se encontro el empleado a borrar.");
        }
    }

    public static void borrarCliente(Cliente Cborrar, File f) throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(Empresa.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Empresa empresa = (Empresa) unmarshaller.unmarshal(f);

        boolean eliminado = empresa.getClientes().removeIf(c -> 
            c.getId().equals(Cborrar.getId()) || c.getDni().equals(Cborrar.getDni())
        );

        if (eliminado) {
            guardarXML(empresa, f, context);
            System.out.println("Cliente borrado correctamente.");
        } else {
            System.out.println("No se encontro el cliente a borrar.");
        }
    }

    public static void modificarEmpleado(Empleado Emodificar, File f) throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(Empresa.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Empresa empresa = (Empresa) unmarshaller.unmarshal(f);

        boolean modificado = false;
        for (Empleado e : empresa.getEmpleados()) {
            if (e.getId().equals(Emodificar.getId())) {
                e.setDni(Emodificar.getDni());
                e.setNombre(Emodificar.getNombre());
                e.setTelefono(Emodificar.getTelefono());
                e.setLocalidad(Emodificar.getLocalidad());
                e.setEdad(Emodificar.getEdad());
                e.setPuesto(Emodificar.getPuesto());
                e.setSalario(Emodificar.getSalario());
                modificado = true;
                break;
            }
        }

        if (modificado) {
            guardarXML(empresa, f, context);
            System.out.println("Empleado modificado correctamente.");
        } else {
            System.out.println("No se encontró el empleado para modificar.");
        }
    }

    public static void modificarCliente(Cliente Cmodificar, File f) throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(Empresa.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Empresa empresa = (Empresa) unmarshaller.unmarshal(f);

        boolean modificado = false;
        for (Cliente c : empresa.getClientes()) {
            if (c.getId().equals(Cmodificar.getId())) {
                c.setDni(Cmodificar.getDni());
                c.setNombre(Cmodificar.getNombre());
                c.setTelefono(Cmodificar.getTelefono());
                c.setLocalidad(Cmodificar.getLocalidad());
                c.setEdad(Cmodificar.getEdad());
                c.setPremium(Cmodificar.getPremium());
                modificado = true;
                break;
            }
        }

        if (modificado) {
            guardarXML(empresa, f, context);
            System.out.println("Cliente modificado correctamente.");
        } else {
            System.out.println("No se encontro el cliente para modificar.");
        }
    }

    private static void guardarXML(Empresa empresa, File f, JAXBContext context) throws JAXBException, IOException {
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
        marshaller.setProperty(Marshaller.JAXB_FRAGMENT, false);
        marshaller.marshal(empresa, new FileWriter(f, StandardCharsets.UTF_8));
    }
}
