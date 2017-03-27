package lunatic.hemapp.Model;

import com.orm.SugarApp;
import com.orm.SugarRecord;

import java.util.ArrayList;

/**
 * Created by -Lunatic on 24/03/2017.
 */

public class Doacao extends SugarRecord{

    private Doador doador;
    private int n_bolsas;
    private String dt_doacao;
    private String hora_doacao;
    private String campanha;
    private String alvonome;
    private String alvohosp;

    public Doacao(){}

    public Doacao(Doador doador, int n_bolsas, String dt_doacao, String hora_doacao, String campanha, String alvonome, String alvohosp) {
        this.doador = doador;
        this.n_bolsas = n_bolsas;
        this.dt_doacao = dt_doacao;
        this.hora_doacao = hora_doacao;
        this.campanha = campanha;
        this.alvonome = alvonome;
        this.alvohosp = alvohosp;
    }

    public String getTipoSanguineo(){
        return this.doador.getTipo_sanguineo_doador();
    }

    public String getNomeDoador(){
        return this.doador.getNome_doador();
    }

    public Doador getDoador() {
        return doador;
    }

    public int getN_bolsas() {
        return n_bolsas;
    }

    public String getDt_doacao() {
        return dt_doacao;
    }

    public String getHora_doacao() {
        return hora_doacao;
    }

    public String getCampanha() {
        return campanha;
    }

    public String getAlvonome() {
        return alvonome;
    }

    public String getAlvohosp() {
        return alvohosp;
    }


}
