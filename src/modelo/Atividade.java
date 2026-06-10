package modelo;

import java.util.HashSet;
import java.util.Set;

public abstract class Atividade {

    // Atributos

    private String codigo;
    private String titulo;
    private int cargaHoraria;
    private int capacidadeMaxima;
    private Palestrante palestrante;
    private Set<Participante> participantesInscritos;

    // Construtor

    public Atividade(String codigo, String titulo, int cargaHoraria, int capacidadeMaxima, Palestrante palestrante){
        this.setCodigo(codigo);
        this.setTitulo(titulo);
        this.setCargaHoraria(cargaHoraria);
        this.setCapacidadeMaxima(capacidadeMaxima);
        this.setPalestrante(palestrante);
        this.participantesInscritos = new HashSet<>();
    }

    //Métodos Abstratos

    public abstract double calcularCusto();

    public abstract String obterTipoAtividade();

    public boolean inscreverParticipante(Participante participante) {
        if (participantesInscritos.size() >= capacidadeMaxima) {
            return false;
        }
        return participantesInscritos.add(participante);
    }

    // Getters

    public int obterVagasDisponiveis() {
        return capacidadeMaxima - participantesInscritos.size();
    }

    public double obterTaxaOcupacao() {
        return (
            ((double) participantesInscritos.size() / capacidadeMaxima) * 100
        );
    }

    public String getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public int getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

    public Palestrante getPalestrante() {
        return palestrante;
    }

    public int getNumeroParticipantesInscritos() {
        return participantesInscritos.size();
    }

    public Set<Participante> getParticipantesInscritos() {
        return new HashSet<>(participantesInscritos);
    }

    // Setters

	public void setCodigo(String codigo) {
		if (codigo == null || codigo.trim().isEmpty()) {
                throw new IllegalArgumentException("Código não pode ser nulo");
            }
        this.codigo = codigo.trim();
	}

	public void setTitulo(String titulo) {
		if(titulo == null || titulo.trim().isEmpty()) {
			throw new IllegalArgumentException("O tituli nao pode ser vazio");
		}
		this.titulo=titulo;
	}

	public void setCargaHoraria(int cargaHoraria) {
        if (cargaHoraria <= 0) {
                throw new IllegalArgumentException("Carga horária deve ser maior que zero");
            }
		this.cargaHoraria = cargaHoraria;
	}

	public void setCapacidadeMaxima(int capacidadeMaxima) {
        if (capacidadeMaxima <= 0) {
                throw new IllegalArgumentException("Capacidade máxima deve ser maior que zero");
            }
		this.capacidadeMaxima = capacidadeMaxima;
	}

	public void setPalestrante(Palestrante palestrante) {
        if (palestrante == null) {
            throw new IllegalArgumentException("Palestrante não pode ser nulo");
        }
        this.palestrante = palestrante;
    }

	public void setParticipantesInscritos(Set<Participante> participantesInscritos) {
		this.participantesInscritos = participantesInscritos;
	}

}
