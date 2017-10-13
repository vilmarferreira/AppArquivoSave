package com.example.vilmar.apparquivosave;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListChamado extends AppCompatActivity {

    List<Chamado> chamados;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_chamado);

        try {
            chamados= new chamadoDAO().Ler();
        } catch (IOException e) {
            e.printStackTrace();
        }

        AdapterChamado adapter = new AdapterChamado(chamados,this);
        
    }

    private Context getContext()
    {
        return this;
    }
}
