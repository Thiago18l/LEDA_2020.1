package algoritmos;

import sorting.AbstractSorting;

public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public T[] ordena(T[] array, int inicio, int fim) {
		if (fim - inicio < 1) return array;
		int meio = (inicio + fim) / 2;
		ordena(array, inicio, meio);
		ordena(array, meio + 1, fim);

		merge(array, inicio, meio,fim);

		return array;
	}
	private static <T extends Comparable<T>> void merge(T[] array, int inicio, int meio, int fim) {
		Object[] temporario = new Object[fim - inicio + 1];
		int i = inicio; //esquerda
		int j = meio + 1; //direita
		int k = 0;
		while (i <= meio && j <= fim) {
			if (array[i].compareTo(array[j]) < 0) {
				temporario[k] = array[i++];
			} else {
				temporario[k] = array[j++];
			}
			k++;
		}
		if (i <= meio && j > fim) {
			while (i <= meio) {
				temporario[k++] = array[i++];
			}
		} else {
			while (j <= fim) {
				temporario[k++] = array[j++];
			}
		}
		for (k = 0; k < temporario.length; k++) {
			array[k+inicio] = (T)(temporario[k]);
		}
	}
}
