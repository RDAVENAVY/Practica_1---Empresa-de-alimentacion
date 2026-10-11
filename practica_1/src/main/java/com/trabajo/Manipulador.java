package com.trabajo; 

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import javax.xml.bind.JAXBException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;


public class Manipulador {
    public static void main(String[] args) throws JAXBException, IOException{
        
        File f=new File("proyecto.xml");
        
        crearEmpleado(,f);
        crearCliente(,f);
        leerEmpresa(,f);
        leerClientes(,f);
        leerCliente(,f);
        leerEmpleados(,f);
        leerEmpleado(,f);
        borrarEmpleado(,f);
        borrarCliente(,f);
        modificarEmpleado(,f);
        modificarCliente(,f);

    }

    public static void leerEmpresa(File f) throws JAXBException{

    }

    public static void crearEmpleado(Empleado Enuevo, File f) throws JAXBException, IOException{

    }

    public static void crearCliente(Cliente Cnuevo, File f) throws JAXBException, IOException{

    }

    public static void leerEmpleado(Empleado Eleer, File f) throws JAXBException, IOException{

    }

    public static void leerCliente(Cliente Cleer, File f) throws JAXBException, IOException{

    }

    public static void leerEmpleados(File f) throws JAXBException{

    }

    public static void leerClientes(File f) throws JAXBException{

    }


    public static void borrarEmpleado(Empleado Eborrar, File f) throws JAXBException, IOException{

    }

    public static void borrarCliente(Cliente Cborrar, File f) throws JAXBException, IOException{

    }

    public static void modificarEmpleado(Empleado Emodificar, File f) throws JAXBException, IOException{

    }

    public static void modificarCliente(Cliente Cmodificar, File f) throws JAXBException, IOException{

    }

}
