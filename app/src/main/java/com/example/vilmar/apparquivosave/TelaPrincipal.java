package com.example.vilmar.apparquivosave;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.IOException;

public class TelaPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);
    }
    public void OnClickLerArquivo (View view) throws IOException {
        chamadoDAO vrDAO= new chamadoDAO(this);
        Log.i("teste","teste c");
        vrDAO.Ler();
    }
    public void OnClickListar (View v)
    {
        Intent vrIntent = new Intent(this,ListChamado.class);
        startActivity(vrIntent);
    }
    public void OnClickAbrirChamado (View v)
    {
        Intent vrIntent = new Intent(this,TelaCadastroChamado.class);
        startActivity(vrIntent);
    }
}
