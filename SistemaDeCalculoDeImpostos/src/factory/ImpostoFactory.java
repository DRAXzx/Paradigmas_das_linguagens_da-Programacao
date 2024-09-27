package factory;
import imposto.ICMS;
import imposto.ISS;
import imposto.Imposto;
import imposto.IPI;
import imposto.PIS;

public class ImpostoFactory {
    public static Imposto getImposto(TipoImposto tipo) {
        switch (tipo){
            case TIPOICMS:
                return new ICMS();
            case TIPOPIS:
                return new PIS();
            case TIPOIPI:
                return new IPI();
            case TIPOISS:
                return new ISS();
            default:
                throw new IllegalArgumentException(" Tipo de Imposto Desconhecido ");
        }

    }
}
