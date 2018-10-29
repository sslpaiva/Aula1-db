package ufrpe.aula1;

import java.util.Date;

public class Saidas {
    private int id;
    private int id_rubrica;
    private String descricao;
    private Date data;
    private float valor;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_rubrica() {
        return id_rubrica;
    }

    public void setId_rubrica(int id_rubrica) {
        this.id_rubrica = id_rubrica;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

}
