package com.movil.p.mathmagic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Plantilla_Calculo extends AppCompatActivity {

    ImageView img;
    Button next;
    ImageButton b1,b2,b3,b4;
    LinearLayout correcto, incorrecto;
    List<Ejercicio> ejercicios;
    ProgressBar barra;
    TextView enunciado, retro;
    int page=0, puntos=0;
    int [] myDay = {-1,-1,-1,-1,-1,-1,-1};

    int [] images = {R.drawable.ca1, R.drawable.ca2, R.drawable.ca3, R.drawable.ca4, R.drawable.ca5, R.drawable.ca6, R.drawable.ca7, R.drawable.ca8
            ,R.drawable.ca9 ,R.drawable.ca10};

    String [] tipodeEjercicios ={"Resuelva el siguiente limite:", "Resuelva la siguiente derivada:","Resuelva la integral:"};

    int [] posibilidades1 = {R.drawable.a01, R.drawable.b1, R.drawable.d1, R.drawable.e1};
    int [] posibilidades2 = {R.drawable.c1, R.drawable.b1, R.drawable.e1, R.drawable.d1};
    int [] posibilidades3 = {R.drawable.b1, R.drawable.e1, R.drawable.a03, R.drawable.d1};
    int [] posibilidades4 = {R.drawable.b4, R.drawable.c4, R.drawable.d4, R.drawable.a04};
    int [] posibilidades5 = {R.drawable.a05, R.drawable.b5, R.drawable.d5, R.drawable.c5};
    int [] posibilidades6 = {R.drawable.b6, R.drawable.c6, R.drawable.d6, R.drawable.a06};
    int [] posibilidades7 = {R.drawable.b6, R.drawable.c6, R.drawable.d6, R.drawable.a06};
    int [] posibilidades8 = {R.drawable.c8, R.drawable.d8, R.drawable.a08, R.drawable.b8};
    int [] posibilidades9 = {R.drawable.d9, R.drawable.a09, R.drawable.b9, R.drawable.c9};
    int [] posibilidades10 = {R.drawable.a010, R.drawable.b10, R.drawable.c10, R.drawable.d10};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plantilla__calculo);

        enunciado = (TextView) findViewById(R.id.enunciado);
        retro = (TextView) findViewById(R.id.retro);
        img = (ImageView) findViewById(R.id.ejercicio);
        barra = (ProgressBar) findViewById(R.id.toolbar);
        correcto = (LinearLayout) findViewById(R.id.retroalimentacion_ok);
        incorrecto = (LinearLayout) findViewById(R.id.retroalimentacion_fail);

        barra.setMax(7);
        b1 = (ImageButton) findViewById(R.id.btn1);
        b2 = (ImageButton) findViewById(R.id.btn2);
        b3 = (ImageButton) findViewById(R.id.btn3);
        b4 = (ImageButton) findViewById(R.id.btn4);
        next = (Button) findViewById(R.id.bnt_next);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comprobarRespuesta(1);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comprobarRespuesta(2);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comprobarRespuesta(3);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comprobarRespuesta(4);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comprobarRespuesta(4);
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(page<7) {
                    mostrarEjercicio();
                }else {
                    //inten
                    Intent intent = new Intent(Plantilla_Calculo.this,Resumen.class);
                    intent.putExtra("Puntos",puntos);
                    startActivity(intent);
                    finish();
                }
            }
        });

        ejercicios = initEjercicios();
        selectorRetos();
        mostrarEjercicio();
    }

    private void comprobarRespuesta(int boton) {

        //bloqueamos los botones
        b1.setEnabled(false);
        b2.setEnabled(false);
        b3.setEnabled(false);
        b4.setEnabled(false);

        if(ejercicios.get(myDay[page]).getSolucion() == boton){
            correcto.setVisibility(View.VISIBLE);
            puntos +=5;
        }else{
            incorrecto.setVisibility(View.VISIBLE);

            switch (ejercicios.get(myDay[page]).getSolucion()){
                case 1:
                    retro.setText("La respuesta correcta es la A.");
                    break;
                case 2:
                    retro.setText("La respuesta correcta es la B.");
                    break;
                case 3:
                    retro.setText("La respuesta correcta es la C.");
                    break;
                case 4:
                    retro.setText("La respuesta correcta es la D.");
                    break;

            }

        }
        next.setVisibility(View.VISIBLE);
        page++;
        barra.setProgress(page);
        if(page>=7){
            next.setText("Terminar");
        }
    }

    public void mostrarEjercicio() {

        next.setVisibility(View.INVISIBLE);
        correcto.setVisibility(View.INVISIBLE);
        incorrecto.setVisibility(View.INVISIBLE);
        enunciado.setText(ejercicios.get(myDay[page]).getEnunciado());
        img.setImageResource(images[myDay[page]]);

        b1.setEnabled(true);
        b2.setEnabled(true);
        b3.setEnabled(true);
        b4.setEnabled(true);
        b1.setImageResource(ejercicios.get(myDay[page]).getPosibilidad(0));
        b2.setImageResource(ejercicios.get(myDay[page]).getPosibilidad(1));
        b3.setImageResource(ejercicios.get(myDay[page]).getPosibilidad(2));
        b4.setImageResource(ejercicios.get(myDay[page]).getPosibilidad(3));

        //Log.i("revisando", ejercicios.get(0).getPosibilidades(3));

    }

    public void selectorRetos() {

        int n;
        boolean pasar = false;
        Random rnd = new Random();
        n = rnd.nextInt(10) + 0;
        Log.i("N=",String.valueOf(n));
        myDay[0]=n;
        for(int i=0;i<6;i++){
            pasar = false;

            while(!pasar){

                rnd = new Random();
                n = rnd.nextInt(10) + 0;

                if(n!=myDay[0] && n!=myDay[1] && n!=myDay[2] && n!=myDay[3] && n!=myDay[4] && n!=myDay[5] && n!=myDay[6]){
                    myDay[i+1] = n;
                    pasar=true;
                }

            }
        }

        for (int j=0; j<7;j++){
            Log.i("valoes de N=",String.valueOf(myDay[j]));
        }

    }

    private List<Ejercicio> initEjercicios() {

        List<Ejercicio> ejercicios = new ArrayList<>();


        ejercicios.add(new Ejercicio(tipodeEjercicios[0],1,posibilidades1) );

        ejercicios.add(new Ejercicio(tipodeEjercicios[0],2,posibilidades2) );

        ejercicios.add(new Ejercicio(tipodeEjercicios[0],3,posibilidades3) );

        ejercicios.add(new Ejercicio(tipodeEjercicios[1],4,posibilidades4) );

        ejercicios.add(new Ejercicio(tipodeEjercicios[1],1,posibilidades5) );

        ejercicios.add(new Ejercicio(tipodeEjercicios[1],4,posibilidades6) );

        ejercicios.add(new Ejercicio(tipodeEjercicios[1],1,posibilidades7) );

        ejercicios.add(new Ejercicio(tipodeEjercicios[2],3,posibilidades8) );

        ejercicios.add(new Ejercicio(tipodeEjercicios[2],2,posibilidades9) );

        ejercicios.add(new Ejercicio(tipodeEjercicios[2],1,posibilidades10) );

        return ejercicios;

    }
}
