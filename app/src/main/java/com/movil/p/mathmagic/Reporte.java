package com.movil.p.mathmagic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Reporte extends AppCompatActivity {

    int puntos;
    TextView titulo,puntaje,correctas,incorrectas,nivel;
    Button btnNext,btnReplay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporte);

        puntos = getIntent().getIntExtra("Puntos",1);

        titulo = (TextView) findViewById(R.id.textView7);
        puntaje = (TextView) findViewById(R.id.textView9);
        correctas = (TextView) findViewById(R.id.corectas);
        incorrectas = (TextView) findViewById(R.id.incorrectas);
        nivel = (TextView) findViewById(R.id.nivel);
        btnReplay = (Button) findViewById(R.id.btnReplay);
        btnNext = (Button) findViewById(R.id.btnNext);
        //Bloqueo de botones
        //btnNext.setEnabled(false);
        //btnReplay.setEnabled(false);


        btnNext.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Reporte.this,Menu_Areas.class);
                startActivity(intent);
                finish();
            }
        });

        btnReplay.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Reporte.this,Quiz.class);
                startActivity(intent);
                finish();
            }
        });

        //Calculamos el nivel
        if(puntos>=15){
            nivel.setText(String.valueOf(10));
            puntaje.setText(String.valueOf(puntos*5));
            titulo.setText("Master");
            final ClaseGlobal global = (ClaseGlobal) getApplicationContext();
            global.getJugador().setNivel(10);
            global.getJugador().setTotal_pts(puntos*5);
            btnNext.setEnabled(true);
        }else{
            nivel.setText(String.valueOf(4));
            puntaje.setText(String.valueOf(puntos*5));
            titulo.setText("Principiante");
            correctas.setText(String.valueOf(puntos));
            incorrectas.setText(String.valueOf(24-puntos));
            btnReplay.setEnabled(true);
        }
    }
}
