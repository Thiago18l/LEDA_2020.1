package model;


import java.util.Arrays;

public class Locadora {
    private static final Integer TAMANHO_DO_ARRAY = 10;
    private Cliente[] clientes;
    private Fita[] fitas;
    private Aluguel[] alugueis;
    private Integer size = 0;
    private Integer sizeFita = 0;
    private Integer sizeAlugueis = 0;

    public Locadora () {
        clientes = new Cliente[TAMANHO_DO_ARRAY];
        fitas = new Fita[TAMANHO_DO_ARRAY];
        alugueis = new Aluguel[TAMANHO_DO_ARRAY];
    }

    // metodos para Clientes
    /**
     *
     * @param index
     * @return um Cliente
     */
    public Cliente getCliente (int index) {
        if (index>= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", de Tamanho: " + index);
        }
        return clientes[index];
    }
    /**
     *
     * @return tamanho do array de Clientes
     */
    public Integer size() {
        return this.size;
    }
    /**
     * Adiciona um cliente a uma posição do array.
     * @param cliente
     */
    public void inserirClienteOrdenado (Cliente cliente) {
        if (size == clientes.length) {
            aumentaTamanhoCliente();
        }
        clientes[this.size++] = cliente;
        ordenarClientesPeloNome();

    }
    /**
     * Aumenta o tamanho do array, copiando o antigo e criando um
     * novo.
     */
    private void aumentaTamanhoCliente () {
        int newSize = clientes.length * 2;
        clientes = Arrays.copyOf(clientes, newSize);
    }
    /**
     * Remove cliente pelo nome.
     * @param nome
     */
    public Cliente removeCliente (String nome) {
        Cliente cliente = null;
        for (int i = 0; i < size(); i++) {
            if (clientes[i] == null) {
                break;
            }
            if (clientes[i].getNome().equals(nome)) {
                cliente = clientes[i];
                for (int j = i; j < size(); j++) {
                    clientes[j] = clientes[j+1];
                }
                size--;
                return cliente;
            }
        }
        return cliente;
    }
    public Cliente[] ordenarClientesPeloNome (Cliente [] clientes) {
        Integer sizeClientes = clientes.length;
        Integer ordena = 1;
        Integer index;
        while (ordena < sizeClientes) {
            Cliente cliente = clientes[ordena];
            for (index = ordena; index > 0; index--) {
                if (cliente.getNome().compareTo(clientes[index -1].getNome()) < 0) {
                    clientes[index] = clientes[index - 1];
                } else {
                    break;
                }
            }
            clientes[index] = cliente;
            ordena++;
        }
        return clientes;
    }
    public Cliente[] ordenarClientesPeloNome () {
        int ordenado = 0;
        int index;
        clientes = Arrays.copyOf(clientes, size() + 1);
        while (ordenado < size()) {
            Cliente first = clientes[ordenado];
            if (clientes[ordenado] == null) {
                break;
            }
            for (index = ordenado; index > 0; index--) {
                if (first.getNome().compareTo(clientes[index - 1].getNome()) < 0) {
                    clientes[index]  = clientes[index - 1];
                } else {
                    break;
                }
            }
            clientes[index] = first;
            ordenado++;
        }
        return clientes;
    }
    public Cliente buscaLinearClientes (String nome) {
        Cliente cliente = null;
        for (int i = 0; i < size(); i++) {
            if (clientes[i].getNome().equals(nome)) {
                cliente = clientes[i];
            }
        }
        return cliente;
    }
    public Cliente buscaBinariaClientes (String nome) {
        Cliente[] clientes = ordenarClientesPeloNome();
        Integer comeco = 0;
        Integer end = size() - 1;
        Cliente cliente = null;
        while (comeco <= end) {
            Integer meio = (comeco + end)/2;
            if (clientes[meio].getNome().compareTo(nome) == 0) {
                cliente = clientes[meio];
                return cliente;
            } else if (clientes[meio].getNome().compareTo(nome) < 0) {
                comeco++;
            } else if (clientes[meio].getNome().compareTo(nome) > 0) {
                end--;
            }
        }
        return cliente;
    }

    // Metodos para Fita
    public Fita[] ordenarFitasMergeSortPorValor(Fita [] fitas) {
        Integer length = fitas.length;
        if (length < 2) {
            return fitas;
        }
        int mid = length / 2;
        Fita [] esquerda = new Fita[mid];
        Fita [] direita = new Fita[length - mid];
        for (int i = 0; i < mid; i++){
            esquerda[i] = fitas[i];
        }
        for (int i = mid; i < length; i++) {
            direita[i - mid] = fitas[i];
        }
        ordenarFitasMergeSortPorValor(esquerda);
        ordenarFitasMergeSortPorValor(direita);

        merge(fitas, esquerda, direita, mid, length - mid);
        return fitas;
    }
    private void merge(Fita[] fita, Fita[] esquerda, Fita[] direita, Integer left, Integer right) {
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (esquerda[i].getValor(1) <= direita[i].getValor(1)) {
                fita[k++] = esquerda[i++];
            } else {
                fita[k++] = direita[j++];
            }
        }
        while (i < left) {
            fita[k++] = esquerda[i++];
        }
        while (j < right) {
            fita[k++] = direita[j++];
        }
    }
    public Fita[] ordenarFitasQuickSortPorValor(Fita[] fitas, int begin, int end) {
        if (begin < end) {
            int index = particao(fitas, begin, end);
            ordenarFitasQuickSortPorValor(fitas, begin, index - 1);
            ordenarFitasQuickSortPorValor(fitas, index + 1, end);
        }
        return fitas;
    }
    private int particao(Fita[] fita, int begin, int end) {
        double pivot = fita[end].getValor(1);
        int i = (begin - 1);
        for (int j = begin; j < end; j++) {
            if (fita[j].getValor(1) <= pivot) {
                i++;
                Fita troca = fita[i];
                fita[i] = fita[j];
                fita[j] = troca;
            }
        }
        Fita troca = fita[i+1];
        fita[i+1] = fita[end];
        fita[end] = troca;
        return i+1;
    }
    public Fita getFita (Integer index) {
        if (index>= sizeFita || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", de Tamanho: " + index);
        }
        return fitas[index];
    }
    public void inserirFitaOrdenada (Fita fita) {
        if (sizeFita() == fitas.length) {
            aumentaTamanhoFita();
        }
        fitas[this.sizeFita++] = fita;
    }
    public Integer sizeFita () { return this.sizeFita; }
    public Fita removeFita(String titulo) {
        Fita fita = null;
        fitas = Arrays.copyOf(fitas, sizeFita() + 1);
        for (int i = 0; i < sizeFita(); i++) {
            if (fitas[i].getTitulo().equals(titulo)) {
                fita = fitas[i];
                for (int j = i; j < sizeFita(); j++) {
                    fitas[j] = fitas[j+1];
                }
                sizeFita--;
                return fita;
            }
        }
        return fita;
    }
    private void aumentaTamanhoFita() {
        int newSize = fitas.length * 2;
        fitas = Arrays.copyOf(fitas, newSize);
    }
    public Fita[] ordenaFitaPeloNome(Fita[] fitas) {
        Integer sizeFita = fitas.length;
        Integer ordena = 1;
        Integer index;
        while (ordena < sizeFita) {
            Fita fita = fitas[ordena];
            for (index = ordena; index > 0; index--) {
                if (fita.getTitulo().compareTo(fitas[index -1].getTitulo()) < 0) {
                    fitas[index] = fitas[index - 1];
                } else {
                    break;
                }
            }
            fitas[index] = fita;
            ordena++;
        }
        return fitas;
    }
    public Fita[] ordenaFitaPeloNome() {
        Integer ordena = 1;
        Integer index;
        Integer size = sizeFita();
        fitas = Arrays.copyOf(fitas, sizeFita());
        while (ordena < size) {
            Fita fita = fitas[ordena];
            for (index = ordena; index > 0; index--) {
                if (fita.getTitulo().compareTo(fitas[index - 1].getTitulo()) < 0) {
                    fitas[index] = fitas[index - 1];
                } else {
                    break;
                }
            }
            fitas[index] = fita;
            ordena++;
        }
        return fitas;
    }
    public Fita buscaLinearFita (String titulo) {
        Fita fita = null;
        for (int i = 0; i < sizeFita(); i++) {
            if (fitas[i].getTitulo().equals(titulo)) {
                fita = fitas[i];
            }
        }
        return fita;
    }
    public Fita buscaBinariaFita (String titulo) {
        Fita[] fitas = ordenaFitaPeloNome();
        Integer comeco = 0;
        Integer end = sizeFita() - 1;
        Fita fita = null;
        while (comeco <= end) {
            Integer meio = (comeco + end)/2;
            if (fitas[meio].getTitulo().compareTo(titulo) == 0) {
                fita = fitas[meio];
                return fita;
            } else if (fitas[meio].getTitulo().compareTo(titulo) < 0) {
                comeco++;
            } else if (fitas[meio].getTitulo().compareTo(titulo) > 0) {
                end--;
            }
        }
        return fita;
    }

    // Metodos para alugueis

    /**
     *
     * @return o tamanho atual dos alugueis.
     */
    public Integer sizeAlugueis () {
        return this.sizeAlugueis;
    }
    /**
     * Metodo para adicionar um aluguel a
     * o array.
     * @param aluguel
     */
    public void adicionarAluguel (Aluguel aluguel) {
        if (this.sizeAlugueis == alugueis.length) {
            aumentaTamanhoAluguel();
        }
        alugueis[sizeAlugueis++] = aluguel;
    }
    private void aumentaTamanhoAluguel () {
        int newTam = alugueis.length * 2;
        alugueis = Arrays.copyOf(alugueis, newTam);
    }
    public Aluguel getAluguel(int index) {
        if (index>= sizeAlugueis() || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", de Tamanho: " + index);
        }
        return alugueis[index];
    }
    public Aluguel[] ordenarAlugueisPorValor () {
        Integer ordena = 1;
        Integer index;
        alugueis = Arrays.copyOf(alugueis, sizeAlugueis);
        while (ordena < this.sizeAlugueis) {
            Aluguel aluguel = alugueis[ordena];
            if (alugueis[ordena] == null) {
                break;
            }
            for (index = ordena; index > 0; index--) {
                if (aluguel.calcularValor() < alugueis[index - 1].calcularValor()) {
                    alugueis[index] = alugueis[index - 1];
                } else {
                    break;
                }
            }
            alugueis[index] = aluguel;
            ordena++;
        }
        return alugueis;
    }
    public Aluguel[] ordenarAlugueisPorValor(Aluguel[] alugueis) {
        Integer sizeAlugueis = alugueis.length;
        Integer ordena = 1;
        Integer index;
        while (ordena < sizeAlugueis) {
            Aluguel aluguel = alugueis[ordena];
            if (alugueis[ordena] == null) {
                break;
            }
            for (index = ordena; index > 0; index--) {
                if (aluguel.calcularValor() < alugueis[index - 1].calcularValor()) {
                    alugueis[index] = alugueis[index - 1];
                } else {
                    break;
                }
            }
            alugueis[index] = aluguel;
            ordena++;
        }
        return alugueis;
    }
    public Aluguel[] ordenarAlugueisSelectionSortPorValor() {
        int index;
        int max;
        int size = sizeAlugueis();
        alugueis = Arrays.copyOf(alugueis, sizeAlugueis());
        while (size > 0) {
            max = 0;
            for (index = 1; index < sizeAlugueis(); index++) {
                if (alugueis[max].calcularValor() < alugueis[index].calcularValor()) max = index;
            }
            swap(alugueis, max, sizeAlugueis -1);
            size--;
        }
        return alugueis;
    }
    private void swap (Aluguel[] alugueis, Integer max, Integer size) {
        Aluguel smallestNumber = alugueis[max];
        alugueis[max] =  alugueis[size];
        alugueis[size] = smallestNumber;
    }
}
