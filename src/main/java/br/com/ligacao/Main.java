package br.com.ligacao;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

import br.com.ligacao.client.PromotorApp;
import br.com.ligacao.persistence.connection.Connection;
import br.com.ligacao.persistence.model.Database;

public class Main {

	private static Scanner scanner = new Scanner(System.in);
	private static int opcao;

	public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
//        Database.cadastraPromotor("Vida Lata", "Apoio Animais", "32132131",
//        "13/01/1988", "ONG de auxilio a animais abandonados",
//        "vidalata@gmail.com", "", "facebook/vidalata", "432141432", "vidalata", "123456");
//
//
//Database.cadastraAcao("Vida Lata", "Campanha de adocao", "apoio animais", "12/10/2019",
//        "Precisamos de voluntÃ¡rios para auxiliar nas tarefas doaÃ§oes de animais", "12PM", "18PM");
//
//Database.consultaPromotor("Vida Lata"); 
//        
		// System.out.println(Database.consultaSenha("Vida Lata"));

		System.out.println("O que deseja realizar?\n" + "0 - Cadastrar uma ação\n" + "1 - Inscrição de Voluntario\n"
				+ "2 - Cadastrar Promotor de Ação\n");

		opcao = scanner.nextInt();

		switch (opcao) {
		case 0:
			break;
		case 1:
			break;
		case 2:
			int retorno = PromotorApp.cadastro();
			scanner.close();
			break;
		default:
			scanner.close();
			break;
		}

	}

}
