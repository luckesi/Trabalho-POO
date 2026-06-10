package modelo;

public class MesaRedonda extends Atividade{

	// Atributos

	private String tema;
	private Pessoa moderador;

	// Construtor

	public MesaRedonda(String codigo, String titulo, int cargaHoraria, int capacidadeMaxima, Palestrante palestrante, String tema, Pessoa moderador) {
		super(codigo, titulo, cargaHoraria, capacidadeMaxima, palestrante);
		this.setTema(tema);
		this.setModerador(moderador);
	}

	@Override
	public double calcularCusto() {
		return 25;
	}
	@Override
	public String obterTipoAtividade() {
		return "Mesa Redonda";
	}

	// Getters
	
	public String getTema(){
		return tema;
	}

	public Pessoa getModerador(){
		return moderador;
	}

	// Setters

	public void setTema(String tema){
		if (tema == null || tema.trim().isEmpty()){
			throw new IllegalArgumentException("Tema não pode ser nulo.");
		}
		this.tema = tema.trim();
	}

	public void setModerador(Pessoa moderador){
		if (moderador == null){
			throw new IllegalArgumentException("Moderador inválido");
		}
		this.moderador = moderador;
	}

}