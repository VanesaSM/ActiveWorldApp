package com.activeworldapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class activity_physical_health extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physical_health);


        Button id_btnSigui5, id_btnSigui6;

        id_btnSigui5 = (Button) findViewById(R.id.id_btnSigui5);
        id_btnSigui6 = (Button) findViewById(R.id.id_btnSigui6);

        id_btnSigui5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(activity_physical_health.this, activity_real_food.class);
                startActivity(i);

            }
        });//Botón Anterior

        id_btnSigui6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i2 = new Intent(activity_physical_health.this, activity_mental_health.class);
                startActivity(i2);

            }
        }); //Botón Siguiente
    }
}