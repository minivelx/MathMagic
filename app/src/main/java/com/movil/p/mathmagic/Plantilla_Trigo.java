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

public class Plantilla_Trigo extends AppCompatActivity {

    ImageView img;
    Button b1,b2,b3,b4,next;
    LinearLayout correcto, incorrecto;
    List<Ejercicio> ejercicios;
    ProgressBar barra;
    TextView enunciado, retro;
    int page=0, puntos=0;
    int ejercicio_actual;
    int [] myDay = {-1,-1,-1,-1,-1,-1,-1};

    int [] images = {R.drawable.tr1, R.drawable.tr2, R.drawable.tr3, R.drawable.tr4, R.drawable.tr5, R.drawable.tr6, R.drawable.tr7, R.drawable.tr8
            ,R.drawable.tr9 ,R.drawable.t10, R.drawable.tr11};

    String [] tipodeEjercicios ={"Halle el valor faltante:", "Ángulos Notables","Identidad Trigonometrica","Halle el área del triangulo","Halle el área del circulo", "Halle el ángulo"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plantilla__trigo);


        enunciado = (TextView) findViewById(R.id.enunciado);
        retro = (TextView) findViewById(R.id.retro);
        img = (ImageView) findViewById(R.id.ejercicio);
        barra = (ProgressBar) findViewById(R.id.toolbar);
        correcto = (LinearLayout) findViewById(R.id.retroalimentacion_ok);
        incorrecto = (LinearLayout) findViewById(R.id.retroalimentacion_fail);

        barra.setMax(7);
        b1 = (Button) findViewById(R.id.btn1);
        b2 = (Button) findViewById(R.id.btn2);
        b3 = (Button) findViewById(R.id.btn3);
        b4 = (Button) findViewById(R.id.btn4);
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

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(page<7) {
                    mostrarEjercicio();
                }else {
                    //inten
                    Intent intent = new Intent(Plantilla_Trigo.this,Resumen.class);
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
        b1.setText(ejercicios.get(myDay[page]).getPosibilidades(0));
        b2.setText(ejercicios.get(myDay[page]).getPosibilidades(1));
        b3.setText(ejercicios.get(myDay[page]).getPosibilidades(2));
        b4.setText(ejercicios.get(myDay[page]).getPosibilidades(3));

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

        String [] posibilidades1 = {"c = 5","c = 6", "c = 3", "c = 9"};
        ejercicios.add(new Ejercicio(tipodeEjercicios[0],1,posibilidades1) );

        String [] posibilidades2 = {"a = 2", "a = 3", "a = 4", "a = 5"};
        ejercicios.add(new Ejercicio(tipodeEjercicios[0],2,posibilidades2) );

        String [] posibilidades3 = {"1/2", "√2/2", "√3","√3/2"};
        ejercicios.add(new Ejercicio(tipodeEjercicios[1],3,posibilidades3) );

        String [] posibilidades4 = {"√2/2", "√3","√3/2","1/2"};
        ejercicios.add(new Ejercicio(tipodeEjercicios[1],4,posibilidades4) );

        String [] posibilidades5 = {"√3/2","1/2","√2/2", "√3"};
        ejercicios.add(new Ejercicio(tipodeEjercicios[1],1,posibilidades5) );

        String [] posibilidades6 = {"1/2", "√2/2", "√3","√3/2"};
        ejercicios.add(new Ejercicio(tipodeEjercicios[1],2,posibilidades6) );

        String [] posibilidades7 = {"1/2", "√2/2", "1","√3/2"};
        ejercicios.add(new Ejercicio(tipodeEjercicios[1],3,posibilidades7) );

        String [] posibilidades8 = {"2" ,"√2/2","√3/2","1"};
        ejercicios.add(new Ejercicio(tipodeEjercicios[2],4,posibilidades8) );

        String [] posibilidades9 = {"A = 8","A = 12","A = 9","A = 6"};
        ejercicios.add(new Ejercicio(tipodeEjercicios[3],4,posibilidades9) );

        String [] posibilidades10 = {"A = 50,27","A = 25,16","A = 14,25","A = 31,41"};
        ejercicios.add(new Ejercicio(tipodeEjercicios[4],1,posibilidades10) );

        String [] posibilidades11 = {"57,32°","32,7°","25,82°","36,87°"};
        ejercicios.add(new Ejercicio(tipodeEjercicios[5],2,posibilidades11) );

        return ejercicios;

    }

}
