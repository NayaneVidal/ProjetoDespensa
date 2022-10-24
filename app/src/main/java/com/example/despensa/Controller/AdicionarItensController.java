package com.example.despensa.Controller;

import android.content.Context;

import com.example.despensa.API.ConexaoSQLServer;
import com.example.despensa.Model.AdicionarItensModel;

import java.sql.PreparedStatement;

public class AdicionarItensController {
    public int cadastrarProdutos(AdicionarItensModel adicionarItensModel, Context context) {

        //Se a resposta for 0 ou menor de 0 então o e-mail não foi encontrado
        int resposta = 0;
        try {
            PreparedStatement pst = ConexaoSQLServer.conectar(context).prepareStatement(
                    "INSERT INTO PRODUTOS(nome_prod,validade,ean,quant,id_categoria,id_local) values (?,?,?,?,?,?)"

//            PreparedStatement pst = ConexaoSQLServer.conectar(context).prepareStatement(
//                    "INSERT INTO USUARIO(email,senha) values (?,?)"
//
//

            );
            pst.setString(1, adicionarItensModel.getNomeProd());
            pst.setString(2, adicionarItensModel.getDataValidade());
            pst.setString(3, adicionarItensModel.getEan());
            pst.setString(4, adicionarItensModel.getTvQuantidade());
            pst.setString(5, adicionarItensModel.getSpnnCategoria());
            pst.setString(6, adicionarItensModel.getSpnnLocal());
            resposta = pst.executeUpdate();

        } catch (Exception e) {
            e.getMessage();
        }

        return resposta;
    }
    public int cadastrarCategoria(AdicionarItensModel adicionarItensModel, Context context) {

        //Se a resposta for 0 ou menor de 0 então o e-mail não foi encontrado
        int resposta = 0;
        try {
            PreparedStatement pst = ConexaoSQLServer.conectar(context).prepareStatement(
                    "SELECT CATEGORIA (descri_categ) values (?)"

//            PreparedStatement pst = ConexaoSQLServer.conectar(context).prepareStatement(
//                    "INSERT INTO USUARIO(email,senha) values (?,?)"
//
//

            );
            pst.setString(1, adicionarItensModel.getSpnnCategoria());
            resposta = pst.executeUpdate();

        } catch (Exception e) {
            e.getMessage();
        }

        return resposta;
    }

}
