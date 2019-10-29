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

	public static int cadastro() throws IOException, InterruptedException, ExecutionException {
		
		/**
		 * Realiza a solicitação dos dados para cadastro.
		 */
		System.out.println("Para cadastrar um Promotor, informe os seguintes dados: \n" + "Nome do Promotor: \n"
				+ "Categoria Ação: \n" + "CPF do Responsável: \n" + "Data de Fundacao: \n" + "Descrição: \n"
				+ "Email: \n" + "Imagem: \n" + "Rede Social: \n" + "Telefone: \n");

		/**
		 * Preenchedor automatico do form de cadastro para fins de teste.
		 */
		promotor = PromotorForm.preencherForm();

		/**
		 * Exibindo os dados na tela para confirmação.
		 */
		StringBuilder sb = new StringBuilder();
		sb.append("Confirme os dados. \n").append("Nome do Promotor: ").append(promotor.getNomePromotor())
				.append("\nCategoria Ação: ").append(promotor.getCategoriaAcao()).append("\nCPF do Responsavel: ")
				.append(promotor.getCpfResponsavel()).append("\nData de Fundacao: ").append(promotor.getDataFundacao())
				.append("\nDescricao: ").append(promotor.getDescricao()).append("\nEmail: ").append(promotor.getEmail())
				.append("Rede Social: ").append(promotor.getRedeSocial()).append("\nTelefone: ")
				.append(promotor.getTelefone());

		System.out.println(sb.toString());
		
		/**
		 * 4º passo do caso de uso 10;
		 */
		System.out.println("Digite 1 para confirmar o cadastro ou 0 para não proceder.\n");
		int opcao = scanner.nextInt();

		if (opcao == 1) {
			scanner.close();
			Database.cadastraPromotor(promotor.getNomePromotor(), promotor.getCategoriaAcao(),
					promotor.getCpfResponsavel(), promotor.getDataFundacao(), promotor.getDataFundacao(),
					promotor.getEmail(), promotor.getImagem(), promotor.getRedeSocial(), promotor.getTelefone(),
					"vidalata", "teste");
			return 0;
		} else {
			scanner.close();
			System.exit(0);
		}

		return 1;

	}
}
