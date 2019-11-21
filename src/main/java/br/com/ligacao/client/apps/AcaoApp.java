package br.com.ligacao.client.apps;

import br.com.ligacao.Main;
import br.com.ligacao.services.AcaoService;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

/**
 * Classe responsavel por gerenciar requisições do cliente sobre ações.
 */
public class AcaoApp {

    /**
     * Scanner para entrada de dados pelo usuario.
     */
    private static Scanner scanner;

    /**
     * Método para simular interface para invocar métodos sobre Ações.
     *
     * @throws InterruptedException se houver problema na Main
     * @throws ExecutionException   se houver problema na Main
     * @throws IOException          se houver problema na Main
     * @args Entrada padrão do menu principal
     */
    public static void simuladorInterface(final String[] args) throws InterruptedException, ExecutionException, IOException {
        int tipoPromotor = selecionaTipoPromotor();

        System.out.println("----- O que deseja executar? -----\n"
                + "0 - Cadastrar Ação.\n"
                + "1 - Editar Ação\n"
                + "2 - Excluir Ação - TBI\n"
                + "3 - Voltar ao menu principal\n"
                + "4 - Sair do sistema");

        scanner = new Scanner(System.in);
        int opcao = scanner.nextInt();
        switch (opcao) {
            case 0:
                AcaoService.cadastrar(tipoPromotor);
                break;
            case 1:
                AcaoService.editar(tipoPromotor);
                break;
            case 2:
                AcaoService.excluir(tipoPromotor);
                break;
            case 3:
                Main.main(args);
                break;
            default:
                scanner.close();
                System.exit(0);
        }
        simuladorInterface(args);
    }

    private static int selecionaTipoPromotor() {
        scanner = new Scanner(System.in);
        System.out.println("Selecione o tipo de pessoa: \n"
                + "0 - Pessoa Física\n1 - Pessoa Juridica");
        int option = scanner.nextInt();
        return option;
    }
}
