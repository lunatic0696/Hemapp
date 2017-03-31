package lunatic.hemapp.Model;

import com.orm.SugarRecord;

/**
 * Created by -Lunatic on 24/03/2017.
 */

public class Campanha extends SugarRecord {

    private String nome;
    private String descricao;

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public Campanha(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }
}
