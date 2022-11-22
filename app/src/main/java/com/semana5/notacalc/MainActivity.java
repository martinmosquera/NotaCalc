package com.semana5.notacalc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText nome;
    private EditText nota01;
    private EditText nota02;
    private EditText frequencia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nome = findViewById(R.id.nomeEditText);
        nota01 = findViewById(R.id.nota01EditText);
        nota02 = findViewById(R.id.nota02EditText);
        frequencia = findViewById(R.id.frequenciaEditText);

    }

    public void calcular(View view){
        String nomeStr = nome.getText().toString();
        try{
            int nota01num = Integer.parseInt(nota01.getText().toString());
            int nota02num = Integer.parseInt(nota02.getText().toString());
            int freqNum = Integer.parseInt(frequencia.getText().toString());
            double media = (nota01num+nota02num)/2;
            String condicao = "";
            if(nota01num > 10 || nota02num > 10 || freqNum > 100 || nomeStr.isEmpty()){
                throw new RuntimeException("Valores não validos! Preencha com nome,nota 0 - 10 e freq 0 - 100");
            }else if(media >= 7){
                condicao = "Aprovado";
            }else if(media >= 4){
                condicao = "Final";
            }else{
                condicao = "reprovado por nota";
            }

            if(media >= 4 && freqNum < 75){
                condicao = "reprovado por falta";
            }

            Intent intent = new Intent(MainActivity.this,Result.class);
            Bundle params = new Bundle();

            params.putString("nome",nomeStr);
            params.putDouble("media",media);
            params.putString("condicao",condicao);

            intent.putExtras(params);

            startActivity(intent);
        }catch(RuntimeException e){
            Toast.makeText(this, "Erro:"+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}