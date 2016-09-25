package com.movil.p.mathmagic;

public class Juego {

    private int subnivel;

    public Juego() {
        subnivel = 1;
    }

    public static String[] getTematica(int nivel){

        switch (nivel){

            case 1:
                String[] tematica = {"Saluda a los Números", "Practica lo aprendido", "Comienza a Sumar"};
                return tematica;

            default:
                return null;
        }

    }

}
