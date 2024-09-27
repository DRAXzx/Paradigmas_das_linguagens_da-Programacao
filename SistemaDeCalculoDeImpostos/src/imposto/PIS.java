package imposto;
import model.Produto;
public class PIS implements Imposto{
    @Override
    public double calcular(Produto produto) {
        if (!produto.isServico()) {
            return produto.getValor() * 0.0065;
        }
        return 0;
    }
}
