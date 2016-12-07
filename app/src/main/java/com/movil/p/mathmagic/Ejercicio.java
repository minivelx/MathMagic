package com.movil.p.mathmagic;

/**
 * Created by miguel on 6/12/16.
 */

public class Ejercicio {

    private String enunciado;
    private int solucion;
    String [] posibilidades = new String[4];
    int [] posibilidad = new int[4];

    Ejercicio(String enunciado, int solucion, String [] posibilidades){
        this.enunciado = enunciado;
        this.solucion = solucion;
        this.posibilidades = posibilidades;

    }

    Ejercicio(String enunciado, int solucion, int [] posibilidad){
        this.enunciado = enunciado;
        this.solucion = solucion;
        this.posibilidad = posibilidad;

    }

    public String getEnunciado() {
        return enunciado;
    }

    public int getSolucion() {
        return solucion;
    }

    public String getPosibilidades(int pos) {
        return posibilidades[pos];
    }

    public int getPosibilidad(int pos) {
        return posibilidad[pos];
    }
}
