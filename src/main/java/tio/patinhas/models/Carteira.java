package tio.patinhas.models;

import java.util.ArrayList;
import java.util.List;

public class Carteira {
    private Long id;

    private Double saldoVirtual = 0.0;
    private Double valorTotalInvestido = 0.0;
    private Double valorAtual = 0.0;
    private Double lucroPrejuizo = 0.0;

    public Carteira(Long id, Double saldoVirtual, Double valorTotalInvestido, Double valorAtual, Double lucroPrejuizo, List<Transacao> transacoes) {
        this.id = id;
        this.saldoVirtual = saldoVirtual;
        this.valorTotalInvestido = valorTotalInvestido;
        this.valorAtual = valorAtual;
        this.lucroPrejuizo = lucroPrejuizo;
        this.transacoes = new ArrayList<>();
    }

    public Carteira() {
    }

    public void adicionarTransacao(Transacao t) {
        transacoes.add(t);
        valorTotalInvestido += t.getValor();
    }

    public void calcularValorAtual() {
        valorAtual = transacoes.stream()
                .mapToDouble(Transacao::getValorAtual)
                .sum();
    }

    public void calcularLucroPrejuizo() {
        lucroPrejuizo = valorAtual - valorTotalInvestido;
    }

    public List<Transacao> listarTransacoes() {
        return transacoes;
    }

    private List<Transacao> transacoes = new ArrayList<>();



    public Double getSaldoVirtual() {
        return saldoVirtual;
    }

    public void setSaldoVirtual(Double saldoVirtual) {
        this.saldoVirtual = saldoVirtual;
    }
}
