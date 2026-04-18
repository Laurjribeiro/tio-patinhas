package tio.patinhas.models;

import java.util.List;

public class DashboardMercado {
    public void exibirPrecoAtual(List<Criptomoeda> criptos) {
        criptos.forEach(c ->
                System.out.println(c.getPrecoAtual())
        );
    }

    public void exibirVariacao(List<Criptomoeda> criptos) {
        criptos.forEach(c ->
                System.out.println(c.getVariacaoPercentual())
        );
    }

    public void exibirHistorico(List<Criptomoeda> criptos) {
        criptos.forEach(c ->
                System.out.println(c.getHistorico())
        );
    }

    public void exibirVolume(List<Criptomoeda> criptos) {
        criptos.forEach(c ->
                System.out.println(c.getVolumeNegociacao())
        );
    }
}
