package br.com.ligacao.services;

import br.com.ligacao.persistence.interfaces.IAcaoDAO;
import br.com.ligacao.persistence.model.Acao;
import br.com.ligacao.persistence.model.AcaoDAO;
import br.com.ligacao.persistence.model.PromotorFisico;
import br.com.ligacao.persistence.model.PromotorJuridico;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

/**
 * Classe responsavel por oferecer serviços relacionados a acoes.
 */
public class AcaoService {

    /**
     * Tipo de promotor. O, se for Pessoa Fisica; 1 se for Pessoa Juridica.
     */
    private static int TIPO_PROMOTOR;

    /**
     * Acao a ser criada/editada/lida/excluida.
     */
    private static Acao acao = new Acao();

    /**
     * Promotor fisico.
     */
    private static PromotorJuridico promotorJuridico = new PromotorJuridico();

    /**
     * Promotor juridico.
     */
    private static PromotorFisico promotorFisico = new PromotorFisico();

    /**
     * Scanner para entrada de dados pelo usuario.
     */
    private static Scanner scanner;

    /**
     * Cadastrar nova acao de um promotor existente.
     *
     */
    public static void cadastrar() throws ExecutionException, InterruptedException {
        if (login()) {
            System.out.println("---CADASTRAR DE AÇÃO---");

            System.out.println("Nome da ação: ");
            acao.setNomeAcao(scanner.nextLine());

            System.out.println("Data de realização: ");
            acao.setDataRealizacao(scanner.nextLine());

            System.out.println("Categoria da ação: ");
            acao.setCategoriaAcao(scanner.nextLine());

            System.out.println("Descrição: ");
            acao.setDescricao(scanner.nextLine());

            System.out.println("Horário de início: ");
            acao.setHoraInicio(scanner.nextLine());

            System.out.println("Horário de fim: ");
            acao.setHoraFim(scanner.nextLine());

            System.out.println("0 - Confirmar o cadastro da acao\n"
                    + "1 - Cancelar.\n");
            int opcaoConfirmar = scanner.nextInt();

            if (opcaoConfirmar == 0) {
                if (TIPO_PROMOTOR == 0) {
                    IAcaoDAO.cadastraAcao(promotorFisico, acao);
                } else {
                    IAcaoDAO.cadastraAcao(promotorJuridico, acao);
                }
                System.out.println("Acão cadastrada com sucesso!");
            } else {
                System.out.println("Cadastro da Ação cancelado!");
            }
        }
    }

    /**
     * Editar acao de um promotor existente.
     *
     */
    public static void editar() throws ExecutionException, InterruptedException {
        if (login()) {
            System.out.println("---EDITAR AÇÃO---");
            Scanner scanner = new Scanner(System.in);

            String nomePromotor = TIPO_PROMOTOR == 0
                    ? promotorFisico.getNomePessoa()
                    : promotorFisico.getNomePessoa();
            List<Acao> acoes = AcaoDAO.consultaAcoes(nomePromotor);
            if (acoes.size() == 0) {
                System.out.println("Esse promotor não possui ações cadastradas.");
            } else {
                System.out.println("Esse promotor possui as seguintes ações:");
                acoes.forEach(acao -> System.out.println(acao.getNomeAcao()));

                System.out.println("Nome da ação a ser editada:");
                String nomeAcao = scanner.nextLine();
                acao = AcaoDAO.consultaAcao(nomePromotor, nomeAcao);

                if (acao == null) {
                    System.out.println("Essa ação não existe.\n");
                } else {
                    int opcao = 0;
                    while (opcao > -1 && opcao < 6) {
                        System.out.println("Qual campo gostaria de editar:\n"
                                + "0 - Categoria\n"
                                + "1 - Data de realização\n"
                                + "2 - Descrição\n"
                                + "3 - Hora de início\n"
                                + "4 - Hora de fim\n"
                                + "5 - Nome da ação\n"
                                + "6 - Cancelar\n");
                        opcao = scanner.nextInt();

                        switch (opcao) {
                            case 0:
                                System.out.println("Categoria atual: "
                                        + acao.getCategoriaAcao()
                                        + "\nModificar para:");
                                scanner.nextLine();
                                String modificado = scanner.nextLine();
                                acao.setCategoriaAcao(modificado);
                                break;
                            case 1:
                                System.out.println("Data de realização atual: "
                                        + acao.getDataRealizacao()
                                        + "\nModificar para:");
                                acao.setDataRealizacao(scanner.nextLine());
                                break;
                            case 2:
                                System.out.println("Descrição atual: "
                                        + acao.getDescricao()
                                        + "\nModificar para:");
                                acao.setDescricao(scanner.nextLine());
                                break;
                            case 3:
                                System.out.println("Hora de início atual: "
                                        + acao.getHoraInicio()
                                        + "\nModificar para:");
                                acao.setHoraInicio(scanner.nextLine());
                                break;
                            case 4:
                                System.out.println("Hora de fim atual: "
                                        + acao.getHoraFim()
                                        + "\nModificar para:");
                                acao.setHoraFim(scanner.nextLine());
                                break;
                            case 5:
                                System.out.println("Nome da Ação atual: "
                                        + acao.getNomeAcao()
                                        + "\nModificar para:");
                                acao.setNomeAcao(scanner.nextLine());
                                break;
                            default:
                                break;
                        }
                        if (TIPO_PROMOTOR == 0) {
                            IAcaoDAO.cadastraAcao(promotorFisico, acao);
                        } else {
                            IAcaoDAO.cadastraAcao(promotorJuridico, acao);
                        }
                        System.out.println("Ação editada com sucesso!");
                    }
                }
            }

        }


    }

    public static void excluir() {
        //TODO
    }

    private static boolean login() {
        scanner = new Scanner(System.in);
        TIPO_PROMOTOR = selecionaTipoPromotor();

        if (TIPO_PROMOTOR == 0) {
            promotorFisico = PromotorFisicoService.login();
        } else {
            promotorJuridico = PromotorJuridicoService.login();
        }

        boolean isLogado = promotorFisico == null && promotorJuridico == null;
        if (isLogado) {
            System.out.println("Senha e/ou usuario incorretos!");
        } else {
            System.out.println("Usuario logado no sistema!");
        }
        return isLogado;
    }

    private static int selecionaTipoPromotor() {
        System.out.println("Selecione o tipo de pessoa: \n"
                + "0 - Pessoa Física\n1 - Pessoa Juridica");
        int option = scanner.nextInt();
        return option;
    }


}
