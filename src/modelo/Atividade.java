package modelo;

import java.util.HashSet;
import java.util.Objects;
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

    public Atividade(
        String codigo,
        String titulo,
        int cargaHoraria,
        int capacidadeMaxima,
        Palestrante palestrante
    ) {
        if (codigo == null || codigo.trim().isEmpty()) {
            throw new IllegalArgumentException("Código não pode ser nulo");
        }
        if (cargaHoraria <= 0) {
            throw new IllegalArgumentException(
                "Carga horária deve ser maior que zero"
            );
        }
        if (capacidadeMaxima <= 0) {
            throw new IllegalArgumentException(
                "Capacidade máxima deve ser maior que zero"
            );
        }

        this.codigo = codigo.trim();
        this.titulo = titulo.trim();
        this.cargaHoraria = cargaHoraria;
        this.capacidadeMaxima = capacidadeMaxima;
        this.palestrante = palestrante;
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

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void setTitulo(String titulo) {
		if(titulo == null || titulo.trim().isEmpty()) {
			throw new IllegalArgumentException("O tituli nao pode ser vazio");
		}
		this.titulo=titulo;
	}

	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public void setCapacidadeMaxima(int capacidadeMaxima) {
		this.capacidadeMaxima = capacidadeMaxima;
	}

	public void setPalestrante(Palestrante palestrante) {
		this.palestrante = palestrante;
	}

	public void setParticipantesInscritos(Set<Participante> participantesInscritos) {
		this.participantesInscritos = participantesInscritos;
	}
    
}
