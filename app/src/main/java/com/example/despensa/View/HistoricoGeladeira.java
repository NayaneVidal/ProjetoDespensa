package com.example.despensa.View;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.despensa.R;

public class HistoricoGeladeira extends AppCompatActivity {
    ImageView imgVoltarGel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historico_geladeira);

        inicializarComponentes();

        //botão de voltar
        imgVoltarGel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void inicializarComponentes() {
        imgVoltarGel = findViewById(R.id.imgVoltarGel);
    }
}