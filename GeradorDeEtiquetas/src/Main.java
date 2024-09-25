public class Main {
    public static void main(String[] args) {

        Produto produto = new Produto(
                "Cerveja Original",
                4.50,
                36.0,
                "40028922");
        String etiquetaZPL = GeradorEtiquetas.gerarEtiquetas(produto);
        System.out.println(etiquetaZPL);

    }
}