package br.com.ligacao.services;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

import br.com.ligacao.persistence.model.*;

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
    private static PromotorJuridico promotorJuridico;

    /**
     * Promotor juridico.
     */
    private static PromotorFisico promotorFisico;

    /**
     * Scanner para entrada de dados pelo usuario.
     */
    private static Scanner scanner;

    /**
     * Cadastrar nova acao de um promotor existente.
     *
     * @throws ExecutionException   se houver problema ao acessar o banco de dados
     * @throws InterruptedException se houver problema ao acessar o banco de dados
     */
    public static void cadastrar() throws ExecutionException, InterruptedException {
        scanner = new Scanner(System.in, "UTF-8");
        if (login()) {
            System.out.println("----- Cadastrar Ação -----");

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
                    + "1 - Cancelar.");
            int opcaoConfirmar = scanner.nextInt();

            if (opcaoConfirmar == 0) {
                String nomePromotor = TIPO_PROMOTOR == 0
                        ? promotorFisico.getNomePessoa()
                        : promotorJuridico.getRazaoSocial();
                try {
                    AcaoDAO.cadastraAcao(nomePromotor, acao);

                } catch (IOException e) {
                    System.out.println("Erro ao cadastrar Acao!");
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
     * @throws ExecutionException   se houver problema ao acessar o banco de dados
     * @throws InterruptedException se houver problema ao acessar o banco de dados
     */
    public static void editar() throws ExecutionException, InterruptedException {
        scanner = new Scanner(System.in, "UTF-8");

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
                    System.out.println(" -> " + item.getNomeAcao());
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
                                + "6 - Sair");
                        opcao = scanner.nextInt();

                        switch (opcao) {
                            case 0:
                                System.out.println("Categoria atual: "
                                        + acao.getCategoriaAcao()
                                        + "\nModificar para:");
                                scanner.nextLine();
                                String categoria = scanner.nextLine();
                                acao.setCategoriaAcao(categoria);
                                break;
                            case 1:
                                System.out.println("Data de realização atual: "
                                        + acao.getDataRealizacao()
                                        + "\nModificar para:");
                                scanner.nextLine();
                                String data = scanner.nextLine();
                                acao.setDataRealizacao(data);
                                break;
                            case 2:
                                System.out.println("Descrição atual: "
                                        + acao.getDescricao()
                                        + "\nModificar para:");
                                scanner.nextLine();
                                String descricao = scanner.nextLine();
                                acao.setDescricao(descricao);
                                break;
                            case 3:
                                System.out.println("Hora de início atual: "
                                        + acao.getHoraInicio()
                                        + "\nModificar para:");
                                scanner.nextLine();
                                String horaInicio = scanner.nextLine();
                                acao.setHoraInicio(horaInicio);
                                break;
                            case 4:
                                System.out.println("Hora de fim atual: "
                                        + acao.getHoraFim()
                                        + "\nModificar para:");
                                scanner.nextLine();
                                String horaFim = scanner.nextLine();
                                acao.setHoraFim(horaFim);
                                break;
                            case 5:
                                System.out.println("Nome da Ação atual: "
                                        + acao.getNomeAcao()
                                        + "\nModificar para:");
                                scanner.nextLine();
                                String nome = scanner.nextLine();
                                acao.setNomeAcao(nome);
                                break;
                            default:
                                break;
                        }

                        try {
                            AcaoDAO.cadastraAcao(nomePromotor, acao);
                        } catch (IOException e) {
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
        Scanner scannerExcluir = new Scanner(System.in, "UTF-8");

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
                acoes.forEach(item -> System.out.println(" -> " + item.getNomeAcao()));

                System.out.println("\nNome da Ação a ser excluída:");
                String nomeAcao = scannerExcluir.nextLine();
                acao = AcaoDAO.consultaAcao(nomePromotor, nomeAcao);

                if (acao == null) {
                    System.out.println("Essa Ação não existe!");
                } else {
                    try{
                        AcaoDAO.excluiAcao(nomePromotor,nomeAcao);
                    } catch (InterruptedException | ExecutionException e) {
                        e.printStackTrace();
                        System.out.println("Erro ao excluir ação!");
                    }
                    System.out.println("Ação excluída com sucesso!");
                }
                scannerExcluir.close();
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
        scanner = new Scanner(System.in, "UTF-8");
        TIPO_PROMOTOR = selecionaTipoPromotor();
        System.out.println("Nome do usuário:");
        scanner.nextLine();
        String username = scanner.nextLine();

        System.out.println("Senha do usuário:");
        String senha = scanner.nextLine();

        if (TIPO_PROMOTOR == 0) {
            try {
                promotorFisico = new PromotorFisico();
                promotorFisico = PromotorDAO.loginPromotorFisico(username,
                        senha);
                if (promotorFisico != null) {
                    System.out.println("Usuario logado no sistema!");
                    return true;
                } else {
                    System.out.println("Senha e/ou usuario incorretos!");
                }
            } catch (InterruptedException | ExecutionException | NullPointerException e) {
                System.out.println("Erro ao logar no sistema!");
            }
        } else {
            try {
                promotorJuridico = new PromotorJuridico();
                promotorJuridico = PromotorDAO.loginPromotorJuridico(username
                        ,senha);
                if (promotorJuridico != null) {
                    System.out.println("Usuario logado no sistema!");
                    return true;
                } else {
                    System.out.println("Senha e/ou usuario incorretos!");
                }
            } catch (InterruptedException | ExecutionException | NullPointerException e) {
                System.out.println("Erro ao logar no sistema!");
            }
        }
        return false;
    }

    /**
     * Método para selecionar o tipo de promotor, físico ou jurídico.
     *
     * @return 0, se o tipo de promotor for físico, 1, se o tipo de promotor
     * for jurídico
     */
    private static int selecionaTipoPromotor() {
        scanner = new Scanner(System.in, "UTF-8");

        System.out.println("Selecione o tipo de pessoa: \n"
                + "0 - Pessoa Física\n1 - Pessoa Juridica");
        int tipoPromotor = scanner.nextInt();
        return tipoPromotor;
    }

}
