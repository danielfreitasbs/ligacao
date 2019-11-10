package br.com.ligacao.client.apps;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

import br.com.ligacao.client.forms.FormulariosSolicitacao;
import br.com.ligacao.persistence.interfaces.PromotorJuridicoDAO;
import br.com.ligacao.persistence.model.Login;
import br.com.ligacao.persistence.model.PromotorFisico;
import br.com.ligacao.persistence.model.PromotorJuridico;

public class PromotorApp {

	static int PROMOTOR_FISICO = 0;
	static int PROMOTOR_JURIDICO = 1;

	private static PromotorFisico promotorFisico = new PromotorFisico();
	private static PromotorJuridico promotorJuridico = new PromotorJuridico();

	private static Scanner scanner = new Scanner(System.in);
	private static StringBuilder sb = new StringBuilder();

	public static void simuladorInterface() throws IOException, InterruptedException, ExecutionException {
		sb = new StringBuilder();
		sb.append("Qual ação deseja executar?\n").append("0 - Cadastrar Promotor\n")
				.append("1 - Editar Perfil de Promotor\n");
		System.out.println(sb.toString());
		int opcao = scanner.nextInt();

		switch (opcao) {
		case 0:
			selecionaTipoPromotor();
			break;
		case 1:
			selecionaTipoPromotorEditar();
//			editarPerfil();
			break;
		default:
			break;
		}
	}

	private static void selecionaTipoPromotorEditar() throws IOException, InterruptedException, ExecutionException {
		sb = new StringBuilder();
		sb.append("\n---- Formulário de Cadastro de Promotor ----\n");
		sb.append("Selecione o tipo de pessoa: \n");
		sb.append("0 - Pessoa Física \n1 - Pessoa Juridica");
		System.out.println(sb.toString());
		int option = scanner.nextInt();

		switch (option) {
		case 0:
			editarPromotorFisico();
			break;
		case 1:
			editarPromotorJuridico();
			break;

		default:
			break;
		}
	}

	static void editarPromotorFisico() {
		sb = new StringBuilder();
		sb.append("\n ---- Acesso ao Sistema ---- \n");
		sb.append("Informe o nome de usuário: \n");
		System.out.println(sb.toString());

		String user = scanner.nextLine();

		sb = new StringBuilder();
		sb.append("\n ---- Acesso ao Sistema ---- \n");
		sb.append("Informe a senha: \n");
		System.out.println(sb.toString());

		String password = scanner.nextLine();

		promotorFisico = new PromotorFisico();
//		promotorFisico = PromotorFisicoDAO.fazerLogin(user, password);

		if (promotorFisico == null) {
			sb = new StringBuilder();
			sb.append("\nUsuário não encontrado ou Usuario/Senha incorreto.\n");
			return;
		} else {
			promotorFisico = FormulariosSolicitacao.formDadosAlteracao(promotorFisico);
			System.out.println("\n ---- Alteração de Cadastro Finalizada ---- \n");
		}

	}

	static void editarPromotorJuridico() {
		sb = new StringBuilder();
		sb.append("\n ---- Acesso ao Sistema ---- \n");
		sb.append("Informe o nome de usuário: \n");
		System.out.println(sb.toString());

		String user = scanner.nextLine();

		sb = new StringBuilder();
		sb.append("\n ---- Acesso ao Sistema ---- \n");
		sb.append("Informe a senha: \n");
		System.out.println(sb.toString());

		String password = scanner.nextLine();

		promotorJuridico = PromotorJuridicoDAO.login(user, password);

		if (promotorJuridico == null) {
			sb = new StringBuilder();
			sb.append("\nUsuário não encontrado ou Usuario/Senha incorreto.\n");
			return;
		} else {
			promotorJuridico = FormulariosSolicitacao.formDadosAlteracaoPJ(promotorJuridico);
			System.out.println("\n ---- Alteração de Cadastro Finalizada ---- \n");
		}
	}

	private static void selecionaTipoPromotor() throws IOException, InterruptedException, ExecutionException {
		sb = new StringBuilder();
		sb.append("\n---- Formulário de Cadastro de Promotor ----\n");
		sb.append("Selecione o tipo de pessoa: \n");
		sb.append("0 - Pessoa Física \n1 - Pessoa Juridica");
		int option = scanner.nextInt();

		switch (option) {
		case 0:
			cadastroPromotorFisico();
			break;
		case 1:
			cadastroPromotorJuridico();
			break;

		default:
			break;
		}
	}

