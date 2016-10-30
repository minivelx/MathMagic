package com.movil.p.mathmagic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.ImageView;


public class MainNivel extends AppCompatActivity {

    ViewPager viewPager;
    CustomSwipeAdapter adapter;
    ImageView imageView;
    private int[] numeros = {R.drawable.uno, R.drawable.dos, R.drawable.tres, R.drawable.cuatro, R.drawable.cinco, R.drawable.seis, R.drawable.siete, R.drawable.ocho, R.drawable.nueve, R.drawable.diez};
    private static final int REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_nivel);
        imageView = (ImageView) findViewById(R.id.lvlNumber);
        final ClaseGlobal global=(ClaseGlobal) getApplicationContext();
        imageView.setImageResource(numeros[global.getJugador().getNivel() - 1]);
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        adapter =  new CustomSwipeAdapter(this);
        viewPager.setAdapter(adapter);

        //Log.i("MainNivel",String.valueOf(global.getJugador().getSubNivel()));

    }


}
