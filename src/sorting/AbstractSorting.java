package sorting;

public abstract class AbstractSorting <T extends Comparable<T>> implements Sort<T>{

	@Override
	public void sort(T[] array) {
		ordena(array, 0, array.length - 1);
	}

	public abstract Integer[] ordena(T[] array, int inicio, int fim);

}
