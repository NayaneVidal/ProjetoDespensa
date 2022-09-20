package com.example.despensa.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.despensa.R;
import com.example.despensa.API.UsarMetodo;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class AdicionarItens extends AppCompatActivity {
    Spinner spnnLocal, spnncategoria;
    ImageButton imgbtnEAN, imgbtnMenosUm, imgbtMaisUm, imgbtnSalvar, imgbtnCancelar;
    EditText edtEAN, edtNomeProd, edtDataValidade;
    TextView tvQuantidade;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_itens);

        inicializarComponentes();

        //Lista dos spinners
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.local_armazen, android.R.layout.simple_spinner_item
        );
        spnnLocal.setAdapter(adapter);

        ArrayAdapter adapter2 = ArrayAdapter.createFromResource(this, R.array.categorias_add_itens, android.R.layout.simple_spinner_item
        );
        spnncategoria.setAdapter(adapter2);

        //Scanner código de barras
        imgbtnEAN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentIntegrator integrator = new IntentIntegrator(AdicionarItens.this);
                integrator.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
                integrator.setPrompt("Leitor código de barras");
                integrator.setCameraId(0);
                integrator.setBeepEnabled(true);
                integrator.setBarcodeImageEnabled(true);
                integrator.initiateScan();
            }
        });

        //adicionando e retirando item no cadastro de produtos
        imgbtMaisUm.setOnClickListener(new View.OnClickListener() {
            int numero = 0;

            @Override
            public void onClick(View view) {
                numero = numero + 1; // adiciona +1 na váriavel numero
                tvQuantidade.setText(String.valueOf(numero));

                imgbtnMenosUm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        numero = numero - 1; // adiciona -1 na váriavel numero
                        tvQuantidade.setText(String.valueOf(numero));


                    }
                });
            }


        });

        //cancelando e salvando cadastro de produto
        imgbtnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                limparCampos();
                UsarMetodo.alert("Produto cancelado!", getApplicationContext());
                finish();
            }
        });

        imgbtnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UsarMetodo.alert("Produto adicionado!", getApplicationContext());
                limparCampos();
            }
        });

    }

    //setando o ean no edt text
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents() == null) {
                Toast.makeText(this, "Leitura cancelada", Toast.LENGTH_LONG).show();
            } else {
                edtEAN.setText(result.getContents());
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    //Limpar os campos quando cancela ou salva o produto
    private void limparCampos() {
        edtEAN.setText(" ");
        edtNomeProd.setText(" ");
        edtDataValidade.setText(" ");
        tvQuantidade.setText("0");
        edtEAN.requestFocus();
    }

    //Validando os dados
    private Boolean validaDados() {
        Boolean existeErros = false;
        if (edtNomeProd.getText().toString().isEmpty()) {
            edtNomeProd.setError("Obrigatório*");
            edtNomeProd.requestFocus();
            existeErros = true;
        } else if (edtDataValidade.getText().toString().isEmpty()) {
            edtDataValidade.setError("Obrigatório*");
            edtDataValidade.requestFocus();
            existeErros = true;
        } else if (tvQuantidade.getText().toString() == String.valueOf(0)) {
            tvQuantidade.setError("Obrigatório*");
            tvQuantidade.requestFocus();
            existeErros = true;
        }

        return existeErros;
    }

    private void inicializarComponentes() {
        spnnLocal = (Spinner) findViewById(R.id.spnnLocal);
        spnncategoria = (Spinner) findViewById(R.id.spnnCategoria);
        imgbtnEAN = findViewById(R.id.imgbtnEAN);
        edtEAN = findViewById(R.id.edtEAN);
        edtNomeProd = findViewById(R.id.edtAddItenLista);
        edtDataValidade = findViewById(R.id.edtDataValidade);
        imgbtMaisUm = findViewById(R.id.imgbtMaisUm);
        imgbtnMenosUm = findViewById(R.id.imgbtnMenosUm);
        imgbtnCancelar = findViewById(R.id.imgbtnCancelar);
        imgbtnSalvar = findViewById(R.id.imgbtnSalvar);
        tvQuantidade = findViewById(R.id.tvQuantidade);
    }
}