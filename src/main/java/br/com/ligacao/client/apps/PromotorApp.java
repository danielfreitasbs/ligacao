package br.com.ligacao.client.apps;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

import br.com.ligacao.services.PromotorFisicoService;
import br.com.ligacao.services.PromotorJuridicoService;

/**
 * Classe responsável pela simulação interface de apicação para interação com
 * Promotores de Ações.
 * 
 * @author danielfreitasbs
 *
 */
public class PromotorApp {

	/**
	 * Variavel que representa o cabeçalho do formulário de cadastro de promotor.
	 */
	static String CABECALHO_FORM_CAD = "\n---- Formulário de Cadastro de Promotor ----\n";

	/**
	 * Variavel que representa o cabeçalho do formulário de edição de promotor.
	 */
	static String CABECALHO_FORM_EDIT = "\n---- Formulário de Cadastro de Promotor ----\n";

	/**
	 * Variavel que representa o cabeçalho do formulário de exclusão de promotor.
	 */
	static String CABECALHO_FORM_DEL = "\n---- Formulário de Exclusao de Promotor ----\n";

	/**
	 * Variavel que representa o cabeçalho do formulário de avaliar voluntario.
	 */
	static String CABECALHO_AVALIAR_VOLUNT = "\n---- Avaliar Voluntário ----\n";

	/**
	 * Scanner para entrada de dados pelo usuário.
	 */
	private static Scanner scanner = new Scanner(System.in);

	/**
	 * Variavel para construção de strings de exibição de mensagens do sistema.
	 */
	private static StringBuilder sb = new StringBuilder();

	/**
	 * Metodo responsável pela representação conceitual da interface de interação
	 * com o usuário.
	 * 
	 * @throws IOException          caso não seja possivel ler do teclado.
	 * @throws InterruptedException caso ocorra erro na busca de dados do banco de
	 *                              dados.
	 * @throws ExecutionException   caso ocorra erro na busca de dados do banco de
	 *                              dados.
	 */
	public static void simuladorInterface() throws IOException, InterruptedException, ExecutionException {
		sb = new StringBuilder();
		sb.append("Qual ação deseja executar?\n").append("0 - Cadastrar Promotor\n")
				.append("1 - Editar Perfil de Promotor\n").append("2 - Excluir Perfil de Promotor\n")
				.append("3 - Avaliar Voluntário\n");
		System.out.println(sb.toString());
		int opcao = scanner.nextInt();

		switch (opcao) {
		case 0:
			promotorCadastro();
			break;
		case 1:
			promotorEditar();
			break;
		case 2:
			promotorExcluir();
			break;
		case 3:
			avaliarVoluntario();
		default:
			break;
		}
	}

	/**
	 * Metodo responsável pela chamada de metodos para avaliação de voluntarios.
	 * 
	 * @throws ExecutionException caso ocorra problemas na consulta do banco de dados. 
	 * @throws InterruptedException caso ocorra problemas na consulta do banco de dados. 
	 */
	private static void avaliarVoluntario() throws InterruptedException, ExecutionException {
		int option = selecionaTipoPromotor(CABECALHO_AVALIAR_VOLUNT);

		switch (option) {
		case 0:
			PromotorFisicoService.avaliarVoluntario();
			break;
		case 1:
//			PromotorJuridicoService.avaliarVoluntario();
			break;
		default:
			break;
		}
	}

	/**
	 * Metodo responsável pela chamada de metodos para exclusao de promotor.
	 */
	private static void promotorExcluir() {
		int option = selecionaTipoPromotor(CABECALHO_FORM_DEL);

		switch (option) {
		case 0:
			PromotorFisicoService.excluirPromotor();
			break;
		case 1:
			PromotorJuridicoService.excluirPromotor();
			break;
		default:
			break;
		}
	}

	/**
	 * Metodo responsável pela chamada de metodos para edicao de perfil de promotor.
	 */
	private static void promotorEditar() throws IOException, InterruptedException, ExecutionException {
		int option = selecionaTipoPromotor(CABECALHO_FORM_EDIT);

		switch (option) {
		case 0:
			PromotorFisicoService.editarPromotorFisico();
			break;
		case 1:
			PromotorJuridicoService.editarPromotorJuridico();
			break;

		default:
			break;
		}
	}

	/**
	 * Responsável pela chamada de metodos para cadastro de promotores.
	 * 
	 * @throws IOException          caso ocorra erro na leitura de input do teclado.
	 * @throws InterruptedException erro ao efetuar acao com banco de dados.
	 * @throws ExecutionException   erro ao efetuar acao com banco de dados.
	 */
	private static void promotorCadastro() throws IOException, InterruptedException, ExecutionException {
		int option = selecionaTipoPromotor(CABECALHO_FORM_CAD);

		switch (option) {
		case 0:
			PromotorFisicoService.cadastroPromotorFisico();
			break;
		case 1:
			PromotorJuridicoService.cadastroPromotorJuridico();
			break;

		default:
			break;
		}
	}

	/**
	 * Responsável pela seleção do tipo de pessoa do perfil de promotor.
	 * 
	 * @param cabecalho referente ao nome do formulário que será usada a ação.
	 * @return 0 representando pessoa física, e 1 representando pessoa juridica.
	 */
	static int selecionaTipoPromotor(String cabecalho) {
		sb = new StringBuilder();
		sb.append(cabecalho);
		sb.append("Selecione o tipo de pessoa: \n");
		sb.append("0 - Pessoa Física \n1 - Pessoa Juridica");

		int option = scanner.nextInt();
		return option;
	}

}
