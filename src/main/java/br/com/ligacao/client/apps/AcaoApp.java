package br.com.ligacao.client.apps;

import br.com.ligacao.Main;
import br.com.ligacao.persistence.model.Acao;
import br.com.ligacao.persistence.model.AcaoDAO;
import br.com.ligacao.persistence.model.Promotor;
import br.com.ligacao.persistence.model.PromotorDAO;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

/**
 * Classe responsavel por gerenciar metodos relacionados a acoes.
 */
public class AcaoApp {

    /**
     * Acao a ser criada/editada/lida/excluida.
     */
    private static Acao acao = new Acao();

    /**
     * Promotor ligado a acao.
     */
    private static Promotor promotor = new Promotor();

    /**
     * Método para simular interface para invocar métodos sobre Ações.
     *
     * @throws InterruptedException se houver problema na Main
     * @throws ExecutionException   se houver problema na Main
     * @throws IOException          se houver problema na Main
     * @args Entrada padrão do menu principal
     */
    public static void simuladorInterface(final String[] args) throws InterruptedException, ExecutionException, IOException {
        System.out.println("----- O que deseja executar? -----\n"
                + "0 - Cadastrar Ação.\n"
                + "1 - Editar Ação\n"
                + "2 - Excluir Ação - TBI\n"
                + "3 - Voltar ao menu principal\n"
                + "4 - Sair do sistema");

        Scanner scanner = new Scanner(System.in);
        int opcao = scanner.nextInt();

        switch (opcao) {
            case 0:
                cadastrar();
                simuladorInterface(args);
                break;
            case 1:
                editar();
                simuladorInterface(args);
                break;
            case 2:
                excluir();
                simuladorInterface(args);
                break;
            case 3:
                Main.main(args);
                break;
            default:
                scanner.close();
                System.exit(0);
        }
    }

    /**
     * Metodo responsavel por cadastrar nova acao
     *
     * @throws ExecutionException   se houver problema...
     * @throws InterruptedException se houver problema...
     * @throws IOException          se houver problema na entrada
     */
    private static void cadastrar() throws ExecutionException, InterruptedException, IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nome do promotor: ");
        String nomePromotor = scanner.nextLine();

        promotor = PromotorDAO.consultaPromotor(nomePromotor);
        if (promotor != null) {
            System.out.println("Nome da ação: ");
            acao.setNomeAcao(scanner.nextLine());

            System.out.println("Data de realização: ");
            acao.setDataRealizacao(scanner.nextLine());

            Acao acaoMesmoNome = new Acao();
            acaoMesmoNome = AcaoDAO.consultaAcao(nomePromotor, acao.getNomeAcao());
            if (acaoMesmoNome != null) {
                if (acaoMesmoNome.getDataRealizacao().equals(acao.getDataRealizacao())) {
                    System.out.println("Já existe uma ação de mesmo nome "
                            + "registrada nesse dia!\n"
                            + "0 - Modificar data da Ação\n"
                            + "1 - Voltar ao menu inicial de Ação");
                    int opcaoAcao = scanner.nextInt();
                    if (opcaoAcao == 0) {
                        System.out.println("Data de realização: ");
                        acao.setDataRealizacao(scanner.nextLine());
                    } else simuladorInterface(null);
                }
            }
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
                try {
                    AcaoDAO.cadastraAcao(promotor, acao);
                    System.out.println("Acão cadastrada com sucesso!");
                } catch (IOException e) {
                    System.out.println("Erro ao cadastrar Ação!");
                    e.printStackTrace();
                }
            } else {
                System.out.println("Cadastro da Ação cancelado!");
            }
        }
    }

    /**
     * Metodo responsavel por editar acao de um promotor existente
     *
     * @throws ExecutionException   se houver problema...
     * @throws InterruptedException se houver problema...
     * @throws IOException          se houver problema na entrada
     */
    private static void editar() throws ExecutionException, InterruptedException, IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nome do promotor:");
        String nomePromotor = scanner.nextLine();
        promotor = PromotorDAO.consultaPromotor(nomePromotor);
        if (promotor == null) {
            System.out.println("Esse promotor não existe.");
            simuladorInterface(null);
        }

        List<Acao> acoes = AcaoDAO.consultaAcoes(nomePromotor);
        if (acoes.size() == 0) {
            System.out.println("Esse promotor não possui ações cadastradas.");
            simuladorInterface(null);
        }
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
                        + "6 - Voltar ao menu inicial de ações\n");
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
                        simuladorInterface(null);
                        break;
                }
                try {
                    AcaoDAO.cadastraAcao(promotor, acao);
                    System.out.println("Ação editada com sucesso!");
                } catch (IOException e) {
                    System.out.println("Erro ao salvar ação.");
                    e.printStackTrace();
                }
            }
        }
    }

    private static void excluir() {
        //TODO
    }
}
