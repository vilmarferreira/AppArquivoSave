package com.example.vilmar.apparquivosave;

import android.content.ContentValues;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.vilmar.apparquivosave.Models.Chamado;
import com.example.vilmar.apparquivosave.Persistencia.GerenciadorBanco;

import java.io.IOException;



public class TelaCadastroChamado extends AppCompatActivity {

    EditText vrEditUser,vrEditEmpresa,vrEditCNPJ,vrEditEmail,vrEditTelefone,vrEditProblema;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro_chamado);
        vrEditUser= (EditText) findViewById(R.id.editNomeUser);
        vrEditEmpresa= (EditText) findViewById(R.id.editEmpresa);
        vrEditCNPJ= (EditText) findViewById(R.id.editCNPJ);
        vrEditEmail= (EditText) findViewById(R.id.editEmail);
        vrEditTelefone= (EditText) findViewById(R.id.editTelefone);
        vrEditProblema= (EditText) findViewById(R.id.editProblema);

    }

    public void OnClickSave (View v) throws IOException {
        Chamado vrChamado=new Chamado();
        ContentValues values = new ContentValues();

                values.put("nomeCliente", vrEditUser.getText().toString());
                values.put("empresa", vrEditEmpresa.getText().toString());
                values.put("CNPJ", vrEditCNPJ.getText().toString());
                values.put("contato",vrEditTelefone.getText().toString());
                values.put("email",vrEditEmail.getText().toString());
                values.put("problema",vrEditProblema.getText().toString());

        GerenciadorBanco gerenciadorBanco = new GerenciadorBanco(getContext());
        gerenciadorBanco.inserirChamado(values);
        finish();

    }

    private Context getContext()
    {
        return this;
    }
}
