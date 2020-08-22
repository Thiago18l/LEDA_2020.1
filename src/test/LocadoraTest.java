package test;

import model.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LocadoraTest {

    Cliente cliente = new Cliente("Jose");
    Cliente cliente1 = new Cliente("Maria");
    Cliente cliente2 = new Cliente("Thiago");

    Fita baby = new Fita("Baby", new TipoInfantil());
    Fita wonderful_woman = new Fita("Mulher Maravilha", new TipoLancamento());
    Fita wolf_of_wall_street = new Fita("Lobo de wall street", new TipoNormal());


    Aluguel aluguel1 = new Aluguel(baby, 2);
    Aluguel aluguel2 = new Aluguel(wonderful_woman, 4);
    Aluguel aluguel3 = new Aluguel(wolf_of_wall_street, 3);

    @Test
    void inserirClienteOrdenado() {
        Locadora locadora = new Locadora();
        locadora.inserirClienteOrdenado(cliente);
        locadora.inserirClienteOrdenado(cliente1);
        locadora.inserirClienteOrdenado(cliente2);
        Cliente cl1 = locadora.getCliente(0);
        Cliente cl2 = locadora.getCliente(1);
        Cliente cl3 = locadora.getCliente(2);
        assertEquals(cliente.getNome(), cl1.getNome());
        assertEquals(cliente1.getNome(), cl2.getNome());
        assertEquals(cliente2.getNome(), cl3.getNome());
    }
    @Test void removeCliente() {
        Locadora locadora = new Locadora();
        locadora.inserirClienteOrdenado(cliente1);
        locadora.inserirClienteOrdenado(cliente2);
        locadora.inserirClienteOrdenado(cliente);
        Cliente c1 = locadora.removeCliente("Jose");
        assertEquals(cliente.getNome(), c1.getNome());
    }
    @Test void buscaLinearClientes() {
        Locadora locadora = new Locadora();
        locadora.inserirClienteOrdenado(cliente);
        locadora.inserirClienteOrdenado(cliente2);
        locadora.inserirClienteOrdenado(cliente1);
        Cliente thiago = locadora.buscaLinearClientes("Thiago");
        assertEquals(cliente2.getNome(), thiago.getNome());
    }
    @Test void buscaBinariaClientes() {
        Locadora locadora = new Locadora();
        locadora.inserirClienteOrdenado(cliente2);
        locadora.inserirClienteOrdenado(cliente1);
        locadora.inserirClienteOrdenado(cliente);
        assertEquals(cliente2, locadora.buscaBinariaClientes("Thiago"));
    }
    @Test void inserirFitaOrdenada() {
        Locadora locadora = new Locadora();
        locadora.inserirFitaOrdenada(baby);
        locadora.inserirFitaOrdenada(wonderful_woman);
        locadora.inserirFitaOrdenada(wolf_of_wall_street);
        assertEquals(baby, locadora.getFita(0));
        assertEquals(wonderful_woman, locadora.getFita(1));
        assertEquals(wolf_of_wall_street, locadora.getFita(2));
    }
    @Test void removeFita() {
        Locadora locadora = new Locadora();
        locadora.inserirFitaOrdenada(baby);
        locadora.inserirFitaOrdenada(wonderful_woman);
        assertEquals(baby, locadora.removeFita("Baby"));
        assertEquals(null, locadora.removeFita("Nome"));
        assertEquals(1, locadora.sizeFita());
    }
    @Test void ordenaFitaPeloNome() {
        Locadora locadora = new Locadora();
        locadora.inserirFitaOrdenada(wonderful_woman);
        locadora.inserirFitaOrdenada(baby);
        locadora.inserirFitaOrdenada(wolf_of_wall_street);
        Fita[] array = {baby, wolf_of_wall_street, wonderful_woman};
        assertArrayEquals(array, locadora.ordenaFitaPeloNome());
    }
    @Test void testOrdenaFitaPeloNome() {
        Locadora locadora = new Locadora();
        Fita[] fitas = {wonderful_woman, wolf_of_wall_street, baby};
        Fita[] expected = {baby, wolf_of_wall_street, wonderful_woman};
        assertArrayEquals(expected, locadora.ordenaFitaPeloNome(fitas));
    }
    @Test void buscaLinearFita() {
        Locadora locadora = new Locadora();
        locadora.inserirFitaOrdenada(baby);
        locadora.inserirFitaOrdenada(wonderful_woman);
        locadora.inserirFitaOrdenada(wolf_of_wall_street);
        assertEquals(baby, locadora.buscaLinearFita("Baby"));
    }
    @Test void buscaBinariaFita() {
        Locadora locadora = new Locadora();
        locadora.inserirFitaOrdenada(baby);
        locadora.inserirFitaOrdenada(wonderful_woman);
        locadora.inserirFitaOrdenada(wolf_of_wall_street);
        assertEquals(wonderful_woman, locadora.buscaBinariaFita("Mulher Maravilha"));
    }
    @Test
    void adicionarAluguel () {
        Locadora locadora = new Locadora();
        locadora.adicionarAluguel(aluguel1);
        locadora.adicionarAluguel(aluguel3);
        locadora.adicionarAluguel(aluguel2);
        assertEquals(aluguel1, locadora.getAluguel(0));
        assertEquals(aluguel3, locadora.getAluguel(1));
        assertEquals(aluguel2, locadora.getAluguel(2));
    }
    @Test
    void ordenarAlugueisPorValor() {
        Locadora locadora = new Locadora();
        locadora.adicionarAluguel(aluguel1);
        locadora.adicionarAluguel(aluguel3);
        locadora.adicionarAluguel(aluguel2);
        Aluguel[] alugueis = locadora.ordenarAlugueisPorValor();
        assertEquals(1.5, alugueis[0].calcularValor());
        assertEquals(3.5, alugueis[1].calcularValor());
    }

    @Test
    void testOrdenarAlugueisPorValor() {
        Locadora locadora = new Locadora();
        Aluguel[] alugueis = {aluguel3, aluguel1, aluguel2};
        Aluguel[] expected = {aluguel1, aluguel3, aluguel2};
        assertArrayEquals(expected, locadora.ordenarAlugueisPorValor(alugueis));
    }@Test
    void ordenarAlugueisSelectionSortPorValor() {
        Locadora locadora = new Locadora();
        locadora.adicionarAluguel(aluguel1);
        locadora.adicionarAluguel(aluguel2);
        locadora.adicionarAluguel(aluguel3);
        Aluguel[] expected = {aluguel1, aluguel3, aluguel2};
        assertArrayEquals(expected, locadora.ordenarAlugueisSelectionSortPorValor());
        assertEquals(3, locadora.sizeAlugueis());
    }
}