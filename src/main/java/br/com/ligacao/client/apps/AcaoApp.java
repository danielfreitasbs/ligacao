package br.com.ligacao.client.apps;

import br.com.ligacao.Main;
import br.com.ligacao.services.AcaoService;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

/**
 * Classe responsavel por gerenciar requisições do cliente sobre ações.
 */
public final class AcaoApp {

    /**
     * Construtor privado para evitar instanciação da classe.
     */
    private AcaoApp() {
    }

    /**
     * Scanner para entrada de dados pelo usuario.
     */
    private static Scanner scanner;

    /**
     * Método para simular interface para invocar métodos sobre Ações.
     *
     * @throws InterruptedException se houver problema na Main ou ao acessar
     *                              o banco de dados
     * @throws ExecutionException   se houver problema na Main ou ao acessar
     *                              o banco de dados
     * @throws IOException          se houver problema na Main ou ao utilizar
     *                              o banco de dados
     */
    public static void simuladorInterface() throws InterruptedException, ExecutionException, IOException {
        scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        System.out.println("----- Acoes -----\n"
                + "0 - Cadastrar Acao.\n"
                + "1 - Editar Acao\n"
                + "2 - Excluir Acao\n"
                + "3 - Voltar ao menu principal\n"
                + "4 - Sair do sistema");

        int opcao = scanner.nextInt();
        escolherOpcao(opcao);
        Main.main(new String[0]);
    }

    /**
     * Método para escolher opção do usuário e oferecer serviços sobre a Ação.
     *
     * @param opcao opcao a ser escolhida
     * @throws InterruptedException se houver problema ao acessar o banco de dados
     * @throws ExecutionException   se houver problema na Main ou ao acessar
     *                              o banco de dados
     * @throws IOException          se houver problema na Main
     */
    public static void escolherOpcao(final int opcao) throws ExecutionException,
            InterruptedException, IOException {
        switch (opcao) {
            case 0:
                AcaoService.cadastrar();
                break;
            case 1:
                AcaoService.editar();
                break;
            case 2:
                AcaoService.excluir();
                break;
            case 3:
                Main.main(new String[0]);
                break;
            default:
                scanner.close();
                System.exit(0);
        }
    }


}
