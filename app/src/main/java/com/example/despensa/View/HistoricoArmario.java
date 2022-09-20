package com.example.despensa.View;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.despensa.R;

public class HistoricoArmario extends AppCompatActivity {
    ImageView imgVoltarArm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historico_armario);

        inicializarComponentes();

        //botão de voltar
        imgVoltarArm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    private void inicializarComponentes() {
        imgVoltarArm=findViewById(R.id.imgVoltarArm);
    }
}