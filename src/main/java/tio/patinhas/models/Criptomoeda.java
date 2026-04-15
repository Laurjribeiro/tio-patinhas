package tio.patinhas.models;

public class Criptomoeda {
    private String idApi;
    private String nome;
    private String simbolo;
    private double precoAtual;
    private double variacaoPercentual;
    private double volumeNegociacao;

    public void consultarCotacao() {
        System.out.println("Consultar Cotação");
    }

    public void atualizarPreco(double novoPreco) {
        this.precoAtual = novoPreco;
    }
}
