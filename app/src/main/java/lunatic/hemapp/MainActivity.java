package lunatic.hemapp;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lunatic.hemapp.Model.Doacao;
import lunatic.hemapp.adapters.ListaDoacoesRVAdapter;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.fab) FloatingActionButton floatingActionButton;
    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.main_doacoes_recycler) RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        DrawerUtils.makeDrawer(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        initRecyclerView();
    }

    public void initRecyclerView() {
        List<Doacao> doacoes = Doacao.listAll(Doacao.class);
        ListaDoacoesRVAdapter adapter = new ListaDoacoesRVAdapter(this,doacoes);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @OnClick(R.id.fab)
    public void addDoacao() {
        Intent addDoacao = new Intent(MainActivity.this,AddDoacaoFormActivity.class);
        startActivity(addDoacao);
    }

}
