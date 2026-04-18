package tio.patinhas.service;

import tio.patinhas.models.Criptomoeda;

import java.util.List;

public class UpdatePriceService {
    public void buscarDadosAPI() {
        // chamada externa (ex: REST API de mercado)
        System.out.println("Buscando dados da API...");
    }

    public void atualizarCriptomoedas(List<Criptomoeda> criptos) {
        buscarDadosAPI();

        for (Criptomoeda c : criptos) {
            Double novoPreco = Math.random() * 100000; // simulação
            c.atualizarPreco(novoPreco);
        }
    }

    public void agendarAtualizacao() {
        // poderia usar scheduler (ex: Spring @Scheduled)
        System.out.println("Atualização agendada.");
    }
}
