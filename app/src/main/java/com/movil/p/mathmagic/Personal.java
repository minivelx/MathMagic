package com.movil.p.mathmagic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Personal extends AppCompatActivity {

    TextView puntos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);

        puntos = (TextView) findViewById(R.id.textView9);

        final ClaseGlobal global = (ClaseGlobal) getApplicationContext();
        puntos.setText(global.getJugador().getTotal_pts());
    }
}
