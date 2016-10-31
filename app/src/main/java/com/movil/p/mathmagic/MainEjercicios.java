package com.movil.p.mathmagic;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainEjercicios extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_ejercicios);

        //se recibe la pisicion actual de viewPager
        int posc = getIntent().getIntExtra("posicion",0);

        //Paso 1: Obtener la instancia del administrador de fragmentos
        //FragmentManager fragmentManager = getFragmentManager();
        FragmentManager fragmentManager = getSupportFragmentManager();
        //Paso 2: Crear una nueva transacción
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        //Paso 3: Crear un nuevo fragmento y añadirlo
        final ClaseGlobal global = (ClaseGlobal) getApplicationContext();
        switch (global.getJugador().getNivel()){
            case 1:
                if(posc==0){
                    Nivel_Basico fragment = new Nivel_Basico ();
                    transaction.add(R.id.main_ejercicios, fragment);
                }else if (posc==1){
                    Nivel_medio fragment = new Nivel_medio ();
                    transaction.add(R.id.main_ejercicios, fragment);
                }else if(posc==2){
                    Nivel_medio fragment = new Nivel_medio ();
                    transaction.add(R.id.main_ejercicios, fragment);
                }
                break;

            default:break;

        }

        //Paso 4: Confirmar el cambio
        transaction.commit();
    }



}
