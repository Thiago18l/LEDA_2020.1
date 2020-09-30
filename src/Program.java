import utils.Sort;
import utils.Password;
import utils.Store;

import java.util.Arrays;

public class Program {
    public static void main(String[] args) {
        Password[] dados;
        Sort algorithms = new Sort();
        Store store = new Store();
        String path = "/home/thiago/Documentos/Dev/PROJETO_LEDA_v1/arquivo.txt";
        String output = "/home/thiago/Documentos/Dev/PROJETO_LEDA_v1/ordenado.txt";
        store.ReadFile(path);
        System.out.println(store.size());


        dados = Arrays.copyOf(store.getData(), store.size());
        algorithms.quicksortMedianaDeTresAlfabetica(dados);
        store.WriteFile(output, dados);
    }
}
