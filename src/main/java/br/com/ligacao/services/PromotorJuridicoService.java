package br.com.ligacao.services;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import br.com.ligacao.client.forms.FormulariosSolicitacao;
import br.com.ligacao.persistence.model.PromotorDAO;
import br.com.ligacao.persistence.model.PromotorJuridico;

/**
 * Classe responsável pela execução de regra de negocio para promotor juridico.
 * 
 * @author danielfreitasbs.
 *
 */
public class PromotorJuridicoService {

  /**
   * Scanner para leitura de input do teclado.
   */
  private static Scanner scanner;

  /**
   * Metodo responsável pela edição de promotorJuridico.
   * 
   * @throws ExecutionException erro ao realizar ação no banco de dados.
   * @throws InterruptedException erro ao realizar ação no banco de dados.
   */
  public static void editarPromotorJuridico() throws InterruptedException, ExecutionException {
    PromotorJuridico promotorJuridico = new PromotorJuridico();
    promotorJuridico = login();

    if (promotorJuridico == null) {
      StringBuilder sb = new StringBuilder();
      sb.append("\nUsuário não encontrado ou Usuario/Senha incorreto.\n");
      System.out.println(sb.toString());
      return;
    } else {
      promotorJuridico = FormulariosSolicitacao.formDadosAlteracaoPJ(promotorJuridico);
      System.out.println("\n ---- Alteração de Cadastro Finalizada ---- \n");
    }
  }

  /**
   * Metodo responsável pelo cadastro de promotor Juridico.
   * 
   * @throws ExecutionException erro ao realizar ação no banco de dados.
   * @throws InterruptedException erro ao realizar ação no banco de dados.
   * @throws IOException caso ocorra erro na leitura de inputs do teclado.
   */
  public static void cadastroPromotorJuridico()
      throws IOException, InterruptedException, ExecutionException {

    StringBuilder sb = new StringBuilder();
    Scanner scanner = new Scanner(System.in);
    PromotorJuridico promotorJuridico = new PromotorJuridico();

    /**
     * Realiza a solicitação dos dados para cadastro.
     */
    promotorJuridico = FormulariosSolicitacao.solCadPromotorJuridico();

    sb = new StringBuilder();
    sb.append("\nPara confirmar o cadastro digite 0, para cancelar digite 1: \n");
    System.out.println(sb.toString());
    int opcao = scanner.nextInt();

    if (opcao == 0) {
      scanner.close();
      PromotorDAO.cadastraPromotorJuridico(promotorJuridico);
    } else {
      scanner.close();
      System.exit(0);
    }
  }

  /**
   * Exclusão de promotor juridico.
   * 
   * @throws ExecutionException erro ao realizar ação no banco de dados.
   * @throws InterruptedException erro ao realizar ação no banco de dados.
   */
  public static void excluirPromotor() throws InterruptedException, ExecutionException {
    PromotorJuridico promotorJuridico = new PromotorJuridico();
    promotorJuridico = login();

    if (promotorJuridico == null) {
      System.out.println("\nUsuário não encontrado ou Usuario/Senha incorreto.\n");
      return;
    } else {
      StringBuilder sb = new StringBuilder();
      sb.append("Tem certeza que deseja excluir o perfil de " + promotorJuridico.getRazaoSocial()
          + " junto de todos seus dados?\n")
          .append("\nPara confirmar a ação digite 0, para cancelar digite 1: \n");
      System.out.println(sb.toString());
      int option = scanner.nextInt();

      switch (option) {
        case 0:
          PromotorDAO.excluiPromotor(promotorJuridico.getNomePessoaResponsavel());
          System.out.println("\nExclusão de perfil do Promotor Juridico "
              + promotorJuridico.getRazaoSocial() + " executada com sucesso.");
          return;
        case 1:
          System.out.println("\nExclusão de perfil do Promotor Juridico"
              + promotorJuridico.getRazaoSocial() + " cancelada.");
          return;
        default:
          System.out.println("ERRO");
          break;
      }

    }

  }

  /**
   * Metodo responsável pela execução de login para promotorJuridico.
   * 
   * @throws ExecutionException erro ao realizar ação no banco de dados.
   * @throws InterruptedException erro ao realizar ação no banco de dados.
   * @return instancia de promotor juridico.
   */
  static PromotorJuridico login() throws InterruptedException, ExecutionException {
    StringBuilder sb = new StringBuilder();
    scanner = new Scanner(System.in);
    PromotorJuridico promotorJuridico = new PromotorJuridico();

    sb.append("\n ---- Acesso ao Sistema ---- \n");
    sb.append("Informe o nome de usuário: \n");
    System.out.println(sb.toString());

    String user = scanner.nextLine();

    sb = new StringBuilder();
    sb.append("\n ---- Acesso ao Sistema ---- \n");
    sb.append("Informe a senha: \n");
    System.out.println(sb.toString());

    String password = scanner.nextLine();

    return PromotorDAO.loginPromotorJuridico(user, password);
  }
}
