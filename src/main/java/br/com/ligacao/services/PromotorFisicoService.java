package br.com.ligacao.services;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

import br.com.ligacao.client.forms.FormulariosSolicitacao;
import br.com.ligacao.persistence.interfaces.IPromotorFisicoDAO;
import br.com.ligacao.persistence.model.Acao;
import br.com.ligacao.persistence.model.AcaoDAO;
import br.com.ligacao.persistence.model.PromotorDAO;
import br.com.ligacao.persistence.model.PromotorFisico;
import br.com.ligacao.persistence.model.Voluntario;
import br.com.ligacao.persistence.model.VoluntarioDAO;

/**
 * Classe responsável pela execução de regras de negócio do promotorFisico.
 * 
 * @author danielfreitasbs.
 *
 */
public class PromotorFisicoService {

	/**
	 * Instancia de promotor fisico.
	 */
	private static PromotorFisico promotorFisico = new PromotorFisico();

	/**
	 * Scanner para leitura de input do teclado.
	 */
	private static Scanner scanner;

	/**
	 * Metodo responsável pela coleta de dados para avaliação de voluntário.
	 * 
	 * @throws InterruptedException problemas em acoes com banco de dados.
	 * @throws ExecutionException   problemas em acoes com banco de dados.
	 */
	public static void avaliarVoluntario() throws InterruptedException, ExecutionException {
		promotorFisico = login();

		if (promotorFisico == null) {
			System.out.println("\nUsuário não encontrado ou Usuario/Senha incorreto.\n");
			return;
		} else {
			List<Acao> listaAcoes = AcaoDAO.consultaTodasAcoes();

			listaAcoes.removeIf(acao -> (acao.getNomePromotor() != promotorFisico.getNomePessoa()));

			if (listaAcoes.isEmpty() || listaAcoes == null) {
				System.out.println("\nNenhuma ação encontrada para este promotor");
				return;
			}

			for (int i = 0; i < listaAcoes.size(); i++) {
				System.out.println(i + " - " + listaAcoes.get(i) + "\n");
			}

			System.out.println("Infome o numero da ação que deseja avaliar o voluntario: \n");
			scanner = new Scanner(System.in);
			int option = scanner.nextInt();
			Acao acao = new Acao();
			boolean acaoEncontrada = false;
			for (int i = 0; i < listaAcoes.size(); i++) {
				if (option == i) {
					acao = listaAcoes.get(i);
					acaoEncontrada = true;
				}
			}

			if (!acaoEncontrada) {
				System.out.println("\nNao existe esta ação na listagem.");
				return;
			}

			List<Voluntario> listVoluntarios = VoluntarioDAO.consultaVoluntarios(promotorFisico.getNomePessoa(),
					acao.getNomeAcao());

			for (int i = 0; i < listVoluntarios.size(); i++) {
				System.out.println(i + " - " + listVoluntarios.get(i) + "\n");
			}

			System.out.println("Infome o numero do voluntario que deseja avaliar: \n");
			option = scanner.nextInt();
			Voluntario voluntario = new Voluntario();
			boolean voluntarioEncontrado = false;

			for (int i = 0; i < listVoluntarios.size(); i++) {
				if (option == i) {
					voluntario = listVoluntarios.get(i);
					voluntarioEncontrado = true;
				}
			}

			if (!voluntarioEncontrado) {
				System.out.println("Não existe este voluntario na listagem. \n");
				return;
			}

			System.out.println("Informe a nota de avaliação de 0 a 5: \n");
			int valuation = scanner.nextInt();

			if (valuation < 0 || valuation > 5) {
				System.out.println("Não foi possivel avaliar o voluntario com este valor.");
				return;
			}

			System.out.println(
					"Deseja confirmar a avaliação do voluntario: " + voluntario.getNome() + "?. \n0 - Sim\n1 - Não\n");
			option = scanner.nextInt();

			if (option == 0) {
//				IPromotorFisicoDAO.registrarAvaliacaoVoluntario(voluntario, valuation);
			} else {
				System.out.println("\nAvaliação de voluntario não registrada.\n");
			}

			System.out.println("\n ---- Avaliação de Voluntário Finalizada ---- \n");
		}

	}

