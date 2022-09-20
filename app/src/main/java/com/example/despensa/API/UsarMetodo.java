package com.example.despensa.API;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

public class UsarMetodo {
    public static boolean login(String usuario, String senha){
        boolean sucesso=false;
        if(usuario.trim().equals("familia")&&senha.trim().equals("123")) {
            sucesso=true;
        }
    return sucesso;
    }
    public static void alert(String s, Context context) {
        Toast toast = Toast.makeText(context,s, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER_HORIZONTAL|Gravity.CLIP_VERTICAL,0,0);
        toast.show();
    }











}
