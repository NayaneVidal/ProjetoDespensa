package com.example.despensa.API;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.despensa.Controller.AdicionarItensController;
import com.example.despensa.Model.AdicionarItensModel;
import com.example.despensa.R;

import java.util.List;

public class ProdutosAdapter extends RecyclerView.Adapter<ProdutosAdapter.ViewHolder>{
    @NonNull

    public List<AdicionarItensModel> listaProdutos;
    public Context aContext;

    AdicionarItensController adicionarItensController;

    public ProdutosAdapter(List<AdicionarItensModel> produto, Context context) {
        listaProdutos = produto;
        aContext = context;
    }

    @Override
    public ProdutosAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Context context = parent.getContext();

        LayoutInflater inflater = LayoutInflater.from(context);
        View linhaView = inflater.inflate(R.layout.linhas_custom_lista_produtos, parent, false);
        ViewHolder viewHolder = new ViewHolder(linhaView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProdutosAdapter.ViewHolder holder, int position) {
        AdicionarItensModel objLinha = listaProdutos.get(position);

//        TextView tvIdBolo = holder.rvIdBolo;
//        tvIdBolo.setText(String.valueOf(objLinha.getId()));

//        ========Carrega as Imagens===========

//        ImageView tvImagemBolo = holder.rvImagemBolo;
//
//        Resources resources = aContext.getResources();
//        int idR = resources.getIdentifier(objLinha.getFotoBolo(), "drawable", aContext.getPackageName());
//        tvImagemBolo.setImageResource(idR);

//        =====================================

        TextView tvNomeProdLista = holder.rvNomeProduto;
        tvNomeProdLista.setText(objLinha.getNomeProd());

        TextView tvQuantProdLista = holder.rvQuantProduto;
        tvQuantProdLista.setText("Quantidade: "+objLinha.getTvQuantidade());


        TextView tvDtValiLista = holder.rvValidadeProduto;
        tvDtValiLista.setText("Validade: "+objLinha.getDataValidade());

    }

    @Override
    public int getItemCount() {
        return listaProdutos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

//        public TextView rvIdBolo;
//        public ImageView rvImagemBolo;
        public TextView rvNomeProduto;
        public TextView rvQuantProduto;
        public TextView rvValidadeProduto;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

//            rvIdBolo = itemView.findViewById(R.id.tvIdBolo);
//            rvImagemBolo = itemView.findViewById(R.id.ivBolo);
            rvNomeProduto = itemView.findViewById(R.id.tvNomeProdLista);
            rvQuantProduto = itemView.findViewById(R.id.tvQuantProdLista);
            rvValidadeProduto = itemView.findViewById(R.id.tvDtValiLista);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            adicionarItensController = new AdicionarItensController();

            //Grava no Frag o valor 1 para consultar os itens do pedido
//            adicionarItensController.alterarItemDoPedido(rvIdBolo.getText().toString(), aContext);

//            Intent intent = new Intent(aContext, ItensDoPedido.class);
//
//            //Passando o id do Bolo e o valor
//            intent.putExtra("chave", rvIdBolo.getText().toString());
//            intent.putExtra("chaveValorBolo", rvPrecoBolo.getText().toString());
//            intent.putExtra("contextPedido", "aContext");
//            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//            aContext.startActivity(intent);
        }
    }
}
