package com.example.vilmar.apparquivosave;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.vilmar.apparquivosave.Chamado;
import com.example.vilmar.apparquivosave.R;

import java.util.List;

/**
 * Created by vilmarferreira on 12/10/2017.
 */

public class AdapterChamado extends BaseAdapter {

    private final List<Chamado> chamados;
    private final Activity activity;

    public AdapterChamado(List<Chamado> chamado, Activity act) {
        this.chamados = chamado;
        this.activity=act;
    }

    @Override
    public int getCount() {
        return chamados.size();
    }

    @Override
    public Object getItem(int position) {
        return chamados.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView==null)
        {
            convertView = this.activity.getLayoutInflater().inflate(R.layout.itens_chamados, null);
        }
        Chamado chamado = chamados.get(position);

        TextView cliente= (TextView) convertView.findViewById(R.id.txtNome);
        cliente.setText(chamado.getNomeCliente());

        TextView empresa= (TextView) convertView.findViewById(R.id.txtEmpresa);
        empresa.setText(chamado.getEmpresa().toString());

        TextView cnpj= (TextView) convertView.findViewById(R.id.txtCNPJ);
        cnpj.setText(chamado.getCNPJ());

        TextView email= (TextView) convertView.findViewById(R.id.txtEmail);
        email.setText(chamado.getEmail());

        TextView telefone= (TextView) convertView.findViewById(R.id.txtTelefone);
        telefone.setText(chamado.getContato());

        TextView problema= (TextView) convertView.findViewById(R.id.txtProblema);
        problema.setText(chamado.getProblema());

        return convertView;


    }


}
