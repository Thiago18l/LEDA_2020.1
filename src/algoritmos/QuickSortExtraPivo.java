package algoritmos;

import sorting.AbstractSorting;

/**
 * QuickSort de pivô extra foca na implementação de um método de pivoteamento
 * O(n) para escolher um pivo com base nos valores do array. Este método deve
 * analisar os elementos do array e obter uma média dos valores para que seja 
 * usado como o pivô.
 * Lembre de identificar pivô que de fato existam no array, ou seja, você precisa
 * fazer uma busca no próprio array.
 * @author fabioleite
 *
 * @param <T>
 */
public class QuickSortExtraPivo<T extends Comparable<T>> extends AbstractSorting<T>{

	@Override
	public T[] ordena(T[] array, int inicio, int fim) {
		/*
		if (right > left) {
        // Choose outermost elements as pivots
        if (A[left] > A[right]) swap(A, left, right);
        int p = A[left], q = A[right];

        // Partition A according to invariant below
        int l = left + 1, g = right - 1, k = l;
        while (k <= g) {
            if (A[k] < p) {
                swap(A, k, l);
                ++l;
            } else if (A[k] >= q) {
                while (A[g] > q && k < g) --g;
                swap(A, k, g);
                --g;
                if (A[k] < p) {
                    swap(A, k, l);
                    ++l;
                }
            }
            ++k;
        }
        --l; ++g;

        // Swap pivots to final place
        swap(A, left, l); swap(A, right, g);

        // Recursively sort partitions
        sort(A, left, l - 1);
        sort(A, l + 1, g - 1);
        sort(A, g + 1, right);
    }
}

void swap(int[] A, int i, int j) {
    final int tmp = A[i]; A[i] = A[j]; A[j] = tmp;
}
		 */
	return array;
	}
}
