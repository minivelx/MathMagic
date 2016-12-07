package com.movil.p.mathmagic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Menu_Areas extends AppCompatActivity {

    ImageButton b1,b2,b3,b4,b5,b6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu__areas);

        b1 = (ImageButton) findViewById(R.id.algebra);
        b2 = (ImageButton) findViewById(R.id.calculo);
        b3 = (ImageButton) findViewById(R.id.trigo);
        b4 = (ImageButton) findViewById(R.id.trivia);
        b5 = (ImageButton) findViewById(R.id.agilidad);
        b6 = (ImageButton) findViewById(R.id.repaso);


        b1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                bringActivity(1);
            }
        });
        b2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                bringActivity(2);
            }
        });
        b3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                bringActivity(3);
            }
        });
        b4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                bringActivity(4);
            }
        });
        b5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                bringActivity(5);
            }
        });
        b6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                bringActivity(6);
            }
        });

    }

    public void bringActivity(int id){

        if(id==1){
            Intent intent = new Intent(Menu_Areas.this,Plantilla_Algebra.class);
            startActivity(intent);

        }

        if(id==2){
            Intent intent = new Intent(Menu_Areas.this,Plantilla_Calculo.class);
            startActivity(intent);

        }







        if(id==4){
            Intent intent = new Intent(Menu_Areas.this,Plantilla_Trivia.class);
            startActivity(intent);

        }
    }
}
