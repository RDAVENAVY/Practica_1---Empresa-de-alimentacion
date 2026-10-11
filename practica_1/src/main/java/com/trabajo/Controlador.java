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
                    vista.mostrarEmpresa(manipulador.leerEmpresa());
                    break;
                case 2:
                    vista.mostrarClientes(manipilador.leerClientes);
                    break;


                case 3:
                    vista.mostrarCliente(manipulador.leerCliente());
                    break;

                case 4:
                    vista.mostrarEmpleados(manipulador.leerEmpleados());
                    break;
                
                case 5:
                    vista.mostrarEmpleado(manipulador.leerEmpleado());
                    break;
                
                case 6: 
                  
                    manipulador.crearCliente(vista.recogerNuevoCliente());
                    break;

                case 7: 
                    manipulador.crearEmpleado(vista.recogerNuevoEmpleado());
                    break;

                case 8:
                    manipulador.borrarCliente(vista.recogerClienteABorrar());
                    break;
                
                case 9: 
                    manipulador.borrarEmpleado(vista.recogerEmpleadoABorrar());
                    break;
                
                case 10:
                    manipulador.modificarEmpleado(vista.recogerEmpleadoAModificar());
                    break;
                
                case 11:
                    manipulador.modificarCliente(vista.recogerClienteAModificar());

                case 0:
                    vista.mostrarMensaje("Saliendo de la aplicación");
                    break;
            }

        } while (opcion != 0);
    }


    }
}

