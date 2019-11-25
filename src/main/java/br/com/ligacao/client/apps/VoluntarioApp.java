package br.com.ligacao.client.apps;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

import br.com.ligacao.services.VoluntarioService;

/**
 * Classe responsável pelo cadastro ou edição de um voluntário.
 * @author caiob
 *
 */
public final class VoluntarioApp {

    /**
     * Construtor privado para evitar instanciação da classe.
     */
    private VoluntarioApp() {
    }

    /**
     * Scanner para entrada de dados pelo usuario.
     */
    private static Scanner scanner = new Scanner(System.in);

    /**
     * StringBuilder para interação com usuário.
     */
    private static StringBuilder sb = new StringBuilder();

    /**
     * Método para simular interface para invocar métodos sobre Voluntarios.
     *
     * @throws IOException			Se houver problema na Main ou ao utilizar
     *                              o banco de dados.
     * @throws InterruptedException Se houver problema na Main ou ao utilizar
     *                              o banco de dados.
     * @throws ExecutionException   Se houver problema na Main ou ao utilizar
     *                              o banco de dados.
     */
    public static void simuladorInterface() throws IOException, InterruptedException, ExecutionException {
    	sb = new StringBuilder();
    	sb.append("Qual ação deseja executar?\n").append("0 - Cadastrar Voluntário\n")
    			.append("1 - Editar Perfil de Voluntário\n");
    	System.out.println(sb.toString());
    	int opcao = scanner.nextInt();

    	switch (opcao) {
    	case 0:
    		VoluntarioService.cadastroVoluntario();
    		break;
    	case 1:
    		//voluntarioEditar();
    		break;
    	default:
    		break;
    	}
    }
}
