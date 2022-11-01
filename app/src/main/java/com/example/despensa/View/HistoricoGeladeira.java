package com.example.despensa.View;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.despensa.API.ProdutosAdapter;
import com.example.despensa.Controller.AdicionarItensController;
import com.example.despensa.Model.AdicionarItensModel;
import com.example.despensa.R;

import java.util.List;

public class HistoricoGeladeira extends AppCompatActivity {
    ImageView imgVoltarGel;

    AdicionarItensController adicionarItensController;

    List<AdicionarItensModel> consultaProdutosGeladeira; //Linha dos dados
    RecyclerView recyclerView; //Objetos receberá os dados montados

    ProdutosAdapter produtosAdapter;//RecyclerView
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historico_geladeira);
        recyclerView = findViewById(R.id.rvGeladeira);

        carregaLista();

        inicializarComponentes();

        //botão de voltar
        imgVoltarGel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    private void carregaLista() {
        adicionarItensController = new AdicionarItensController();

        //Obtem a lista de todos os bolos
        consultaProdutosGeladeira = adicionarItensController.consultaProdutosGeladeira(getApplicationContext());

        //Adaptador RecyclerView passando a lista de bolos
        produtosAdapter = new ProdutosAdapter(consultaProdutosGeladeira,HistoricoGeladeira.this);

        //Add a Linha onde está no LinearLayout
//        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(produtosAdapter);
    }
    private void inicializarComponentes() {
        imgVoltarGel = findViewById(R.id.imgVoltarGel);
    }
}