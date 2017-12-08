package com.example.vilmar.apparquivosave;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.vilmar.apparquivosave.Models.Cep;
import com.example.vilmar.apparquivosave.Models.Chamado;
import com.example.vilmar.apparquivosave.Persistencia.GerenciadorBanco;
import com.example.vilmar.apparquivosave.Utils.AdapterCEP;
import com.example.vilmar.apparquivosave.Utils.AdapterChamado;

import java.util.List;

public class ListaCep extends AppCompatActivity {

    List<Cep> ceps;
    GerenciadorBanco gerenciadorBanco;
    ListView listViewCep;
    AdapterCEP adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_cep);
        listViewCep = (ListView)findViewById(R.id.listCEP);
        gerenciadorBanco = new GerenciadorBanco(this);

        adapter = new AdapterCEP(ceps,this);
        listViewCep.setAdapter(adapter);
    }
}
