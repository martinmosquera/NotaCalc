package com.semana5.notacalc;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class Result extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        if(intent != null){
            Bundle params = intent.getExtras();
            if(params != null){
                String nome = params.getString("nome");
                Double media = params.getDouble("media");
                String condicao = params.getString("condicao");

                String[] result = {"Condição do Aluno","Nome: "+nome,"Média final: "+String.format("%.02f",media),"Condição: "+condicao};

                ArrayAdapter<String> array = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,result);

                setListAdapter(array);
             }
        }
    }
}