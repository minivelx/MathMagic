package com.movil.p.mathmagic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Personal extends AppCompatActivity {

    TextView puntos;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);

        puntos = (TextView) findViewById(R.id.textView9);

        final ClaseGlobal global = (ClaseGlobal) getApplicationContext();
        puntos.setText(String.valueOf(global.getJugador().getTotal_pts()));

        b1 = (Button) findViewById(R.id.btnNext);
        b1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
