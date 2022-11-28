package com.example.despensa.View;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.despensa.API.Auxiliares;
import com.example.despensa.Controller.LoginController;
import com.example.despensa.Model.LoginModel;
import com.example.despensa.R;

public class TelaCadastro extends AppCompatActivity {
    EditText edtNomeCadastro, edtEmailCad, edtSenhaCad, edtQuantPess;
    Button btnCadastro;
    TextView tvEntrarConta;
    LoginController loginController;
    LoginModel loginModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro);

        inicializarComponentes();

        //botão de cadastro
        btnCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(TelaCadastro.this, Login.class);
//                startActivity(intent);

                if (TextUtils.isEmpty(edtEmailCad.getText().toString())) {
                    edtEmailCad.setError("Obrigatório *");
                    edtEmailCad.requestFocus();
                } else if (TextUtils.isEmpty(edtSenhaCad.getText().toString())) {
                    edtSenhaCad.setError("Obrigatório *");
                    edtSenhaCad.requestFocus();
                } else if (TextUtils.isEmpty(edtNomeCadastro.getText().toString())) {
                    edtNomeCadastro.setError("Obrigatório *");
                    edtNomeCadastro.requestFocus();
                } else if (!Auxiliares.validEmail(edtEmailCad.getText().toString().trim())) {
                    Auxiliares.alertCustom(getApplicationContext(), "Formato do e-mail incorreto");
                    edtEmailCad.requestFocus();
                } else {
                    loginModel = new LoginModel();
                    loginModel.setNome(edtNomeCadastro.getText().toString());
                    loginModel.setEmail(edtEmailCad.getText().toString());
                    loginModel.setSenha(edtSenhaCad.getText().toString());


                    loginController = new LoginController();

                    //Se validar retorna valor 0 ou menor, então não cadastrou o e-mail/senha
                    int validar = loginController.cadastrarLogin(loginModel, getApplicationContext());
                    if (validar > 0) {
                        Auxiliares.alert(getApplicationContext(), "Cadastro realizado com Sucesso!");
                        finish();
                    } else {
                        Auxiliares.alert(getApplicationContext(), "Erro no Cadastro!");
                    }


                }
            }});

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
        btnCadastro = findViewById(R.id.btnCadastro);
        tvEntrarConta = findViewById(R.id.tvEntrarConta);
    }
}