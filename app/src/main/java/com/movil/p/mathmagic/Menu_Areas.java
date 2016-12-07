package com.movil.p.mathmagic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

public class Menu_Areas extends AppCompatActivity {

    ImageButton b1,b2,b3,b4,b5,b6,personal;

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
        personal = (ImageButton) findViewById(R.id.personal);

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

        personal.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu_Areas.this,Personal.class);
                startActivity(intent);
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


        if(id==3){
            Intent intent = new Intent(Menu_Areas.this,Plantilla_Trigo.class);
            startActivity(intent);

        }

        if(id==4){
            Intent intent = new Intent(Menu_Areas.this,Plantilla_Trivia.class);
            startActivity(intent);

        }

        if(id==5){
            Intent intent = new Intent(Menu_Areas.this,Plantilla_Agilidad.class);
            startActivity(intent);

        }

        if(id==6){
            Intent intent = new Intent(Menu_Areas.this,Plantilla_Repaso.class);
            startActivity(intent);

        }
    }
}
