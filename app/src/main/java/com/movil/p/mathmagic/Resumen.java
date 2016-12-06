package com.movil.p.mathmagic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Resumen extends AppCompatActivity {

    int puntos;
    TextView titulo,puntaje,correctas,incorrectas,nivel;
    Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumen);

        puntos = getIntent().getIntExtra("Puntos",1);

        titulo = (TextView) findViewById(R.id.textView7);
        puntaje = (TextView) findViewById(R.id.textView9);
        correctas = (TextView) findViewById(R.id.corectas);
        incorrectas = (TextView) findViewById(R.id.incorrectas);

        btnNext = (Button) findViewById(R.id.btnNext);

        btnNext.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Resumen.this,Menu_Areas.class);
                startActivity(intent);
                finish();
            }
        });

        //Mostramos resultados y guardamos
        puntaje.setText(String.valueOf(puntos));
        correctas.setText(String.valueOf(puntos/5));
        incorrectas.setText(String.valueOf(7-puntos/5));
        titulo.setText("Master");
        final ClaseGlobal global = (ClaseGlobal) getApplicationContext();
        global.getJugador().setTotal_pts(global.getJugador().getTotal_pts()+puntos);
    }

}
