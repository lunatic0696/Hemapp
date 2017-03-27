package lunatic.hemapp.Model;

import com.orm.SugarRecord;

/**
 * Created by -Lunatic on 24/03/2017.
 */

public class Doador extends SugarRecord{

    protected String nome_doador;
    protected String sexo_doador;
    protected String tipo_sanguineo_doador;
    protected String email_doador;
    protected String telefone_doador;
    protected int n_doacoes;
    protected String dt_ultima_doacao;

    public Doador(String nome_doador, String sexo_doador, String tipo_sanguineo_doador, String email_doador, String telefone_doador) {
        this.nome_doador = nome_doador;
        this.sexo_doador = sexo_doador;
        this.tipo_sanguineo_doador = tipo_sanguineo_doador;
        this.email_doador = email_doador;
        this.telefone_doador = telefone_doador;
    }
}
