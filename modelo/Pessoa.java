package modelo;

import java.time.LocalDate;

public abstract class Pessoa {

    //Atributos

    private String cpf;
    private String nome;
    private String email;
    private LocalDate dataNascimento;

    //Getters

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    //Setters

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser vazio.");
        }
        this.nome = nome.trim();
    }

    public void setCpf(String cpf) {
        if (cpf == null || cpf.trim().isEmpty() || cpf.length() != 11) {
            throw new IllegalArgumentException("CPF inválido");
        }
        this.cpf = cpf;
    }

    public void setEmail(String email) {
        if (email == null || email.trim().isEmpty() || !email.contains("@")) {
            throw new IllegalArgumentException("E-mail inválido.");
        }
        this.email = email;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        if (
            dataNascimento == null ||
            dataNascimento.trim().isEmpty ||
            !dataNascimento.contains("/")
        ) {
            throw new IllegalArgumentException("Data de nascimento inválida.");
        }
        this.dataNascimento = dataNascimento;
    }

    // Método abstrato
}
