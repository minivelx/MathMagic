package com.movil.p.mathmagic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

public class iniciar extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar);


        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setTitleTextColor(getResources().getColor(R.color.ColorAccent2));
        getSupportActionBar().setTitle("Elige tu ruta");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.flecha);

    }

    public void comenzarCero(View view) {
        Log.v("iniciar","funcion 1");
    }

    public void comenzarEvaluacion(View view) {
        Log.v("iniciar","funcion 2");
    }


}
