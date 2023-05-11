package com.example.RestApiRJM;

import java.util.Iterator;
import java.util.concurrent.ThreadLocalRandom;

public class TestVo {
	
	// https://parzibyte.me/blog
    public static void main(String[] args) {
        int longitud = 4;
        for (int i = 0; i < 10; i++) {
        	String cadena = cadenaAleatoria(longitud);
            System.out.printf("Cadena aleatoria de %d caracteres: %s\n", longitud, cadena);
		}
        
    }

    public static String cadenaAleatoria(int longitud) {
        // El banco de caracteres
        String banco = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        // La cadena en donde iremos agregando un carácter aleatorio
        String cadena = "";
        for (int x = 0; x < longitud; x++) {
            int indiceAleatorio = numeroAleatorioEnRango(0, banco.length() - 1);
            char caracterAleatorio = banco.charAt(indiceAleatorio);
            cadena += caracterAleatorio;
        }
        return cadena;
    }

    public static int numeroAleatorioEnRango(int minimo, int maximo) {
        // nextInt regresa en rango pero con límite superior exclusivo, por eso sumamos 1
        return ThreadLocalRandom.current().nextInt(minimo, maximo + 1);
    }

}
