package com.trabajo;

import java.io.IOException;
import javax.xml.bind.JAXBException;

public class Controlador {
    private Manipulador manipulador;
    private Vista vista;

    public Controlador(Manipulador manipulador, Vista vista) {
        this.manipulador = manipulador;
        this.vista = vista;
    }

  // Método para iniciar el flujo de la aplicación
    public void start()throws JAXBException, IOException{

        int opcion;

        do {
            opcion = vista.mostrarMenu();

            switch (opcion) {
                case 1:
                    vista.mostrarEmpresa(manipulador.leerEmpresa());
                    break;

                case 2:
                    vista.mostrarClientes(manipulador.leerClientes());
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
                    manipulador.borrarCliente();
                    break;
                
                case 9: 
                    manipulador.borrarEmpleado();
                    break;
                
                case 10:
                    manipulador.modificarEmpleado(vista.recogerEmpleadoAModificar());
                    break;
                
                case 11:
                    manipulador.modificarCliente(vista.recogerClienteAModificar());
                    break;

                case 0:
                    vista.mostrarMensaje("Saliendo de la aplicación");
                    break;

                default:
                    vista.mostrarMensaje("Opción no válida. Vuelva a introducir su opción deseada.");
                    break;
            }

        } while (opcion != 0);
    }


}


