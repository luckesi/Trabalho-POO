package modelo;

public class Minicurso extends Atividade {
	private double custoMaterial;
	private double[] avaliacoes;
	private int numAvaliacoes;
	private static final int TAMANHO_MAXIMO = 5;
	public Minicurso(String codigo, String titulo, int cargaHoraria, int capacidadeMaxima, Palestrante palestrante,
			double custoMaterial) {
		super(codigo, titulo, cargaHoraria, capacidadeMaxima, palestrante);
		if(custoMaterial <0) {
			throw new IllegalArgumentException("Custo nao pode ser menor que zero");
		}
		this.custoMaterial = custoMaterial;
		this.avaliacoes = new double[TAMANHO_MAXIMO];
		this.numAvaliacoes = 0;
	}
	@Override
	public double calcularCusto() {
		
		return custoMaterial;
	}
	@Override
	public String obterTipoAtividade() {
		return "Minicurso";
	}
	public boolean adicionarAvaliacao(double nota) {
		if (nota < 0 || nota > 10) {
			throw new IllegalArgumentException("Nota deve estar entre 0 e 10");
			}
			if (numAvaliacoes < TAMANHO_MAXIMO) {
			avaliacoes[numAvaliacoes] = nota;
			numAvaliacoes++;
			return true;
			}
			return false;
	}
	public double calcularMediaAvaliacoes() {
		if (numAvaliacoes == 0) return 0;
		double soma = 0;
		for (int i = 0; i < numAvaliacoes; i++) {
		soma += avaliacoes[i];
		}
		return soma / numAvaliacoes;
		}
	
	
}
