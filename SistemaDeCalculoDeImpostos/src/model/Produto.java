package model;

public class Produto {
    private int codigo;
    private String descricao;
    private double valor;
    private double impostoCalculado;
    private double total;
    private boolean industrial;
    private boolean isServico;

    public Produto(int codigo, String descricao, double valor, boolean isServico) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.valor = valor;
        this.isServico = isServico;
    }

    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getImpostoCalculado() {
        return impostoCalculado;
    }

    public void setImpostoCalculado(double impostoCalculado) {
        this.impostoCalculado = impostoCalculado;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public boolean isIndustrial() {
        return industrial;
    }

    public void setIndustrial(boolean industrial) {
        this.industrial = industrial;
    }

    public boolean isServico() {
        return isServico;
    }

    public void setServico(boolean servico) {
        isServico = servico;
    }
}
