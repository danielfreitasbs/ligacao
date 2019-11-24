package br.com.ligacao.persistence.model;

import java.util.Objects;

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
	@SuppressWarnings("unused")
    private String tipoPessoa;

	public PromotorJuridico(String usuario, String senha,String nomePessoaResponsavel,
            String cpfResponsavel, String cnpj, String razaoSocial,
            String dataFundacao, String fotoPerfil, String redesSociais,
            String categoriasAcoes, String descricaoGeral, String telefone,
            String endereco, String email) {
        super(usuario, senha);
        this.nomePessoaResponsavel = nomePessoaResponsavel;
        this.cpfResponsavel = cpfResponsavel;
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.dataFundacao = dataFundacao;
        this.fotoPerfil = fotoPerfil;
        this.redesSociais = redesSociais;
        this.categoriasAcoes = categoriasAcoes;
        this.descricaoGeral = descricaoGeral;
        this.telefone = telefone;
        this.endereco = endereco;
        this.email = email;
    }

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
	
	public void setTipoPessoa(String tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public String getTipoPessoa() {
        return tipoPessoa;
    }

    @Override
    public int hashCode() {
      return Objects.hash( nomePessoaResponsavel,
      cpfResponsavel,
      cnpj,
      razaoSocial,
      dataFundacao,
      fotoPerfil,
      redesSociais,
      categoriasAcoes,
      descricaoGeral,
      telefone,
      endereco,
      email,
      tipoPessoa);
  }
}
