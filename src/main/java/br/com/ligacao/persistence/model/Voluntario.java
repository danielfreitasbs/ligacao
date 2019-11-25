package br.com.ligacao.persistence.model;

/**
 * Classe representante da entidade de voluntario.
 *
 * @author developer
 *
 */
public class Voluntario extends Login  {

    private String nome;
    private String email;
    private String imagem;
    private String redeSocial;
    private String endereco;
    private String areaDeAtuacao;
    private String categoriaInteresse;
    
    public Voluntario() {
        
    }
    
    public Voluntario(String usuario, String senha, String nomeVoluntario, String emailVoluntario,
    		String imagem, String redeSocial, String endereco,
    		String areaDeAtuacao, String categoriaInteresse) {
        super(usuario, senha);
        this.nome = nomeVoluntario;
        this.email = emailVoluntario;
        this.imagem = imagem;
        this.redeSocial = redeSocial;
        this.endereco = endereco;
        this.areaDeAtuacao = areaDeAtuacao;
        this.categoriaInteresse = categoriaInteresse;
    }
    public String getNome() {
		return nome;
	}

	public void setNome(String nomeVoluntario) {
		this.nome = nomeVoluntario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String emailVoluntario) {
		this.email = emailVoluntario;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public String getRedeSocial() {
		return redeSocial;
	}

	public void setRedeSocial(String redeSocial) {
		this.redeSocial = redeSocial;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getAreaDeAtuacao() {
		return areaDeAtuacao;
	}

	public void setAreaDeAtuacao(String areaDeAtuacao) {
		this.areaDeAtuacao = areaDeAtuacao;
	}

	public String getCategoriaInteresse() {
		return categoriaInteresse;
	}

	public void setCategoriaInteresse(String categoriaInteresse) {
		this.categoriaInteresse = categoriaInteresse;
	}
}
