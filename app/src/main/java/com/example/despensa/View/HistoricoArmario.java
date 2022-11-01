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

public class HistoricoArmario extends AppCompatActivity {
    ImageView imgVoltarArm;

    AdicionarItensController adicionarItensController;

    List<AdicionarItensModel> consultaProdutosArmario; //Linha dos dados
    RecyclerView recyclerView; //Objetos receberá os dados montados

    ProdutosAdapter produtosAdapter;//RecyclerView
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historico_armario);
        recyclerView = findViewById(R.id.rvArmario);

        carregaLista();

        inicializarComponentes();

        //botão de voltar
        imgVoltarArm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
    private void carregaLista() {
        adicionarItensController = new AdicionarItensController();

        //Obtem a lista de todos os bolos
        consultaProdutosArmario = adicionarItensController.consultaProdutosArmario(getApplicationContext());

        //Adaptador RecyclerView passando a lista de bolos
        produtosAdapter = new ProdutosAdapter(consultaProdutosArmario,HistoricoArmario.this);

        //Add a Linha onde está no LinearLayout
//        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(produtosAdapter);
    }
    private void inicializarComponentes() {
        imgVoltarArm=findViewById(R.id.imgVoltarArm);
    }
}