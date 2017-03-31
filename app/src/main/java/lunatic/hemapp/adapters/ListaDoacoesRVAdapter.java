package lunatic.hemapp.adapters;

import android.content.Context;
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

import lunatic.hemapp.Model.Doacao;
import lunatic.hemapp.R;

/**
 * Created by -Lunatic on 26/03/2017.
 */

public class ListaDoacoesRVAdapter extends RecyclerView.Adapter<ListaDoacoesRVAdapter.ViewHolder>{

    private final Context context;
    private final List<Doacao> doacaoList;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.card_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final Doacao doacao = this.doacaoList.get(position);
        holder.tvDoacaoNome.setText(doacao.getNomeDoador());
        holder.tvDoacaoNBolsas.setText(String.format(context.getString(R.string.numero_bolsas), doacao.getN_bolsas()));
        holder.tvDoacaoHora.setText(doacao.getHora_doacao());
        holder.tvDoacaoData.setText(doacao.getDt_doacao());
        holder.tvDoacaoTipoSangue.setText(doacao.getTipoSanguineo());

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
                            doacao.delete();

                            ListaDoacoesRVAdapter.this.notifyItemRemoved(position);
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
        return doacaoList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        protected TextView tvDoacaoNome;
        protected TextView tvDoacaoNBolsas;
        protected TextView tvDoacaoBolsastext;
        protected TextView tvDoacaoData;
        protected TextView tvDoacaoTipoSangue;
        protected TextView tvDoacaoHora;

        public ViewHolder(View itemView) {
            super(itemView);

            tvDoacaoNome = (TextView) itemView.findViewById(R.id.nome_doador);
            tvDoacaoNBolsas = (TextView) itemView.findViewById(R.id.nbolsasdoadas);
            tvDoacaoBolsastext = (TextView) itemView.findViewById(R.id.textbolsasdoadas);
            tvDoacaoData = (TextView) itemView.findViewById(R.id.doacao_data);
            tvDoacaoTipoSangue = (TextView) itemView.findViewById(R.id.tiposangue);
            tvDoacaoHora = (TextView) itemView.findViewById(R.id.doacao_horario);
        }
    }

    public ListaDoacoesRVAdapter(Context context, List<Doacao> doacoes){

        this.context = context;
        this.doacaoList = doacoes;
    }



}
