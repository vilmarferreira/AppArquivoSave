package com.example.vilmar.apparquivosave;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.IOException;

public class TelaPrincipal extends AppCompatActivity {

    EditText vrEditUser,vrEditEmpresa,vrEditCNPJ,vrEditEmail,vrEditTelefone,vrEditProblema;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);
        vrEditUser= (EditText) findViewById(R.id.editNomeUser);
        vrEditEmpresa= (EditText) findViewById(R.id.editEmpresa);
        vrEditCNPJ= (EditText) findViewById(R.id.editCNPJ);
        vrEditEmail= (EditText) findViewById(R.id.editEmail);
        vrEditTelefone= (EditText) findViewById(R.id.editTelefone);
        vrEditProblema= (EditText) findViewById(R.id.editProblema);

    }

    public void OnClickSave (View v) throws IOException {
        Chamado vrChamado=new Chamado();
        vrChamado.setNomeCliente(vrEditUser.getText().toString());
        vrChamado.setEmpresa(vrEditEmpresa.getText().toString());
        vrChamado.setCNPJ(vrEditCNPJ.getText().toString());
        vrChamado.setEmail(vrEditEmail.getText().toString());
        vrChamado.setContato(vrEditTelefone.getText().toString());
        vrChamado.setProblema(vrEditProblema.getText().toString());

        chamadoDAO vrDAO= new chamadoDAO(getContext());

        vrDAO.Salvar(vrChamado);
        Intent vrIntent = new Intent(getContext(),Registos.class);
        startActivity(vrIntent);
    }

    private Context getContext()
    {
        return this;
    }
}
