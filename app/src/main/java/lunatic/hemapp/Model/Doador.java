package lunatic.hemapp.Model;

import com.orm.SugarRecord;

/**
 * Created by -Lunatic on 24/03/2017.
 */

public class Doador extends SugarRecord {

    private String nome_doador;
    private String sexo_doador;
    private String tipo_sanguineo_doador;
    private String email_doador;
    private String telefone_doador;
    private int n_doacoes;
    private String dt_ultima_doacao;

    public Doador(){}

    public Doador(String nome_doador, String sexo_doador, String tipo_sanguineo_doador, String email_doador, String telefone_doador) {
        this.nome_doador = nome_doador;
        this.sexo_doador = sexo_doador;
        this.tipo_sanguineo_doador = tipo_sanguineo_doador;
        this.email_doador = email_doador;
        this.telefone_doador = telefone_doador;
    }

    public String getNome_doador() {
        return nome_doador;
    }

    public String getSexo_doador() {
        return sexo_doador;
    }

    public String getTipo_sanguineo_doador() {
        return tipo_sanguineo_doador;
    }

    public String getEmail_doador() {
        return email_doador;
    }

    public String getTelefone_doador() {
        return telefone_doador;
    }

    public int getN_doacoes() {
        return n_doacoes;
    }

    public String getDt_ultima_doacao() {
        return dt_ultima_doacao;
    }
}
