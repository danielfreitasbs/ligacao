package br.com.ligacao.client.apps;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

import br.com.ligacao.services.PromotorFisicoService;
import br.com.ligacao.services.PromotorJuridicoService;

public class PromotorApp {

	static String CABECALHO_FORM_CAD = "\n---- Formulário de Cadastro de Promotor ----\n";
	static String CABECALHO_FORM_EDIT = "\n---- Formulário de Cadastro de Promotor ----\n";
	static String CABECALHO_FORM_DEL = "\n---- Formulário de Cadastro de Promotor ----\n";

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
			promotorCadastro();
			break;
		case 1:
			promotorEditar();
			break;
		case 2:
			promotorExcluir();
			break;
		default:
			break;
		}
	}

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

	static int selecionaTipoPromotor(String cabecalho) {
		sb = new StringBuilder();
		sb.append(cabecalho);
		sb.append("Selecione o tipo de pessoa: \n");
		sb.append("0 - Pessoa Física \n1 - Pessoa Juridica");

		int option = scanner.nextInt();
		return option;
	}

}
