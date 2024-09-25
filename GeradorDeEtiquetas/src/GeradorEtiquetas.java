public class GeradorEtiquetas {
    public static String gerarEtiquetas(Produto produto) {
        String descricao = produto.getDescricao();
        String valorLata = formatarMoeda(produto.getPrecoLata());
        String valorCaixa = formatarMoeda(produto.getPrecoCaixa());
        String codigoDeBarras = produto.getCodigoDeBarras();

        return "^XA\n" +
                "^CF0,60\n" +
                "^FO50,50^FD" + descricao + "^FS\n" +
                "^CFA,50\n" +
                "^FO50,200^FDLata  " + valorLata + "^FS\n" +
                "^FO50,280^FDCaixa " + valorCaixa + "^FS\n" +
                "^BY5,2,270\n" +
                "^FO100,450^BC^FD" + codigoDeBarras + "^FS\n" +
                "^XZ";
    }
    private static String formatarMoeda(double valor) {
        return "R$ " + String.format("%.2f", valor).replace(".", ",");
    }
}
