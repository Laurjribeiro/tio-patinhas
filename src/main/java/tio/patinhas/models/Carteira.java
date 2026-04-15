package tio.patinhas.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Carteira {
    private Long id;
    private BigDecimal saldoVirtual;
    private BigDecimal valorTotalInvestido;
    private BigDecimal valorAtual;
    private BigDecimal lucroPrejuizo;

    private List<Transacao> transacoes;

    public Carteira(Long id, BigDecimal saldoVirtual, BigDecimal valorTotalInvestido, BigDecimal valorAtual, BigDecimal lucroPrejuizo, List<Transacao> transacoes) {
        this.id = id;
        this.saldoVirtual = saldoVirtual;
        this.valorTotalInvestido = valorTotalInvestido;
        this.valorAtual = valorAtual;
        this.lucroPrejuizo = lucroPrejuizo;
        this.transacoes = new ArrayList<>();
    }

    public void addTransaction(Transacao t) {
        transacoes.add(t);
    }

    public BigDecimal calculateValue() {
        return valorAtual;
    }

    public BigDecimal calculateLucroPrejuizo() {
        lucroPrejuizo = valorAtual.subtract(valorTotalInvestido);
        return lucroPrejuizo;
    }

    public List<Transacao> toListTransacoes() {
        return transacoes;
    }
}
