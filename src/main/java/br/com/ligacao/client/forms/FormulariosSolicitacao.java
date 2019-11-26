package br.com.ligacao.client.forms;

import java.util.Scanner;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import br.com.ligacao.persistence.model.PromotorFisico;
import br.com.ligacao.persistence.model.PromotorJuridico;
import br.com.ligacao.persistence.model.Voluntario;

/**
 * Esta é uma classe utilitaria, usada para representação dos atributos de um
 * formulário de cadastro.
 *
 * @author danielfreitasbs
 *
 */
public final class FormulariosSolicitacao {

    /**
     * Scanner para entrada de dados pelo usuário.
     */
    private static Scanner input = new Scanner(System.in);

    /**
     * Realiza a construção de uma String, que representa a solicitação dos dados
     * para cadastro de um Promotor do tipo pessoa física.
     *
     * @return instancia de Promotor Física;
     */
    public static PromotorFisico solCadPromotorFisico() {

        PromotorFisico promotorFisico = new PromotorFisico();

        StringBuilder sb = new StringBuilder();
        sb.append("----- Cadastro de Promotor do tipo Pessoa Física -----\n").append("Nome da Pessoa: \n");
        System.out.println(sb.toString());
        promotorFisico.setNomePessoa(input.nextLine());

        sb = new StringBuilder();
        sb.append("\nCPF do Responsável: \n");
        System.out.println(sb.toString());
        promotorFisico.setCpf(input.nextLine());

        sb = new StringBuilder();
        sb.append("\nData de Nascimento: \n");
        System.out.println(sb.toString());
        promotorFisico.setDataNascimento(input.nextLine());
        promotorFisico.setFotoPerfil("");

        sb = new StringBuilder();
        sb.append("\nCategorias de Ações: \n");
        System.out.println(sb.toString());
        promotorFisico.setCategoriasAcoes(input.nextLine());

        sb = new StringBuilder();
        sb.append("\nDescricao Geral: \n");
        System.out.println(sb.toString());
        promotorFisico.setDescricaoGeral(input.nextLine());

        sb = new StringBuilder();
        sb.append("\nTelefone: \n");
        System.out.println(sb.toString());
        promotorFisico.setTelefone(input.nextLine());

        sb = new StringBuilder();
        sb.append("\nEndereco: \n");
        System.out.println(sb.toString());
        promotorFisico.setEndereco(input.nextLine());

        sb = new StringBuilder();
        sb.append("\nEmail: \n");
        System.out.println(sb.toString());
        promotorFisico.setEmail(input.nextLine());

        sb = new StringBuilder();
        sb.append("\n----- Informacoes de Acesso -----\n").append("\nLogin: \n");
        System.out.println(sb.toString());
        promotorFisico.setUsuario(input.nextLine());

        sb = new StringBuilder();
        sb.append("\nSenha: \n");
        System.out.println(sb.toString());
        promotorFisico.setSenha(input.nextLine());

        return promotorFisico;
    }

    /**
     * Metodo responsável por simular a interface de um formulário com o usuário
     * Promotor.
     *
     * @return instancia de PromotorJuridico.
     */
    public static PromotorJuridico solCadPromotorJuridico() {
        PromotorJuridico promotorJuridico = new PromotorJuridico();

        StringBuilder sb = new StringBuilder();
        sb.append("----- Cadastro de Promotor do tipo Pessoa Física -----\n")
                .append("Nome da Pessoa Física Responsável: \n");
        System.out.println(sb.toString());
        promotorJuridico.setCpfResponsavel(input.nextLine());

        sb = new StringBuilder();
        sb.append("\nCPF da Pessoa Física Responsável: \n");
        System.out.println(sb.toString());
        promotorJuridico.setCpfResponsavel(input.nextLine());

        sb = new StringBuilder();
        sb.append("\nCNPJ: \n");
        System.out.println(sb.toString());
        promotorJuridico.setCnpj(input.nextLine());
        promotorJuridico.setFotoPerfil("");

        sb = new StringBuilder();
        sb.append("\nRazao Social: \n");
        System.out.println(sb.toString());
        promotorJuridico.setRazaoSocial(input.nextLine());

        sb = new StringBuilder();
        sb.append("\nData de Fundação: \n");
        System.out.println(sb.toString());
        promotorJuridico.setDataFundacao(input.nextLine());

        sb = new StringBuilder();
        sb.append("\nRedes Sociais: \n");
        System.out.println(sb.toString());
        promotorJuridico.setRedesSociais(input.nextLine());

        sb = new StringBuilder();
        sb.append("\nCategorias de Ações: \n");
        System.out.println(sb.toString());
        promotorJuridico.setCategoriasAcoes(input.nextLine());

        sb = new StringBuilder();
        sb.append("\nDescricao Geral: \n");
        System.out.println(sb.toString());
        promotorJuridico.setDescricaoGeral(input.nextLine());

        sb = new StringBuilder();
        sb.append("\nTelefone: \n");
        System.out.println(sb.toString());
        promotorJuridico.setTelefone(input.nextLine());

        sb = new StringBuilder();
        sb.append("\nEndereco: \n");
        System.out.println(sb.toString());
        promotorJuridico.setEndereco(input.nextLine());

        sb = new StringBuilder();
        sb.append("\nEmail: \n");
        System.out.println(sb.toString());
        promotorJuridico.setEmail(input.nextLine());

        sb = new StringBuilder();
        sb.append("\n----- Informacoes de Acesso -----\n").append("\nUsuario: \n");
        System.out.println(sb.toString());
        promotorJuridico.setUsuario(input.nextLine());

        sb = new StringBuilder();
        sb.append("\nSenha: \n");
        System.out.println(sb.toString());
        promotorJuridico.setSenha(input.nextLine());

        return promotorJuridico;
    }

