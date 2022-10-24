package com.example.despensa.API;

import android.content.Context;
import android.database.SQLException;
import android.os.StrictMode;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConexaoSQLServer {
    public static Connection conectar(Context context) {
        //Objeto de conexao
        Connection conn = null;
        try {
//            Adicionar Política de criacao de thread
            StrictMode.ThreadPolicy politica;
            politica = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(politica);



            Class.forName("net.sourceforge.jtds.jdbc.Driver");



              conn= DriverManager.getConnection("jdbc:jtds:sqlserver://172.17.16.28;"+
                    "databaseName=DESPENSA;user=sa;password=123456;");

//              conn= DriverManager.getConnection("jdbc:jtds:sqlserver://192.168.1.102;"+
//                    "databaseName=DESPENSA;user=sa;password=123456;");




//            conn = DriverManager.getConnection("jdbc:jtds:sqlserver://bdConfeitaria.mssql.somee.com;" +
//                    "databaseName=bdConfeitaria;user=leomar_SQLLogin_1;password=o6k2w94pzc;");




        } catch (SQLException e) { // SQLException
            e.getMessage();
            Toast.makeText(context, "Servidor Indisponível", Toast.LENGTH_LONG).show();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
