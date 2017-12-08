package com.example.vilmar.apparquivosave;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.EditText;
import android.widget.ListView;

import com.example.vilmar.apparquivosave.Persistencia.DownloadConteudo;
import com.example.vilmar.apparquivosave.Utils.AdapterCEP;

import java.net.URL;

public class BuscaCep extends AppCompatActivity {

    ListView lista;
    AdapterCEP adapterCEP;
    EditText cep;
    DownloadConteudo downloadConteudo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busca_cep);
        cep=(EditText) findViewById(R.id.editCEP);
        downloadConteudo = new DownloadConteudo(this);
    }

    public void onClickBtnBuscaCep(View v)
    {
        String URL="https://viacep.com.br/ws/"+cep.getText().toString()+"/json/";
        try
        {
            downloadConteudo.execute(new URL(URL));
        }
        catch (Exception e)
        {

        }
    }
}
