package br.com.ligacao.services;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

import br.com.ligacao.persistence.model.Acao;
import br.com.ligacao.persistence.model.AcaoDAO;
import br.com.ligacao.persistence.model.PromotorFisico;
import br.com.ligacao.persistence.model.PromotorJuridico;

/**
 * Classe responsavel por oferecer serviços relacionados a acoes.
 */
public final class AcaoService {

    /**
     * Construtor privado para evitar instanciação da classe.
     */
    private AcaoService() {
    }

    /**
     * Tipo de promotor. O, se for Pessoa Fisica; 1 se for Pessoa Juridica.
     */
    private static int TIPO_PROMOTOR;

    /**
     * Acao a ser criada/editada/excluida.
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
    private static Scanner scanner = new Scanner(System.in, "UTF-8");

    /**
     * Cadastrar nova acao de um promotor existente.
     *
     * @throws ExecutionException   se houver problema ao acessar o banco de dados
     * @throws InterruptedException se houver problema ao acessar o banco de dados
     */
    public static void cadastrar() throws ExecutionException, InterruptedException {
        if (login()) {
            System.out.println("----- Cadastrar Ação -----");

            scanner.nextLine();
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
                String nomePromotor = TIPO_PROMOTOR == 0
                        ? promotorFisico.getNomePessoa()
                        : promotorJuridico.getRazaoSocial();
                try {
                    AcaoDAO.cadastraAcao(nomePromotor, acao);

                } catch (IOException e) {
                    System.out.println("Erro ao cadastrar Acao\n");
                }
                System.out.println("Acão cadastrada com sucesso!\n");
            } else {
                System.out.println("Cadastro da Ação cancelado!\n");
            }
        }
    }

    /**
     * Editar acao de um promotor existente.
     *
     * @throws ExecutionException   se houver problema ao acessar o banco de dados
     * @throws InterruptedException se houver problema ao acessar o banco de dados
     */
    public static void editar() throws ExecutionException, InterruptedException {
        if (login()) {
            System.out.println("----- Editar Ação -----");

            String nomePromotor = TIPO_PROMOTOR == 0
                    ? promotorFisico.getNomePessoa()
                    : promotorJuridico.getRazaoSocial();
            List<Acao> acoes = AcaoDAO.consultaAcoes(nomePromotor);
            if (acoes.size() == 0) {
                System.out.println("Esse promotor não possui ações cadastradas.");
            } else {
                System.out.println("Esse promotor possui as seguintes ações:");
                acoes.forEach(item -> {
                    System.out.println(item.getNomeAcao());
                });

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

                        try {
                            AcaoDAO.cadastraAcao(nomePromotor, acao);
                        } catch (IOException e) {
                            e.printStackTrace();
                            System.out.println("Problema ao editar ação!");
                        }
                    }
                    System.out.println("Ação editada com sucesso!");
                }
            }
        }
    }

    /**
     * Exclui acao de um promotor existente.
     *
     * @throws ExecutionException   se houver problema ao acessar o banco de dados
     * @throws InterruptedException se houver problema ao acessar o banco de dados
     */
    public static void excluir() throws ExecutionException, InterruptedException {
        if (login()) {
            System.out.println("----- Excluir Ação -----");

            String nomePromotor = TIPO_PROMOTOR == 0
                    ? promotorFisico.getNomePessoa()
                    : promotorJuridico.getRazaoSocial();

            List<Acao> acoes = AcaoDAO.consultaAcoes(nomePromotor);
            if (acoes.size() == 0) {
                System.out.println("Esse promotor não possui ações cadastradas.");
            } else {
                System.out.println("Esse promotor possui as seguintes ações:");
                acoes.forEach(item -> System.out.println(item.getNomeAcao()));

                System.out.println("Nome da Ação a ser excluída:");
                String nomeAcao = scanner.nextLine();
                acao = AcaoDAO.consultaAcao(nomePromotor, nomeAcao);

                if (acao == null) {
                    System.out.println("Essa Ação não está listada");
                } else {
                    AcaoDAO.excluiAcao(nomeAcao, nomePromotor);
                }
            }
        }
    }

    /**
     * Realiza o login do promotor de acordo com tipo.
     *
     * @return true, se as informações de login são válidadas, false, caso o
     * usuário ou senha forem inválidos
     */
    private static boolean login() {
        TIPO_PROMOTOR = selecionaTipoPromotor();

        if (TIPO_PROMOTOR == 0) {
            try {
                promotorFisico = PromotorFisicoService.login();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        } else {
            try {
                promotorJuridico = PromotorJuridicoService.login();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        boolean isLogado = promotorFisico != null || promotorJuridico != null;
        if (isLogado) {
            System.out.println("Usuario logado no sistema!\n");
        } else {
            System.out.println("Senha e/ou usuario incorretos!\n");
        }
        return isLogado;
    }

    /**
     * Método para selecionar o tipo de promotor, físico ou jurídico.
     *
     * @return 0, se o tipo de promotor for físico, 1, se o tipo de promotor
     * for jurídico
     */
    private static int selecionaTipoPromotor() {
        System.out.println("Selecione o tipo de pessoa: \n"
                + "0 - Pessoa Física\n1 - Pessoa Juridica");
        return scanner.nextInt();
    }

}
