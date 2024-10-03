import java.util.List;

public class CalibracaoThreads extends Thread {
    private List<String> listaPalavras;
    private int somaParcial;

    public CalibracaoThreads(List<String> listaPalavras) {
        this.listaPalavras = listaPalavras;
        this.somaParcial = 0;
    }

    // Método que será executado pela thread
    @Override
    public void run() {
        for (String palavra : listaPalavras) {
            Integer primeiroDigito = null;
            Integer ultimoDigito = null;

            for (char c : palavra.toCharArray()) {
                if (Character.isDigit(c)) {
                    if (primeiroDigito == null) {
                        primeiroDigito = Character.getNumericValue(c);
                    }
                    ultimoDigito = Character.getNumericValue(c);
                }
            }

            if (primeiroDigito != null && ultimoDigito != null) {
                int numeroCalibracao = Integer.parseInt("" + primeiroDigito + ultimoDigito);
                somaParcial += numeroCalibracao;
            }
        }
    }

    public int getSomaParcial() {
        return somaParcial;
    }
}


