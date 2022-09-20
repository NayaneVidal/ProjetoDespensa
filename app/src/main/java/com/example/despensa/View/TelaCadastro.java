package com.example.despensa.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.despensa.R;

public class TelaCadastro extends AppCompatActivity {
    EditText edtNomeCadastro, edtEmailCad, edtSenhaCad, edtQuantPess;
    Button btnCadastro;
    TextView tvEntrarConta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro);

        inicializarComponentes();

        //botão de cadastro
        btnCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TelaCadastro.this, Login.class);
                startActivity(intent);
            }
        });

        //botão link para conta existente
        tvEntrarConta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TelaCadastro.this, Login.class);
                startActivity(intent);
            }
        });









    }

    private void inicializarComponentes() {
        edtNomeCadastro = findViewById(R.id.edtNomeCadastro);
        edtEmailCad = findViewById(R.id.edtEmailCad);
        edtSenhaCad = findViewById(R.id.edtSenhaCad);
        edtQuantPess = findViewById(R.id.edtQuantPess);
        btnCadastro = findViewById(R.id.btnCadastro);
        tvEntrarConta = findViewById(R.id.tvEntrarConta);
    }
}