package lunatic.hemapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lunatic.hemapp.Model.Campanha;
import lunatic.hemapp.adapters.CampanhaRVAdapter;

public class CampanhasActivity extends AppCompatActivity {
    
    @BindView(R.id.rv_campanhas) RecyclerView rvCampanhas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campanhas);
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        initRecyclerView();
    }

    public void initRecyclerView() {
        List<Campanha> campanhas = Campanha.listAll(Campanha.class);
        CampanhaRVAdapter adapter = new CampanhaRVAdapter(this,campanhas);
        rvCampanhas.setAdapter(adapter);
        rvCampanhas.setLayoutManager(new LinearLayoutManager(this));
    }

    @OnClick (R.id.add_campanha_fab)
    public void addCampanha(){
        Intent intent = new Intent(CampanhasActivity.this,AddCampanhaFormActivity.class);
        startActivity(intent);
    }
}
