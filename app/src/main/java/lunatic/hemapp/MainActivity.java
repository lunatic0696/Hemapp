package lunatic.hemapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import lunatic.hemapp.Model.Doacao;
import lunatic.hemapp.Model.Doador;
import lunatic.hemapp.adapters.ListaDoacoesRVAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //enfiando doacoes
        Doador d = new Doador("Joao","Masculino","B-","joao@gmail.com","3225-2134");
        d.save();
        Doacao da = new Doacao(d,2,"11/04/2017","11:15","","","");
        da.save();

        RecyclerView mainDoacoes = (RecyclerView) findViewById(R.id.main_doacoes_recycler);

        List<Doacao> doacoes = Doacao.listAll(Doacao.class);

        //adapter
        ListaDoacoesRVAdapter adapter = new ListaDoacoesRVAdapter(this,doacoes);
        mainDoacoes.setAdapter(adapter);

        //LayoutManager
        mainDoacoes.setLayoutManager(new LinearLayoutManager(this));
    }
}
