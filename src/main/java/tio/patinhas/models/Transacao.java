package tio.patinhas.models;

import tio.patinhas.models.enums.TipoTransacao;

import java.math.BigDecimal;
import java.util.Date;

public class Transacao {
    private Long id;
    private Date dataHora;
    private TipoTransacao tipo;
    private BigDecimal quantidade;
    private BigDecimal precoUnitario;
    private BigDecimal valorTotal;

    public Transacao(Long id, TipoTransacao tipo, BigDecimal quantidade, BigDecimal precoUnitario) {
        this.id = id;
        this.dataHora = new Date();
        this.tipo = tipo;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.valorTotal = calcularValorTotal();
    }

    public BigDecimal calcularValorTotal() {
        return quantidade.multiply(precoUnitario);
    }

    public void registrar() {
        System.out.println("Transação registrada com sucesso.");
    }
}