	public static void cadastroPromotorJuridico() {

		/**
		 * Realiza a solicitação dos dados para cadastro.
		 */
		promotorFisico = FormulariosSolicitacao.solCadPromotorFisico();

		sb = new StringBuilder();
		sb.append("\nPara confirmar o cadastro digite 0, para cancelar digite 1: \n");
		System.out.println(sb.toString());
		int opcao = scanner.nextInt();

		if (opcao == 1) {
			scanner.close();
			// PromotorDAO.cadastraPromotor(promotorFisico);
		} else {
			scanner.close();
			System.exit(0);
		}
	}

	public static void cadastroPromotorFisico() throws IOException, InterruptedException, ExecutionException {

		/**
		 * Realiza a solicitação dos dados para cadastro.
		 */

		promotorFisico = FormulariosSolicitacao.solCadPromotorFisico();

		sb = new StringBuilder();
		sb.append("\nPara confirmar o cadastro digite 0, para cancelar digite 1: \n");
		System.out.println(sb.toString());
		int opcao = scanner.nextInt();

		if (opcao == 1) {
			scanner.close();
			// PromotorDAO.cadastraPromotor(promotorFisico);
		} else {
			scanner.close();
			System.exit(0);
		}
	}

//	public static void editarPerfil() throws InterruptedException, ExecutionException, IOException {
//
//		/**
//		 * Limpa a instancia de promotor.
//		 */
//		promotorFisico = new Promotor();
//
//		/**
//		 * Solicitação de Dados para busca do promotor.
//		 */
//		sb.append("Confirme seu nome: ");
//		System.out.println(sb.toString());
//
//		String entrada = scanner.nextLine();
//
//		promotorFisico = PromotorDAO.consultaPromotor("Joãozinho do Trenó");
//
//		/**
//		 * Exibindo os dados na tela para confirmação.
//		 */
//		sb = new StringBuilder();
//		sb.append("----- Dados do Promotor ----- \n").append("Nome do Promotor: ").append(promotorFisico.getNomePromotor())
//				.append("\nCategoria Ação: ").append(promotorFisico.getCategoriaAcao()).append("\nCPF do Responsavel: ")
//				.append(promotorFisico.getCpfResponsavel()).append("\nData de Fundacao: ").append(promotorFisico.getDataFundacao())
//				.append("\nDescricao: ").append(promotorFisico.getDescricao()).append("\nEmail: ").append(promotorFisico.getEmail())
//				.append("Rede Social: ").append(promotorFisico.getRedeSocial()).append("\nTelefone: ")
//				.append(promotorFisico.getTelefone()).append("\n\n\n");
//
//		System.out.println(sb.toString());
//
//		System.out.println("Digite um novo CPF: \n");
//		String cpf = scanner.nextLine();
//
//		/**
//		 * Simulando alteração de dados com form automatico para fins de teste.
//		 */
//		sb = new StringBuilder();
//		promotorFisico = FormulariosSolicitacao.preencherFormAlterado(cpf);
//		System.out.println("---- Confirmar alteração de Dados do Promotor ----\n");
//		sb.append("Nome do Promotor: ").append(promotorFisico.getNomePromotor()).append("\nCategoria Ação: ")
//				.append(promotorFisico.getCategoriaAcao()).append("\nCPF do Responsavel: ")
//				.append(promotorFisico.getCpfResponsavel()).append("\nData de Fundacao: ").append(promotorFisico.getDataFundacao())
//				.append("\nDescricao: ").append(promotorFisico.getDescricao()).append("\nEmail: ").append(promotorFisico.getEmail())
//				.append("Rede Social: ").append(promotorFisico.getRedeSocial()).append("\nTelefone: ")
//				.append(promotorFisico.getTelefone())
//				.append("\n0 - para confirmar a alteração\n 1 - para cancelar a alteração:\n");
//
//		System.out.println(sb.toString());
//
//		int opcao = scanner.nextInt();
//
//		if (opcao == 0) {
//			PromotorDAO.cadastraPromotor(promotorFisico, login);
//			System.out.println("Dados alterados com sucesso.");
//			scanner.close();
//			System.exit(0);
//		} else {
//			scanner.close();
//			System.exit(0);
//		}
//	}

}
