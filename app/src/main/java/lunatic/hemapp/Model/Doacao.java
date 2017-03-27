package lunatic.hemapp.Model;

import com.orm.SugarApp;
import com.orm.SugarRecord;

import java.util.ArrayList;

/**
 * Created by -Lunatic on 24/03/2017.
 */

public class Doacao extends SugarRecord{

    protected Doador doador;
    protected int n_bolsas;
    protected String dt_doacao;
    protected String hora_doacao;
    protected String campanha;
    protected String alvonome;
    protected String alvohosp;

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
        return this.doador.tipo_sanguineo_doador;
    }

    public String getNomeDoador(){
        return this.doador.nome_doador;
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
