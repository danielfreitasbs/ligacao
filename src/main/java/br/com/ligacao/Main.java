package br.com.ligacao;

import br.com.ligacao.client.apps.AcaoApp;
import br.com.ligacao.client.apps.InscreverApp;
import br.com.ligacao.client.apps.PromotorApp;
import br.com.ligacao.client.apps.VoluntarioApp;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import javax.management.AttributeNotFoundException;

/**
 * Classe principal de execução do sistema.
 *
 * @author caiob
 *
 */
public class Main {

    /**
     * Scanner para entrada de dados pelo usuario.
     */
    private static Scanner scanner = new Scanner(System.in, "UTF-8");
    /**
     * Int que irá receber opção definida pelo usuário.
     */
    private static int opcao;

    /**
     * Método de execução do sistema.
     *
     * @param args Argumentos para execução.
     *
     * @throws IOException          Se houver problema na Main ou ao utilizar o
     *                              banco de dados.
     * @throws InterruptedException Se houver problema na Main ou ao utilizar o
     *                              banco de dados.
     * @throws ExecutionException   Se houver problema na Main ou ao utilizar o
     *                              banco de dados.
     */
    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException, AttributeNotFoundException {

        System.out.println("----- Inicio -----\n" + "O que deseja realizar?\n"
                + "0 - Cadastrar/Editar/Excluir uma ação\n" + "1 - Inscrever em ação\n"
                + "2 - Acoes em Promotor de Ação\n" + "3 - Acoes em Voluntário\n" + "4 - Sair do sistema");

        opcao = scanner.nextInt();

        switch (opcao) {
        case 0:
            AcaoApp.simuladorInterface();
            break;
        case 1:
            InscreverApp.simuladorInterface();
            break;
        case 2:
            PromotorApp.simuladorInterface();
            break;
        case 3:
            VoluntarioApp.simuladorInterface();
        default:
            scanner.close();
            System.exit(0);
        }

    }

}
