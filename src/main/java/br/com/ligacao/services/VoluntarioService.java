package br.com.ligacao.services;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

import br.com.ligacao.client.forms.FormulariosSolicitacao;
import br.com.ligacao.persistence.interfaces.IPromotorFisicoDAO;
import br.com.ligacao.persistence.model.PromotorFisico;
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
	
	public static void editarVoluntario() {
		Voluntario voluntario = new Voluntario();
		voluntario = login();
		
		if (voluntario == null) {
			System.out.println("\nUsuário não encontrado ou Usuario/Senha incorreto.\n");
			return;
		} else {
			voluntario = FormulariosSolicitacao.formDadosAlteracaoVoluntario(voluntario);
			System.out.println("\n ---- Alteração de Cadastro Finalizada ---- \n");
		}
	}
	
	static Voluntario login() {
		StringBuilder sb = new StringBuilder();
		scanner = new Scanner(System.in);

		sb.append("\n ---- Acesso ao Sistema ---- \n");
		sb.append("Informe o nome de usuário: \n");
		System.out.println(sb.toString());

		String user = scanner.nextLine();

		sb = new StringBuilder();
		sb.append("\n ---- Acesso ao Sistema ---- \n");
		sb.append("Informe a senha: \n");
		System.out.println(sb.toString());

		String password = scanner.nextLine();

		return VoluntarioDAO.loginVoluntario(user, password);
	}
	
}
