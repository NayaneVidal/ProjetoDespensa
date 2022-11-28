package com.example.despensa.API;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.despensa.Controller.AdicionarItensController;
import com.example.despensa.Model.AdicionarItensModel;
import com.example.despensa.R;

import java.util.List;

public class ProdutosAdapter extends RecyclerView.Adapter<ProdutosAdapter.ViewHolder> {
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

        TextView tvIdBolo = holder.rvIdProduto;
        tvIdBolo.setText(String.valueOf(objLinha.getId()));
//        tvIdBolo.setText(" ");
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
        tvQuantProdLista.setText("Quantidade: " + objLinha.getTvQuantidade());


        TextView tvDtValiLista = holder.rvValidadeProduto;
        tvDtValiLista.setText("Validade: " + objLinha.getDataValidade());

    }

    @Override
    public int getItemCount() {
        return listaProdutos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView rvIdProduto;
        public TextView rvNomeProduto;
        public TextView rvQuantProduto;
        public TextView rvValidadeProduto;
        public Button btnExcluirListaProd;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            rvIdProduto = itemView.findViewById(R.id.tvIdProduto);
            rvNomeProduto = itemView.findViewById(R.id.tvNomeProdLista);
            rvQuantProduto = itemView.findViewById(R.id.tvQuantProdLista);
            rvValidadeProduto = itemView.findViewById(R.id.tvDtValiLista);

            btnExcluirListaProd = itemView.findViewById(R.id.btnExcluirListaProd);


            btnExcluirListaProd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    excluirItemLista();
                }
            });
        }

        private void excluirItemLista() {
            AlertDialog.Builder excluir = new AlertDialog.Builder(aContext);
            excluir.setTitle("Excluir item");
            excluir.setMessage("Tem certeza que deseja excluir?");
            excluir.setCancelable(false);

            excluir.setPositiveButton("Não", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    }
            );
            excluir.setNegativeButton("Sim", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    adicionarItensController = new AdicionarItensController();
                    adicionarItensController.excluirItemLista(rvIdProduto.getText().toString(), aContext);
                    int position = getAdapterPosition();
                    listaProdutos.remove(position);
                    notifyItemRemoved(position);
                }

            });
            excluir.create().show();
        }

    }
}

