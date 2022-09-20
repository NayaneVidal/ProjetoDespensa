package com.example.despensa.View;

import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.despensa.R;

import java.util.ArrayList;

public class Lista extends AppCompatActivity {
    Button btnAddItemLista;
    ImageView imgbtnCancelarLista, imgbtnSalvarLista, imgVoltarLista, imgbtnLixo;
    EditText edtAddItenLista;
    AlertDialog.Builder dialogBuilderLista;
    AlertDialog dialogLista;
    ListView lvListaCompras;

    private ArrayList<String> listaCompra = new ArrayList<String>();
    ArrayAdapter<String> adapter = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        inicializarComponentes();

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listaCompra);
        lvListaCompras.setAdapter(adapter);


        //botão de voltar
        imgVoltarLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        //check quando clica nos itens da lista
        //"^" usa para dar check e uncheck
        lvListaCompras.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView textView = (TextView) view;
                textView.setPaintFlags(textView.getPaintFlags() ^ Paint.STRIKE_THRU_TEXT_FLAG);
            }
        });
//adicionar itens na lista
        btnAddItemLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogBuilderLista = new AlertDialog.Builder(Lista.this);
                final View contactPopupView = getLayoutInflater().inflate(R.layout.popup_lista, null);

                imgbtnCancelarLista = (ImageView) contactPopupView.findViewById(R.id.imgbtnCancelarLista);
                imgbtnSalvarLista = (ImageView) contactPopupView.findViewById(R.id.imgbtnSalvarLista);
                edtAddItenLista = (EditText) contactPopupView.findViewById(R.id.edtAddItenLista);

                dialogBuilderLista.setView(contactPopupView);
                dialogLista = dialogBuilderLista.create();
                dialogLista.show();

                imgbtnSalvarLista.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String itemLista = edtAddItenLista.getText().toString();
                        if (itemLista.length() > 0) {
                            edtAddItenLista.setText("");
                            edtAddItenLista.findFocus();
                            listaCompra.add(itemLista);
                            adapter.notifyDataSetChanged();
                        }
                    }
                });

                imgbtnCancelarLista.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String itemLista = edtAddItenLista.getText().toString();
                        if (itemLista.length() > 0) {
                            edtAddItenLista.setText("");
                        }
                    }
                });
            }
        });
//        lvListaCompras.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
//                AlertDialog.Builder removerItem = new AlertDialog.Builder(Lista.this);
//                setTitle("Remover item?");
//                final int positionToRemove = adapterView.getSelectedItemPosition();
//                removerItem.setNegativeButton("Cancelar", null);
//                removerItem.setPositiveButton("Remover", new AlertDialog.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int which) {
//                        listaCompra.remove(positionToRemove);
//                        adapter.notifyDataSetChanged();
//                    }
//                });
//                removerItem.show();
//
//                return true;
//            }
//
//
//        });

    }


    private void inicializarComponentes() {
        btnAddItemLista = findViewById(R.id.btnAddItemLista);
        imgVoltarLista = findViewById(R.id.imgVoltarLista);
        lvListaCompras = findViewById(R.id.lvListaCompras);

    }
}