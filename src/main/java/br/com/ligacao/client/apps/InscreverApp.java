package br.com.ligacao.client.apps;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import br.com.ligacao.persistence.model.Acao;
import br.com.ligacao.persistence.model.AcaoDAO;
import br.com.ligacao.services.InscreverService;

/**
 * Classe responsável pela inscrição de um voluntário em uma ação de seu interesse.
 */
public class InscreverApp {
	
	/**
     * Scanner para entrada de dados pelo usuario.
     */
    private static Scanner scanner = new Scanner(System.in);
    
	/**
	 * Método de execução da inscrição do voluntário em uma ação de interesse.
	 * 
	 * @param args Entrada padrão do menu principal
	 */
	public static void simuladorInterface() throws InterruptedException, ExecutionException, IOException {
		Acao acao;
		List<Acao> acoes = AcaoDAO.consultaTodasAcoes();
		System.out.println("Ações disponíveis para inscrever:");

		for(int cont = 0; cont < acoes.size(); cont++) {
			acao = acoes.get(cont);
			System.out.println(cont + " - Ação: " + acao.getNomeAcao() + " Promotor: " + acao.getNomePromotor());
		}
		
		System.out.println("\nEscolha o número da ação ao qual deseja se cadastrar:");
		
		int option = scanner.nextInt();
		scanner.nextLine();
		
		InscreverService.inscreverEmAcao(acoes.get(option));
	}
	
}
