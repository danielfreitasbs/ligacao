package br.com.ligacao.persistence.model;

/**
 * Classe representante da entidade de promotor do tipo pessoa jurídica.
 * 
 * @author developer
 *
 */
public class PromotorJuridico extends Login {

	private String nomePessoaResponsavel;
	private String cpfResponsavel;
	private String cnpj;
	private String razaoSocial;
	private String dataFundacao;
	private String fotoPerfil;
	private String redesSociais;
	private String categoriasAcoes;
	private String descricaoGeral;
	private String telefone;
	private String endereco;
	private String email;

	public PromotorJuridico() {
	}

	public String getNomePessoaResponsavel() {
		return nomePessoaResponsavel;
	}

	public void setNomePessoaResponsavel(String nomePessoaResponsavel) {
		this.nomePessoaResponsavel = nomePessoaResponsavel;
	}

	public String getCpfResponsavel() {
		return cpfResponsavel;
	}

	public void setCpfResponsavel(String cpfResponsavel) {
		this.cpfResponsavel = cpfResponsavel;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getDataFundacao() {
		return dataFundacao;
	}

	public void setDataFundacao(String dataFundacao) {
		this.dataFundacao = dataFundacao;
	}

	public String getFotoPerfil() {
		return fotoPerfil;
	}

	public void setFotoPerfil(String fotoPerfil) {
		this.fotoPerfil = fotoPerfil;
	}

	public String getRedesSociais() {
		return redesSociais;
	}

	public void setRedesSociais(String redesSociais) {
		this.redesSociais = redesSociais;
	}

	public String getCategoriasAcoes() {
		return categoriasAcoes;
	}

	public void setCategoriasAcoes(String categoriasAcoes) {
		this.categoriasAcoes = categoriasAcoes;
	}

	public String getDescricaoGeral() {
		return descricaoGeral;
	}

	public void setDescricaoGeral(String descricaoGeral) {
		this.descricaoGeral = descricaoGeral;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
