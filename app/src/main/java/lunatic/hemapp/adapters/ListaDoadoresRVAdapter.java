package lunatic.hemapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

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
    public void onBindViewHolder(ViewHolder holder, int position) {
        Doador doador = this.doadorList.get(position);

        holder.tvDoadorNome.setText(doador.getNome_doador());
        holder.tvDoadorEmail.setText(doador.getEmail_doador());
        holder.tvDoadorTipoSangue.setText(doador.getTipo_sanguineo_doador());
        holder.tvDoadorNDoacoes.setText(String.format(context.getString(R.string.numero_doacoes),doador.getN_doacoes()));
        holder.tvDoadorNBolsas.setText(String.format(context.getString(R.string.numero_bolsas),doador.getN_bolsas()));
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
