package br.com.ligacao.client.apps;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import br.com.ligacao.persistence.model.Acao;
import br.com.ligacao.persistence.model.AcaoDAO;
import br.com.ligacao.services.InscreverService;

/**
 * Classe responsável pela inscrição de um voluntário em uma ação de seu
 * interesse.
 */
public final class InscreverApp {

    /**
     * Construtor privado para evitar instanciação da classe.
     */
    private InscreverApp() {
    }

    /**
     * Scanner para entrada de dados pelo usuario.
     */
    private static Scanner scanner = new Scanner(System.in, "UTF-8");

    /**
     * Método para simular interface para invocar métodos sobre inscrição de
     * Voluntarios em Ações.
     *
     * @throws IOException          Se houver problema na Main ou ao utilizar o
     *                              banco de dados.
     * @throws InterruptedException Se houver problema na Main ou ao utilizar o
     *                              banco de dados.
     * @throws ExecutionException   Se houver problema na Main ou ao utilizar o
     *                              banco de dados.
     */
    public static void simuladorInterface() throws InterruptedException, ExecutionException, IOException {
        Acao acao;
        List<Acao> acoes = AcaoDAO.consultaTodasAcoes();
        System.out.println("Ações disponíveis para inscrever:");

        for (int cont = 0; cont < acoes.size(); cont++) {
            acao = acoes.get(cont);
            System.out.println(cont + " - Ação: " + acao.getNomeAcao() + " Promotor: "
                                    + acao.getNomePromotor());
        }

        System.out.println("\nEscolha o número da ação ao qual deseja se cadastrar:");

        int option = scanner.nextInt();
        scanner.nextLine();

        InscreverService.inscreverEmAcao(acoes.get(option));
    }
}
