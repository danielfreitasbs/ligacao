package br.com.ligacao.services;

import java.util.Scanner;

import br.com.ligacao.client.forms.FormulariosSolicitacao;
import br.com.ligacao.persistence.interfaces.IPromotorJuridicoDAO;
import br.com.ligacao.persistence.model.PromotorJuridico;

public class PromotorJuridicoService {

	public static void editarPromotorJuridico() {
		StringBuilder sb = new StringBuilder();
		Scanner scanner = new Scanner(System.in);
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

		promotorJuridico = IPromotorJuridicoDAO.login(user, password);

		if (promotorJuridico == null) {
			sb = new StringBuilder();
			sb.append("\nUsuário não encontrado ou Usuario/Senha incorreto.\n");
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
}
