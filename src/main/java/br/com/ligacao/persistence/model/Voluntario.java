package br.com.ligacao.persistence.model;

public class Voluntario extends Login  {
    private String nomeVoluntario;
    private String emailVoluntario;
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
        this.nomeVoluntario = nomeVoluntario;
        this.emailVoluntario = emailVoluntario;
        this.imagem = imagem;
        this.redeSocial = redeSocial;
        this.endereco = endereco;
        this.areaDeAtuacao = areaDeAtuacao;
        this.categoriaInteresse = categoriaInteresse;
    }

    public String getNomeVoluntario() {
		return nomeVoluntario;
	}

	public void setNomeVoluntario(String nomeVoluntario) {
		this.nomeVoluntario = nomeVoluntario;
	}

	public String getEmailVoluntario() {
		return emailVoluntario;
	}

	public void setEmailVoluntario(String emailVoluntario) {
		this.emailVoluntario = emailVoluntario;
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
