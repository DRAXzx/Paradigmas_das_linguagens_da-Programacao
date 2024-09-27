package imposto;
import model.Produto;
public class ICMS implements Imposto {

    @Override
    public double calcular(Produto produto) {
        if(!produto.isServico()){
            return produto.getValor() * 0.18;
        }
        return 0;
    }
}
