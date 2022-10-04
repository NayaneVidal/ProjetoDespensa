package com.example.despensa.Controller;


import android.content.Context;

import com.example.despensa.API.ConexaoSQLServer;
import com.example.despensa.Model.LoginModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class LoginController {
    public static LoginModel validarLogin(Context context, String email, String senha) {

        try {

//            PreparedStatement pst = ConexaoSQLServer.conectar(context).prepareStatement(
//                    "SELECT EmailCliente, SenhacCliente FROM clientes WHERE EmailCliente=? AND SenhacCliente=?");

//            PreparedStatement pst = ConexaoSQLServer.conectar(context).prepareStatement(
//                    "SELECT eMail, senha FROM tbUsuario WHERE eMail=? AND senha=?");

             PreparedStatement pst = ConexaoSQLServer.conectar(context).prepareStatement(
                    "SELECT email, senha FROM USUARIO WHERE email=? AND senha=?");


            //Os números abaixo são os indices da ordem dos campos da tabela
            //Deve seguir a ordem
            pst.setString(1,email);
            pst.setString(2,senha);

            ResultSet res = pst.executeQuery();

            while (res.next()) {

                LoginModel loginModel = new LoginModel();

                loginModel.setEmail(res.getString(1));
                loginModel.setSenha(res.getString(2));
                return loginModel;
            }

        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

    public int cadastrarLogin(LoginModel loginModel, Context context) {

        //Se a resposta for 0 ou menor de 0 então o e-mail não foi encontrado
        int resposta = 0;
        try {
            PreparedStatement pst = ConexaoSQLServer.conectar(context).prepareStatement(
                    "INSERT INTO USUARIO(nome,email,senha) values (?,?,?)"

//            PreparedStatement pst = ConexaoSQLServer.conectar(context).prepareStatement(
//                    "INSERT INTO USUARIO(email,senha) values (?,?)"
//
//

            );
            pst.setString(1, loginModel.getNome());
            pst.setString(2, loginModel.getEmail());
            pst.setString(3, loginModel.getSenha());
            resposta = pst.executeUpdate();

        } catch (Exception e) {
            e.getMessage();
        }

        return resposta;
    }


}
