package com.movil.p.mathmagic;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Random;

public class Quiz extends AppCompatActivity {

    Button b1,b2,b3,b4;
    TextView problema,rating, fraccion,denominador, signo, base,exp;
    String operador,result;
    int contador=1,n1,n2,n3,n4,r,puntos=0;
    int btn_correcto; //1-2-3-4
    int blackList[];
    ProgressBar barra;
    int rango = 10;
    RelativeLayout vista1,vista2,vista3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        blackList = new int[4];
        blackList[0]=blackList[1]=blackList[2]=blackList[3]=0;
        barra = (ProgressBar) findViewById(R.id.barra);
        barra.setMax(24);
        problema = (TextView) findViewById(R.id.problem);
        fraccion = (TextView) findViewById(R.id.problem2);
        base = (TextView) findViewById(R.id.problem3);
        exp = (TextView) findViewById(R.id.exponente);
        denominador = (TextView) findViewById(R.id.denominador);
        signo = (TextView) findViewById(R.id.signo);
        rating = (TextView) findViewById(R.id.rating);
        b1 = (Button)findViewById(R.id.b1);
        b2 = (Button)findViewById(R.id.b2);
        b3 = (Button)findViewById(R.id.b3);
        b4 = (Button)findViewById(R.id.b4);

        vista1 = (RelativeLayout) findViewById(R.id.normal);
        vista2 = (RelativeLayout) findViewById(R.id.fraccion_buena);
        vista3 = (RelativeLayout) findViewById(R.id.vista3);
        setearVista();

