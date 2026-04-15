package tio.patinhas.models;

import java.util.Date;

import tio.patinhas.models.enums.TipoTransacao;

public class Transacao {
    private Date dataHora;
    private TipoTransacao tipo;
    private double quantidade;
    private double precoUnitario;
    private double valorTotal;
    private Criptomoeda criptomoeda;

    public void registrar() {
        this.dataHora = new Date();
        calcularValorTotal();
    }

    public void calcularValorTotal() {
        this.valorTotal = quantidade * precoUnitario;
    }
}