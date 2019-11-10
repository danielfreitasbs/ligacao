package br.com.ligacao.client.forms;

import java.util.Scanner;

import br.com.ligacao.persistence.model.Promotor;
import br.com.ligacao.persistence.model.PromotorFisico;
import br.com.ligacao.persistence.model.PromotorJuridico;

/**
 * Esta é uma classe utilitaria, usada para representação dos atributos de um
 * formulário de cadastro.
 * 
 * @author developer
 *
 */
public final class FormulariosSolicitacao {

	private static Scanner input = new Scanner(System.in);
	
	public static Promotor preencherForm() {
		Promotor promotor = new Promotor("Joãozinho do Tren�", "Ações Etílicas", "700.000.231-00", "02-02-2002",
				"Teste de Descrição Geral", "trenotunado@email.com", "imagem1.jpg", "instagram.com/meprocuraqueacha",
				"6299999999");
		return promotor;
	}

	public static Promotor preencherFormAlterado(String cpf) {
		Promotor promotor = new Promotor("Joãozinho do Trenó com Nó", "Ações Etílicas", cpf, "02-02-2002",
				"Teste de Descrição Geral", "trenotunado@email.com", "imagem1.jpg", "instagram.com/meprocuraqueacha",
				"6299999999");
		return promotor;
	}

	/**
	 * Realiza a construção de uma String, que representa a solicitação dos dados para cadastro de um Promotor do tipo pessoa física.
	 * 
	 * @return instancia de Promotor Física;
	 */
	public static PromotorFisico solCadPromotorFisico() {
		
		PromotorFisico promotorFisico = new PromotorFisico();
		
		StringBuilder sb = new StringBuilder();
		sb.append("----- Cadastro de Promotor do tipo Pessoa Física -----\n")
		.append("Nome da Pessoa: \n");
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
		sb.append("\n----- Informacoes de Acesso -----\n")
		.append("\nLogin: \n");
		System.out.println(sb.toString());
		promotorFisico.setUsuario(input.nextLine());
		
		sb = new StringBuilder();
		sb.append("\nSenha: \n");
		System.out.println(sb.toString());
		promotorFisico.setSenha(input.nextLine());
		
		
		return promotorFisico;
	}
	
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
		promotorJuridico.setCnpj(input.nextLine());;
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
		sb.append("\n----- Informacoes de Acesso -----\n")
		.append("\nUsuario: \n");
		System.out.println(sb.toString());
		promotorJuridico.setUsuario(input.nextLine());
		
		sb = new StringBuilder();
		sb.append("\nSenha: \n");
		System.out.println(sb.toString());
		promotorJuridico.setSenha(input.nextLine());
		
		return promotorJuridico;
	}
	
	public static PromotorFisico formDadosAlteracao(PromotorFisico promotor) {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("-----  Perfil de Promotor Pessoa Física -----\n")
		.append("Nome da Pessoa: ").append(promotor.getNomePessoa()).append("\n")
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
	
	public static PromotorJuridico formDadosAlteracaoPJ(PromotorJuridico promotor) {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("-----  Perfil de Promotor Pessoa Jurídica -----\n")
		.append("Nome da Pessoa Fisica Responsável: ").append(promotor.getNomePessoaResponsavel()).append("\n")
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
	
	static String lerTeclado() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n Informe o valor do campo \n");
		
		return input.nextLine();
	}
}
