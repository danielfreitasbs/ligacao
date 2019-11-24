package br.com.ligacao.services;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

import br.com.ligacao.client.forms.FormulariosSolicitacao;
import br.com.ligacao.persistence.interfaces.IPromotorFisicoDAO;
import br.com.ligacao.persistence.model.Acao;
import br.com.ligacao.persistence.model.AcaoDAO;
import br.com.ligacao.persistence.model.PromotorFisico;
import br.com.ligacao.persistence.model.Voluntario;
import br.com.ligacao.persistence.model.VoluntarioDAO;

public class PromotorFisicoService {

	private static PromotorFisico promotorFisico = new PromotorFisico();
	private static Scanner scanner;

	public static void avaliarVoluntario() throws InterruptedException, ExecutionException {
		promotorFisico = login();

		if (promotorFisico == null) {
			System.out.println("\nUsuário não encontrado ou Usuario/Senha incorreto.\n");
			return;
		} else {
			List<Acao> listaAcoes = AcaoDAO.consultaTodasAcoes();

			for (int i = 0; i < listaAcoes.size(); i++) {
				System.out.println(i + " - " + listaAcoes.get(i) + "\n");
			}

			System.out.println("Infome o numero da ação que deseja avaliar o voluntario: \n");
			scanner = new Scanner(System.in);
			int option = scanner.nextInt();
			Acao acao = new Acao();

			for (int i = 0; i < listaAcoes.size(); i++) {
				if (option == i) {
					acao = listaAcoes.get(i);
				}
			}
			List<Voluntario> listVoluntarios = VoluntarioDAO.consultaVoluntarios(promotorFisico.getNomePessoa(), acao.getNomeAcao());

			for(int i = 0; i < listVoluntarios.size(); i++) {
				System.out.println(i + " - " + listVoluntarios.get(i) + "\n");
			}
			
			System.out.println("Infome o numero do voluntario que deseja avaliar: \n");
			scanner = new Scanner(System.in);
			option = scanner.nextInt();
			Voluntario voluntario = new Voluntario();
			
			for (int i = 0; i < listVoluntarios.size(); i++) {
				if (option == i) {
					voluntario = listVoluntarios.get(i);
				}
			}
			
			
			System.out.println("\n ---- Avaliação de Voluntário Finalizada ---- \n");
		}

	}

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
			IPromotorFisicoDAO.cadastraPromotor(promotorFisico);
		} else {
			scanner.close();
			System.exit(0);
		}
	}

	public static void editarPromotorFisico() {
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

	public static void excluirPromotor() {
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
				IPromotorFisicoDAO.excluirPromotor(promotorFisico);
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

	static PromotorFisico login() {
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

		return IPromotorFisicoDAO.login(user, password);
	}
}
