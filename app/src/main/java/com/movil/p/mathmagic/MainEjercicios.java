package com.movil.p.mathmagic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainEjercicios extends AppCompatActivity {

    private int[] numeros = {R.drawable.n1, R.drawable.n2, R.drawable.n3, R.drawable.n4, R.drawable.n5, R.drawable.n6, R.drawable.n7, R.drawable.n8, R.drawable.n9, R.drawable.n10};
    private int page;
    ImageView numPar;
    ImageView numImpar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_ejercicios);
        page = 1;
        numImpar = (ImageView) findViewById(R.id.num1);
        numPar = (ImageView) findViewById(R.id.num2);
        numImpar.setImageResource(numeros[0]);
        numPar.setImageResource(numeros[1]);
    }

    public void soundImpar(View view) {
    }

    public void soundPar(View view) {
    }

    public void avanzar(View view) {
        page++;
        numImpar.setImageResource(numeros[page-1]);
        numPar.setImageResource(numeros[page]);
    }
}
