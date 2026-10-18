package com.trabajo;

import java.io.IOException;
import javax.xml.bind.JAXBException;

public class Main {

    public static void main(String[] args) {

        // Creamos la vista
        Vista vista = new Vista();

        // Creamos el manipulador y le pasamos la vista
        Manipulador manipulador = new Manipulador(vista);

        // Creamos el controlador y le pasamos ambas clases
        Controlador controlador = new Controlador(manipulador, vista);

        // Iniciamos la aplicación
        try {
            controlador.start();
        } catch (JAXBException | IOException e) {
            System.out.println("Error al ejecutar la aplicación: " + e.getMessage());
            e.printStackTrace();
        }
    }
}