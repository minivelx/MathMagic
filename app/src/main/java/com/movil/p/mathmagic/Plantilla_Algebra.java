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

public class Plantilla_Algebra extends AppCompatActivity {

    ImageView img;
    Button b1,b2,b3,b4,next;
    LinearLayout correcto, incorrecto;
    List<Ejercicio> ejercicios;
    ProgressBar barra;
    TextView enunciado, retro;
    int page=0, puntos=0;
    int ejercicio_actual;
    int [] myDay = {-1,-1,-1,-1,-1,-1,-1};

    int [] images = {R.drawable.al1, R.drawable.al2, R.drawable.al3, R.drawable.al4, R.drawable.al5, R.drawable.al6, R.drawable.al7, R.drawable.al8
            ,R.drawable.al9 ,R.drawable.al10, R.drawable.al11, R.drawable.al12, R.drawable.al13,R.drawable.al14 ,R.drawable.al15, R.drawable.al16, R.drawable.al17};


    String [] tipodeEjercicios ={"Resuelva la siguiente ecuación:", "Resuelva el sistema de ecuaciones:","Resuelva la inecuación:"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plantilla__algebra);


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
                    Intent intent = new Intent(Plantilla_Algebra.this,Resumen.class);
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
        n = rnd.nextInt(16) + 0;
        Log.i("N=",String.valueOf(n));
        myDay[0]=n;
        for(int i=0;i<6;i++){
            pasar = false;

            while(!pasar){

                rnd = new Random();
                n = rnd.nextInt(16) + 0;

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

        String [] posibilidades1 = {"x = 2, x = 4","x = 3, x = 5","x = 2, x = 1","x = 3, x = 2"};
        ejercicios.add(new Ejercicio(tipodeEjercicios[0],4,posibilidades1) );

        String [] posibilidades2 = {"x = 3, x = 1/2","x = 2, x = 7","x = 2, x = 2","x = 4, x = 1"};
        ejercicios.add(new Ejercicio(tipodeEjercicios[0],1,posibilidades2) );

        String [] posibilidades3 = {"x = 3, x = 2","x = 1, x = 1","x = 1, x = 2","x = 4, x = 3"};
        ejercicios.add(new Ejercicio(tipodeEjercicios[0],2,posibilidades3) );

        String [] posibilidades4 = {"x = 3" ,"x = 1","x = 2","x = 4"};
        ejercicios.add(new Ejercicio(tipodeEjercicios[0],3,posibilidades4) );

        String [] posibilidades5 = {"x = 6" ,"x = 3","x = 2","x = 4"};
        ejercicios.add(new Ejercicio(tipodeEjercicios[0],4,posibilidades5) );

        String [] posibilidades6 = {"x = 3/2" ,"x = 3","x = 2","x = 1/4"};
        ejercicios.add(new Ejercicio(tipodeEjercicios[0],1,posibilidades6) );

        String [] posibilidades7 = {"x = 1" ,"x = 0","x = 2","x = 4"};
        ejercicios.add(new Ejercicio(tipodeEjercicios[0],2,posibilidades7) );

        String [] posibilidades8 = {"x = 5" ,"x = 1/3","x = 3","x = 4"};
        ejercicios.add(new Ejercicio(tipodeEjercicios[0],3,posibilidades8) );

        String [] posibilidades9 = {"x = 5, y = 3" ,"x = 3, y = 2","x = 2, y = 2","x = 2, y = 3"};
        ejercicios.add(new Ejercicio(tipodeEjercicios[1],4,posibilidades9) );

        String [] posibilidades10 = {"x = 4, y = -3" ,"x = -3, y = 2","x = -3, y = 4","x = 4, y = 3"};
        ejercicios.add(new Ejercicio(tipodeEjercicios[1],1,posibilidades10) );

        String [] posibilidades11 = {"x = 5, y = 3, z = 3" ,"x = 4, y = 6, z = 1","x = 2, y = 2, z = 2","x = 6, y = 1, z = 4"};
        ejercicios.add(new Ejercicio(tipodeEjercicios[1],2,posibilidades11) );

        String [] posibilidades12 = {"(-1,∞)" ,"(-∞,1)","(1,∞)","(-∞,4)"};
        ejercicios.add(new Ejercicio(tipodeEjercicios[2],3,posibilidades12) );

        String [] posibilidades13 = {"(-10,∞)" ,"(-∞,4)","(-∞, 10/4)","(-10/4,∞)"};
        ejercicios.add(new Ejercicio(tipodeEjercicios[2],4,posibilidades13) );

        String [] posibilidades14 = {"(-1/6,∞)" ,"(-∞,-1/6)","(1/6,∞)","(-∞,1/6)"};
        ejercicios.add(new Ejercicio(tipodeEjercicios[2],2,posibilidades14) );

        String [] posibilidades15 = {"x = 3" ,"x = 1/3","x = 2","x = 4"};
        ejercicios.add(new Ejercicio(tipodeEjercicios[0],1,posibilidades15) );

        String [] posibilidades16 = {"x = 9" ,"x = 1/7","x = 49/4","x = 7"};
        ejercicios.add(new Ejercicio(tipodeEjercicios[0],3,posibilidades16) );

        String [] posibilidades17 = {"x = 4" ,"x = 2/3","x = 5","x = 1/2"};
        ejercicios.add(new Ejercicio(tipodeEjercicios[0],4,posibilidades17) );

        return ejercicios;

    }

}
