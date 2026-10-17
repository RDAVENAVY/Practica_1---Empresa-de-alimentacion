package com.trabajo;

import java.util.*;

public class Vista {


private Scanner sc = new Scanner(System.in); 

    public int mostrarMenu() {

        System.out.println("\n===== GESTIÓN DE PATTO =====");
        System.out.println("1. Mostrar datos de la empresa");
        System.out.println("2. Mostrar todos los clientes");
        System.out.println("3. Consultar un cliente");
        System.out.println("4. Mostrar todos los empleados");
        System.out.println("5. Consultar un empleado");
        System.out.println("6. Añadir un cliente");
        System.out.println("7. Añadir un empleado");
        System.out.println("8. Borrar un cliente");
        System.out.println("9. Borrar un empleado");
        System.out.println("10. Modificar un empleado");
        System.out.println("11. Modificar un cliente");
        System.out.println("0. Salir");
        System.out.print("Selecciona una opción: ");

        while (!sc.hasNextInt()) {
            System.out.println("Debes introducir un número.");
            sc.nextLine();
            System.out.print("Selecciona una opción: ");
        }

        int opcion = sc.nextInt();
        sc.nextLine();

        return opcion;
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarEmpresa(Empresa empresa) {
        System.out.println("\n===== DATOS DE LA EMPRESA =====");
        System.out.println("ID: " + empresa.getId());
        System.out.println("Nombre: " + empresa.getNombre());
        System.out.println("Servicio: " + empresa.getServicio());
        System.out.println("Teléfono: " + empresa.getTelefono());
    }

    public void mostrarClientes(List<Cliente> clientes) {
        System.out.println("\n===== LISTADO DE CLIENTES =====");
        for (Cliente cliente : clientes) {
            mostrarCliente(cliente);
            System.out.println("------------------------------");
        }
    }

    public void mostrarCliente(Cliente cliente) {
        System.out.println("ID: " + cliente.getId());
        System.out.println("DNI: " + cliente.getDni());
        System.out.println("Nombre: " + cliente.getNombre());
        System.out.println("Teléfono: " + cliente.getTelefono());
        System.out.println("Localidad: " + cliente.getLocalidad());
        System.out.println("Edad: " + cliente.getEdad());
        System.out.println("Premium: " + cliente.getPremium());
    }

    public void mostrarEmpleados(List<Empleado> empleados) {
        System.out.println("\n===== LISTADO DE EMPLEADOS =====");
        for (Empleado empleado : empleados) {
            mostrarEmpleado(empleado);
            System.out.println("------------------------------");
        }
    }

    public void mostrarEmpleado(Empleado empleado) {
        System.out.println("ID: " + empleado.getId());
        System.out.println("DNI: " + empleado.getDni());
        System.out.println("Nombre: " + empleado.getNombre());
        System.out.println("Teléfono: " + empleado.getTelefono());
        System.out.println("Localidad: " + empleado.getLocalidad());
        System.out.println("Edad: " + empleado.getEdad());
        System.out.println("Puesto: " + empleado.getPuesto());
        System.out.println("Salario: " + empleado.getSalario());
    }
}
