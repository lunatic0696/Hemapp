package lunatic.hemapp;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import lunatic.hemapp.Model.Campanha;

import static lunatic.hemapp.R.string.complete_data;

public class AddCampanhaFormActivity extends AppCompatActivity {

    @BindView(R.id.ed_nome_campanha) EditText nomeCampanha;
    @BindView(R.id.ed_desc_campanha) EditText descCampanha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_campanha_form);
        ButterKnife.bind(this);
    }

    protected void addCampanha(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View dialogView = getLayoutInflater().inflate(R.layout.activity_add_doacao_form, null);
        builder.setTitle(R.string.Title_nova_campanha);
        builder.setPositiveButton(android.R.string.ok, null);
        builder.setView(dialogView);
        final AlertDialog dialog = builder.show();
        dialog.getButton(DialogInterface.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nomeCamp = nomeCampanha.getText().toString();
                String descCamp = descCampanha.getText().toString();

                if (nomeCamp == "" || descCamp == "") {
                    Toast.makeText(AddCampanhaFormActivity.this,complete_data,Toast.LENGTH_LONG).show();
                } else {
                    Campanha campanha = new Campanha(nomeCamp, descCamp);
                    campanha.save();
                }

            }
        });


    }
}
