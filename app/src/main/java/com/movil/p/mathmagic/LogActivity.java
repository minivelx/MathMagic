package com.movil.p.mathmagic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LogActivity extends AppCompatActivity {

    public static Jugador player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);
        player = new Jugador();
    }

    //pendiente de implementacion
    public void registrar(View view) {

    }

    //se pasa de la vista login a la vista iniciar
    public void iniciar(View view) {
        Intent intent = new Intent(this,iniciar.class);
        startActivity(intent);
    }
}
