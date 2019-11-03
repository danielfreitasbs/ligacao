package br.com.ligacao.client.apps;

import br.com.ligacao.Main;
import br.com.ligacao.persistence.model.PromotorDAO;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

/**
 * Classe para realizar login do usuário no sistema.
 */
public final class LoginApp {

    /**
     * Construtor privado para evitar instanciação da classe.
     */
    private LoginApp() {
    }

    /**
     * Método para simular interface de login.
     * @args  Entrada padrão do menu principal
     * @throws InterruptedException se houver problema na Main
     * @throws ExecutionException se houver problema na Main
     * @throws IOException se houver problema na Main
     */
    public static void simuladorInterface(final String[] args)
            throws InterruptedException, ExecutionException, IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Login necessário.\n"
                + "0 - Realizar Login\n"
                + "1 - Voltar ao menu principal\n"
                + "2 - Sair do sistema");

        int opcao = scanner.nextInt();

        switch (opcao) {
            case 0:
                if (logar()) {
                    System.out.println("Usuario logado no sistema!");
                } else {
                    System.out.println("Senha e/ou usuario incorretos!");
                    simuladorInterface(args);
                }
                break;
            case 1:
                Main.main(args);
                break;
            default:
                scanner.close();
                System.exit(0);
        }
    }

    /**
     * Método para fazer login do usuário.
     *
     * @return true, se senha e usuários estão corretamente informados
     * false, se senha e/ou usuários estão incorretos.
     */
    private static boolean logar() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Insira o nome do Promotor: ");
        String nome = scanner.nextLine();

        String senhaBD = PromotorDAO.consultaSenha(nome);

        System.out.println("Insira a senha: ");
        String senhaInformada = scanner.nextLine();

        return senhaInformada.equals(senhaBD);
    }

}

