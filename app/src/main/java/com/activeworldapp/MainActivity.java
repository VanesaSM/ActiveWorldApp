package com.activeworldapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button id_btnLog, id_BtnRF, id_BtnSF, id_BtnSM;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        id_btnLog = (Button)findViewById(R.id.id_btnLog);
        id_BtnRF = (Button)findViewById(R.id.id_BtnRF);
        id_BtnSF = (Button) findViewById(R.id.id_BtnSF);
        id_BtnSM = (Button) findViewById(R.id.id_BtnSM);


        id_btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this, loginActiveWorld.class);
                startActivity(i);

            }
        });

        id_BtnRF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i2 = new Intent(MainActivity.this, activity_real_food.class);
                startActivity(i2);

            }
        });

        id_BtnSF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i3 = new Intent(MainActivity.this, activity_physical_health.class);
                startActivity(i3);

            }
        });

        id_BtnSM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i4 = new Intent(MainActivity.this, activity_mental_health.class);
                startActivity(i4);

            }
        });
    }
}
