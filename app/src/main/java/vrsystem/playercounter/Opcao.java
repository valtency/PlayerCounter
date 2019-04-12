package vrsystem.playercounter;

import java.io.Serializable;

public class Opcao implements Serializable {
    private String nomePartida;
    private String descricaoPartida;
    private String modalidadePartida;
    private int qtdJogadores;


    public Opcao(){}

    public Opcao(String nomePartida, String descricaoPartida, String modalidadePartida, int qtdJogadores) {
        this.nomePartida = nomePartida;
        this.descricaoPartida = descricaoPartida;
        this.modalidadePartida = modalidadePartida;
        this.qtdJogadores = qtdJogadores;
    }



    public String getNomePartida() {
        return nomePartida;
    }

    public void setNomePartida(String nomePartida) {
        this.nomePartida = nomePartida;
    }

    public String getDescricaoPartida() {
        return descricaoPartida;
    }

    public void setDescricaoPartida(String descricaoPartida) {
        this.descricaoPartida = descricaoPartida;
    }

    public String getModalidadePartida() {
        return modalidadePartida;
    }

    public void setModalidadePartida(String modalidadePartida) {
        this.modalidadePartida = modalidadePartida;
    }

    public int getQtdJogadores() {
        return qtdJogadores;
    }

    public void setQtdJogadores(int qtdJogadores) {
        this.qtdJogadores = qtdJogadores;
    }
}
