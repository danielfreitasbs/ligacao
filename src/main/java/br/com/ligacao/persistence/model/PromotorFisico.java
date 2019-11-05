package br.com.ligacao.persistence.model;

/**
 * Classe representante da entidade de promotor do tipo pessoa física.
 * 
 * @author danielfreitasbs
 *
 */
public class PromotorFisico extends Login {

	private String nomePessoa;
	private String cpf;
	private String dataNascimento;
	private String fotoPerfil;
	private String redesSociais;
	private String categoriasAcoes;
	private String descricaoGeral;
	private String telefone;
	private String endereco;
	private String email;


	public PromotorFisico(String usuario, String senha, String nomePessoa, String cpf, String dataNascimento,
			String fotoPerfil, String redesSociais, String categoriasAcoes, String descricaoGeral, String telefone,
			String endereco, String email) {
		super(usuario, senha);
		this.nomePessoa = nomePessoa;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.fotoPerfil = fotoPerfil;
		this.redesSociais = redesSociais;
		this.categoriasAcoes = categoriasAcoes;
		this.descricaoGeral = descricaoGeral;
		this.telefone = telefone;
		this.endereco = endereco;
		this.email = email;
	}
	
	public PromotorFisico(String usuario, String senha, PromotorFisico promotor) {
		
	}

	public PromotorFisico() {
	}

	public String getNomePessoa() {
		return nomePessoa;
	}

	public void setNomePessoa(String nomePessoa) {
		this.nomePessoa = nomePessoa;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
}
