package com.example.vilmar.apparquivosave;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class ListChamado extends AppCompatActivity {

    ArrayList<Chamado> chamados;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_chamado);
        chamados=new ArrayList<>();
    }
}