    /**
     * Metodo responsável por simular a interface de um formulário com o usuário
     * Promotor.
     *
     * @param promotor instancia de promotor fisico.
     * @return instancia de PromotorFisico.
     */
    public static PromotorFisico formDadosAlteracao(final PromotorFisico promotor) {

        StringBuilder sb = new StringBuilder();

        sb.append("-----  Perfil de Promotor Pessoa Física -----\n").append("Nome da Pessoa: ")
                .append(promotor.getNomePessoa()).append("\n")
                .append("0 - para alterar este dado \n1 - para não alterar");
        System.out.println(sb.toString());
        int option = input.nextInt();
        promotor.setNomePessoa(option == 1 ? promotor.getNomePessoa() : lerTeclado());

        sb = new StringBuilder();
        sb.append("\nCPF do Responsável: ").append(promotor.getCpf()).append("\n")
                .append("0 - para alterar este dado \n1 - para não alterar");
        System.out.println(sb.toString());
        option = input.nextInt();
        promotor.setCpf(option == 1 ? promotor.getCpf() : lerTeclado());

        sb = new StringBuilder();
        sb.append("\nData de Nascimento (DDMMYYYY): ").append(promotor.getDataNascimento()).append("\n")
                .append("0 - para alterar este dado \n1 - para não alterar");
        System.out.println(sb.toString());
        option = input.nextInt();
        promotor.setDataNascimento(option == 1 ? promotor.getDataNascimento() : lerTeclado());
        promotor.setFotoPerfil("");

        sb = new StringBuilder();
        sb.append("\nCategorias de Ações: ").append(promotor.getCategoriasAcoes()).append("\n")
                .append("0 - para alterar este dado \n1 - para não alterar");
        System.out.println(sb.toString());
        option = input.nextInt();
        promotor.setCategoriasAcoes(option == 1 ? promotor.getDataNascimento() : lerTeclado());

        sb = new StringBuilder();
        sb.append("\nDescricao Geral: ").append(promotor.getDescricaoGeral()).append("\n")
                .append("0 - para alterar este dado \n1 - para não alterar");
        System.out.println(sb.toString());
        promotor.setDescricaoGeral(option == 1 ? promotor.getDescricaoGeral() : lerTeclado());

        sb = new StringBuilder();
        sb.append("\nTelefone: ").append(promotor.getTelefone()).append("\n")
                .append("0 - para alterar este dado \n1 - para não alterar");
        System.out.println(sb.toString());
        promotor.setTelefone(option == 1 ? promotor.getTelefone() : lerTeclado());

        sb = new StringBuilder();
        sb.append("\nEndereco: ").append(promotor.getEndereco()).append("\n")
                .append("0 - para alterar este dado \n1 - para não alterar");
        System.out.println(sb.toString());
        promotor.setEndereco(option == 1 ? promotor.getCpf() : lerTeclado());

        sb = new StringBuilder();
        sb.append("\nEmail: ").append(promotor.getEmail()).append("\n")
                .append("0 - para alterar este dado \n1 - para não alterar");
        System.out.println(sb.toString());
        promotor.setEmail(option == 1 ? promotor.getCpf() : lerTeclado());

        return promotor;

    }

