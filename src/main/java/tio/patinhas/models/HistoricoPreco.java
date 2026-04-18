package tio.patinhas.models;

import java.util.Date;

public class HistoricoPreco {
    private Date dataHora;
    private Double preco;

    public HistoricoPreco(Double preco) {
        this.dataHora = new Date();
        this.preco = preco;
    }

    public void registrarPreco(Double preco) {
        this.preco = preco;
        this.dataHora = new Date();
    }

    public Date getDataHora() {
        return dataHora;
    }

    public Double getPreco() {
        return preco;
    }
}
