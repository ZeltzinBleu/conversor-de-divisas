package com.aluracursos.conversor.de.divisas;

import com.aluracursos.conversor.de.divisas.conversor.Conversion;
import com.aluracursos.conversor.de.divisas.conversor.Conversor;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        int opcion = 0;

        ConsultaMoneda consulta = new ConsultaMoneda();
        ArrayList<Conversion> listaDeConversiones = new ArrayList<>();
        System.out.println("*** ¡Bienvenidx a Mi Conversor de Divisas! ***\n");
        while (opcion != 3) {
            Menu menu = new Menu();
            menu.mostrarMenuPrincipal();
            opcion = menu.elegirOpcionPrincipal();

            switch (opcion) {
                case 1:
                    menu.mostrarOpcionesDisponibles("inicial");
                    String monedaBase = menu.elegirOpcionDisponible();
                    menu.mostrarOpcionesDisponibles("final");
                    String monedaFinal = menu.elegirOpcionDisponible();
                    Double cantidadCambiar = menu.ingresarCantidadACambiar();
                    Conversor conversor = consulta.buscaMoneda(monedaBase);
                    Double tasaDeConversion = conversor.getConversionRate(monedaFinal.toUpperCase());
                    Double cantidadIngresas = menu.cantidadIngresada(monedaBase, cantidadCambiar, tasaDeConversion,monedaFinal);
                    Conversion nuevaConversion = new Conversion(monedaBase, monedaFinal, cantidadCambiar, cantidadIngresas);
                    listaDeConversiones.add(nuevaConversion);
                    break;
                case 2:
                    menu.imprimirConversiones(listaDeConversiones);
                    break;
                case 3:
                    System.out.println("Gracias por utilizar Mi Conversor de Divisas");
                    break;
                default:
                    System.out.println("Opcion no disponible, por favor elija la opcion dentro del menu.");
            }

        }

    }
}
