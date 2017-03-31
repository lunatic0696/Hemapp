package lunatic.hemapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import lunatic.hemapp.DoadorDetalheActivity;
import lunatic.hemapp.DoadoresActivity;
import lunatic.hemapp.Model.Doador;
import lunatic.hemapp.R;

/**
 * Created by -Lunatic on 28/03/2017.
 */

public class ListaDoadoresRVAdapter extends RecyclerView.Adapter<ListaDoadoresRVAdapter.ViewHolder> {

    private final Context context;
    private final List<Doador> doadorList;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.doador_card_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final Doador doador = this.doadorList.get(position);

        holder.tvDoadorNome.setText(doador.getNome_doador());
        holder.tvDoadorEmail.setText(doador.getEmail_doador());
        holder.tvDoadorTipoSangue.setText(doador.getTipo_sanguineo_doador());
        holder.tvDoadorNDoacoes.setText(String.format(context.getString(R.string.numero_doacoes),doador.getN_doacoes()));
        holder.tvDoadorNBolsas.setText(String.format(context.getString(R.string.numero_bolsas),doador.getN_bolsas()));
/*
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent detalheDoadorIntent = new Intent(,DoadorDetalheActivity.class,);
            }
        });
        */
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener(

        ) {
            @Override
            public boolean onLongClick(View view) {
                PopupMenu pop = new PopupMenu(context, view);
                MenuInflater inflater = pop.getMenuInflater();

                inflater.inflate(R.menu.popup_menu_lista, pop.getMenu());
                pop.show();

                pop.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        if (item.getItemId() == R.id.remover_pop_text){
                            doador.delete();

                            ListaDoadoresRVAdapter.this.notifyItemRemoved(position);
                            Toast.makeText(context,context.getString(R.string.removido_text),Toast.LENGTH_LONG).show();
                        }

                        return false;
                    }
                });

                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return doadorList.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{

        protected TextView tvDoadorNome;
        protected TextView tvDoadorEmail;
        protected TextView tvDoadorTipoSangue;
        protected TextView tvDoadorNDoacoes;
        protected TextView tvDoadorNBolsas;

        public ViewHolder(View itemView){
            super(itemView);

            tvDoadorNome = (TextView) itemView.findViewById(R.id.tvNome_Doador);
            tvDoadorEmail = (TextView) itemView.findViewById(R.id.tvEmail_Doador);
            tvDoadorTipoSangue = (TextView) itemView.findViewById(R.id.tv_Tipo_Sangue_Doador);
            tvDoadorNDoacoes = (TextView) itemView.findViewById(R.id.tvN_doacoes_Doador);
            tvDoadorNBolsas = (TextView) itemView.findViewById(R.id.tvNBolsas);

        }



    }

    public ListaDoadoresRVAdapter(Context context, List<Doador> doadorList) {
        this.context = context;
        this.doadorList = doadorList;
    }
}
