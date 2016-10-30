package com.movil.p.mathmagic;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LogActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);
        cargarPreferencias();

    }

    //pendiente de implementacion
    public void registrar(View view) {

    }

    //se pasa de la vista login a la vista iniciar
    public void iniciar(View view) {
        Intent intent = new Intent(this,iniciar.class);
        startActivity(intent);

    }

    //Metodos para cargar informacion guradada
    public void cargarPreferencias(){

        final ClaseGlobal global = (ClaseGlobal) getApplicationContext();
        Jugador player = new Jugador();
        global.crearJuador(player);

        SharedPreferences mispreferencias = getSharedPreferences("PreferenciasUsuario", Context.MODE_PRIVATE);
        global.getJugador().setNivel(mispreferencias.getInt("nivel",1));
        global.getJugador().setSubNivel(mispreferencias.getInt("subNivel",1));
        global.getJugador().setTotal_pts(mispreferencias.getInt("puntos",0));

        //Se carga directamente al activity Nivel si ya hay progresos guardados
        if(global.getJugador().getNivel()>1 || global.getJugador().getSubNivel()>1){
            Intent intent = new Intent(this,MainNivel.class);
            startActivity(intent);
        }

    }

}
