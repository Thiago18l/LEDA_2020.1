package utils;

import java.util.Objects;

public class Password {
    private Integer length;
    private Integer ocorrencia;
    private String password;

    public Password(Integer length, Integer ocorrencia, String password) {
        this.length = length;
        this.ocorrencia = ocorrencia;
        this.password = password;
    }

    public Integer getLength() {
        return length;
    }

    public Integer getOcorrencia() {
        return ocorrencia;
    }

    public String getPassword() {
        return password;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Password)) return false;
        Password passwords = (Password) o;
        return length.equals(passwords.length) &&
                ocorrencia.equals(passwords.ocorrencia) &&
                password.equals(passwords.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(length, ocorrencia, password);
    }
}
