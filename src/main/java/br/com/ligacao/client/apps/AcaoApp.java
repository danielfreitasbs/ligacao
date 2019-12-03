package br.com.ligacao.client.apps;

import br.com.ligacao.Main;
import br.com.ligacao.services.AcaoService;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import javax.management.AttributeNotFoundException;

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
     * @throws InterruptedException       se houver problema na Main ou ao acessar o banco de dados.
     * @throws ExecutionException         se houver problema na Main ou ao acessar o banco de dados.
     * @throws IOException                se houver problema na Main ou ao utilizar o banco de dados.
     * @throws AttributeNotFoundException caso falte algum atributo chave.
     */
    public static void simuladorInterface()
            throws InterruptedException, ExecutionException, IOException, AttributeNotFoundException {
        scanner = new Scanner(System.in, "UTF-8");
        System.out.println("----- Acoes -----\n" + "0 - Cadastrar Ação.\n" + "1 - Editar Ação\n"
                + "2 - Excluir Ação\n" + "3 - Sair do Sistema");

        int opcao = scanner.nextInt();
        while(opcao >= 0 && opcao <3){
            escolherOpcao(opcao);
            System.out.println("----- Acoes -----\n" + "0 - Cadastrar Ação\n" + "1 - Editar Ação\n"
                    + "2 - Excluir Ação\n" + "3 - Sair do Sistema");
            opcao = scanner.nextInt();
        }
    }

    /**
     * Método para escolher opção do usuário e oferecer serviços sobre a Ação.
     *
     * @param opcao opcao a ser escolhida
     * @throws InterruptedException       se houver problema ao acessar o banco de dados
     * @throws ExecutionException         se houver problema na Main ou ao acessar o banco de dados
     * @throws IOException                se houver problema na Main
     * @throws AttributeNotFoundException caso falte algum atributo chave.
     */
    public static void escolherOpcao(final int opcao)
            throws ExecutionException, InterruptedException, IOException, AttributeNotFoundException {
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
            default:
                Main.main(new String[0]);
        }
    }


}
