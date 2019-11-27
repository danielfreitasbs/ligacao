package br.com.ligacao.services;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import javax.management.AttributeNotFoundException;
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
   * @param promotorParam instancia de promotor juridico.
   * @throws ExecutionException erro ao realizar ação no banco de dados.
   * @throws InterruptedException erro ao realizar ação no banco de dados.
   * @throws IOException caso ocorra algum erro no uso do banco de dados.
   */
  public static void editarPromotorJuridico(final PromotorJuridico promotorParam)
      throws InterruptedException, ExecutionException, IOException {
    if (promotorParam.getRazaoSocial() == "") {
      PromotorDAO.cadastraPromotorJuridico(promotorParam);
    } else {
      throw new IllegalArgumentException();
    }
  }

  /**
   * Metodo responsável pelo cadastro de promotor Juridico.
   *
   * @param promotorJuridico instancia de promotor juridico.
   * @throws ExecutionException erro ao realizar ação no banco de dados.
   * @throws InterruptedException erro ao realizar ação no banco de dados.
   * @throws IOException caso ocorra erro na leitura de inputs do teclado.
   * @throws AttributeNotFoundException caso não seja informado o atributo cnpj do promotor.
   */
  public static void cadastroPromotorJuridico(final PromotorJuridico promotorJuridico)
      throws IOException, InterruptedException, ExecutionException, AttributeNotFoundException {
    if (promotorJuridico.getCnpj() != "") {
      PromotorDAO.cadastraPromotorJuridico(promotorJuridico);
    } else {
      throw new AttributeNotFoundException();
    }
  }

  /**
   * Exclusão de promotor juridico.
   *
   * @param promotorJuridico instancia de promotor juridico.
   * @throws ExecutionException erro ao realizar ação no banco de dados.
   * @throws InterruptedException erro ao realizar ação no banco de dados.
   */
  public static void excluirPromotor(final PromotorJuridico promotorJuridico)
      throws InterruptedException, ExecutionException {
    if (promotorJuridico.getRazaoSocial() != "") {
      PromotorDAO.excluiPromotor(promotorJuridico.getRazaoSocial());
    } else {
      throw new IllegalArgumentException();
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

  /**
   * Realiza o login atraves de parametros.
   *
   * @param user usuario do promotor.
   * @param password senha do promotor.
   * @return instancia caso encontre e null caso contrario.
   * @throws InterruptedException caso ocorra algum erro no uso do banco de dados.
   * @throws ExecutionException caso ocorra algum erro no uso do banco de dados.
   */
  public static PromotorJuridico login(final String user, final String password)
      throws InterruptedException, ExecutionException {
    if (user != "" && password != "") {
      return PromotorDAO.loginPromotorJuridico(user, password);
    } else {
      return null;
    }
  }
}
