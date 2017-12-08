package com.example.vilmar.apparquivosave.Utils;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.vilmar.apparquivosave.Models.Chamado;
import com.example.vilmar.apparquivosave.R;

/**
 * Created by vilmarferreira on 19/10/2017.
 */

public class AdapterChamadoArrayAdapter  extends ArrayAdapter<Chamado>{

    public AdapterChamadoArrayAdapter(@NonNull Context context, @LayoutRes int resource) {
        super(context, resource);
    }

    public View getView(int posicao, View view, ViewGroup pai)
    {

        Chamado chamado =  getItem(posicao);

        TextView cliente= (TextView) view.findViewById(R.id.txtNome);
        cliente.setText(chamado.getNomeCliente());

        TextView empresa= (TextView) view.findViewById(R.id.txtEmpresa);
        empresa.setText(chamado.getEmpresa().toString());

        TextView cnpj= (TextView) view.findViewById(R.id.txtCNPJ);
        cnpj.setText(chamado.getCNPJ());

        TextView email= (TextView) view.findViewById(R.id.txtEmail);
        email.setText(chamado.getEmail());

        TextView telefone= (TextView) view.findViewById(R.id.txtTelefone);
        telefone.setText(chamado.getContato());

        TextView problema= (TextView) view.findViewById(R.id.txtProblema);
        problema.setText(chamado.getProblema());

        return view;

    }

}
