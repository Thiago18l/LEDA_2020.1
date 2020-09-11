package algoritmos;

public class main {
    public static void main(String[] args) {
        RadixSort radixSort = new RadixSort();
        Integer[] inteiros = {-3, -10, 2, 4, 5, 1, 4, 32};
        CountingSort countingSort = new CountingSort();
        radixSort.ordena(inteiros, 0, inteiros.length);
        for (Integer n : inteiros) {
            System.out.println(n);
        }
    }
}
