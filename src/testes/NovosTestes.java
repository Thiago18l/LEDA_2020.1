package testes;

import java.util.Arrays;

import algoritmos.CountingSort;
import algoritmos.ExtendedCountingSort;
import algoritmos.RadixSort;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sorting.AbstractSorting;

class NovosTestes {
	
	private Integer[] vetorTamPar;
	private Integer[] vetorTamImpart;
	private Integer[] vetorVazio;
	private Integer[] vetorValoresRepetidos;
	private Integer[] vetorValoresIguais;
	private AbstractSorting<Integer> Implementacao;
	private Integer[] vetorPiorCaso;
	private Integer[] vetorMelhorCaso;
	
	@BeforeEach
	public void setUp() {
		populaVetorValoresIguais(new Integer[] {10, 10, 10, 10, 10, 10, 10, 10,});
		populaVetorTamImpar(new Integer[] {3, 99, 48, 13, 47, 18, 1, 28, 59, 22, 67});
		populaVetorTamPar(new Integer[] {23, 10, 3, 69, 51, 99, 45, 32, 87, 88});
		populaVetorVazio(new Integer[] {});
		populaVetorRepetidos(new Integer[] {2, 6, 98, 54, 6, 78, 2, 34, 87, 78, 2, 1 });
		populaVetorMelhorCaso(new Integer[] {1, 5, 8, 12, 38, 40, 45, 67, 70, 78, 80, 98});
		populaVetorPiorCaso(new Integer[] {59, 43, 36, 20, 19, 17, 13, 10, 8, 5, 2, 1});
		getImplementacao();
	}
	
	private void getImplementacao() {
		//TODO: colocar a implementação do método a ser testada
		//this.Implementacao = new QuickSortExtraPivo()<Integer>();
//		Assert.fail("falhar quando não tiver implementação");
	}
	
	public void populaVetorRepetidos(Integer[] arrayArgumento) {
		this.vetorValoresRepetidos = Arrays.copyOf(arrayArgumento, arrayArgumento.length);
	}
	
	public void populaVetorValoresIguais(Integer[] arrayArgumento) {
		this.vetorValoresIguais = Arrays.copyOf(arrayArgumento, arrayArgumento.length);
	}
	
	public void populaVetorTamImpar(Integer[] arrayArgumento) {
		this.vetorTamImpart = Arrays.copyOf(arrayArgumento, arrayArgumento.length);
	}
	
	public void populaVetorTamPar(Integer[] arrayArgumento) {
		this.vetorTamPar = Arrays.copyOf(arrayArgumento, arrayArgumento.length);
	}
	
	public void populaVetorVazio(Integer[] arrayArgumento) {
		this.vetorVazio = Arrays.copyOf(arrayArgumento, arrayArgumento.length);
	}
	
	public void populaVetorPiorCaso(Integer[] arrayArgumento) {
		this.vetorPiorCaso = Arrays.copyOf(arrayArgumento, arrayArgumento.length);
	}
	
	public void populaVetorMelhorCaso(Integer[] arrayArgumento) {
		this.vetorMelhorCaso = Arrays.copyOf(arrayArgumento, arrayArgumento.length);
	}
	@Test
	public void testSortVetorPar() {
		CountingSort countingSort = new CountingSort();
		RadixSort radixSort = new RadixSort();
		Integer[] expected;
		expected = Arrays.copyOf(vetorTamPar, vetorTamPar.length);
		Arrays.sort(expected);
		Assert.assertArrayEquals(expected, countingSort.ordena(vetorTamPar, 3, 99));
		Assert.assertArrayEquals(expected, radixSort.ordena(vetorTamPar, 0, vetorTamPar.length - 1));
	}
	@Test
	public void testSortVetorImpar() {
		CountingSort countingSort = new CountingSort();
		RadixSort radixSort = new RadixSort();
		Integer[] expected;
		expected = Arrays.copyOf(vetorTamImpart, vetorTamImpart.length);
		Arrays.sort(expected);
		Assert.assertArrayEquals(expected, countingSort.ordena(vetorTamImpart, 1, 99));
		Assert.assertArrayEquals(expected, radixSort.ordena(vetorTamImpart, 0, vetorTamImpart.length - 1));
	}
	
	@Test
	public void testSortRepetidos() {
		CountingSort countingSort = new CountingSort();
		RadixSort radixSort = new RadixSort();
		Integer[] expected;
		expected = Arrays.copyOf(vetorValoresRepetidos, vetorValoresRepetidos.length);
		Arrays.sort(expected);
		Assert.assertArrayEquals(expected, countingSort.ordena(vetorValoresRepetidos, 1, 98));
		Assert.assertArrayEquals(expected, radixSort.ordena(vetorValoresRepetidos, 0, vetorValoresRepetidos.length - 1));
	}
	
	@Test
	public void testSortIguais() {
		CountingSort countingSort = new CountingSort();
		RadixSort radixSort = new RadixSort();
		Integer[] expected;
		expected = Arrays.copyOf(vetorValoresIguais, vetorValoresIguais.length);
		Arrays.sort(expected);
		Assert.assertArrayEquals(expected, countingSort.ordena(vetorValoresIguais, 10, 10));
		Assert.assertArrayEquals(expected, radixSort.ordena(vetorValoresIguais, 0, vetorValoresIguais.length - 1));
	}
	@Test
	public void testSortPiorCaso() {
		CountingSort countingSort = new CountingSort();
		RadixSort radixSort = new RadixSort();
		Integer[] expected;
		expected = Arrays.copyOf(vetorPiorCaso, vetorPiorCaso.length);
		Arrays.sort(expected);
		Assert.assertArrayEquals(expected, countingSort.ordena(vetorPiorCaso, 1, 59));
		Assert.assertArrayEquals(expected, radixSort.ordena(vetorPiorCaso, 0, vetorPiorCaso.length - 1));
	}
	
	@Test
	public void testSortMelhorCaso() {
		CountingSort countingSort = new CountingSort();
		RadixSort radixSort = new RadixSort();
		Integer[] expected;
		expected = Arrays.copyOf(vetorMelhorCaso, vetorMelhorCaso.length);
		Arrays.sort(expected);
		Assert.assertArrayEquals(expected, countingSort.ordena(vetorMelhorCaso, 1, 98));
		Assert.assertArrayEquals(expected, radixSort.ordena(vetorMelhorCaso, 0, vetorMelhorCaso.length - 1));
	}
	@Test
	public void testSortNegativos() {
		ExtendedCountingSort extendedCountingSort = new ExtendedCountingSort();
		Integer[] expected = {-10, -29, 2, 4, 1, 10, 234, 100};
		Integer[] actual = {-10, -29, 2, 4, 1, 10, 234, 100};
		Arrays.sort(expected);
		Assert.assertArrayEquals(expected, extendedCountingSort.ordena(actual, -29, 234));
	}

}
