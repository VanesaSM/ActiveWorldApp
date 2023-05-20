package com.activeworldapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import com.google.android.gms.common.api.Api;

public class activity_real_food extends AppCompatActivity {

    String url = "https://www.yogurtinnutrition.com/es/las-diferentes-dietas-y-su-impacto-en-la-salud-y-el-medio-ambiente-infografia/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_real_food);

        Button id_btnSigui3, id_btnSigui4;

        id_btnSigui3 = (Button) findViewById(R.id.id_btnSigui3);
        id_btnSigui4 = (Button) findViewById(R.id.id_btnSigui4);

        id_btnSigui3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(activity_real_food.this, loginActiveWorld.class);
                startActivity(i);

            }
        }); //Botón Anterior


        id_btnSigui4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i2 = new Intent(activity_real_food.this, activity_physical_health.class);
                startActivity(i2);

            }
        }); //Botón Siguiente

        WebView web = (WebView) findViewById(R.id.id_wv1);
        web.setWebViewClient (new MyWebViewClient());
        WebSettings settings = web.getSettings();
        settings.setJavaScriptEnabled(true);
        web.loadUrl(url);
    }

    private class MyWebViewClient extends WebViewClient
    {
        public boolean shoudlOverrideUrlLoading(WebView view, String url){
            view.loadUrl(url);
            return true;
        }
    }
}