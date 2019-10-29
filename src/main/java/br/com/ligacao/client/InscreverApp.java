package br.com.ligacao.client;

import java.util.Scanner;

import br.com.ligacao.client.forms.InscreverForm;
import br.com.ligacao.persistence.model.Database;
import br.com.ligacao.persistence.model.InscritoEmAcao;

public class InscreverApp {

	private static Scanner scanner = new Scanner(System.in);
	private static InscritoEmAcao inscrito;
	
	public static void main(String[] args) {
		
		
		System.out.println("1 - Continuar inscrição em ação.\n"
				+"0 - Cancelar\n");
		
		int option = scanner.nextInt();
		
		if(option == 1) {
			scanner.close();
			inscrito = InscreverForm.preencherForm();
		}
		else {
			scanner.close();
			System.exit(0);
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("Confirme os dados. \n").append("Seu nome: ").append(inscrito.getNomeVoluntario())
					.append("\nSeu email: ").append(inscrito.getEmailVoluntario())
					.append("\nNome da ação: ").append(inscrito.getNomeAcao())
					.append("\nNome do promotor: ").append(inscrito.getNomePromotor());

		System.out.println(sb.toString());
		
		System.out.println("Digite 1 para confirmar o cadastro ou 0 para n�o proceder.\n");
		int opcao = scanner.nextInt();

		if (opcao == 1) {
			scanner.close();
			//Database.cadastraVoluntarioEmAcao();
		} else {
			scanner.close();
			System.exit(0);
		}
		
	}
	
}
