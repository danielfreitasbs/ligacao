package br.com.ligacao.client.apps;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import br.com.ligacao.persistence.model.Acao;
import br.com.ligacao.persistence.model.AcaoDAO;
import br.com.ligacao.persistence.model.Promotor;
import br.com.ligacao.persistence.model.PromotorDAO;
import br.com.ligacao.persistence.model.Voluntario;
import br.com.ligacao.persistence.model.VoluntarioDAO;

/**
 * Classe responsável pela inscrição de um voluntário em uma ação de seu interesse.
 */
public class InscreverApp {
	
	/**
	 * Método de execução da inscrição do voluntário em uma ação de interesse.
	 * 
	 * @param args Entrada padrão do menu principal
	 */
	public static void main(String[] args) throws InterruptedException, ExecutionException, IOException {

		Scanner scanner = new Scanner(System.in);
		Acao acao;
		List<Acao> acoes = AcaoDAO.consultaTodasAcoes();
		System.out.println("Ações disponíveis para inscrever:");

		for(int cont = 0; cont < acoes.size(); cont++) {
			acao = acoes.get(cont);
			System.out.println(cont + " - Ação: " + acao.getNomeAcao() + " Promotor: " + acao.getNomePromotor());
		}
		
		System.out.println("\nEscolha o número da ação:");
		
		int option = scanner.nextInt();
		scanner.nextLine();
		
		acao = acoes.get(option);
		/*
		 * Comentei aqui pois estava dando erro
		 * Promotor promotor =	PromotorDAO.consultaPromotor(acao.getNomePromotor());
		 *
		 */

		System.out.println("\nDigite seu nome:");
		
		String nomeVoluntario = scanner.nextLine();
		
		System.out.println("\nDigite seu email:");
		
		String emailVoluntario = scanner.nextLine();
		
		while(isValidEmailAddress(emailVoluntario) == false) {
			System.out.println("\nEmail inválido. Digite um email válido:");
			emailVoluntario = scanner.nextLine();
		}

		/*
		 * Voluntario voluntario = new Voluntario(nomeVoluntario,
		 * emailVoluntario);
		 */

		
		StringBuilder sb = new StringBuilder();
		/*
		sb.append("\nConfirme os dados. \n").append("Seu nome: ").append(voluntario.getNomeVoluntario())
					.append("\nSeu email: ").append(voluntario.getEmailVoluntario())
					.append("\nNome da ação: ").append(acao.getNomeAcao())
					.append("\nNome do promotor: ").append(promotor.getNomePromotor());
		*/
		System.out.println(sb.toString());
		
		System.out.println("\nDigite 1 para confirmar o cadastro ou 0 para não proceder.");
		int opcao = scanner.nextInt();

		if (opcao == 1) {
			scanner.close();
			/*VoluntarioDAO.cadastraVoluntario(promotor, acao, voluntario);
			 */
			System.exit(0);
		} else {
			scanner.close();
			System.exit(0);
		}
		
	}
	
	/**
	 * Método que valida endereço de email.
	 * 
	 * @param email String contendo endereço de email a ser validado.
	 * 
	 * @return {@code true} se endereço de email é valido e {@code false} caso não seja.
	 */
	public static boolean isValidEmailAddress(String email) {
        boolean result = true;
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (AddressException ex) {
            result = false;
        }
        return result;
    }
	
}
