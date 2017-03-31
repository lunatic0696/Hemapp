package lunatic.hemapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import lunatic.hemapp.Model.Campanha;
import lunatic.hemapp.R;

/**
 * Created by -Lunatic on 30/03/2017.
 */

public class CampanhaRVAdapter extends RecyclerView.Adapter<CampanhaRVAdapter.ViewHolder> {

    private final Context context;
    private final List<Campanha> campanhaList;


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.card_layout_campanha,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Campanha campanha = this.campanhaList.get(position);
        holder.tv_nome.setText(campanha.getNome());
    }

    @Override
    public int getItemCount() {
        return campanhaList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        protected TextView tv_nome ;

        public ViewHolder(View itemView) {
            super(itemView);

            tv_nome = (TextView) itemView.findViewById(R.id.tv_nome_campanha);
        }
    }

    public CampanhaRVAdapter(Context context, List<Campanha> campanhaList) {
        this.context = context;
        this.campanhaList = campanhaList;
    }
}
