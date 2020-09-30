package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

public class Store {
    private static final Integer default_capacity = 20;
    private Password[] data;
    private Integer size = 0;

    public Store() {
        data = new Password[default_capacity];
    }

    public void add(Password element) {
        if (size == data.length) {
            grow();
        }
        data[this.size] = element;
        size++;
    }
    public void print() {
        for (int i = 0; i < size(); i++) {
            System.out.println(this.data[i].getLength());
        }
    }
    private void grow() {
        int newSize = data.length + 10;
        data = Arrays.copyOf(data, newSize);
    }
    public Password get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index:" + index + " , de Tamanho: " + index);
        }
        return data[index];
    }
    public void ReadFile (String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = "";
            line = br.readLine();

            while (line != null) {
                    String[] linhas = line.split(" ");
                    add(new Password((Integer.parseInt(linhas[0])), Integer.parseInt(linhas[1]), linhas[2]));
                    System.out.println(Arrays.toString(linhas));
                    line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void WriteFile (String output, Password[] passwords) {
    	try (BufferedWriter bw = new BufferedWriter(new FileWriter(output))) {
    		String line = "";
    		for (int i = 0; i < passwords.length; i++) {
    			line = passwords[i].getLength() + " " + passwords[i].getOcorrencia() + " " + passwords[i].getPassword();
    			bw.write(line + '\n');
    		}
    	} catch (Exception e) {
    		System.out.println(e.getMessage());
    	}
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Store)) return false;
        Store store = (Store) o;
        return size == store.size &&
                Arrays.equals(data, store.data);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size);
        result = 31 * result + Arrays.hashCode(data);
        return result;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return this.size;
    }

    public Password[] getData() {
        return this.data;
    }

}
