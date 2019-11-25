package br.com.ligacao.services;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

import br.com.ligacao.client.forms.FormulariosSolicitacao;
import br.com.ligacao.persistence.model.Voluntario;
import br.com.ligacao.persistence.model.VoluntarioDAO;;

public class VoluntarioService {

	private static Voluntario voluntario = new Voluntario();
	private static Scanner scanner;
	
	public static void cadastroVoluntario() throws IOException, InterruptedException, ExecutionException {
		scanner = new Scanner(System.in);
		
		voluntario = FormulariosSolicitacao.solCadVoluntario();
		
		StringBuilder sb = new StringBuilder();
		sb.append("\nPara confirmar o cadastro digite 1, para cancelar digite 0: \n");
		System.out.println(sb.toString());
		int opcao = scanner.nextInt();

		if (opcao == 1) {
			scanner.close();
			VoluntarioDAO.cadastraVoluntario(voluntario);
		} else {
			scanner.close();
			System.exit(0);
		}
	}
	
}
