package com.trabajo;


import java.io.IOException;
import java.util.List;
import java.util.Scanner;


public class Controlador {
    private Manipulador manipulador;
    private Vista vista;

    public Controlador(Manipulador manipulador, Vista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    // Método para iniciar el flujo de la aplicación
    public void start() throws IOException {
     
    
  // Método para iniciar el flujo de la aplicación
    public void start() throws IOException {

        int opcion;

        do {
            opcion = vista.mostrarMenu();

            switch (opcion) {
                case 1:
                    vista.mostrarEmpresa();
                    break;
                case 2:
                    vista.mostrarClientes();
                    break;


                case 3: 
                    

                case 0:
                    break;
            }

        } while (opcion != 0);
    }


    }
}