    /**
     * Metodo responsável por simular a interface de um formulário com o usuário
     * Promotor.
     *
     * @param promotor instancia de promotor juridico.
     * @return instancia de PromotorJuridico.
     */
    public static PromotorJuridico formDadosAlteracaoPJ(final PromotorJuridico promotor) {

        StringBuilder sb = new StringBuilder();

        sb.append("-----  Perfil de Promotor Pessoa Jurídica -----\n").append("Nome da Pessoa Fisica Responsável: ")
                .append(promotor.getNomePessoaResponsavel()).append("\n")
                .append("0 - para alterar este dado \n1 - para não alterar");
        System.out.println(sb.toString());
        int option = input.nextInt();
        promotor.setNomePessoaResponsavel(option == 1 ? promotor.getNomePessoaResponsavel() : lerTeclado());

        sb = new StringBuilder();
        sb.append("\nCPF do Responsável: ").append(promotor.getCpfResponsavel()).append("\n")
                .append("0 - para alterar este dado \n1 - para não alterar");
        System.out.println(sb.toString());
        option = input.nextInt();
        promotor.setCpfResponsavel(option == 1 ? promotor.getCpfResponsavel() : lerTeclado());

        sb = new StringBuilder();
        sb.append("\nCNPJ: ").append(promotor.getCnpj()).append("\n")
                .append("0 - para alterar este dado \n1 - para não alterar");
        System.out.println(sb.toString());
        option = input.nextInt();
        promotor.setCnpj(option == 1 ? promotor.getCnpj() : lerTeclado());

        sb = new StringBuilder();
        sb.append("\nRazão Social: ").append(promotor.getRazaoSocial()).append("\n")
                .append("0 - para alterar este dado \n1 - para não alterar");
        System.out.println(sb.toString());
        option = input.nextInt();
        promotor.setRazaoSocial(option == 1 ? promotor.getRazaoSocial() : lerTeclado());

        sb = new StringBuilder();
        sb.append("\nData de Fundacao: ").append(promotor.getDataFundacao()).append("\n")
                .append("0 - para alterar este dado \n1 - para não alterar");
        System.out.println(sb.toString());
        option = input.nextInt();
        promotor.setDataFundacao(option == 1 ? promotor.getDataFundacao() : lerTeclado());

        sb = new StringBuilder();
        sb.append("\nFoto de Perfil: ").append(promotor.getFotoPerfil()).append("\n")
                .append("0 - para alterar este dado \n1 - para não alterar");
        System.out.println(sb.toString());
        option = input.nextInt();
        promotor.setFotoPerfil(option == 1 ? promotor.getFotoPerfil() : lerTeclado());

        sb = new StringBuilder();
        sb.append("\nRede Social: ").append(promotor.getRedesSociais()).append("\n")
                .append("0 - para alterar este dado \n1 - para não alterar");
        System.out.println(sb.toString());
        option = input.nextInt();
        promotor.setRedesSociais(option == 1 ? promotor.getRedesSociais() : lerTeclado());

        sb = new StringBuilder();
        sb.append("\nCategoria de Acoes: ").append(promotor.getCategoriasAcoes()).append("\n")
                .append("0 - para alterar este dado \n1 - para não alterar");
        System.out.println(sb.toString());
        option = input.nextInt();
        promotor.setCategoriasAcoes(option == 1 ? promotor.getCategoriasAcoes() : lerTeclado());

        sb = new StringBuilder();
        sb.append("\nDescricao Geral: ").append(promotor.getDescricaoGeral()).append("\n")
                .append("0 - para alterar este dado \n1 - para não alterar");
        System.out.println(sb.toString());
        option = input.nextInt();
        promotor.setDescricaoGeral(option == 1 ? promotor.getDescricaoGeral() : lerTeclado());

        sb = new StringBuilder();
        sb.append("\nTelefone: ").append(promotor.getTelefone()).append("\n")
                .append("0 - para alterar este dado \n1 - para não alterar");
        System.out.println(sb.toString());
        option = input.nextInt();
        promotor.setTelefone(option == 1 ? promotor.getTelefone() : lerTeclado());

        sb = new StringBuilder();
        sb.append("\nEndereco: ").append(promotor.getEndereco()).append("\n")
                .append("0 - para alterar este dado \n1 - para não alterar");
        System.out.println(sb.toString());
        option = input.nextInt();
        promotor.setEndereco(option == 1 ? promotor.getEndereco() : lerTeclado());

        sb = new StringBuilder();
        sb.append("\nEmail: ").append(promotor.getEmail()).append("\n")
                .append("0 - para alterar este dado \n1 - para não alterar");
        System.out.println(sb.toString());
        option = input.nextInt();
        promotor.setEmail(option == 1 ? promotor.getEmail() : lerTeclado());

        return promotor;

    }

