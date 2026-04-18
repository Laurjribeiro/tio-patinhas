package tio.patinhas.models;

import tio.patinhas.models.enums.TipoTransacao;

import java.util.Date;

public class Transacao {
    private Long id;

    private Date dataHora;
    private TipoTransacao tipo;
    private double quantidade;
    private double precoUnitario;
    private double valorTotal;
    private double valor;
    private double valorAtual;

    public Transacao(Long id, TipoTransacao tipo, double quantidade, double precoUnitario) {
        this.id = id;
        this.dataHora = new Date();
        this.tipo = tipo;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
    }

    public Transacao(double valor, double valorAtual) {
        this.valor = valor;
        this.valorAtual = valorAtual;
    }

    public void registrar() {
        this.dataHora = new Date();

        System.out.println("Transação registrada com sucesso.");
    }

    public double getValor() {
        return valor;
    }

    public double getValorAtual() {
        return valorAtual;
    }
}
