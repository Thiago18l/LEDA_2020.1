package utils;

public class Sort {

    public void insertionSortOrdenaPorFrequencia(Password[] array) {
        int tamanho = array.length;

        for(int i = 1; i < tamanho; i++) {
            Password key = array[i];
            int j = i - 1;

            while(j >= 0 && (array[j].getOcorrencia().compareTo(key.getOcorrencia()) > 0)) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }
    public void insertionSortOrdemAlfabetica (Password[] passwords) {
        int size = passwords.length;
        for (int i = 1; i < size; i++) {
            Password key = passwords[i];
            int j = i - 1;
            while (j >= 0 && (passwords[j].getPassword().compareTo(key.getPassword()) > 0)) {
                passwords[j + 1] = passwords[j];
                j = j - 1;
            }
            passwords[j + 1] = key;
        }
    }
    public void selectionSortOrdemAlfabetica (Password[] passwords) {
        int size = passwords.length;
        int ordena = 1;
        int index;
        while (ordena < size) {
            Password password = passwords[ordena];
            for (index = ordena; index > 0; index--) {
                if (password.getPassword().compareTo(passwords[index - 1].getPassword()) < 0) {
                    passwords[index] = passwords[index - 1];
                } else {
                    break;
                }
            }
            passwords[index] = password;
            ordena++;
        }
    }
    public void selectionSortPorOcorrencia(Password[] passwords) {
        int index;
        int max;
        int size = passwords.length;
        while (size > 0) {
            max = 0;
            for (index = 1; index < size; index++) {
                if (passwords[max].getOcorrencia() < passwords[index].getOcorrencia()) max = index;
            }
            swap(passwords, max, size -1);
            size--;
        }
    }
    private void swap (Password[] passwords, Integer max, Integer size) {
        Password smallestNumber = passwords[max];
        passwords[max] =  passwords[size];
        passwords[size] = smallestNumber;
    }
    public void mergeSortOrdemAlfabetica (Password[] a, int n) {
        if (n < 2) return;

        int mid = n / 2;
        Password[] left = new Password[mid];
        Password[] right = new Password[n - mid];
        for (int i = 0; i < mid; i++) {
            left[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            right[i - mid] = a[i];
        }
        mergeSortOrdemAlfabetica(left, mid);
        mergeSortOrdemAlfabetica(right, n - mid);
        mergeAlfabetico(a, left, right, mid, n - mid);
    }

    public void mergeSortPorOcorrencia(Password[] a, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        Password[] l = new Password[mid];
        Password[] r = new Password[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        mergeSortPorOcorrencia(l, mid);
        mergeSortPorOcorrencia(r, n - mid);
        merge(a, l, r, mid, n - mid);
    }
    private void mergeAlfabetico (Password[] array, Password[] left, Password[] right, int l, int r) {
        int i = 0, j = 0, k = 0;
        while (i < l && j < r) {
            if (left[i].getPassword().compareTo(right[j].getPassword()) < 0) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }
        while (i < l) {
            array[k++] = left[i++];
        }
        while (j < r) {
            array[k++] = right[j++];
        }
    }

    public static void merge(Password[] a, Password[] l, Password[] r, int left, int right) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i].getOcorrencia() <= r[j].getOcorrencia()) {
                a[k++] = l[i++];
            } else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }
    public void quickSortPorOcorrencia(Password[] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partitionQuickSort(arr, begin, end);

            quickSortPorOcorrencia(arr, begin, partitionIndex - 1);
            quickSortPorOcorrencia(arr, partitionIndex + 1, end);
        }
    }

    private int partitionQuickSort(Password arr[], int begin, int end) {
        Password pivot = arr[end];
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (arr[j].getOcorrencia() <= pivot.getOcorrencia()) {
                i++;

                Password swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        Password swapTemp = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = swapTemp;

        return i + 1;
    }
    public void quicksortMedianaDeTres(Password[] A) {
        quicksortMedianaDeTres(A, 0, A.length - 1);
    }

    private static void quicksortMedianaDeTres(Password[] A, int inicio, int fim) {
        if (inicio < fim) {
            int q = partitionQuickMedianaDeTres(A, inicio, fim);
            quicksortMedianaDeTres(A, inicio, q - 1);
            quicksortMedianaDeTres(A, q + 1, fim);
        }
    }

    private static int partitionQuickMedianaDeTres(Password[] A, int inicio, int fim) {
        int meio = (inicio + fim) / 2;
        Password a = A[inicio];
        Password b = A[meio];
        Password c = A[fim];
        int medianaIndice;
        if (a.getOcorrencia() < b.getOcorrencia()) {
            if (b.getOcorrencia() < c.getOcorrencia()) {
                //a < b && b < c
                medianaIndice = meio;
            } else {
                if (a.getOcorrencia() < c.getOcorrencia()) {
                    //a < c && c <= b
                    medianaIndice = fim;
                } else {
                    //c <= a && a < b
                    medianaIndice = inicio;
                }
            }
        } else {
            if (c.getOcorrencia() < b.getOcorrencia()) {
                //c < b && b <= a
                medianaIndice = meio;
            } else {
                if (c.getOcorrencia() < a.getOcorrencia()) {
                    //b <= c && c < a
                    medianaIndice = fim;
                } else {
                    //b <= a && a <= c
                    medianaIndice = inicio;
                }
            }
        }
        swapMedianaDeTres(A, medianaIndice, fim);
        Password pivo = A[fim];
        int i = inicio - 1;

        for (int j = inicio; j <= fim - 1; j++) {
            if (A[j].getOcorrencia() <= pivo.getOcorrencia()) {
                i = i + 1;
                swapMedianaDeTres(A, i, j);
            }
        }
        swapMedianaDeTres(A, i + 1, fim);
        return i + 1;
    }

    private static void swapMedianaDeTres(Password[] A, int i, int j) {
        Password temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }


    public void countSort(Password[] array, int size) {
        Password[] output = new Password[size + 1];

        // Find the largest element of the array
        Password max = array[0];
        for (int i = 1; i < size; i++) {
            if (array[i].getOcorrencia() > max.getOcorrencia())
                max = array[i];
        }
        int[] count = new int[max.getOcorrencia() + 1];


        for (int i = 0; i < max.getOcorrencia(); ++i) {
            count[i] = 0;
        }

        for (int i = 0; i < size; i++) {
            count[array[i].getOcorrencia()]++;
        }


        for (int i = 1; i <= max.getOcorrencia(); i++) {
            count[i] += count[i - 1];
        }

        for (int i = size - 1; i >= 0; i--) {
            output[count[array[i].getOcorrencia()] - 1] = array[i];
            count[array[i].getOcorrencia()]--;
        }

        for (int i = 0; i < size; i++) {
            array[i] = output[i];
        }
    }
    public void quicksortMedianaDeTresAlfabetica(Password[] A) {
        quicksortMedianaDeTresAlfabetica(A, 0, A.length - 1);
    }


    private static void quicksortMedianaDeTresAlfabetica(Password[] A, int inicio, int fim) {
        if (inicio < fim) {
            int q = partitionQuickMedianaDeTresAlfabetica(A, inicio, fim);
            quicksortMedianaDeTresAlfabetica(A, inicio, q - 1);
            quicksortMedianaDeTresAlfabetica(A, q + 1, fim);
        }
    }


    private static int partitionQuickMedianaDeTresAlfabetica(Password[] A, int inicio, int fim) {
        int meio = (inicio + fim) / 2;
        Password a = A[inicio];
        Password b = A[meio];
        Password c = A[fim];
        int medianaIndice;
        if (a.getPassword().compareTo(b.getPassword()) < 0) {
            if (b.getPassword().compareTo(c.getPassword()) < 0) {
                //a < b && b < c
                medianaIndice = meio;
            } else {
                if (a.getPassword().compareTo(c.getPassword()) < 0) {
                    //a < c && c <= b
                    medianaIndice = fim;
                } else {
                    //c <= a && a < b
                    medianaIndice = inicio;
                }
            }
        } else {
            if (c.getPassword().compareTo(b.getPassword()) < 0) {
                //c < b && b <= a
                medianaIndice = meio;
            } else {
                if (c.getPassword().compareTo(a.getPassword()) < 0) {
                    //b <= c && c < a
                    medianaIndice = fim;
                } else {
                    //b <= a && a <= c
                    medianaIndice = inicio;
                }
            }
        }
        swapMedianaDeTres(A, medianaIndice, fim);
        Password pivo = A[fim];
        int i = inicio - 1;

        for (int j = inicio; j <= fim - 1; j++) {
            if (A[j].getPassword().compareTo(pivo.getPassword()) <= 0) {
                i = i + 1;
                swapMedianaDeTres(A, i, j);
            }
        }
        swapMedianaDeTresAlfabetica(A, i + 1, fim);
        return i + 1;
    }

    private static void swapMedianaDeTresAlfabetica(Password[] A, int i, int j) {
        Password temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public void quickSortPorOrdemAlfabetica(Password[] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partitionQuickSortPorOrdemAlfabetica(arr, begin, end);

            quickSortPorOrdemAlfabetica(arr, begin, partitionIndex - 1);
            quickSortPorOrdemAlfabetica(arr, partitionIndex + 1, end);
        }
    }

    private int partitionQuickSortPorOrdemAlfabetica(Password[] arr, int begin, int end) {
        Password pivot = arr[end];
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (arr[j].getPassword().compareTo(pivot.getPassword()) < 0) {
                i++;

                Password swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        Password swapTemp = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = swapTemp;

        return i + 1;
    }
    public void heapSortOcorrencias(Password[] arr){
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--)
            heapifyOcorrencias(arr, n, i);

        for (int i=n-1; i>0; i--) {
            Password temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapifyOcorrencias(arr, i, 0);
        }
    }

    public void heapifyOcorrencias(Password[] arr, int n, int i) {
        int largest = i; // Initialize largest as root
        int l = 2*i + 1; // left = 2*i + 1
        int r = 2*i + 2; // right = 2*i + 2

        if (l < n && arr[l].getOcorrencia()  > arr[largest].getOcorrencia()) {
            largest = l;
        }
        if (r < n && arr[r].getOcorrencia()  > arr[largest].getOcorrencia()) {
            largest = r;
        }
        if (largest != i){
            Password swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapifyOcorrencias(arr, n, largest);
        }
    }
    public void heapSortAlfabetico(Password[] arr){
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--)
            heapifyAlfabetico(arr, n, i);

        for (int i=n-1; i>0; i--) {
            Password temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapifyAlfabetico(arr, i, 0);
        }
    }

    void heapifyAlfabetico(Password[] arr, int n, int i) {
        int largest = i; // Initialize largest as root
        int l = 2*i + 1; // left = 2*i + 1
        int r = 2*i + 2; // right = 2*i + 2

        if (l < n && arr[l].getPassword().compareTo(arr[largest].getPassword()) > 0) {
            largest = l;
        }
        if (r < n && arr[r].getPassword().compareTo(arr[largest].getPassword()) > 0) {
            largest = r;
        }
        if (largest != i){
            Password swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapifyAlfabetico(arr, n, largest);
        }
    }
}
