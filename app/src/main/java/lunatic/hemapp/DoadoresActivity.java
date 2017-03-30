package lunatic.hemapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import lunatic.hemapp.Model.Doador;
import lunatic.hemapp.adapters.ListaDoadoresRVAdapter;

public class DoadoresActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doadores);

        //Intent
        Intent doadorIntent = getIntent();

        RecyclerView RVDoadoresactivity = (RecyclerView) findViewById(R.id.doadores_recycler);
        //RVDoadores.addView();

        //Recycler
        //RecyclerView RVDoadores = (RecyclerView) findViewById(R.layout.activity_doadores);

        //Lista de Doadores
        List<Doador> doadores = Doador.listAll(Doador.class);

        //Adapter
        ListaDoadoresRVAdapter adapter = new ListaDoadoresRVAdapter(this,doadores);
        RVDoadoresactivity.setAdapter(adapter);

        //LayoutManager
        RVDoadoresactivity.setLayoutManager(new LinearLayoutManager(this));
    }

    public void addDoadorForm(){}
}
