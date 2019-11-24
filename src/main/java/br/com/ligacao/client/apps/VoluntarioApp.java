package br.com.ligacao.client.apps;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

import br.com.ligacao.services.VoluntarioService;

public class VoluntarioApp {

	private static Scanner scanner = new Scanner(System.in);
	private static StringBuilder sb = new StringBuilder();
	
	public static void simuladorInterface() throws IOException, InterruptedException, ExecutionException {
		sb = new StringBuilder();
		sb.append("Qual ação deseja executar?\n").append("0 - Cadastrar Voluntário\n")
				.append("1 - Editar Perfil de Voluntário\n");
		System.out.println(sb.toString());
		int opcao = scanner.nextInt();
		
		switch (opcao) {
		case 0:
			voluntarioCadastro();
			break;
		case 1:
			//voluntarioEditar();
			break;
		default:
			break;
		}
	}
	
	/*private static void voluntarioEditar() {
		VoluntarioService.editarVoluntario();
	}*/
	
private static void voluntarioCadastro() throws IOException, InterruptedException, ExecutionException {
		VoluntarioService.cadastroVoluntario();
	}
}
