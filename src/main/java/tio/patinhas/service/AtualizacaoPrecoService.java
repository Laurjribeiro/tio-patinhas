package tio.patinhas.servico;

import tio.patinhas.modelos.Criptomoeda;
import tio.patinhas.modelos.HistoricoPreco;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Serviço responsável por atualizar os preços das criptomoedas.
 * Busca preços atuais de APIs externas e atualiza o histórico.
 */
public class AtualizacaoPrecoService {

    /**
     * Atualiza o preço de uma criptomoeda específica e registra no histórico.
     */
    public void atualizarPreco(Criptomoeda cripto, BigDecimal novoPreco) {
        if (cripto == null || novoPreco == null) return;

        cripto.atualizarPreco(novoPreco); // passa BigDecimal direto — sem perda de precisão

        HistoricoPreco historico = new HistoricoPreco(
            gerarIdHistorico(),
            cripto,
            novoPreco,
            LocalDateTime.now()
        );

        // Aqui seria salvo no banco de dados
        System.out.println("Preço atualizado: " + cripto.getNome() + " — R$ " + novoPreco);
    }

    /**
     * Atualiza os preços de uma lista de criptomoedas.
     */
    public void atualizarPrecos(List<Criptomoeda> criptos) {
        if (criptos == null || criptos.isEmpty()) return;

        for (Criptomoeda cripto : criptos) {
            BigDecimal novoPreco = gerarPrecoAleatorio(cripto.getPrecoAtual());
            atualizarPreco(cripto, novoPreco);
        }
    }

    /**
     * Busca o preço atual de uma criptomoeda em uma API externa (simulado).
     * Em produção, usaria HttpClient para chamar APIs como CoinGecko ou Binance.
     */
    public BigDecimal buscarPrecoAtualAPI(String simbolo) {
        if (simbolo == null || simbolo.isEmpty()) return BigDecimal.ZERO;

        System.out.println("Buscando preço de " + simbolo + " na API...");

        // Simulação — substituir pela chamada HTTP real futuramente
        return gerarPrecoAleatorio(100.0);
    }

    /**
     * Atualiza todos os preços consultando a API externa.
     */
    public void atualizarTodosPrecosViaAPI(List<Criptomoeda> criptos) {
        if (criptos == null || criptos.isEmpty()) return;

        for (Criptomoeda cripto : criptos) {
            BigDecimal precoAPI = buscarPrecoAtualAPI(cripto.getSimbolo());
            if (precoAPI.compareTo(BigDecimal.ZERO) > 0) {
                atualizarPreco(cripto, precoAPI);
            }
        }
    }

    /**
     * Verifica se o preço precisa ser atualizado.
     * Retorna true se passou mais de 1 hora desde a última atualização.
     */
    public boolean precisaAtualizar(HistoricoPreco ultimoHistorico) {
        if (ultimoHistorico == null) return true;

        LocalDateTime agora = LocalDateTime.now();
        LocalDateTime ultimaAtualizacao = ultimoHistorico.getDataHora();

        return agora.isAfter(ultimaAtualizacao.plusHours(1));
    }

    // -------------------------------------------------------------------------
    // Métodos privados
    // -------------------------------------------------------------------------

    /**
     * Gera um ID único para o registro de histórico.
     * Em produção seria gerado pelo banco de dados.
     */
    private Long gerarIdHistorico() {
        return System.currentTimeMillis();
    }

    /**
     * Gera um preço simulado com variação de ±10% sobre o preço base.
     */
    private BigDecimal gerarPrecoAleatorio(double precoBase) {
        double variacao = (Math.random() - 0.5) * 0.2;
        double novoPreco = precoBase * (1 + variacao);
        return BigDecimal.valueOf(novoPreco).setScale(2, RoundingMode.HALF_UP);
    }
}