package com.example.vilmar.apparquivosave;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.IOException;

public class Registos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registos);
    }
    public void OnClickListar (View view) throws IOException {
        chamadoDAO vrDAO= new chamadoDAO(this);
        Log.i("teste","teste c");
        vrDAO.Ler();
    }
}
