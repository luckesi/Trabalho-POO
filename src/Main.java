import modelo.*;
import modelo.Participante.Tipo;
import sistema.SistemaEventos;

public class Main {

	public static void main(String[] args) {
		SistemaEventos sistema = new SistemaEventos("Evento Teste");
		System.out.println("=================================================");
		System.out.println("   SGEAC - SISTEMA DE GESTÃO DE EVENTOS          ");
		System.out.println("=================================================");
		System.out.println("Evento iniciado");

		try {
			// 1. INICIALIZAÇÃO DOS OBJETOS BASE (Usando String para as datas)
			Palestrante pal = new Palestrante("11122233344", "Sergio Roberto", "sergioro@email.com", "01011990", "Mestre", "Tecnologia da Informação");
			Participante partPro = new Participante("22233344455", "Michele Arruda", "michelearr@email.com", "12112001", "1507", Tipo.PROFISSIONAL);
			Participante partEst = new Participante("33344455566", "Maria Joaquina", "joaquina@email.com", "15032002", "1407", Tipo.ESTUDANTE);
			Participante partDoc = new Participante("44455566677", "Lucas Reis", "lucasreis@email.com", "07032003", "1001", Tipo.DOCENTE);
			
			// Palestra configurada propositalmente com apenas 2 vagas para testar o limite de lotação mais abaixo
			MesaRedonda mesa = new MesaRedonda("111", "Discussao Cientifica", 4, 10, pal, "Assuntos academicos", partPro);			
			Palestra pale = new Palestra("222", "Obtenha resultados com codigo limpo", 4, 2, pal); 
			Minicurso mini = new Minicurso("333", "Desenvolvimento de Sites", 35, 5, pal, 350);
			
			System.out.println("✅ Objetos base inicializados com sucesso");

			// 2. CADASTRO NO SISTEMA
			sistema.cadastrarAtividade(mini);
			sistema.cadastrarAtividade(pale);
			sistema.cadastrarAtividade(mesa);
			
			sistema.cadastrarPalestrante(pal);
			sistema.cadastrarParticipante(partDoc);
			sistema.cadastrarParticipante(partEst);
			sistema.cadastrarParticipante(partPro);
			System.out.println("✅ Entidades cadastradas no SistemaEventos");

			// 3. TESTE DE VALIDAÇÃO: NOTA INVÁLIDA (VETOR E TRY-CATCH)
			System.out.println("\n--- Testando validação: Nota inválida ---");
			try {
				mini.adicionarAvaliacao(11);
				System.out.println("❌ Controle: essa linha não deve rodar!");
			} catch(IllegalArgumentException e) {
				System.out.println("✅ Validação feita com sucesso (Capturado): " + e.getMessage());
			}
			
			// Inserindo notas válidas para o relatório posterior
			mini.adicionarAvaliacao(9.5);
			mini.adicionarAvaliacao(8.0);

			// 4. TESTE DO FLUXO DE INSCRIÇÕES E REGRAS DE NEGÓCIO
			System.out.println("\n--- Testando Mecanismo de Inscrições ---");
			
			// Inscrições através do método centralizado do sistema (o que atualiza o histórico do aluno)
			sistema.inscreverParticipanteEmAtividade("1001", "333"); // Lucas no Minicurso
			sistema.inscreverParticipanteEmAtividade("1407", "333"); // Maria no Minicurso
			
			// Testando limite de vagas (Palestra configurada com máximo de 2 vagas)
			System.out.println("\n-> Testando limite de vagas na Palestra:");
			sistema.inscreverParticipanteEmAtividade("1507", "222"); // Michele na Palestra (Vaga 1)
			sistema.inscreverParticipanteEmAtividade("1407", "222"); // Maria na Palestra (Vaga 2 - Lotou)
			
			// Esta inscrição deve falhar por falta de vagas
			boolean lotou = sistema.inscreverParticipanteEmAtividade("1001", "222"); // Lucas tenta entrar
			System.out.println(lotou ? "❌ Erro: Permitindo inscrição além da capacidade!" 
					                 : "✅ Sucesso: O sistema barrou a inscrição por falta de vagas.");

			// Testando inscrição duplicada (Garantia do Set)
			System.out.println("\n-> Testando duplicidade de inscrição (mesmo participante):");
			boolean duplicado = sistema.inscreverParticipanteEmAtividade("1407", "333"); // Maria tenta se reinscrever no minicurso
			System.out.println(duplicado ? "❌ Erro: Permitindo inscrição duplicada!" 
					                     : "✅ Sucesso: O sistema barrou a inscrição duplicada através do Set.");

			// 5. PROCESSAMENTO POLIMÓRFICO E RELATÓRIOS
			System.out.println("\n=================================================");
			System.out.println("            RELATÓRIOS ESTATÍSTICOS              ");
			System.out.println("=================================================");

			// Cálculo Polimórfico de Faturamento
			// Conta esperada: Palestra (2 inscritos * 0) + Minicurso (2 inscritos * 350) = R$ 700.00
			System.out.printf("Faturamento Total do Evento: R$ %.2f\n", sistema.calcularFaturamentoTotal());
			System.out.println("-------------------------------------------------");

			// Média das avaliações do Minicurso (Vetor)
			System.out.printf("Média de avaliações do Minicurso '%s': %.2f\n", 
					mini.getTitulo(), mini.calcularMediaAvaliacoes());
			System.out.println("-------------------------------------------------");

			// Demonstração das Taxas de Ocupação calculadas dinamicamente
			System.out.println("Taxa de Ocupação por Atividade:");
			System.out.printf("- %s: Ocupação %.1f%% (Vagas restantes: %d)\n", 
					pale.getTitulo(), pale.obterTaxaOcupacao(), pale.obterVagasDisponiveis());
			System.out.printf("- %s: Ocupação %.1f%% (Vagas restantes: %d)\n", 
					mini.getTitulo(), mini.obterTaxaOcupacao(), mini.obterVagasDisponiveis());
			System.out.printf("- %s: Ocupação %.1f%% (Vagas restantes: %d)\n", 
					mesa.getTitulo(), mesa.obterTaxaOcupacao(), mesa.obterVagasDisponiveis());
			System.out.println("-------------------------------------------------");

			// Teste do método concreto da classe abstrata Pessoa (Cálculo de idade com base no ano)
			System.out.println("Cálculo de Idade (Método de Pessoa):");
			System.out.printf("- %s tem %d anos.\n", partPro.getNome(), partPro.calcularIdade());
			System.out.printf("- %s tem %d anos.\n", pal.getNome(), pal.calcularIdade());
			System.out.println("=================================================");
			
		} catch (IllegalArgumentException e) {
			System.out.println("❌ Erro fatal na inicialização: " + e.getMessage());
		}
	}
}