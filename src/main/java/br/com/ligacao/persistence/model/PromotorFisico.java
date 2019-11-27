package br.com.ligacao.persistence.model;

import java.util.Objects;

/**
 * Classe representante da entidade de promotor do tipo pessoa física.
 *
 * @author danielfreitasbs
 *
 */
public class PromotorFisico extends Login {

  /**
   * Atributo representando nome do promotor.
   */
  private String nomePessoa;
  /**
   * Atributo representando o cpf do promotor.
   */
  private String cpf;
  /**
   * Atributo representando a data de nascimento do promotor.
   */
  private String dataNascimento;
  /**
   * Atributo representando a foto de perfil do promotor.
   */
  private String fotoPerfil;
  /**
   * Atributo representando os links das redes sociais.
   */
  private String redesSociais;
  /**
   * Atributo representando uma lista de categorias de acoes atendidas pelo promotor.
   */
  private String categoriasAcoes;
  /**
   * Atributo representando descricao geral aberta do promotor.
   */
  private String descricaoGeral;
  /**
   * Atributo representando telefone do promotor.
   */
  private String telefone;
  /**
   * Atributo representando endereco do promotor.
   */
  private String endereco;
  /**
   * Atributo representando email do promotor.
   */
  private String email;
  /**
   * Atributo representando tipo de pessoa do promotor.
   */
  @SuppressWarnings("unused")
  private String tipoPessoa;

  /**
   * Construtor com todos os atributos da classe.
   *
   * @param usuarioConstructor para acesso.
   * @param senhaConstructor para acesso.
   * @param nomePessoaConstructor string para pessoa fisica.
   * @param cpfConstructor string representando o cpf.
   * @param dataNascimentoConstructor string representando a data de nascimento.
   * @param fotoPerfilConstructor string representado foto de perfil.
   * @param redesSociaisConstructor string representando lista de links de redes sociais.
   * @param categoriasAcoesConstructor string representando lista de categorias de acoes atendidas
   *        pelo promotor.
   * @param descricaoGeralConstructor string representando descricao geral do promotor.
   * @param telefoneConstructor string representando o numero de contato.
   * @param enderecoConstructor representa endereco completo.
   * @param emailConstructor representa email de contato.
   */
  public PromotorFisico(final String usuarioConstructor, final String senhaConstructor,
      final String nomePessoaConstructor, final String cpfConstructor,
      final String dataNascimentoConstructor, final String fotoPerfilConstructor,
      final String redesSociaisConstructor, final String categoriasAcoesConstructor,
      final String descricaoGeralConstructor, final String telefoneConstructor,
      final String enderecoConstructor, final String emailConstructor) {
    super(usuarioConstructor, senhaConstructor);
    this.nomePessoa = nomePessoaConstructor;
    this.cpf = cpfConstructor;
    this.dataNascimento = dataNascimentoConstructor;
    this.fotoPerfil = fotoPerfilConstructor;
    this.redesSociais = redesSociaisConstructor;
    this.categoriasAcoes = categoriasAcoesConstructor;
    this.descricaoGeral = descricaoGeralConstructor;
    this.telefone = telefoneConstructor;
    this.endereco = enderecoConstructor;
    this.email = emailConstructor;
  }

  /**
   * construtor default.
   */
  public PromotorFisico() {

  }

  /**
   * @return the nomePessoa
   */
  public String getNomePessoa() {
    return nomePessoa;
  }

  /**
   * @param nomePessoaSet the nomePessoa to set
   */
  public void setNomePessoa(final String nomePessoaSet) {
    this.nomePessoa = nomePessoaSet;
  }

  /**
   * @return the cpf
   */
  public String getCpf() {
    return cpf;
  }

  /**
   * @param cpfSet the cpf to set
   */
  public void setCpf(final String cpfSet) {
    this.cpf = cpfSet;
  }

  /**
   * @return the dataNascimento
   */
  public String getDataNascimento() {
    return dataNascimento;
  }

  /**
   * @param dataNascimentoSet the dataNascimento to set
   */
  public void setDataNascimento(final String dataNascimentoSet) {
    this.dataNascimento = dataNascimentoSet;
  }

  /**
   * @return the fotoPerfil
   */
  public String getFotoPerfil() {
    return fotoPerfil;
  }

  /**
   * @param fotoPerfilSet the fotoPerfil to set
   */
  public void setFotoPerfil(final String fotoPerfilSet) {
    this.fotoPerfil = fotoPerfilSet;
  }

  /**
   * @return the redesSociais
   */
  public String getRedesSociais() {
    return redesSociais;
  }

  /**
   * @param redesSociaisSet the redesSociais to set
   */
  public void setRedesSociais(final String redesSociaisSet) {
    this.redesSociais = redesSociaisSet;
  }

  /**
   * @return the categoriasAcoes
   */
  public String getCategoriasAcoes() {
    return categoriasAcoes;
  }

  /**
   * @param categoriasAcoesSet the categoriasAcoes to set
   */
  public void setCategoriasAcoes(final String categoriasAcoesSet) {
    this.categoriasAcoes = categoriasAcoesSet;
  }

  /**
   * @return the descricaoGeral
   */
  public String getDescricaoGeral() {
    return descricaoGeral;
  }

  /**
   * @param descricaoGeralSet the descricaoGeral to set
   */
  public void setDescricaoGeral(final String descricaoGeralSet) {
    this.descricaoGeral = descricaoGeralSet;
  }

  /**
   * @return the telefone
   */
  public String getTelefone() {
    return telefone;
  }

  /**
   * @param telefoneSet the telefone to set
   */
  public void setTelefone(final String telefoneSet) {
    this.telefone = telefoneSet;
  }

  /**
   * @return the endereco
   */
  public String getEndereco() {
    return endereco;
  }

  /**
   * @param enderecoSet the endereco to set
   */
  public void setEndereco(final String enderecoSet) {
    this.endereco = enderecoSet;
  }

  /**
   * @return the email
   */
  public String getEmail() {
    return email;
  }

  /**
   * @param emailSet the email to set
   */
  public void setEmail(final String emailSet) {
    this.email = email;
  }

  /**
   * @param tipoPessoa the tipoPessoa to set
   */
  public void setTipoPessoa(String tipoPessoa) {
      this.tipoPessoa = tipoPessoa;
  }

  /**
   * @return the tipoPessoa
   */
  public String getTipoPessoa() {
      return tipoPessoa;
  }

  /**
   * hashCode baseada nos atributos.
   */
  @Override
  public int hashCode() {
    return Objects.hash(nomePessoa, cpf, dataNascimento, fotoPerfil, redesSociais, categoriasAcoes,
        descricaoGeral, telefone, endereco, email, tipoPessoa);
  }

  /**
   * metodo equals.
   */
  @Override
  public boolean equals(final Object obj) {
    if (obj instanceof PromotorFisico) {
      PromotorFisico qualquer = (PromotorFisico) obj;
      return this.nomePessoa.equals(qualquer.getNomePessoa());
    } else {
      return false;
    }
  }
}