    /**
     * Realiza a construção de uma String, que representa a solicitação dos dados
     * para cadastro de um voluntário.
     *
     * @return Instância de Voluntário;
     */
    public static Voluntario solCadVoluntario() {

        Voluntario voluntario = new Voluntario();

        StringBuilder sb = new StringBuilder();
        sb.append("----- Cadastro de Voluntário -----\n").append("Nome da Pessoa: \n");
        System.out.println(sb.toString());
        voluntario.setNome(input.nextLine());

        sb = new StringBuilder();
        sb.append("\nEmail: \n");
        System.out.println(sb.toString());
        String emailValido = input.nextLine();

        while (!isValidEmailAddress(emailValido)) {
            System.out.println("\nEmail inválido. Digite um email válido: \n");
            emailValido = input.nextLine();
        }
        voluntario.setEmail(emailValido);

        sb = new StringBuilder();
        sb.append("\nEndereco: \n");
        System.out.println(sb.toString());
        voluntario.setEndereco(input.nextLine());

        sb = new StringBuilder();
        sb.append("\nFormação/Profissão: \n");
        System.out.println(sb.toString());
        voluntario.setAreaDeAtuacao(input.nextLine());

        sb = new StringBuilder();
        sb.append("\nCategorias de Ações de interesse: \n");
        System.out.println(sb.toString());
        voluntario.setCategoriaInteresse(input.nextLine());

        sb = new StringBuilder();
        sb.append("\n----- Informacoes de Acesso -----\n").append("\nLogin: \n");
        System.out.println(sb.toString());
        voluntario.setUsuario(input.nextLine());

        sb = new StringBuilder();
        sb.append("\nSenha: \n");
        System.out.println(sb.toString());
        voluntario.setSenha(input.nextLine());

        return voluntario;
    }

    /**
     * Realiza a construção de uma String, que representa a solicitação dos dados
     * para edição de um voluntário.
     *
     * @param voluntario Voluntário a ser editado.
     * @return Voluntário com dados alterados.
     */
    public static Voluntario formDadosAlteracaoVoluntario(final Voluntario voluntario) {

        StringBuilder sb = new StringBuilder();

        sb.append("-----  Perfil de Voluntário -----\n").append("Nome da Pessoa: ").append(voluntario.getNome())
                .append("\n").append("0 - para alterar este dado \n1 - para não alterar");
        System.out.println(sb.toString());
        int option = input.nextInt();
        voluntario.setNome(option == 1 ? voluntario.getNome() : lerTeclado());

        sb = new StringBuilder();
        sb.append("\nEmail: ").append(voluntario.getEmail()).append("\n")
                .append("0 - para alterar este dado \n1 - para não alterar");
        System.out.println(sb.toString());
        voluntario.setEmail(option == 1 ? voluntario.getEmail() : lerTeclado());

        sb = new StringBuilder();
        sb.append("\nEndereco: ").append(voluntario.getEndereco()).append("\n")
                .append("0 - para alterar este dado \n1 - para não alterar");
        System.out.println(sb.toString());
        voluntario.setEndereco(option == 1 ? voluntario.getEndereco() : lerTeclado());

        sb = new StringBuilder();
        sb.append("\nFormação/Profissão: ").append(voluntario.getAreaDeAtuacao()).append("\n")
                .append("0 - para alterar este dado \n1 - para não alterar");
        System.out.println(sb.toString());
        option = input.nextInt();
        voluntario.setAreaDeAtuacao(option == 1 ? voluntario.getAreaDeAtuacao() : lerTeclado());

        sb = new StringBuilder();
        sb.append("\nCategorias de Ações de interesse: ").append(voluntario.getCategoriaInteresse()).append("\n")
                .append("0 - para alterar este dado \n1 - para não alterar");
        System.out.println(sb.toString());
        option = input.nextInt();
        voluntario.setCategoriaInteresse(option == 1 ? voluntario.getCategoriaInteresse() : lerTeclado());

        return voluntario;

    }

    /**
     * Metodo responsável pela leitura de entradas do teclado.
     *
     * @return string representando a linha de input.
     */
    static String lerTeclado() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n Informe o valor do campo: \n");

        return input.nextLine();
    }

    /**
     * Método que valida endereço de email.
     *
     * @param email String contendo endereço de email a ser validado.
     *
     * @return {@code true} se endereço de email é valido e {@code false} caso não
     *         seja.
     */
    public static boolean isValidEmailAddress(final String email) {
        boolean result = true;
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (AddressException ex) {
            result = false;
        }
        return result;
    }
}
