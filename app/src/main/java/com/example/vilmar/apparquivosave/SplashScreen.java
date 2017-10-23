package com.example.vilmar.apparquivosave;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Handler handle = new Handler();
        handle.postDelayed(new Runnable() {
            @Override
            public void run() {
                mostraTelaPrincipal();
            }
        }, 2000);

    }

    public void mostraTelaPrincipal()
    {
        Intent intent = new Intent(this,TelaPrincipal.class);
        startActivity(intent);
        finish();
    }
}
