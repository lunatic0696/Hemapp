package lunatic.hemapp;

import android.content.DialogInterface;
import android.os.SystemClock;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Time;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lunatic.hemapp.Model.Campanha;
import lunatic.hemapp.Model.Doacao;
import lunatic.hemapp.Model.Doador;

public class AddDoacaoFormActivity extends AppCompatActivity {

    @BindView(R.id.ac_Doador) AutoCompleteTextView ac_doador;
    @BindView(R.id.ac_Campanha) AutoCompleteTextView ac_campanha;
    @BindView(R.id.ed_nbolsas) EditText ed_nbolsas;
    @BindView(R.id.tv_Tipo_Sangue_Doacao) TextView tv_sangue_doacao;
    @BindView(R.id.tv_Sexo_Doacao) TextView tv_sexo_doacao;
    @BindView(R.id.data_doacao) TextView tv_hora_doacao;
    @BindView(R.id.hora_doacao) TextView tv_data_doacao;
    @BindView(R.id.ed_alvo_doacao) EditText edAlvoDoacao;

    private Doador selectedDoador;
    private Campanha selectedCampanha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_doacao_form);
        ButterKnife.bind(this);

        ac_doador.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                selectedDoador = (Doador) adapterView.getItemAtPosition(position);
            }
        });


        ac_campanha.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                selectedCampanha = (Campanha) adapterView.getItemAtPosition(position);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();

        List<Doador> doadores = Doador.listAll(Doador.class);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, doadores);
        ac_doador.setAdapter(adapter);
    }

    private String getDate(){
        int dia = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        int mes = Calendar.getInstance().get((Calendar.MONTH));
        int ano = Calendar.getInstance().get(Calendar.YEAR);
        return dia+"/"+mes+"/"+ano;
    }

    private String getTime(){
        int hora = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        int minuto = Calendar.getInstance().get(Calendar.MINUTE);
        return hora+":"+minuto;
    }

    @OnClick(R.id.add_doacao_button)
    protected void addDoacao(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View dialogView = getLayoutInflater().inflate(R.layout.activity_add_doacao_form, null);

        final EditText acDoador = (EditText) dialogView.findViewById(R.id.ac_Doador);
        final EditText acCampanha = (EditText) dialogView.findViewById(R.id.ac_Campanha);
        final EditText edNbolsas = (EditText) dialogView.findViewById(R.id.ed_nbolsas);
        final TextView tvSangueDoador = (TextView) dialogView.findViewById(R.id.tv_Tipo_Sangue_Doador);
        final TextView tvSexoDoacao = (TextView) dialogView.findViewById(R.id.tv_Sexo_Doacao);
        final TextView dataDoacao = (TextView) dialogView.findViewById(R.id.data_doacao);
        final TextView horaDoacao = (TextView) dialogView.findViewById(R.id.hora_doacao);
        final EditText nomeAlvo = (EditText)dialogView.findViewById(R.id.ed_alvo_doacao);
        dataDoacao.setText(getDate());
        horaDoacao.setText(getTime());

        builder.setTitle(R.string.Title_Nova_Doacao);
        builder.setPositiveButton(android.R.string.ok, null);
        builder.setView(dialogView);
        final AlertDialog dialog = builder.show();
        dialog.getButton(DialogInterface.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nomeDoador = ac_doador.getText().toString();
                String acCampanha = ac_campanha.getText().toString();
                int edNumbolsas = 1;
                //int edNumbolsas = (Integer) Integer.parseInt(edNbolsas.getText().toString());
                String nomeAlvo = edAlvoDoacao.getText().toString();
                if (Objects.equals(nomeDoador, "") || Objects.equals(acCampanha, "") || Objects.equals(edNbolsas, "")) {
                    Toast.makeText(AddDoacaoFormActivity.this, R.string.complete_data, Toast.LENGTH_LONG).show();
                } else {
                    Doacao novaDoacao = new Doacao(selectedDoador,edNumbolsas,getDate(),getTime(),selectedCampanha,nomeAlvo);
                    novaDoacao.save();
                    Toast.makeText(AddDoacaoFormActivity.this, R.string.success,Toast.LENGTH_LONG).show();
                    dialog.dismiss();
                }
            }
        });
    }
}
