package br.com.ligacao.client.apps;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

import br.com.ligacao.services.PromotorFisicoService;
import br.com.ligacao.services.PromotorJuridicoService;

public class PromotorApp {

	private static Scanner scanner = new Scanner(System.in);
	private static StringBuilder sb = new StringBuilder();

	public static void simuladorInterface() throws IOException, InterruptedException, ExecutionException {
		sb = new StringBuilder();
		sb.append("Qual ação deseja executar?\n").append("0 - Cadastrar Promotor\n")
				.append("1 - Editar Perfil de Promotor\n").append("2 - Excluir Perfil de Promotor\n");
		System.out.println(sb.toString());
		int opcao = scanner.nextInt();

		switch (opcao) {
		case 0:
			selecionaTipoPromotor();
			break;
		case 1:
			selecionaTipoPromotorEditar();
			break;
		case 2:

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
			PromotorFisicoService.editarPromotorFisico();
			break;
		case 1:
			PromotorJuridicoService.editarPromotorJuridico();
			break;

		default:
			break;
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
			PromotorFisicoService.cadastroPromotorFisico();
			break;
		case 1:
			PromotorJuridicoService.cadastroPromotorJuridico();
			break;

		default:
			break;
		}
	}

}
