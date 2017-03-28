package lunatic.hemapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import lunatic.hemapp.R;

/**
 * Created by -Lunatic on 27/03/2017.
 */

public class DrawerAdapter extends RecyclerView.Adapter<DrawerAdapter.ViewHolder>{

    private final Context context;
    private final String[] drawerOptions;

    public DrawerAdapter(Context context, String[] stringList){
        this.context = context;
        this.drawerOptions = stringList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.drawer_option_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String[] option = this.drawerOptions;
        holder.tvOption.setText(drawerOptions[position]);
    }

    @Override
    public int getItemCount() {
        return drawerOptions.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        protected TextView tvOption;

        public ViewHolder(View itemView){
            super(itemView);

            tvOption = (TextView) itemView.findViewById(R.id.option_text_box);
        }
    }
}
