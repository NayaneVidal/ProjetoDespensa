package com.example.despensa.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.despensa.API.Auxiliares;
import com.example.despensa.API.ConexaoSQLServer;
import com.example.despensa.Controller.LoginController;
import com.example.despensa.Model.LoginModel;
import com.example.despensa.R;

import java.sql.Connection;
import java.util.List;

public class Login extends AppCompatActivity {
    EditText edtUser, edtPwd;
    Button btnLogin;
    TextView tvUsuario, tvSenha, tvCriarConta;

    String usuarioAtual, senha;

    Connection conn = ConexaoSQLServer.conectar(getApplication());

    LoginController loginController;
    List<LoginModel> loginModels; //Linha dos dados tipo array

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        InicializarComponentes();
        inicializarConexao();


        //verificação de usuário e senha
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                usuarioAtual = edtUser.getText().toString();
                senha = edtPwd.getText().toString();

                //Criar objeto para o Login
                loginController = new LoginController();

                //Modelo de dados para o login
                LoginModel loginModel;

                //Obtem os usuários
                loginModel = loginController.validarLogin(getApplicationContext(), usuarioAtual, senha);

                if (loginModel != null) {
                    Intent intent = new Intent(getApplicationContext(), TelaInicial.class);
                    startActivity(intent);
                } else {
                    Auxiliares.alert(getApplicationContext(), "Usuário ou Senha incorretos!");
                    edtUser.setText("");
                    edtPwd.setText("");
                    edtUser.requestFocus();
                }




//                if (usuario.isEmpty() || senha.isEmpty()) {
//                    UsarMetodo.alert("Não deixe em branco!!", getApplicationContext());
//                } else if (UsarMetodo.login(usuario, senha)) {
//                    Intent intent = new Intent(Login.this, TelaInicial.class);
//                    intent.putExtra("chave", usuario);
//                    startActivity(intent);
//                } else {
//                    UsarMetodo.alert("Usuário ou senha estão incorretos",
//                            getApplicationContext());
//                }


            }

        });
        //botão link para tela de cadastro
        tvCriarConta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, TelaCadastro.class);
                startActivity(intent);
            }
        });


    }

    private void inicializarConexao() {

        try {
            if (conn != null) {
                if (!conn.isClosed())
//                    setTitle("CONEXAO REALIZADA COM SUCESSO");
                    btnLogin.setText("CONEXAO REALIZADA COM SUCESSO");
                else
//                    setTitle("A CONEXÃO ESTÁ FECHADA");
                    btnLogin.setText("CONEXAO ESTÁ FECHADA");
            } else {
//                setTitle("CONEXAO NULA, NÃO REALIZADA");
                btnLogin.setText("CONEXAO NULA, NÃO REALIZADA");

            }
        } catch (java.sql.SQLException ex) {
            ex.printStackTrace();
//            setTitle("CONEXÃO FALHOU!!!\n" + ex.getMessage());
            btnLogin.setText("CONEXAO FALHOU");

        }
    }



    private void InicializarComponentes() {
        edtUser = findViewById(R.id.edtUser);
        edtPwd = findViewById(R.id.edtPwd);
        btnLogin = findViewById(R.id.btnLogin);
        tvUsuario = findViewById(R.id.tvEmail);
        tvSenha = findViewById(R.id.tvSenha);
        tvCriarConta = findViewById(R.id.tvCriarConta);
        edtUser.setText("boner@gmail.com");
        edtPwd.setText("123");

    }

    public void sair(View view) {
        finish();
    }
}