package com.movil.p.mathmagic;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Random;

public class Nivel_medio extends Fragment {

    private int[] numeros = {R.drawable.n1, R.drawable.n2, R.drawable.n3, R.drawable.n4, R.drawable.n5, R.drawable.n6, R.drawable.n7, R.drawable.n8, R.drawable.n9, R.drawable.n10};
    private int[] figuras = {R.drawable.a1, R.drawable.a2, R.drawable.a3, R.drawable.a4, R.drawable.a5, R.drawable.a6, R.drawable.a7, R.drawable.a8, R.drawable.a9, R.drawable.a10};
    ArrayList<Integer> miVector = new ArrayList();
    int[] noquieroquemesalga =new int[4];
    private int page;
    ImageView figura;
    ImageButton b1,b2,b3,b4;
    int rand;

    public Nivel_medio() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_nivel_medio, container, false);

        page = 1;

        figura = (ImageView) rootView.findViewById(R.id.figura_animal);
        b1 = (ImageButton) rootView.findViewById(R.id.n1);
        b2 = (ImageButton) rootView.findViewById(R.id.n2);
        b3 = (ImageButton) rootView.findViewById(R.id.n3);
        b4 = (ImageButton) rootView.findViewById(R.id.n4);

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

        return rootView;
    }

    public void setearVista(){

        miVector.clear();
        //llenamos el arraylist
        for (int i =0;i<10;i++){
            miVector.add(i,i);
        }
        for (int i =0;i<4;i++){
            noquieroquemesalga[i]=-1;
        }

        //colocamos la imagen
        figura.setImageResource(figuras[page-1]);


        //Generamos num aleatorio entre 1 y 4
        Random rnd = new Random();

        rand = rnd.nextInt(4) + 1;
        Log.i("random: ",String.valueOf(rand));
        noquieroquemesalga[0]=page-1;

        //colocamos el boton
        switch (rand){
            case 1:
                b1.setImageResource(numeros[page-1]);
                break;
            case 2:
                b2.setImageResource(numeros[page-1]);
                break;
            case 3:
                b3.setImageResource(numeros[page-1]);
                break;
            case 4:
                b4.setImageResource(numeros[page-1]);
                break;
        }

        //ponemos la imagen en el botones incorrectos
        int k=1;
        for (int i=1;i<=4;i++){

            if(i!=rand){

                int rand2 = azar();

                switch (i){
                    case 1:
                        b1.setImageResource(numeros[rand2]);
                        noquieroquemesalga[k]=rand2+1;
                        k++;
                        break;
                    case 2:
                        b2.setImageResource(numeros[rand2]);
                        noquieroquemesalga[k]=rand2+1;
                        k++;
                        break;
                    case 3:
                        b3.setImageResource(numeros[rand2]);
                        noquieroquemesalga[k]=rand2+1;
                        k++;
                        break;
                    case 4:
                        b4.setImageResource(numeros[rand2]);
                        noquieroquemesalga[k]=rand2+1;
                        k++;
                        break;
                }

            }

        }

    }

    public int azar(){

        boolean pasar = false;

        Random rnd2 = new Random();
        int rand2 = rnd2.nextInt(9) + 0;
        Log.i("random2: ",String.valueOf(rand2));

        while (pasar!=false){

            if( (noquieroquemesalga[0] != rand2)  && (noquieroquemesalga[1] != rand2) && (noquieroquemesalga[2] != rand2) && (noquieroquemesalga[3] != rand2)){
                pasar=true;
            }
        }
        return rand2;
    }

    public void btnPulsado(int ref_btn){

        //comprobamos si se selecciono el boton correcto
        if(ref_btn==rand){
            page++;
            if(page<=10)
                setearVista();
            final ClaseGlobal global = (ClaseGlobal) getActivity().getApplicationContext();

            if (page > 10) {

                global.cambiarSubnivel(3);
                Intent intent = new Intent(getActivity(), MainNivel.class);
                ((Activity)getContext()).finish();
                startActivity(intent);

            }
        }

    }

}
