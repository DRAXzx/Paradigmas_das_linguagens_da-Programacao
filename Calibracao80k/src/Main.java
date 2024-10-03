import java.util.ArrayList;
import java.util.List;

public class Main{
    public static void main(String[] args) {
            //fiquei com medo de testar todas as linhas e queimar meu note kkkk, coloquei so esses que tava
            // no exemplo, ai o senhor testa com mais linhas.
        String linhasTexto = """
                1abc2
                pqr3stu8vwx
                a1b2c3d4e5f
                treb7uchet
                """;

        List<String> listaPalavras = new ArrayList<>(List.of(linhasTexto.split("\\n")));

        int numeroDeThreads = 4;
        List<CalibracaoThreads> threads = new ArrayList<>();
        int tamanhoParte = listaPalavras.size() / numeroDeThreads;

        for (int i = 0; i < numeroDeThreads; i++) {
            int inicio = i * tamanhoParte;
            int fim = (i == numeroDeThreads - 1) ? listaPalavras.size() : inicio + tamanhoParte;
            List<String> subLista = listaPalavras.subList(inicio, fim);
            CalibracaoThreads task = new CalibracaoThreads(subLista);
            threads.add(task);
            task.start();
        }

        int somaTotal = 0;
        for (CalibracaoThreads task : threads) {
            try {
                task.join();
                somaTotal += task.getSomaParcial();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Soma dos valores de calibração extraídos: " + somaTotal);
    }
}
//Explique qual a melhor performance para o algoritmo em paralelo ou estruturado?

//Quando se trata de escolher entre um algoritmo sequencial e um paralelo, a decisão depende muito do tamanho dos dados
// que você está lidando. O algoritmo sequencial é como seguir uma receita passo a passo; ele funciona bem com conjuntos
// pequenos de dados, processando cada linha uma de cada vez. É simples e fácil de entender, mas pode demorar um pouco
// se você tiver muitas informações.
//Por outro lado, o algoritmo paralelo é como ter várias pessoas trabalhando em uma tarefa ao mesmo tempo. Para grandes
// volumes de dados, como as 80 mil linhas que você mencionou, ele divide o trabalho entre várias threads, aproveitando
// múltiplos núcleos do processador. Isso faz com que o processamento seja muito mais rápido. Portanto, se você está
// lidando com um grande número de linhas, o paralelismo é definitivamente o caminho a seguir, já que pode reduzir
// significativamente o tempo que você levaria para concluir a tarefa.