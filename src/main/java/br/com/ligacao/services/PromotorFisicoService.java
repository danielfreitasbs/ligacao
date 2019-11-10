package br.com.ligacao.services;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

import br.com.ligacao.client.forms.FormulariosSolicitacao;
import br.com.ligacao.persistence.interfaces.IPromotorFisicoDAO;
import br.com.ligacao.persistence.model.PromotorFisico;

public class PromotorFisicoService {

	private static PromotorFisico promotorFisico = new PromotorFisico();
	
	public static void cadastroPromotorFisico() throws IOException, InterruptedException, ExecutionException {
		Scanner scanner = new Scanner(System.in);
		
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
		StringBuilder sb = new StringBuilder();
		Scanner scanner = new Scanner(System.in);
		
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
		promotorFisico = IPromotorFisicoDAO.fazerLogin(user, password);

		if (promotorFisico == null) {
			sb = new StringBuilder();
			sb.append("\nUsuário não encontrado ou Usuario/Senha incorreto.\n");
			return;
		} else {
			promotorFisico = FormulariosSolicitacao.formDadosAlteracao(promotorFisico);
			System.out.println("\n ---- Alteração de Cadastro Finalizada ---- \n");
		}

	}
}
