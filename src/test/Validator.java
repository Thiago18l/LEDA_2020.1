package test;

import java.io.BufferedReader;
import java.io.FileReader;

public class Validator {
    public static void main(String[] args) {
        Validator validator = new Validator();
        validator.validateOcorrencia();
    }
    public void validateOcorrencia () {
        boolean isOk = false;
        String output = "";
        try (BufferedReader br = new BufferedReader(new FileReader(output))) {
            String line = "";
            line = br.readLine();
            while (line != null) {
                String[] lines = line.split(" ");
                for (int i = 0; i < 430000; i++) {
                    if (Integer.parseInt(lines[1]) <= Integer.parseInt(lines[1] + 1)) isOk = true;
                }
                line = br.readLine();
            }
            if (isOk) {
                System.out.println("Arquivo está Ordenado!");
            } else {
                System.out.println("Arquivo não está Ordenado!");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void validateAlfabetico () {
        boolean isOk = false;
        String output = "";
        try (BufferedReader br = new BufferedReader(new FileReader(output))) {
            String line = "";
            line = br.readLine();
            while (line != null) {
                String[] lines = line.split(" ");
                for (int i = 0; i < 430000; i++) {
                    if (lines[2].compareTo(lines[2] + 1) <= 0) isOk = true;
                }
                line = br.readLine();
            }
            if (isOk) {
                System.out.println("Arquivo está Ordenado!");
            } else {
                System.out.println("Arquivo não está Ordenado!");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
