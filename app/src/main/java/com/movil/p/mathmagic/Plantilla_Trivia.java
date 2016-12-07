package com.movil.p.mathmagic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Plantilla_Trivia extends AppCompatActivity {

    ImageView img;
    Button b1,b2,next;
    LinearLayout correcto, incorrecto;
    List<Ejercicio> ejercicios;
    ProgressBar barra;
    TextView enunciado, retro;
    int page=0, puntos=0;
    int [] myDay = {-1,-1,-1,-1,-1,-1,-1};
    int [] images = {R.drawable.t1, R.drawable.t2, R.drawable.t3, R.drawable.t4, R.drawable.t5, R.drawable.t6, R.drawable.t7};
    int [] respuestas = {2,2,2,1,1,2,2};
    String [] retroalimentacion = {"Recuerda que 0/0 no esta definido", "La función mostrada es convexa","Un triángulo isósceles tiene 1 lado diferente a los demás," +
            "el equilatero los tiene todos iguales" , "Ésta es una propiedad que caracteriza a todos los triángulos sin importar su tipo", "La ecuación corresponde a " +
            "la identidad de Euler, se puede demostrar facilmente", "La función toma valores negativos para valores de X entre 0 y 1", "El cubo tiene un volumen de 8 " +
            "metros cubicos"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plantilla__trivia);

        enunciado = (TextView) findViewById(R.id.enunciado);
        retro = (TextView) findViewById(R.id.retro);
        img = (ImageView) findViewById(R.id.ejercicio);
        barra = (ProgressBar) findViewById(R.id.toolbar);
        correcto = (LinearLayout) findViewById(R.id.retroalimentacion_ok);
        incorrecto = (LinearLayout) findViewById(R.id.retroalimentacion_fail);

        barra.setMax(7);
        b1 = (Button) findViewById(R.id.btn1);
        b2 = (Button) findViewById(R.id.btn2);

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

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(page<7) {
                    mostrarEjercicio();
                }else {
                    //inten
                    Intent intent = new Intent(Plantilla_Trivia.this,Resumen.class);
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


        if(ejercicios.get(myDay[page]).getSolucion() == boton){
            correcto.setVisibility(View.VISIBLE);
            puntos +=5;
        }else{
            incorrecto.setVisibility(View.VISIBLE);
            retro.setText(retroalimentacion[page]);

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


    }

    public void selectorRetos() {

        myDay[0]=0;
        myDay[1]=1;
        myDay[2]=2;
        myDay[3]=3;
        myDay[4]=4;
        myDay[5]=5;
        myDay[6]=6;



    }


    private List<Ejercicio> initEjercicios() {

        List<Ejercicio> ejercicios = new ArrayList<>();

        String [] posibilidades = {"verdadero","falso", "", ""};
        ejercicios.add(new Ejercicio("",2,posibilidades) );

        ejercicios.add(new Ejercicio("",2,posibilidades) );

        ejercicios.add(new Ejercicio("",2,posibilidades) );

        ejercicios.add(new Ejercicio("",1,posibilidades) );

        ejercicios.add(new Ejercicio("",1,posibilidades) );

        ejercicios.add(new Ejercicio("",2,posibilidades) );

        ejercicios.add(new Ejercicio("",2,posibilidades) );

        return ejercicios;

    }

}
