package tio.patinhas.models;

public class SimulacaoInvestimento {
    public void comprar(Carteira carteira, String cripto, double quantidade) {
        if (!validarQuantidade(quantidade)) {
            System.out.println("Quantidade inválida.");
            return;
        }

        double precoUnitario = obterPrecoSimulado(cripto);
        double custoTotal = precoUnitario * quantidade;

        if (!validarSaldo(carteira, custoTotal)) {
            System.out.println("Saldo insuficiente.");
            return;
        }

        carteira.setSaldoVirtual(carteira.getSaldoVirtual() - custoTotal);

        Transacao t = new Transacao(custoTotal, custoTotal);
        carteira.adicionarTransacao(t);

        System.out.println("Compra realizada: " + quantidade + " de " + cripto);
    }

    public void vender(Carteira carteira, String cripto, double quantidade) {
        if (!validarQuantidade(quantidade)) {
            System.out.println("Quantidade inválida.");
            return;
        }

        double precoUnitario = obterPrecoSimulado(cripto);
        double valorTotal = precoUnitario * quantidade;

        carteira.setSaldoVirtual(carteira.getSaldoVirtual() + valorTotal);

        Transacao t = new Transacao(-valorTotal, valorTotal);
        carteira.adicionarTransacao(t);

        System.out.println("Venda realizada: " + quantidade + " de " + cripto);
    }

    public boolean validarSaldo(Carteira carteira, double valor) {
        return carteira.getSaldoVirtual() >= valor;
    }

    public boolean validarQuantidade(double quantidade) {
        return quantidade > 0;
    }

    private double obterPrecoSimulado(String cripto) {
        // Simulação simples (em um cenário real viria de API)
        return Math.random() * 100000;
    }
}
