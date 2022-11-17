package com.example.despensa.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SearchView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.despensa.R;

public class TelaInicial extends AppCompatActivity {
    ImageButton imgbtnHistorico, imgbtnAdd, imgbtnLista, imgbtnBuscar;
    AlertDialog.Builder dialogBuilder;
    AlertDialog dialog;
    Button btnPopupGeral, btnPopupGeladeira, btnPopupArmario;
    SearchView svBuscar;
    ImageView imgQuemSomos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);

        inicializarComponentes();

        imgbtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent abrirAddItens = new Intent(getApplicationContext(), AdicionarItens.class);
                startActivity(abrirAddItens);
            }
        });
        imgbtnLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent abrirLista = new Intent(getApplicationContext(), Lista.class);
                startActivity(abrirLista);
            }
        });
        imgbtnHistorico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogBuilder = new AlertDialog.Builder(TelaInicial.this);
                final View contactPopupView = getLayoutInflater().inflate(R.layout.popup, null);

                btnPopupGeral = (Button) contactPopupView.findViewById(R.id.btnPopupGeral);
                btnPopupArmario = (Button) contactPopupView.findViewById(R.id.btnPopupArmario);
                btnPopupGeladeira = (Button) contactPopupView.findViewById(R.id.btnPopupGeladeira);
                svBuscar = (SearchView) contactPopupView.findViewById(R.id.svBuscar);

                dialogBuilder.setView(contactPopupView);
                dialog = dialogBuilder.create();
                dialog.show();


                btnPopupGeral.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(getApplicationContext(), HistoricoGeral.class);
                        startActivity(intent);
                    }
                });
                btnPopupArmario.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(getApplicationContext(), HistoricoArmario.class);
                        startActivity(intent);
                    }
                });
                btnPopupGeladeira.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(getApplicationContext(), HistoricoGeladeira.class);
                        startActivity(intent);
                    }
                });
            }

        });
        imgQuemSomos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogBuilder = new AlertDialog.Builder(TelaInicial.this);
                final View contactPopupView = getLayoutInflater().inflate(R.layout.popup_quem_somos, null);


                dialogBuilder.setView(contactPopupView);
                dialog = dialogBuilder.create();
                dialog.show();
            }

        });

 //       Bundle extra = getIntent().getExtras();
 //       String usuarioInformado = " ";
 //       if (extra != null) {
 //           usuarioInformado = extra.getString("chave");

 //       }
  //      setTitle("Olá " + usuarioInformado);
    }


    private void inicializarComponentes() {
        imgbtnAdd = findViewById(R.id.imgbtnAdd);
        imgbtnHistorico = findViewById(R.id.imgbtnHistorico);
        imgbtnLista = findViewById(R.id.imgbtnLista);
        imgQuemSomos = findViewById(R.id.imgQuemSomos);
    }


}
