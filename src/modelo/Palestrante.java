//Palestrante
//└── atributos: titulacao, areaEspecializacao
package modelo;
import java.time.LocalDate;

public class Palestrante extends Pessoa {
	private String titulacao;
	private String areaEspecializacao;

	public Palestrante(String cpf, String nome, String email, String dataNascimento, String titulação,
			String areaEspecializacao) {
		super(cpf, nome, email, dataNascimento);
		this.titulacao = titulação;
		this.areaEspecializacao = areaEspecializacao;
	}

	@Override
	public String obterTipoPessoa() {
		return "Palestrante: "+titulacao;
	}

	public String getTitulação() {
		return titulacao;
	}

	public void setTitulacao(String titulacao) {
		if(titulacao == null || titulacao.trim().isEmpty() ) {
			throw new IllegalArgumentException("A titulação nao pode ser vazia");
		}
		this.titulacao = titulacao.trim();
	}

	public String getAreaEspecializacao() {
		return areaEspecializacao;
	}

	public void setAreaEspecializacao(String areaEspecializacao) {
		if(areaEspecializacao == null || areaEspecializacao.trim().isEmpty() ) {
			throw new IllegalArgumentException("A area de especializacao nao pode ser vazia");
		}
		this.areaEspecializacao = areaEspecializacao;
	}
	

}
