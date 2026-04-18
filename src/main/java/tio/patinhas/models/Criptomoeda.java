package tio.patinhas.models;

import java.util.ArrayList;
import java.util.List;

public class Criptomoeda {
    private String idApi;
    private String nome;
    private String simbolo;
    private double precoAtual;
    private double variacaoPercentual;
    private double volumeNegociacao;

    private List<HistoricoPreco> historico = new ArrayList<>();

    public Criptomoeda(String idApi, String nome, String simbolo) {
        this.idApi = idApi;
        this.nome = nome;
        this.simbolo = simbolo;
    }

    public void consultarCotacao() {
        System.out.println("Consultando cotação de " + nome);
    }

    public void atualizarPreco(Double novoPreco) {
        this.precoAtual = novoPreco;
        HistoricoPreco hp = new HistoricoPreco(novoPreco);
        historico.add(hp);
    }

    public List<HistoricoPreco> getHistorico() {
        return historico;
    }

    public Double getPrecoAtual() {
        return precoAtual;
    }

    public Double getVariacaoPercentual() {
        return variacaoPercentual;
    }

    public Double getVolumeNegociacao() {
        return volumeNegociacao;
    }
}
