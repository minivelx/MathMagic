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

            case 2:
                String[] tematica2 = {"Aprendiendo a Restar", "Practica lo aprendido",};
                return tematica2;

            default:
                return null;
        }

    }

}
