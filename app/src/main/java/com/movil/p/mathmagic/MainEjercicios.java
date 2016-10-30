package com.movil.p.mathmagic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainEjercicios extends AppCompatActivity {

    private int[] numeros = {R.drawable.n1, R.drawable.n2, R.drawable.n3, R.drawable.n4, R.drawable.n5, R.drawable.n6, R.drawable.n7, R.drawable.n8, R.drawable.n9, R.drawable.n10};
    private int[] figuras = {R.drawable.a1, R.drawable.a2, R.drawable.a3, R.drawable.a4, R.drawable.a5, R.drawable.a6, R.drawable.a7, R.drawable.a8, R.drawable.a9, R.drawable.a10};
    private int page;
    ImageView numPar;
    ImageView numImpar;
    ImageView fig1;
    ImageView fig2;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_ejercicios);
        page = 1;
        btn = (Button) findViewById(R.id.next);

        numImpar = (ImageView) findViewById(R.id.num1);
        numPar = (ImageView) findViewById(R.id.num2);

        fig1 = (ImageView) findViewById(R.id.figura_num);
        fig2 = (ImageView) findViewById(R.id.figura_num2);

        numImpar.setImageResource(numeros[0]);
        numPar.setImageResource(numeros[1]);

        fig1.setImageResource(figuras[0]);
        fig2.setImageResource(figuras[1]);

    }

    public void soundImpar(View view) {
    }

    public void soundPar(View view) {
    }

    public void avanzar(View view) {
        page++;
        final ClaseGlobal global=(ClaseGlobal) getApplicationContext();
        //Log.i("MainEjercicios",String.valueOf(global.getJugador().getSubNivel()));

        if(page<=5){
            numImpar.setImageResource(numeros[page*2-2]);
            numPar.setImageResource(numeros[page*2-1]);

            fig1.setImageResource(figuras[page*2-2]);
            fig2.setImageResource(figuras[page*2-1]);
        }

        if(page==5){
            btn.setText("Terminar");
        }

        if(page>5){

            global.cambiarSubnivel(2);
            Intent intent = new Intent(this,MainNivel.class);
            finish();
            startActivity(intent);

        }
    }
}
