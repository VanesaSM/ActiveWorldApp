package com.activeworldapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class loginActiveWorld extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_active_world);

        TextView id_tx1, id_tx2, id_tx3; //Nombre Usuario, Contraseña, ID usuario
        Button id_bt1, id_bt2, id_btnSigui, id_btnSigui2; //Botón Login, Botón Limpiar


        id_tx1 = (TextView) findViewById(R.id.id_tx1);
        id_tx2 = (TextView) findViewById(R.id.id_tx2);
        id_tx3 = (TextView) findViewById(R.id.id_tx3);

        id_bt1 = (Button) findViewById(R.id.id_bt1);
        id_bt2 = (Button) findViewById(R.id.id_bt2);
        id_btnSigui = (Button) findViewById(R.id.id_btnSigui);
        id_btnSigui2 = (Button) findViewById(R.id.id_btnSigui2);


        id_bt1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                //Proceso 1

                if (id_tx1.getText().toString().trim().isEmpty()
                        || id_tx2.getText().toString().trim().isEmpty()
                        || id_tx3.getText().toString().trim().isEmpty()){

                    Toast.makeText(loginActiveWorld.this, "¡Por favor, revise los campos!", Toast.LENGTH_SHORT).show();

                //Proceso 2

                } else {

                    String username = id_tx1.getText().toString();
                    int password = Integer.parseInt(id_tx2.getText().toString());
                    int id_us = Integer.parseInt(id_tx3.getText().toString());

                //Proceso 3

                    FirebaseDatabase db = FirebaseDatabase.getInstance();
                    DatabaseReference dbRef = db.getReference(Usuario.class.getSimpleName());

                    dbRef.addListenerForSingleValueEvent(new ValueEventListener(){
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot){

                            String aux = username;
                            boolean res = false;
                            for(DataSnapshot x : snapshot.getChildren()){
                                if(username.equalsIgnoreCase(x.child("username").getValue().toString())){
                                    res = true;
                                    id_tx1.setText(x.child("nombre").getValue().toString());
                                    break;
                                }
                            }

                            if(res == false){
                                Toast.makeText(loginActiveWorld.this, "Usuario ("+aux+") aún no se registró!", Toast.LENGTH_SHORT).show();
                            }

                //Proceso 4

                            Usuario Luc = new Usuario(username, password, id_us);
                            dbRef.push().setValue(Luc);
                            Toast.makeText(loginActiveWorld.this, "Usuario registrado!!", Toast.LENGTH_SHORT).show();
                            id_tx1.setText("");
                            id_tx2.setText("");
                            id_tx3.setText("");
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error){

                            Toast.makeText(loginActiveWorld.this, "La configuración ha fallado :(", Toast.LENGTH_SHORT).show();

                        }
                    });

                }

            }
        }); // Proceso de Login y conexión con Firebase

        id_bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(loginActiveWorld.this, "Los campos han sido limpiados!", Toast.LENGTH_SHORT).show();
                id_tx1.setText("");
                id_tx2.setText("");
                id_tx3.setText("");
            }
        }); // Botón para limpiar campos

        id_btnSigui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(loginActiveWorld.this, activity_real_food.class);
                startActivity(i);

            }
        }); // Botón Siguiente

        id_btnSigui2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i2 = new Intent(loginActiveWorld.this, MainActivity.class);
                startActivity(i2);

            }
        }); // Botón Anterior




    }

}



