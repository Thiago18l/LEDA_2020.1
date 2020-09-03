package algoritmos;

import sorting.AbstractSorting;

public class QuickSort<T extends Comparable<T>> extends AbstractSorting<T> {
	@Override
	public T[] ordena(T[] array, int inicio, int fim) {
		if (inicio < fim) {
			int partitionIndex = partition(array, inicio, fim);

			ordena(array, inicio, partitionIndex - 1);
			ordena(array, partitionIndex + 1, fim);
		}
		return array;
	}
	private Integer partition(T[] array, int inicio, int fim) {
		T pivot = array[fim];
		int i = (inicio - 1);

		for (int j = inicio; j < fim; j++) {
			if (array[j].compareTo(pivot) <= 0) {
				i++;

				T swapTemp = array[i];
				array[i] = array[j];
				array[j] = swapTemp;
			}
		}

		T swapTemp = array[i + 1];
		array[i + 1] = array[fim];
		array[fim] = swapTemp;

		return i + 1;
	}
}
