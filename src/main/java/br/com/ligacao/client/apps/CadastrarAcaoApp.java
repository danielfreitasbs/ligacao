package br.com.ligacao.client.apps;

import br.com.ligacao.persistence.model.Database;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class CadastrarAcaoApp {

    private static Scanner scanner;

    public static void main(String[] args) throws InterruptedException, ExecutionException, IOException {
        scanner = new Scanner(System.in);

        System.out.println("Cadastro Ação:");
        System.out.println("Nome do promotor\n:");
        String nomePromotor = scanner.nextLine();

        System.out.println("Nome da ação\n:");
        String nomeAcao = scanner.nextLine();

        System.out.println("Categoria da ação\n:");
        String categoria = scanner.nextLine();

        System.out.println("Data de realização\n:");
        String data= scanner.nextLine();

        System.out.println("Descrição\n:");
        String descricao = scanner.nextLine();

        System.out.println("Horário de início\n:");
        String horaInicio = scanner.nextLine();

        System.out.println("Horário de fim\n:");
        String horaFim = scanner.nextLine();

        Database.cadastraAcao(nomePromotor, nomeAcao, categoria, data,
                descricao, horaInicio, horaFim);

    }

}
