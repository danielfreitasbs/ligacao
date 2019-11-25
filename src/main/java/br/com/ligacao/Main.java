package br.com.ligacao;

import br.com.ligacao.client.apps.AcaoApp;
import br.com.ligacao.client.apps.InscreverApp;
import br.com.ligacao.client.apps.PromotorApp;
import br.com.ligacao.client.apps.VoluntarioApp;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class Main {

    private static Scanner scanner = new Scanner(System.in, "UTF-8");
    private static int opcao;

    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {

        System.out.println("----- Inicio -----\n"
                + "O que deseja realizar?\n"
                + "0 - Cadastrar/Editar/Excluir uma ação\n"
                + "1 - Inscrever em ação\n"
                + "2 - Acoes em Promotor de Ação\n"
                + "3 - Acoes em Voluntário\n"
                + "4 - Sair do sistema");

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
