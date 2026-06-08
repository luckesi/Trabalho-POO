package modelo;
import java.time.LocalDate;
import java.time.Period;

public abstract class Pessoa {

	// Atributos

	private String cpf;
	private String nome;
	private String email;
	private LocalDate dataNascimento;

	// Getters

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

	// Setters

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
		if (dataNascimento == null) {
			throw new IllegalArgumentException("Data de nascimento inválida.");
		}
		if (dataNascimento.isAfter(LocalDate.now())) {
			throw new IllegalArgumentException("Data de nascimento não pode ser no futuro.");
		}
		this.dataNascimento = dataNascimento;
	}

	// Método abstrato

	public abstract String obterTipoPessoa();

	// Método concreto

	public int calcularIdade() {
		return Period.between(dataNascimento, LocalDate.now()).getYears();
	}

	// Construtores

	public Pessoa(String cpf, String nome, String email, LocalDate dataNascimento) {
		this.setCpf(cpf);
		this.setNome(nome);
		this.setEmail(email);
		this.setDataNascimento(dataNascimento);
	}
}
