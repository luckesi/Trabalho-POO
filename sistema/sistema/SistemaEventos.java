package sistema;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import modelo.*;

public class SistemaEventos{
	private String nomeEvento;
	private Map<String, Participante> participantesPorMatricula;
	private Map<String, Palestrante> palestrantesPorCpf;
	private List<Atividade> atividades;
	private String[] diasFuncionamento;
	public SistemaEventos(String nomeEvento) {
	this.nomeEvento = nomeEvento;
	this.participantesPorMatricula = new HashMap<>();
	this.palestrantesPorCpf = new HashMap<>();
	this.atividades = new ArrayList<>();
	this.diasFuncionamento = new String[7];
	inicializarDias();
	}
	private void inicializarDias() {
	diasFuncionamento[0] = "Segunda-feira";
	diasFuncionamento[1] = "Terça-feira";
	diasFuncionamento[2] = "Quarta-feira";
	diasFuncionamento[3] = "Quinta-feira";
	diasFuncionamento[4] = "Sexta-feira";
	diasFuncionamento[5] = "Sabado";
	diasFuncionamento[6] = "Domingo";
	
	}
	public boolean cadastrarParticipante(Participante participante) {
		if(participantesPorMatricula.containsKey(participante.getMatricula())) {
			return false;
		}else {
			participantesPorMatricula.put(participante.getMatricula(), participante);
			return true;
		}
		
	}
	
	public boolean cadastrarPalestrante(Palestrante palestrante) {
		if(palestrantesPorCpf.containsKey(palestrante.getCpf())) {
			return false;
		}else {
			palestrantesPorCpf.put(palestrante.getCpf(), palestrante);
			return true;
		}
		
	}
	
	public Participante buscarParticipantePorMatricula(String matricula) {
		return participantesPorMatricula.get(matricula);
	}
	
	public Palestrante buscarPalestrantePorCpf(String cpf) {
		return palestrantesPorCpf.get(cpf);
	}
	
	public boolean inscreverParticipanteEmAtividade(String matricula, String codigoAtividade) {
		Participante participante = buscarParticipantePorMatricula(matricula);
		if(participante == null) {
			System.out.println("Participante nao encontrado");
			return false;
		}
		Atividade atividadeDesejada = null;
		for (Atividade atividade : atividades) {
			if(atividade.getCodigo().equals(codigoAtividade)) {
				atividadeDesejada = atividade;
			}
		}
		if(atividadeDesejada == null) {
			System.out.println("ATIVIDADE "+codigoAtividade+" Nao encontrada");
			return false;
		}
		boolean sucessoInscricao = atividadeDesejada.inscreverParticipante(participante);
		if(sucessoInscricao) {
			participante.adicionarAtividadeFrequentada(atividadeDesejada);
			System.out.println("Inscricao do participante "+participante.getNome()+" na Atividade "+atividadeDesejada.getTitulo()+" realizada com sucesso");
			return true;
		}
		return sucessoInscricao;
		
	}
	
	public boolean cadastrarAtividade(Atividade atividade) {
	for (Atividade a : atividades) {
	if (a.getCodigo().equals(atividade.getCodigo())) {
	return false;
	}
	}
	atividades.add(atividade);
	return true;
	}
	public double calcularFaturamentoTotal() {
		
	}
}