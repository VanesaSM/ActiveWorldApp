package com.activeworldapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class activity_mental_health extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mental_health);

        Button id_btnSigui7, id_btnSigui8;

        id_btnSigui7 = findViewById(R.id.id_btnSigui7);
        id_btnSigui8 = findViewById(R.id.id_btnSigui8);

        id_btnSigui7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(activity_mental_health.this, activity_physical_health.class);
                startActivity(i);

            }
        });//Botón Anterior

        id_btnSigui8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i2 = new Intent(activity_mental_health.this, MainActivity.class);
                startActivity(i2);

            }
        }); //Botón Siguiente
    }

}

