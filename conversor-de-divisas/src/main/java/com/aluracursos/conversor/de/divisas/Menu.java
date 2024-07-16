package com.aluracursos.conversor.de.divisas;

import com.aluracursos.conversor.de.divisas.conversor.Conversion;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private String opcionesDisponibles = """
            MXN ... Peso Mexicano
            USD ... Dolar Estadounidense
            BRL ... Real Brasileño
            JPY ... Yen Japones
            EUR ... Euro
            ARS ... Peso Argentino
            BOB ... Boliviano 
            CLP ... Peso Chileno
            COP ... Peso Colombiano""";

    public void mostrarMenuPrincipal() {
        System.out.println("****************************************************************");
        System.out.println("Elije la opcion que más desees: \n");
        String menuPrincipal = """
                    1 - Realiza una conversión
                    2 - Consulta historial de movimientos
                    3 - Salir""";
        System.out.println(menuPrincipal);
    }

    public int elegirOpcionPrincipal(){
        Scanner lectura = new Scanner(System.in);
        System.out.println("Elije una opción");
        return lectura.nextInt();
    }

    public void mostrarOpcionesDisponibles(String denominacion){
        System.out.println("***************************************************************");
        System.out.println("Elije la divisa " + denominacion + ": \n");
        System.out.println(opcionesDisponibles);
        System.out.println("***************************************************************");
    }

    public String elegirOpcionDisponible(){
        Scanner lectura = new Scanner(System.in);
        String opcion = lectura.nextLine().toLowerCase();
        while (!opcionesDisponibles.toLowerCase().contains(opcion)) {
            System.out.println("La opcion elegida no esta disponible");
            System.out.println("Elije una opcion valida");
            System.out.println("*************************************************************");
            opcion = lectura.nextLine().toLowerCase();
        }
        return opcion.toUpperCase();

    }

    public Double ingresarCantidadACambiar(){
        System.out.println("*******************************************************************");
        System.out.println("Ingresa la cantidad que deseas convertir: \n");
        Scanner lectura = new Scanner(System.in);
        double cantidad;
        while (!lectura.hasNextDouble()) {
            System.out.println("****************************************************************");
            System.out.println("El digito ingresado no es valido");
            System.out.println("Digita una cantidad valida");
            lectura.nextLine();
        }
        cantidad = lectura.nextDouble();
        lectura.nextLine();
        return cantidad;
    }

    public Double cantidadIngresada(String monedaBase, Double cantidadCambiar, Double tasaDeconversion, String monedaFinal){
        Double resultado = cantidadCambiar * tasaDeconversion;
        System.out.println("***********************************************************************");
        System.out.println(cantidadCambiar + " " + monedaBase + " equivale a: " + resultado + " " + monedaFinal);
        return resultado;
    }

    public void imprimirConversiones(ArrayList<Conversion> listaDeConversiones) {
        if (listaDeConversiones.isEmpty()){
            System.out.println("No se han realizado ninguna conversion.");
        }else {
            System.out.println("Historial de operaciones:");
            for (int i = 0; i < listaDeConversiones.size(); i++) {
                Conversion conversion = listaDeConversiones.get(i);
                System.out.println("Conversion " + (i + 1) + ":" );
                System.out.println("Moneda origen: " + conversion.getMonedaBase());
                System.out.println("Moneda objetivo: " + conversion.getMonedaObjetivo());
                System.out.println("Cantidad a cambiar: " + conversion.getCantidadACambiar());
                System.out.println("Cantidad obtenida: " + conversion.getCantidadEnMonedaObjetivo());
                System.out.println("************************************************************");
            }
        }
    }

}
