package com.movil.p.mathmagic;


import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;

public class ClaseGlobal extends Application{

    //instanciamos al jugador
    private Jugador player;

    public void crearJuador(Jugador p) {
        player=p;
    }

    public Jugador getJugador() {
        return player;
    }

    public void cambiarSubnivel(int subnivel){
        player.setSubNivel(subnivel);
        guardar();
    }

    public void guardar() {

        SharedPreferences mispreferencias = getSharedPreferences("PreferenciasUsuario", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = mispreferencias.edit();
        editor.putInt("nivel",player.getNivel());
        editor.putInt("subNivel",player.getSubNivel());
        editor.putInt("puntos",player.getSubNivel());
        editor.commit();
    }

}
