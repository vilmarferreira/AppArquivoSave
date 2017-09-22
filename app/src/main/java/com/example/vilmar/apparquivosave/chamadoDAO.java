package com.example.vilmar.apparquivosave;

/**
 * Created by VILMAR on 21/09/2017.
 */

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class chamadoDAO {
    String caminho;



    public chamadoDAO(Context context) throws IOException {
        this.caminho=context.getFilesDir().getPath()+"/dados.txt";
    }




    public void Salvar (Chamado chamado) throws IOException {
        FileWriter escrever = new FileWriter(caminho, true);


        escrever.write(chamado.toString());
        escrever.flush();
        escrever.close();
        //return 1;
    }
    public List<Chamado> Ler () throws IOException {
        FileReader reader= new FileReader(caminho);
        BufferedReader buffer = new BufferedReader(reader);
        String linha=null;
        List<Chamado> Lista= new ArrayList<Chamado>();
        Chamado chamado;
        while ((linha=buffer.readLine())!=null)
        {
            String[] dadosChamados= linha.split(";");
            chamado=new Chamado();
            chamado.setNomeCliente(dadosChamados[0]);
            chamado.setEmpresa(dadosChamados[1]);
            chamado.setCNPJ(dadosChamados[2]);
            chamado.setEmail(dadosChamados[3]);
            chamado.setContato(dadosChamados[4]);
            chamado.setProblema(dadosChamados[5]);
            Lista.add(chamado);
            Log.i("INFO",linha);
        }
        return Lista;
    }


}
