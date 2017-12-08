package com.example.vilmar.apparquivosave.Persistencia;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ListView;

import com.example.vilmar.apparquivosave.Models.Cep;
import com.example.vilmar.apparquivosave.R;
import com.example.vilmar.apparquivosave.Utils.AdapterCEP;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by vilmarferreira on 07/12/2017.
 */

public class DownloadConteudo extends AsyncTask<URL,Void, ArrayList>
{
    private Context context;
    public DownloadConteudo(Context context)
    {
        this.context=context;
    }


    //Metodo que executa a Thread em segundo plano
    @Override
    protected ArrayList<Cep> doInBackground(URL...urls) {


        OkHttpClient client = new OkHttpClient();
        Gson gson = new Gson();
        ArrayList<Cep> listaCep= new ArrayList<>();
        Cep cep= new Cep();
        Request request = new Request.Builder().url(urls[0]).build();
        ContentValues values = new ContentValues();
        GerenciadorBanco gerenciadorBanco = new GerenciadorBanco(context);

        try {
            Response response = client.newCall(request).execute();

            String json= response.body().string();
            cep=converteCep(json);

            listaCep.add(cep);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listaCep;
    }

    //Metodo que executa apos a conclusao da Thread
    //Codigo chamado ja na tread principal
    @Override
    public void onPostExecute(ArrayList listaCep)
    {
        ListView listViewCep = ((Activity)context).findViewById(R.id.listCEP);
        AdapterCEP adapter=new AdapterCEP(listaCep,(Activity)context);
        listViewCep.setAdapter(adapter);



    }

    //METODO PARA CONVERTER A STRING JSON PARA UM OBJETO
    //SEPARANDO POR TAG
    public Cep converteCep(String cep)
    {
        JsonParser parser = new JsonParser();
        JsonElement element = parser.parse(cep);
        JsonObject object = element.getAsJsonObject();
        Cep cep1=new Cep();

        cep1.setCep(object.get("cep").getAsString());
        cep1.setLogradouro(object.get("logradouro").getAsString());
        cep1.setComplemento(object.get("complemento").getAsString());
        cep1.setBairro(object.get("bairro").getAsString());
        cep1.setLocalidade(object.get("localidade").getAsString());
        cep1.setUf(object.get("uf").getAsString());
        cep1.setUnidade(object.get("unidade").getAsString());
        cep1.setIbge(object.get("ibge").getAsString());
        cep1.setGia(object.get("gia").getAsString());
        return cep1;
    }

}