package modelo;

import java.util.ArrayList;

public class Participante extends Pessoa{

	//ENUM

	public enum Tipo{
		DOCENTE, PROFISSIONAL, ESTUDANTE;
	}

	// Atributos

	private String matricula;
	private Tipo tipo;
	private ArrayList<Atividade> atividadesFrequentadas;

	//Construtor

	public Participante(String cpf, String nome, String email, String dataNascimento, String matricula,
			Participante.Tipo tipo) {
		super(cpf, nome, email, dataNascimento);
		this.setMatricula(matricula);
		this.setTipo(tipo);
		this.atividadesFrequentadas= new ArrayList<Atividade>();
	}
	
	// Métodos 

	@Override
	public String obterTipoPessoa() {
		return "Participante ("+tipo+")";
	}

	public boolean adicionarAtividadeFrequentada(Atividade atividade) {
		if(!atividadesFrequentadas.contains(atividade)) {
			atividadesFrequentadas.add(atividade);
			return true;
		}
		return false;
	}

	public int calcularTotalDeHoras() {
		int total=0;
		for(Atividade ativ: atividadesFrequentadas) {
			total+=ativ.getCargaHoraria();
			
		}
		return total;
	}

	public double calcularCustoTotal() {
		double total=0;
		for (Atividade atividade : atividadesFrequentadas) {
			total+=atividade.calcularCusto();
			
		}
		return total;
	}

	// Getters
	public String getMatricula() {
		return matricula;
	}

	public Tipo getTipo() {
		return tipo;
	}

	// Setters

	public void setMatricula(String matricula) {
		if(matricula == null || matricula.trim().isEmpty()) {
			throw new IllegalArgumentException("Matricula nao pode ser vazia");
		}
		this.matricula = matricula;
	}

	public void setTipo(Tipo tipo) {
		if(tipo == null) {
			throw new IllegalArgumentException("O tipo nao pode ser vazio");
		}
		this.tipo = tipo;
	}
	
}
 