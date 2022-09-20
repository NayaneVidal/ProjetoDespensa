package com.example.despensa.View;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.despensa.R;

public class HistoricoGeral extends AppCompatActivity {
    ImageView imgVoltarGer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historico_geral);

        inicializarComponentes();

        //botão de voltar
        imgVoltarGer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    private void inicializarComponentes() {
        imgVoltarGer=findViewById(R.id.imgVoltarGer);
    }
}