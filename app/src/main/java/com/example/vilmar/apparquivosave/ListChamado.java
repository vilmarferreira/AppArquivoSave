package com.example.vilmar.apparquivosave;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.vilmar.apparquivosave.Models.Chamado;
import com.example.vilmar.apparquivosave.Persistencia.GerenciadorBanco;
import com.example.vilmar.apparquivosave.Utils.AdapterChamado;

import java.util.List;

public class ListChamado extends AppCompatActivity {

    List<Chamado> chamados;
    GerenciadorBanco gerenciadorBanco;
    ListView listaDeChamado;
    AdapterChamado adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_chamado);
        listaDeChamado = (ListView) findViewById(R.id.lista);

        gerenciadorBanco = new GerenciadorBanco(getContext());
        chamados= gerenciadorBanco.listaChamados();
        adapter = new AdapterChamado(chamados,this);
        listaDeChamado.setAdapter(adapter);
        
    }

    private Context getContext()
    {
        return this;
    }
}
