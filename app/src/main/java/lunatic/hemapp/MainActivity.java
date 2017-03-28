package lunatic.hemapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;

import java.util.List;

import lunatic.hemapp.Model.Doacao;
import lunatic.hemapp.Model.Doador;
import lunatic.hemapp.adapters.DrawerAdapter;
import lunatic.hemapp.adapters.ListaDoacoesRVAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //enfiando doacoes
        /*Doador d = new Doador("Joao","Masculino","B-","joao@gmail.com","3225-2134");
        d.save();
        Doacao da = new Doacao(d,2,"11/04/2017","11:15","","","");
        da.save();*/

        RecyclerView mainDoacoes = (RecyclerView) findViewById(R.id.main_doacoes_recycler);
        RecyclerView RVdrawerOptions = (RecyclerView) findViewById(R.id.drawer_layout);

        //fab
        FloatingActionButton fab = new FloatingActionButton(this);

        //Drawer
        new DrawerBuilder().withActivity(this).build();
        PrimaryDrawerItem item1 = new PrimaryDrawerItem().withIdentifier(1).withName(R.string.adicionr_doador);

        //Lista de doações
        List<Doacao> doacoes = Doacao.listAll(Doacao.class);

        //adapter
        ListaDoacoesRVAdapter adapter = new ListaDoacoesRVAdapter(this,doacoes);
        mainDoacoes.setAdapter(adapter);

        //LayoutManager
        mainDoacoes.setLayoutManager(new LinearLayoutManager(this));
    }

    public void addDoacao(View view){
        Intent doacaoIntent = new Intent(this,DoacaoActivity.class);
    }

}
