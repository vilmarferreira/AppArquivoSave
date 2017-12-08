package com.example.vilmar.apparquivosave.Utils;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.vilmar.apparquivosave.Models.Cep;
import com.example.vilmar.apparquivosave.Models.Chamado;
import com.example.vilmar.apparquivosave.R;

import java.util.List;

/**
 * Created by vilmarferreira on 07/12/2017.
 */

public class AdapterCEP extends BaseAdapter  {
    private final List<Cep> ceps;
    private final Activity activity;

    public AdapterCEP(List<Cep> cep, Activity act) {
        this.ceps = cep;
        this.activity=act;
    }

    @Override
    public int getCount() {
        return ceps.size();
    }

    @Override
    public Object getItem(int position) {
        return ceps.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        {

            if (convertView==null)
            {
                convertView = this.activity.getLayoutInflater().inflate(R.layout.cep_model, null);
            }
            Cep cep = ceps.get(position);

            TextView txtCep= (TextView) convertView.findViewById(R.id.textCEP);
            txtCep.setText("CEP: "+cep.getCep().toString());

            TextView logradouro= (TextView) convertView.findViewById(R.id.textLogradouro);
            logradouro.setText("Logradouro: "+cep.getLogradouro());

            TextView complemento= (TextView) convertView.findViewById(R.id.textComplemento);
            complemento.setText("Complemento: "+cep.getComplemento());

            TextView bairro= (TextView) convertView.findViewById(R.id.textBairro);
            bairro.setText("Bairro: "+cep.getBairro());

            TextView cidade= (TextView) convertView.findViewById(R.id.textCidade);
            cidade.setText("Cidade: "+cep.getLocalidade());

            TextView UF= (TextView) convertView.findViewById(R.id.textUF);
            UF.setText("UF: "+cep.getUf());

            return convertView;


        }

    }
}
