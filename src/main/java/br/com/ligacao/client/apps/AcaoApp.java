package br.com.ligacao.client.apps;

import br.com.ligacao.persistence.model.Acao;
import br.com.ligacao.persistence.model.Promotor;

import java.util.Scanner;

/**
 * Classe responsavel por gerenciar metodos relacionados a acoes.
 */
public class AcaoApp {

    private static Promotor promotor = new Promotor();
    private static Acao acao = new Acao();
    private static Scanner scanner = new Scanner(System.in);;

    public static void simuladorInterface(){

        System.out.println("----- O que deseja executar? -----\n"
                        + "0 - Cadastrar Ação.\n"
                        + "1 - Editar Ação\n"
                        + "2 - Cancelar\n");

        int opcao = scanner.nextInt();

        switch (opcao) {
            case 0:
                cadastrar();
                break;
            case 1:
                editar();
                break;
            default:
                break;
        }
    }

    private static void editar() {
        //TODO
    }

    private static void cadastrar() {
        //TODO
    }
}
