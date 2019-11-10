package br.com.ligacao.services;

import java.util.Scanner;

import br.com.ligacao.client.forms.FormulariosSolicitacao;
import br.com.ligacao.persistence.interfaces.IPromotorFisicoDAO;
import br.com.ligacao.persistence.interfaces.IPromotorJuridicoDAO;
import br.com.ligacao.persistence.model.PromotorJuridico;
import br.com.ligacao.persistence.model.PromotorJuridico;

public class PromotorJuridicoService {

	private static Scanner scanner;

	public static void editarPromotorJuridico() {
		PromotorJuridico promotorJuridico = new PromotorJuridico();
		promotorJuridico = login();

		if (promotorJuridico == null) {
			StringBuilder sb = new StringBuilder();
			sb.append("\nUsuário não encontrado ou Usuario/Senha incorreto.\n");
			System.out.println(sb.toString());
			return;
		} else {
			promotorJuridico = FormulariosSolicitacao.formDadosAlteracaoPJ(promotorJuridico);
			System.out.println("\n ---- Alteração de Cadastro Finalizada ---- \n");
		}
	}

	public static void cadastroPromotorJuridico() {

		StringBuilder sb = new StringBuilder();
		Scanner scanner = new Scanner(System.in);
		PromotorJuridico promotorJuridico = new PromotorJuridico();

		/**
		 * Realiza a solicitação dos dados para cadastro.
		 */
		promotorJuridico = FormulariosSolicitacao.solCadPromotorJuridico();

		sb = new StringBuilder();
		sb.append("\nPara confirmar o cadastro digite 0, para cancelar digite 1: \n");
		System.out.println(sb.toString());
		int opcao = scanner.nextInt();

		if (opcao == 0) {
			scanner.close();
			IPromotorJuridicoDAO.cadastrarPromotor(promotorJuridico);
		} else {
			scanner.close();
			System.exit(0);
		}
	}

	public static void excluirPromotor() {
		PromotorJuridico promotorJuridico = new PromotorJuridico();
		promotorJuridico = login();

		if(promotorJuridico == null) {
			System.out.println("\nUsuário não encontrado ou Usuario/Senha incorreto.\n");
			return;
		}else {
			StringBuilder sb = new StringBuilder();
			sb.append("Tem certeza que deseja excluir o perfil de " + promotorJuridico.getRazaoSocial() + " junto de todos seus dados?\n")
			.append("\nPara confirmar a ação digite 0, para cancelar digite 1: \n");
			System.out.println(sb.toString());
			int option = scanner.nextInt();
			
			switch (option) {
			case 0:
				IPromotorJuridicoDAO.excluirPromotor(promotorJuridico);
				System.out.println("\nExclusão de perfil do Promotor Juridico " + promotorJuridico.getRazaoSocial() + " executada com sucesso.");
				return;
			case 1:
				System.out.println("\nExclusão de perfil do Promotor Juridico" + promotorJuridico.getRazaoSocial() + " cancelada.");
				return;
			default:
				System.out.println("ERRO");
				break;
			}
			
		}

	}

	static PromotorJuridico login() {
		StringBuilder sb = new StringBuilder();
		scanner = new Scanner(System.in);
		PromotorJuridico promotorJuridico = new PromotorJuridico();

		sb.append("\n ---- Acesso ao Sistema ---- \n");
		sb.append("Informe o nome de usuário: \n");
		System.out.println(sb.toString());

		String user = scanner.nextLine();

		sb = new StringBuilder();
		sb.append("\n ---- Acesso ao Sistema ---- \n");
		sb.append("Informe a senha: \n");
		System.out.println(sb.toString());

		String password = scanner.nextLine();

		return IPromotorJuridicoDAO.login(user, password);
	}
}
