package modelo;

public class MesaRedonda extends Atividade{
	private String tema;
	private Pessoa moderador;
	public MesaRedonda(String codigo, String titulo, int cargaHoraria, int capacidadeMaxima, Palestrante palestrante,
			String tema, Pessoa moderador) {
		super(codigo, titulo, cargaHoraria, capacidadeMaxima, palestrante);
		this.tema = tema;
		this.moderador = moderador;
	}
	@Override
	public double calcularCusto() {
		return 25;
	}
	@Override
	public String obterTipoAtividade() {
		return "Mesa Redonda";
	}
	
	
	
	
	
	
	
}