package lunatic.hemapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lunatic.hemapp.Model.Doador;
import lunatic.hemapp.adapters.ListaDoadoresRVAdapter;

public class DoadoresActivity extends AppCompatActivity {

    @BindView(R.id.doadores_recycler) RecyclerView RVDoadoresactivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doadores);
        ButterKnife.bind(this);

        //Recycler
        //RecyclerView RVDoadores = (RecyclerView) findViewById(R.layout.activity_doadores);

    }

    @Override
    protected void onResume() {
        super.onResume();

        //Lista de Doadores
        List<Doador> doadores = Doador.listAll(Doador.class);

        //Adapter
        ListaDoadoresRVAdapter adapter = new ListaDoadoresRVAdapter(this,doadores);
        RVDoadoresactivity.setAdapter(adapter);

        //LayoutManager
        RVDoadoresactivity.setLayoutManager(new LinearLayoutManager(this));
    }

    private void addDoadorDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View dialogView = getLayoutInflater().inflate(R.layout.activity_add_doador_form, null);

        final EditText edNome = (EditText) dialogView.findViewById(R.id.edNome_Doador);
        final EditText edEmail = (EditText) dialogView.findViewById(R.id.edEmail_Doador);
        final EditText edEndereco = (EditText) dialogView.findViewById(R.id.edEndereco_Doador);
        final EditText edTelefone = (EditText) dialogView.findViewById(R.id.edTelefone_Doador);
        final EditText edCPF = (EditText) dialogView.findViewById(R.id.edCPF_Doador);
        final Spinner spinnerSexo = (Spinner) dialogView.findViewById(R.id.spinner_sexo_Doador);
        final Spinner spinnerTipoSangue = (Spinner) dialogView.findViewById(R.id.spinner_tiposangue_Doador);

        builder.setTitle(R.string.adicionr_doador);
        builder.setPositiveButton(android.R.string.ok, null);
        builder.setView(dialogView);
        final AlertDialog dialog = builder.show();
        dialog.getButton(DialogInterface.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String novoNome = edNome.getText().toString();
                String novoEmail = edEmail.getText().toString();
                String novoEndereco = edEndereco.getText().toString();
                String novoTelefone = edTelefone.getText().toString();
                String novoCPF = edCPF.getText().toString();
                String novoSexo = spinnerSexo.getSelectedItem().toString();
                String novoTipoSangue = spinnerTipoSangue.getSelectedItem().toString();
                if (Objects.equals(novoNome, "") || Objects.equals(novoEmail, "") || Objects.equals(novoEndereco, "") || Objects.equals(novoTelefone, "")
                        || Objects.equals(novoCPF, "") || Objects.equals(novoSexo, "") || Objects.equals(novoTipoSangue, "")) {
                    Toast.makeText(DoadoresActivity.this, R.string.complete_data, Toast.LENGTH_LONG).show();
                } else {
                    Doador novoDoador = new Doador(novoNome, novoSexo, novoTipoSangue, novoEmail, novoCPF, novoTelefone, 0, 0, novoEndereco, "Nunca doou");
                    novoDoador.save();
                    Toast.makeText(DoadoresActivity.this, R.string.success,Toast.LENGTH_LONG).show();
                    dialog.dismiss();
                }
            }
        });
    }

    @OnClick(R.id.add_doadorFab)
    public void addDoadorForm(){
        addDoadorDialog();
//        Intent novaDoacaoIntent = new Intent(DoadoresActivity.this,AddDoadorFormActivity.class);
//        startActivity(novaDoacaoIntent);
    }
}