	/**
	 * Metodo responsável pela execução de regras de negocio para cadastro de
	 * promotorFisico.
	 * 
	 * @throws IOException          problema na leitura de input do teclado.
	 * @throws InterruptedException problemas em acoes com banco de dados.
	 * @throws ExecutionException   problemas em acoes com banco de dados.
	 */
	public static void cadastroPromotorFisico() throws IOException, InterruptedException, ExecutionException {
		scanner = new Scanner(System.in);

		/**
		 * Realiza a solicitação dos dados para cadastro.
		 */

		promotorFisico = FormulariosSolicitacao.solCadPromotorFisico();

		StringBuilder sb = new StringBuilder();
		sb.append("\nPara confirmar o cadastro digite 0, para cancelar digite 1: \n");
		System.out.println(sb.toString());
		int opcao = scanner.nextInt();

		if (opcao == 1) {
			scanner.close();
			PromotorDAO.cadastraPromotorFisico(promotorFisico);
		} else {
			scanner.close();
			System.exit(0);
		}
	}

	/**
	 * Método responsável pela execução de regras para edicao de promotorFisico.
	 * 
	 * @throws ExecutionException   erro ao realizar ação no banco de dados.
	 * @throws InterruptedException erro ao realizar ação no banco de dados.
	 */
	public static void editarPromotorFisico() throws InterruptedException, ExecutionException {
		PromotorFisico promotorFisico = new PromotorFisico();
		promotorFisico = login();

		if (promotorFisico == null) {
			System.out.println("\nUsuário não encontrado ou Usuario/Senha incorreto.\n");
			return;
		} else {
			promotorFisico = FormulariosSolicitacao.formDadosAlteracao(promotorFisico);
			System.out.println("\n ---- Alteração de Cadastro Finalizada ---- \n");
		}

	}

	/**
	 * Responsável pela execução de regras da exclusão de promotor
	 * 
	 * @throws ExecutionException   erro ao realizar ação no banco de dados.
	 * @throws InterruptedException erro ao realizar ação no banco de dados.
	 */
	public static void excluirPromotor() throws InterruptedException, ExecutionException {
		PromotorFisico promotorFisico = new PromotorFisico();
		promotorFisico = login();

		if (promotorFisico == null) {
			System.out.println("\nUsuário não encontrado ou Usuario/Senha incorreto.\n");
			return;
		} else {
			StringBuilder sb = new StringBuilder();
			sb.append("Tem certeza que deseja excluir o perfil de " + promotorFisico.getNomePessoa()
					+ " junto de todos seus dados?\n")
					.append("\nPara confirmar a ação digite 0, para cancelar digite 1: \n");
			System.out.println(sb.toString());
			int option = scanner.nextInt();

			switch (option) {
			case 0:
				PromotorDAO.excluiPromotor(promotorFisico.getNomePessoa());
				System.out.println("\nExclusão de perfil do Promotor Fisico " + promotorFisico.getNomePessoa()
						+ " executada com sucesso.");
				return;
			case 1:
				System.out.println(
						"\nExclusão de perfil do Promotor Fisico " + promotorFisico.getNomePessoa() + " cancelada.");
				return;
			default:
				System.out.println("ERRO");
				break;
			}

		}
	}

	/**
	 * Metodo responsável pela execução de login de promotor Fisico.
	 * 
	 * @throws ExecutionException   erro ao realizar ação no banco de dados.
	 * @throws InterruptedException erro ao realizar ação no banco de dados.
	 * @return instancia de promotor fisico.
	 */
	static PromotorFisico login() throws InterruptedException, ExecutionException {
		StringBuilder sb = new StringBuilder();
		scanner = new Scanner(System.in);

		sb.append("\n ---- Acesso ao Sistema ---- \n");
		sb.append("Informe o nome de usuário: \n");
		System.out.println(sb.toString());

		String user = scanner.nextLine();

		sb = new StringBuilder();
		sb.append("\n ---- Acesso ao Sistema ---- \n");
		sb.append("Informe a senha: \n");
		System.out.println(sb.toString());

		String password = scanner.nextLine();

		return PromotorDAO.loginPromotorFisico(user, password);
	}
}
