package br.com.ligacao;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

import br.com.ligacao.client.apps.InscreverApp;
import br.com.ligacao.client.apps.AcaoApp;
import br.com.ligacao.client.apps.LoginApp;
import br.com.ligacao.client.apps.PromotorApp;

public class Main {

	private static Scanner scanner = new Scanner(System.in);
	private static int opcao;

	public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {

		System.out.println("O que deseja realizar?\n"
				+ "0 - Cadastrar/Editar uma ação\n"
				+ "1 - Inscrever em ação\n"
				+ "2 - Cadastrar Promotor de Ação\n");

		opcao = scanner.nextInt();

		switch (opcao) {
		case 0:
			LoginApp.simuladorInterface(args);
			AcaoApp.simuladorInterface();
			scanner.close();
			break;
		case 1:
			InscreverApp.main(args);
			scanner.close();
			break;
		case 2:
			PromotorApp.simuladorInterface();
			scanner.close();
			break;
		default:
			scanner.close();
			break;
		}

	}

}
