package com.example.vilmar.apparquivosave.Persistencia;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.example.vilmar.apparquivosave.Models.Cep;
import com.example.vilmar.apparquivosave.Models.Chamado;

import java.util.ArrayList;

/**
 * Created by vilmarferreira on 07/12/2017.
 */



public class GerenciadorBanco extends SQLiteOpenHelper {
    private Context vrContexto;
    static final String name = "bd";
    static final int version = 1;

    String[] scriptCriaBanco = {"create table chamado(_id integer primary key autoincrement, nomeCliente text not null, empresa text not null, CNPJ text not null, contato text not null, email text not null, problema text not null);"};

    public final String scriptApagaBD = "DROP TABLE IF EXISTS chamado";

    //public vrContexto = null;
    //String nomeCliente, String empresa, String CNPJ, String contato, String email, String problema

    public GerenciadorBanco(Context context) {
        super(context, name, null, version);
        this.vrContexto = context;

    }


    //SCRIPT DE CRIACAO DO BANCO
    @Override
    public void onCreate(SQLiteDatabase db) {
        for (int iIndex = 0; iIndex < scriptCriaBanco.length; iIndex++) {
            db.execSQL(scriptCriaBanco[iIndex]);
        }

    }


    public void inserirChamado(ContentValues values) {
        //int id = carro.id;
        SQLiteDatabase db = getWritableDatabase();
        try {

            db.insert("chamado", null, values);
            Toast.makeText(vrContexto, "Insercao realizada", Toast.LENGTH_SHORT).show();


        } catch (Exception e) {
            Toast.makeText(vrContexto, "Falha ao Inserir", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(scriptApagaBD);

        for (String sql : scriptCriaBanco) {
            db.execSQL(sql);
        }


    }

    public ArrayList<Chamado> listaChamados() {
        ArrayList<Chamado> lista = new ArrayList<Chamado>();
        SQLiteDatabase bancoDados = this.getReadableDatabase();
        Cursor cursor = bancoDados.query("chamado", new String[]{"nomeCliente", "empresa", "CNPJ", "contato", "email", "problema"}, null, null, null, null, null);

        while (cursor.moveToNext()) {

            Chamado chamado = new Chamado();
            chamado.setNomeCliente(cursor.getString(0));
            chamado.setEmpresa(cursor.getString(1));
            chamado.setCNPJ(cursor.getString(2));
            chamado.setEmail(cursor.getString(3));
            chamado.setContato(cursor.getString(4));
            chamado.setProblema(cursor.getString(5));
            lista.add(chamado);
        }
        return lista;
    }
}



