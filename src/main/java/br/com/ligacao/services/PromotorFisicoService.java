package br.com.ligacao.services;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import javax.management.AttributeNotFoundException;
import br.com.ligacao.persistence.model.Acao;
import br.com.ligacao.persistence.model.AcaoDAO;
import br.com.ligacao.persistence.model.PromotorDAO;
import br.com.ligacao.persistence.model.PromotorFisico;
import br.com.ligacao.persistence.model.Voluntario;
import br.com.ligacao.persistence.model.VoluntarioDAO;

/**
 * Classe responsável pela execução de regras de negócio do promotorFisico.
 *
 * @author danielfreitasbs.
 *
 */
public class PromotorFisicoService {

  /**
   * Instancia de promotor fisico.
   */
  private static PromotorFisico promotorFisico = new PromotorFisico();

  /**
   * Scanner para leitura de input do teclado.
   */
  private static Scanner scanner;

  /**
   * Metodo responsável pela coleta de dados para avaliação de voluntário.
   *
   * @throws InterruptedException problemas em acoes com banco de dados.
   * @throws ExecutionException problemas em acoes com banco de dados.
   */
  public static void avaliarVoluntario() throws InterruptedException, ExecutionException {
    promotorFisico = login();

    if (promotorFisico == null) {
      System.out.println("\nUsuário não encontrado ou Usuario/Senha incorreto.\n");
      return;
    } else {
      List<Acao> listaAcoes = AcaoDAO.consultaTodasAcoes();

      listaAcoes.removeIf(acao -> (acao.getNomePromotor() != promotorFisico.getNomePessoa()));

      if (listaAcoes.isEmpty() || listaAcoes == null) {
        System.out.println("\nNenhuma ação encontrada para este promotor");
        return;
      }

      for (int i = 0; i < listaAcoes.size(); i++) {
        System.out.println(i + " - " + listaAcoes.get(i) + "\n");
      }

      System.out.println("Infome o numero da ação que deseja avaliar o voluntario: \n");
      scanner = new Scanner(System.in);
      int option = scanner.nextInt();
      Acao acao = new Acao();
      boolean acaoEncontrada = false;
      for (int i = 0; i < listaAcoes.size(); i++) {
        if (option == i) {
          acao = listaAcoes.get(i);
          acaoEncontrada = true;
        }
      }

      if (!acaoEncontrada) {
        System.out.println("\nNao existe esta ação na listagem.");
        return;
      }

      List<Voluntario> listVoluntarios =
          VoluntarioDAO.consultaVoluntarios(promotorFisico.getNomePessoa(), acao.getNomeAcao());

      for (int i = 0; i < listVoluntarios.size(); i++) {
        System.out.println(i + " - " + listVoluntarios.get(i) + "\n");
      }

      System.out.println("Infome o numero do voluntario que deseja avaliar: \n");
      option = scanner.nextInt();
      Voluntario voluntario = new Voluntario();
      boolean voluntarioEncontrado = false;

      for (int i = 0; i < listVoluntarios.size(); i++) {
        if (option == i) {
          voluntario = listVoluntarios.get(i);
          voluntarioEncontrado = true;
        }
      }

      if (!voluntarioEncontrado) {
        System.out.println("Não existe este voluntario na listagem. \n");
        return;
      }

      System.out.println("Informe a nota de avaliação de 0 a 5: \n");
      int valuation = scanner.nextInt();

      if (valuation < 0 || valuation > 5) {
        System.out.println("Não foi possivel avaliar o voluntario com este valor.");
        return;
      }

      System.out.println("Deseja confirmar a avaliação do voluntario: " + voluntario.getNome()
          + "?. \n0 - Sim\n1 - Não\n");
      option = scanner.nextInt();

      // if (option == 0) {
      // // IPromotorFisicoDAO.registrarAvaliacaoVoluntario(voluntario, valuation);
      // } else {
      // System.out.println("\nAvaliação de voluntario não registrada.\n");
      // }

      System.out.println("\n ---- Avaliação de Voluntário Finalizada ---- \n");
    }

  }

  /**
   * Metodo responsável pela execução de regras de negocio para cadastro de promotorFisico.
   *
   * @param promotorFisicoParam instancia de promotor fisico.
   * @throws IOException problema na leitura de input do teclado.
   * @throws InterruptedException problemas em acoes com banco de dados.
   * @throws ExecutionException problemas em acoes com banco de dados.
   * @throws AttributeNotFoundException caso não seja informado o nome do promotor.
   */
  public static void cadastroPromotorFisico(final PromotorFisico promotorFisicoParam)
      throws IOException, InterruptedException, ExecutionException, AttributeNotFoundException {
    if (promotorFisicoParam.getNomePessoa() != "") {
      PromotorDAO.cadastraPromotorFisico(promotorFisicoParam);
    } else {
      throw new AttributeNotFoundException();
    }
  }

  /**
   * Método responsável pela execução de regras para edicao de promotorFisico.
   *
   * @param promotorFisicoParam instancia de promotor fisico.
   * @throws ExecutionException erro ao realizar ação no banco de dados.
   * @throws InterruptedException erro ao realizar ação no banco de dados.
   * @throws IOException caso ocorra algum erro de escrita.
   */
  public static void editarPromotorFisico(final PromotorFisico promotorFisicoParam)
      throws InterruptedException, ExecutionException, IOException {
    if (promotorFisicoParam.getNomePessoa() != "") {
      PromotorDAO.cadastraPromotorFisico(promotorFisicoParam);
    } else {
      throw new IllegalArgumentException();
    }
  }


  /**
   * Responsável pela execução de regras da exclusão de promotor.
   *
   * @param promotorFisicoParam instancia de promotor fisico.
   * @throws ExecutionException erro ao realizar ação no banco de dados.
   * @throws InterruptedException erro ao realizar ação no banco de dados.
   */
  public static void excluirPromotor(final PromotorFisico promotorFisicoParam)
      throws InterruptedException, ExecutionException {
    if (promotorFisicoParam.getNomePessoa() != "") {
      PromotorDAO.excluiPromotor(promotorFisicoParam.getNomePessoa());
    } else {
      throw new IllegalArgumentException();
    }
  }

  /**
   * Metodo responsável pela execução de login de promotor Fisico.
   *
   * @throws ExecutionException erro ao realizar ação no banco de dados.
   * @throws InterruptedException erro ao realizar ação no banco de dados.
   * @return instancia de promotor fisico.
   */
  public static PromotorFisico login() throws InterruptedException, ExecutionException {
    StringBuilder sb = new StringBuilder();
    scanner = new Scanner(System.in);

    sb.append("\n ---- Acesso ao Sistema ---- \n");
    sb.append("Informe o nome de usuário: \n");
    System.out.println(sb.toString());

    String user = scanner.nextLine();

    sb = new StringBuilder();
    sb.append("\n ---- Acesso ao Sistema ---- \n");
    sb.append("Informe a senha: \n");
    System.out.println(sb.toString());

    String password = scanner.nextLine();

    return PromotorDAO.loginPromotorFisico(user, password);
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
  public static PromotorFisico login(final String user, final String password)
      throws InterruptedException, ExecutionException {
    if (user != "" && password != "") {
      return PromotorDAO.loginPromotorFisico(user, password);
    } else {
      return null;
    }
  }
}
