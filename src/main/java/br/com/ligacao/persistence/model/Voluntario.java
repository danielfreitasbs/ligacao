package br.com.ligacao.persistence.model;

/**
 * Classe representante da entidade de voluntario.
 *
 * @author developer
 *
 */
public class Voluntario extends Login {

    /**
     * Nome do Voluntário.
     */
    private String nome;
    /**
     * E-mail do Voluntário.
     */
    private String email;
    /**
     * Imagem do Voluntário.
     */
    private String imagem;
    /**
     * Rede(s) Social(is) do Voluntário.
     */
    private String redeSocial;
    /**
     * Endereço do Voluntário.
     */
    private String endereco;
    /**
     * Profissão/Área de Atuação do Voluntário.
     */
    private String areaDeAtuacao;
    /**
     * Categorias de ações que o Voluntário tem interesse.
     */
    private String categoriaInteresse;

    /**
     * Construtor public para instanciar voluntário sem atributos.
     */
    public Voluntario() {

    }

    /**
     * Construtor com todos os atributos de voluntário.
     *
     * @param usuario            Usuário necessário para login.
     * @param senha              Senha necessária para login.
     * @param nomeVoluntario     Nome do voluntário.
     * @param emailVoluntario    Email do voluntário.
     * @param imagem             Imagem do voluntário.
     * @param redeSocial         Rede(s) social(is) do voluntário.
     * @param endereco           Endereço do voluntário.
     * @param areaDeAtuacao      Profissão/Área de atuação do voluntário.
     * @param categoriaInteresse Categorias de ações que o voluntário tem interesse.
     */
    public Voluntario(final String usuario, final String senha, final String nomeVoluntario,
            final String emailVoluntario, final String imagem, final String redeSocial, final String endereco,
            final String areaDeAtuacao, final String categoriaInteresse) {
        super(usuario, senha);
        this.nome = nomeVoluntario;
        this.email = emailVoluntario;
        this.imagem = imagem;
        this.redeSocial = redeSocial;
        this.endereco = endereco;
        this.areaDeAtuacao = areaDeAtuacao;
        this.categoriaInteresse = categoriaInteresse;
    }

    /**
     * Retorna nome do Voluntário.
     *
     * @return Nome do Voluntário.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define nome do Voluntário.
     *
     * @param nomeVoluntario Nome definido.
     */
    public void setNome(final String nomeVoluntario) {
        this.nome = nomeVoluntario;
    }

    /**
     * Retorna e-mail do Voluntário.
     *
     * @return E-mail do Voluntário.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Define e-mail do Voluntário.
     *
     * @param emailVoluntario E-mail definido.
     */
    public void setEmail(final String emailVoluntario) {
        this.email = emailVoluntario;
    }

    /**
     * Retorna imagem do Voluntário.
     *
     * @return Imagem do Voluntário.
     */
    public String getImagem() {
        return imagem;
    }

    /**
     * Define imagem do Voluntário.
     *
     * @param imagemVoluntario Imagem definida.
     */
    public void setImagem(final String imagemVoluntario) {
        this.imagem = imagemVoluntario;
    }

    /**
     * Retorna rede(s) social(is) do Voluntário.
     *
     * @return Rede(s) Social(is) do Voluntário.
     */
    public String getRedeSocial() {
        return redeSocial;
    }

    /**
     * Define rede(s) social(is) do Voluntário.
     *
     * @param redeSocialVoluntario Rede(s) social(is) definidas.
     */
    public void setRedeSocial(final String redeSocialVoluntario) {
        this.redeSocial = redeSocialVoluntario;
    }

    /**
     * Retorna endereço do Voluntário.
     *
     * @return Endereço do Voluntário.
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * Define endereço do Voluntário.
     *
     * @param enderecoVoluntario Endereço definido.
     */
    public void setEndereco(final String enderecoVoluntario) {
        this.endereco = enderecoVoluntario;
    }

    /**
     * Retorna profissão/área de atuação do Voluntário.
     *
     * @return Profissão/área de atuação do Voluntário.
     */
    public String getAreaDeAtuacao() {
        return areaDeAtuacao;
    }

    /**
     * Define profissão/área de atuação do Voluntário.
     *
     * @param areaDeAtuacaoVoluntario Profissãoqárea de atuação definina.
     */
    public void setAreaDeAtuacao(final String areaDeAtuacaoVoluntario) {
        this.areaDeAtuacao = areaDeAtuacaoVoluntario;
    }

    /**
     * Retorna categorias de ação que o voluntário tem interesse.
     *
     * @return Categorias de ação que o voluntário tem interesse.
     */
    public String getCategoriaInteresse() {
        return categoriaInteresse;
    }

    /**
     * Define categorias de ação que o voluntário tem interesse.
     *
     * @param categoriaInteresseVoluntario Categorias de ação que o voluntário tem interesse
     *                           definidas.
     */
    public void setCategoriaInteresse(final String categoriaInteresseVoluntario) {
        this.categoriaInteresse = categoriaInteresseVoluntario;
    }
}
