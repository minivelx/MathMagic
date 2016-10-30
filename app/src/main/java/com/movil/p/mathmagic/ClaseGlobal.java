package com.movil.p.mathmagic;


import android.app.Application;

public class ClaseGlobal extends Application{

    //instanciamos al jugador
    private Jugador player;

    public void crearJuador(Jugador p) {
        player=p;
    }

    public Jugador getJugador() {
        return player;
    }
}
