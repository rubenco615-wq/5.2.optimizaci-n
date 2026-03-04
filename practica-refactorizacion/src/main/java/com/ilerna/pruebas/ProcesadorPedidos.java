package com.ilerna.pruebas;

import java.util.List;

/**
 * Código inicial para la práctica de refactorización.
 * Criterios: Nombres genéricos, números mágicos y métodos con demasiadas
 * responsabilidades.
 */
public class ProcesadorPedidos {
    private static final double IVA = 0.21;
    private static final double DESCUENTO_THRESHOLD = 100.0;
    private static final double DESCUENTO_RATE = 0.10;
    private static final double ENVIO_THRESHOLD = 500.0;
    private static final double ENVIO_COST = 15.95;

    public double procesar(List<String> listaNombres, List<Double> listaPrecios) {
        double total = 0;

        // Sumar precios de la lista
        for (int i = 0; i < listaPrecios.size(); i++) {
            System.out.println("Añadiendo producto: " + listaNombres.get(i));
            total = total + listaPrecios.get(i);
        }

        // Lógica de descuento
        if (total > DESCUENTO_THRESHOLD) {
            System.out.println("Descuento aplicado.");
            total = total - (total * DESCUENTO_RATE);
        }

        // Cálculo de impuestos
        double resultado = calcularIVA(total);

        // Gastos de envío
        if (resultado < ENVIO_THRESHOLD) {
            resultado = resultado + ENVIO_COST;
        }

        return resultado;
    }

    private double calcularIVA(double total) {
        return total + (total * IVA);
    }
}