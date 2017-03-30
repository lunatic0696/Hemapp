package lunatic.hemapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Spinner;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lunatic.hemapp.Model.Doador;

public class AddDoadorFormActivity extends AppCompatActivity {

    @BindView(R.id.edNome_Doador) EditText edNome;
    @BindView(R.id.edEmail_Doador) EditText edEmail;
    @BindView(R.id.edEndereco_Doador) EditText edEndereco;
    @BindView(R.id.edTelefone_Doador) EditText edTelefone;
    @BindView(R.id.edCPF_Doador) EditText edCPF;
    @BindView(R.id.spinner_sexo_Doador) Spinner spinnerSexo;
    @BindView(R.id.spinner_tiposangue_Doador) Spinner spinnerTipoSangue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_doador_form);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.addDoadorButton)
    public void addDoador(){
        String novoNome = edNome.getText().toString();
        String novoEmail = edEmail.getText().toString();
        String novoEndereco = edEndereco.getText().toString();
        String novoTelefone = edTelefone.getText().toString();
        String novoCPF = edCPF.getText().toString();
        String novoSexo = spinnerSexo.getSelectedItem().toString();
        String novoTipoSangue = spinnerTipoSangue.getSelectedItem().toString();
        Doador novoDoador = new Doador(novoNome,novoSexo,novoTipoSangue,novoEmail,novoCPF,novoTelefone,0,0,novoEndereco,"Nunca doou");
        novoDoador.save();
    }
}