        b1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                btnPulsado(1);
            }
        });
        b2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                btnPulsado(2);
            }
        });
        b3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                btnPulsado(3);
            }
        });
        b4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                btnPulsado(4);
            }
        });
    }

    public void setearVista(){

        rating.setText(String.valueOf(contador)+"/24");
        blackList[0]=blackList[1]=blackList[2]=blackList[3]=0;

        int n_1=0,n_2=0,n_3=0;

        //suma
        if(contador>=1 && contador<=3){
            operador = " + ";
            Random rnd1 = new Random();
            n1 = rnd1.nextInt(9) + 1;
            Random rnd2 = new Random();
            n2 = rnd2.nextInt(9) + 1;

            while (n1==n2){
                rnd1 = new Random();
                n1 = rnd1.nextInt(9) + 1;
            }
            r = n1+n2;
        }
        //resta
        if(contador>3 && contador<=6){
            operador = " - ";
            Random rnd1 = new Random();
            n1 = rnd1.nextInt(9) + 1;
            Random rnd2 = new Random();
            n2 = rnd2.nextInt(9) + 1;

            while (n1==n2){
                rnd1 = new Random();
                n1 = rnd1.nextInt(9) + 1;
            }
            r = n1-n2;
        }
        //multiplicacion
        if(contador>6 && contador<=9){
            operador = " x ";
            Random rnd1 = new Random();
            n1 = rnd1.nextInt(10) + 2;
            Random rnd2 = new Random();
            n2 = rnd2.nextInt(10) + 2;
            r = n1*n2;
        }
        //division
        if(contador>9 && contador<=12){
            operador = "➗";
            Random rnd1 = new Random();
            n1 = rnd1.nextInt(9) + 1;
            Random rnd2 = new Random();
            n2 = rnd2.nextInt(9) + 1;
            r = n1*n2;
            n1=r;
            r=n1/n2;
        }
        //Fraccion suma
        if(contador>12 && contador<=15){
            operador = " + ";
            Random rnd1 = new Random();
            n1 = rnd1.nextInt(9) + 1;
            Random rnd2 = new Random();
            n2 = rnd2.nextInt(9) + 1;
            Random rnd3 = new Random();
            n3 = rnd3.nextInt(9) + 2;

            while (n1==n2){
                rnd1 = new Random();
                n1 = rnd1.nextInt(9) + 1;
            }
            r = n1+n2;

            vista1.setVisibility(View.INVISIBLE);
            vista2.setVisibility(View.VISIBLE);
            fraccion.setText(String.valueOf(n1)+"    "+String.valueOf(n2)+"      ");
            denominador.setText(String.valueOf(n3)+"    "+String.valueOf(n3)+"      ");

        }

        //fraccion multiplicar
        if(contador>15 && contador<=18){
            operador = " x ";
            signo.setText("  x        ");
            Random rnd1 = new Random();
            n1 = rnd1.nextInt(9) + 1;
            Random rnd2 = new Random();
            n2 = rnd2.nextInt(9) + 1;
            Random rnd3 = new Random();
            n3 = rnd3.nextInt(9) + 1;
            Random rnd4 = new Random();
            n4 = rnd4.nextInt(9) + 1;

            while (n1==n3){
                rnd1 = new Random();
                n1 = rnd1.nextInt(9) + 1;
            }
            r = n1*n2;

            vista1.setVisibility(View.INVISIBLE);
            vista2.setVisibility(View.VISIBLE);
            fraccion.setText(String.valueOf(n1)+"    "+String.valueOf(n2)+"      ");
            denominador.setText(String.valueOf(n3)+"    "+String.valueOf(n4)+"      ");
            n3 = n3*n4;
        }

        //raiz
        if(contador>18 && contador<=21){
            operador = "";
            Random rnd1 = new Random();
            n1 = rnd1.nextInt(9) + 2;
            r = n1;
        }

        if(!(contador>=13 && contador<=18)){
            //Se muestra el problema propuesto
            vista1.setVisibility(View.VISIBLE);
            vista2.setVisibility(View.INVISIBLE);
            if(contador>18 && contador <=21){
                problema.setText("√"+String.valueOf(n1*n1)+" = ?");
            }else
                problema.setText(String.valueOf(n1)+operador+String.valueOf(n2)+" = ?");

        }
        //exponente
        if(contador>21 && contador<=24){
            operador = "e";
            Random rnd1 = new Random();
            n1 = rnd1.nextInt(9) + 1;
            Random rnd2 = new Random();
            n2 = rnd2.nextInt(3) + 1;
            r = (int) Math.pow(n1,n2);
            vista1.setVisibility(View.INVISIBLE);
            vista2.setVisibility(View.INVISIBLE);
            vista3.setVisibility(View.VISIBLE);
            base.setText(String.valueOf(n1)+"  = ?");
            exp.setText(String.valueOf(n2));
        }



        //Se elige el boton con la respuesta correcta al azar
        Random rnd = new Random();
        btn_correcto = rnd.nextInt(4) + 1;
        blackList[btn_correcto-1]=r;


        if(contador>=13 && contador<=18){

            switch (btn_correcto){

                case 1:
                    b1.setText(String.valueOf(r)+"/"+String.valueOf(n3));
                    break;
                case 2:
                    b2.setText(String.valueOf(r)+"/"+String.valueOf(n3));
                    break;
                case 3:
                    b3.setText(String.valueOf(r)+"/"+String.valueOf(n3));
                    break;
                case 4:
                    b4.setText(String.valueOf(r)+"/"+String.valueOf(n3));
                    break;
            }

        }else{
            switch (btn_correcto){

                case 1:
                    b1.setText(String.valueOf(r));
                    break;
                case 2:
                    b2.setText(String.valueOf(r));
                    break;
                case 3:
                    b3.setText(String.valueOf(r));
                    break;
                case 4:
                    b4.setText(String.valueOf(r));
                    break;
            }
        }


        for (int i=1;i<=4;i++){

            if(i!=btn_correcto){

                Log.i("Boton malo: ",String.valueOf(i));
                switch (i){

                    case 1:
                        b1.setText(azar(0));
                        break;
                    case 2:
                        b2.setText(azar(1));
                        break;
                    case 3:
                        b3.setText(azar(2));
                        break;
                    case 4:
                        b4.setText(azar(3));
                        break;
                }
            }
        }


    }


    public void btnPulsado(int ref_btn) {

        //comprobamos si se selecciono el boton correcto
        if (ref_btn == btn_correcto) {
            puntos ++;
        }

        //actualizamos el contador y la vista
        contador++;
        barra.setProgress(contador);
        if(contador>=24) {
            contador = 24;
            //lanzamos el reporte
            Intent intent = new Intent(this,Reporte.class);
            intent.putExtra("Puntos",puntos);
            startActivity(intent);
            finish();

        }

        setearVista();
    }

    //genero numero aleatorio
    public String azar(int pos){

        boolean pasar = false;
        int rand=0;
        int rangoMax=10,rangoMin=0;
        int n3=0,n4=0;

        //puede depender de la operacion
        if(operador==" + ") {
            rangoMax = 3*r/2;
            rangoMin = r/2;
        }
        if(operador==" - "){
            rangoMax = Math.abs(r)+5;
            rangoMin = -r;
        }
        if(operador==" x "){
            rangoMax = r+7;
            rangoMin = r-1;
        }
        if(operador=="➗"){
            rangoMax = r+7;
            rangoMin = r-1;
        }
        if(operador=="e"){
            rangoMax = r+10;
            rangoMin = r-1;
        }
        while (pasar==false){

            Random rnd = new Random();
            rand = rnd.nextInt(rangoMax) + rangoMin;
            //Log.i("random2: ",String.valueOf(rand));

            if( (rand!=blackList[0])  && (rand!=blackList[1]) && (rand!=blackList[2]) && (rand!=blackList[3])){
                pasar=true;
                blackList[pos]=rand;
                //Log.i("randomEscogido: ",String.valueOf(rand));
            }
        }

        if(contador>=13 && contador<=18){
            Random rnd = new Random();
            n3 = rnd.nextInt(9) + 2;
            rnd = new Random();
            n4 = rnd.nextInt(9) + 2;
            if(contador>=15){
                return (String.valueOf(rand)+"/"+String.valueOf(n3*n4));
            }else {
                return (String.valueOf(rand) + "/" + String.valueOf(n3));
            }
        }else{
            return String.valueOf(rand);
        }

    }
}
