package modelo;

public class Palestrante extends Pessoa {

	// Atributos

	private String titulacao;
	private String areaEspecializacao;

	// Construtor

	public Palestrante(String cpf, String nome, String email, String dataNascimento, String titulação, String areaEspecializacao) {
		super(cpf, nome, email, dataNascimento);
		this.setTitulacao(titulação);
		this.setAreaEspecializacao(areaEspecializacao);
	}

	// Método concreto com polimorfismo

	@Override
	public String obterTipoPessoa() {
		return "Palestrante: "+titulacao;
	}

	// Getters

	public String getTitulacao() {
		return titulacao;
	}

	public String getAreaEspecializacao() {
		return areaEspecializacao;
	}

	// Setters

	public void setTitulacao(String titulacao) {
		if(titulacao == null || titulacao.trim().isEmpty() ) {
			throw new IllegalArgumentException("A titulação nao pode ser vazia");
		}
		this.titulacao = titulacao.trim();
	}

	public void setAreaEspecializacao(String areaEspecializacao) {
		if(areaEspecializacao == null || areaEspecializacao.trim().isEmpty() ) {
			throw new IllegalArgumentException("A area de especializacao nao pode ser vazia");
		}
		this.areaEspecializacao = areaEspecializacao.trim();
	}

}
