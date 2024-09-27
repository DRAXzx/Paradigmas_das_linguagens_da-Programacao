package model;

import factory.ImpostoFactory;
import factory.TipoImposto;
import imposto.Imposto;

public class Main {
    public static void main(String[] args) {

        final int MAX_ITENS = 10;
        Produto[] itens = new Produto[MAX_ITENS];
        int contador = 0;

        Produto produto1 = new Produto(1, "Milho", 100, false);
        produto1.setIndustrial(true);
        itens[contador++] = produto1;

        Produto produto2 = new Produto(2, "Arroz", 50, false);
        produto2.setIndustrial(false);
        itens[contador++] = produto2;

        Produto servico1 = new Produto(3, "Consultoria", 500, true);
        itens[contador++] = servico1;

        Produto servico2 = new Produto(4, "Entrega", 150, true);
        itens[contador++] = servico2;

        double totalItens = 0;
        double totalImpostosProdutos = 0;
        double totalImpostosServicos = 0;


        for (int i = 0; i < contador; i++) {
            Produto item = itens[i];
            Imposto imposto;

            if (item.isServico()) {
                imposto = ImpostoFactory.getImposto(TipoImposto.TIPOISS);
                double valorISS = imposto.calcular(item);
                item.setImpostoCalculado(valorISS);
                item.setTotal(item.getValor() + valorISS);
                totalImpostosServicos += valorISS;
            } else {
                imposto = ImpostoFactory.getImposto(TipoImposto.TIPOICMS);
                double valorICMS = imposto.calcular(item);
                item.setImpostoCalculado(valorICMS);
                item.setTotal(item.getValor() + valorICMS);
                totalImpostosProdutos += valorICMS;
            }

            totalItens += item.getTotal();

            System.out.println("Item: " + item.getDescricao() +
                    " | Valor: R$ " + item.getValor() +
                    " | Imposto: R$ " + item.getImpostoCalculado() +
                    " | Total: R$ " + item.getTotal());
        }

        System.out.println("\nTotal dos itens: R$ " + totalItens);
        System.out.println("Total de impostos sobre produtos: R$ " + totalImpostosProdutos);
        System.out.println("Total de impostos sobre serviços: R$ " + totalImpostosServicos);
    }
}
