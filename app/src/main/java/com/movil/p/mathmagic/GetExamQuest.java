package com.movil.p.mathmagic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class GetExamQuest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_exam_quest);

        Button btn1 = (Button) findViewById(R.id.btnNo);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                finish();

            }
        });

        Button btn2 = (Button) findViewById(R.id.btnEmpezar);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                //Codigo para la siguiente vista
                Log.v("GetExamQuest","Pasamos al examen de validacion");
                Intent next =new Intent(GetExamQuest.this,Quiz.class);
                startActivity(next);

            }
        });

    }
}
