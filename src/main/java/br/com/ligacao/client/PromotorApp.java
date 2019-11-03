package br.com.ligacao.client;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

import br.com.ligacao.client.forms.PromotorForm;
import br.com.ligacao.persistence.model.Database;
import br.com.ligacao.persistence.model.Promotor;

public class PromotorApp {

	private static Promotor promotor = new Promotor();
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
			cadastro();
			break;
		case 1:
			editarPerfil();
			break;
		default:
			break;
		}
	}

	public static void cadastro() throws IOException, InterruptedException, ExecutionException {

		/**
		 * Realiza a solicitação dos dados para cadastro.
		 */
		System.out.println("Para cadastrar um Promotor, informe os seguintes dados: \n" + "Nome do Promotor: \n"
				+ "Categoria Ação: \n" + "CPF do Responsável: \n" + "Data de Fundacao: \n" + "Descrição: \n"
				+ "Email: \n" + "Imagem: \n" + "Rede Social: \n" + "Telefone: \n");

		/**
		 * Preenchedor automatico do form de cadastro para fins de teste.
		 */
		System.out.println("Preenchendo o form...");
		promotor = PromotorForm.preencherForm();
		System.out.println("Finalizando o preenchimento do form...");

		/**
		 * Exibindo os dados na tela para confirmação.
		 */
		sb = new StringBuilder();
		sb.append("Confirme os dados. \n").append("Nome do Promotor: ").append(promotor.getNomePromotor())
				.append("\nCategoria Ação: ").append(promotor.getCategoriaAcao()).append("\nCPF do Responsavel: ")
				.append(promotor.getCpfResponsavel()).append("\nData de Fundacao: ").append(promotor.getDataFundacao())
				.append("\nDescricao: ").append(promotor.getDescricao()).append("\nEmail: ").append(promotor.getEmail())
				.append("\nRede Social: ").append(promotor.getRedeSocial()).append("\nTelefone: ")
				.append(promotor.getTelefone());

		System.out.println(sb.toString());

		/**
		 * 4� passo do caso de uso 10;
		 */
		System.out.println("Digite 1 para confirmar o cadastro ou 0 para não proceder.\n");
		int opcao = scanner.nextInt();

		if (opcao == 1) {
			scanner.close();
			Database.cadastraPromotor(promotor.getNomePromotor(), promotor.getCategoriaAcao(),
					promotor.getCpfResponsavel(), promotor.getDataFundacao(), promotor.getDataFundacao(),
					promotor.getEmail(), promotor.getImagem(), promotor.getRedeSocial(), promotor.getTelefone(),
					"vidalata", "teste");
		} else {
			scanner.close();
			System.exit(0);
		}
	}

	public static void editarPerfil() throws InterruptedException, ExecutionException, IOException {

		/**
		 * Limpa a instancia de promotor.
		 */
		promotor = new Promotor();

		/**
		 * Solicitação de Dados para busca do promotor.
		 */
		sb.append("Confirme seu nome: ");
		System.out.println(sb.toString());

		String entrada = scanner.nextLine();

		promotor = Database.consultaPromotor("Joãozinho do Trenó");

		/**
		 * Exibindo os dados na tela para confirmação.
		 */
		sb = new StringBuilder();
		sb.append("----- Dados do Promotor ----- \n").append("Nome do Promotor: ").append(promotor.getNomePromotor())
				.append("\nCategoria Ação: ").append(promotor.getCategoriaAcao()).append("\nCPF do Responsavel: ")
				.append(promotor.getCpfResponsavel()).append("\nData de Fundacao: ").append(promotor.getDataFundacao())
				.append("\nDescricao: ").append(promotor.getDescricao()).append("\nEmail: ").append(promotor.getEmail())
				.append("Rede Social: ").append(promotor.getRedeSocial()).append("\nTelefone: ")
				.append(promotor.getTelefone()).append("\n\n\n");

		System.out.println(sb.toString());

		System.out.println("Digite um novo CPF: \n");
		String cpf = scanner.nextLine();

		/**
		 * Simulando alteração de dados com form automatico para fins de teste.
		 */
		sb = new StringBuilder();
		promotor = PromotorForm.preencherFormAlterado(cpf);
		System.out.println("---- Confirmar alteração de Dados do Promotor ----\n");
		sb.append("Nome do Promotor: ").append(promotor.getNomePromotor()).append("\nCategoria Ação: ")
				.append(promotor.getCategoriaAcao()).append("\nCPF do Responsavel: ")
				.append(promotor.getCpfResponsavel()).append("\nData de Fundacao: ").append(promotor.getDataFundacao())
				.append("\nDescricao: ").append(promotor.getDescricao()).append("\nEmail: ").append(promotor.getEmail())
				.append("Rede Social: ").append(promotor.getRedeSocial()).append("\nTelefone: ")
				.append(promotor.getTelefone())
				.append("\n0 - para confirmar a alteração\n 1 - para cancelar a alteração:\n");

		System.out.println(sb.toString());

		int opcao = scanner.nextInt();

		if (opcao == 0) {
			Database.cadastraPromotor(promotor.getNomePromotor(), promotor.getCategoriaAcao(),
					promotor.getCpfResponsavel(), promotor.getDataFundacao(), promotor.getDataFundacao(),
					promotor.getEmail(), promotor.getImagem(), promotor.getRedeSocial(), promotor.getTelefone(),
					"vidalata", "teste");
			System.out.println("Dados alterados com sucesso.");
			scanner.close();
			System.exit(0);
		} else {
			scanner.close();
			System.exit(0);
		}
	}

}
