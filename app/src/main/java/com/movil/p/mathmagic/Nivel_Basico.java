package com.movil.p.mathmagic;


import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Nivel_Basico extends Fragment {

    private int[] numeros = {R.drawable.n1, R.drawable.n2, R.drawable.n3, R.drawable.n4, R.drawable.n5, R.drawable.n6, R.drawable.n7, R.drawable.n8, R.drawable.n9, R.drawable.n10};
    private int[] figuras = {R.drawable.a1, R.drawable.a2, R.drawable.a3, R.drawable.a4, R.drawable.a5, R.drawable.a6, R.drawable.a7, R.drawable.a8, R.drawable.a9, R.drawable.a10};
    private int page;
    ImageView numPar;
    ImageView numImpar;
    ImageView fig1;
    ImageView fig2,sound1,sound2;
    Button btn;
    MediaPlayer mp1,mp2,mp3,mp4,mp5,mp6,mp7,mp8,mp9,mp10;

    public Nivel_Basico() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_nivel_basico, container, false);

        page = 1;
        btn = (Button) rootView.findViewById(R.id.next);

        numImpar = (ImageView) rootView.findViewById(R.id.num1);
        numPar = (ImageView) rootView.findViewById(R.id.num2);

        fig1 = (ImageView) rootView.findViewById(R.id.figura_num);
        fig2 = (ImageView) rootView.findViewById(R.id.figura_num2);

        sound1 = (ImageButton) rootView.findViewById(R.id.sound1);
        sound2 = (ImageButton) rootView.findViewById(R.id.sound2);

        numImpar.setImageResource(numeros[0]);
        numPar.setImageResource(numeros[1]);

        fig1.setImageResource(figuras[0]);
        fig2.setImageResource(figuras[1]);

        mp1 = MediaPlayer.create(getActivity(), R.raw.s1);
        mp2 = MediaPlayer.create(getActivity(), R.raw.s2);
        mp3 = MediaPlayer.create(getActivity(), R.raw.s3);
        mp4 = MediaPlayer.create(getActivity(), R.raw.s4);
        mp5 = MediaPlayer.create(getActivity(), R.raw.s5);
        mp6 = MediaPlayer.create(getActivity(), R.raw.s6);
        mp7 = MediaPlayer.create(getActivity(), R.raw.s7);
        mp8 = MediaPlayer.create(getActivity(), R.raw.s8);
        mp9 = MediaPlayer.create(getActivity(), R.raw.s9);
        mp10 = MediaPlayer.create(getActivity(), R.raw.s10);


        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                page++;
                final ClaseGlobal global = (ClaseGlobal) getActivity().getApplicationContext();
                //Log.i("MainEjercicios",String.valueOf(global.getJugador().getSubNivel()));

                if (page <= 5) {
                    numImpar.setImageResource(numeros[page * 2 - 2]);
                    numPar.setImageResource(numeros[page * 2 - 1]);

                    fig1.setImageResource(figuras[page * 2 - 2]);
                    fig2.setImageResource(figuras[page * 2 - 1]);
                }

                if (page == 5) {
                    btn.setText("Terminar");
                }

                if (page > 5) {


                    if(global.getJugador().getSubNivel()<2) {
                        global.cambiarSubnivel(2);
                    }
                    Intent intent = new Intent(getActivity(), MainNivel.class);
                    ((Activity)getContext()).finish();
                    startActivity(intent);

                }

            }

        });

        sound1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                switch (page * 2 - 2+1){
                    case 1:
                        mp1.start();
                        break;
                    case 2:
                        mp2.start();
                        break;
                    case 3:
                        mp3.start();
                        break;
                    case 4:
                        mp4.start();
                        break;
                    case 5:
                        mp5.start();
                        break;
                    case 6:
                        mp6.start();
                        break;
                    case 7:
                        mp7.start();
                        break;
                    case 8:
                        mp8.start();
                        break;
                    case 9:
                        mp9.start();
                        break;
                    case 10:
                        mp10.start();
                        break;
                }

            }

        });

        sound2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                switch (page * 2 - 1+1){
                    case 1:
                        mp1.start();
                        break;
                    case 2:
                        mp2.start();
                        break;
                    case 3:
                        mp3.start();
                        break;
                    case 4:
                        mp4.start();
                        break;
                    case 5:
                        mp5.start();
                        break;
                    case 6:
                        mp6.start();
                        break;
                    case 7:
                        mp7.start();
                        break;
                    case 8:
                        mp8.start();
                        break;
                    case 9:
                        mp9.start();
                        break;
                    case 10:
                        mp10.start();
                        break;
                }

            }

        });

        return rootView;
    }

    public void soundImpar(View view) {
    }

    public void soundPar(View view) {
    }

}
