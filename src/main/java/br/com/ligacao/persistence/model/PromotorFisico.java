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
   * @param usuario para acesso.
   * @param senha para acesso.
   * @param nomePessoa string para pessoa fisica.
   * @param cpf string representando o cpf.
   * @param dataNascimento string representando a data de nascimento.
   * @param fotoPerfil string representado foto de perfil.
   * @param redesSociais string representando lista de links de redes sociais.
   * @param categoriasAcoes string representando lista de categorias de acoes atendidas pelo
   *        promotor.
   * @param descricaoGeral string representando descricao geral do promotor.
   * @param telefone string representando o numero de contato.
   * @param endereco representa endereco completo.
   * @param email representa email de contato.
   */
  public PromotorFisico(final String usuario, final String senha, final String nomePessoa,
      final String cpf, final String dataNascimento, final String fotoPerfil,
      final String redesSociais, final String categoriasAcoes, final String descricaoGeral,
      final String telefone, final String endereco, final String email) {
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
   * @param nomePessoa the nomePessoa to set
   */
  public void setNomePessoa(final String nomePessoa) {
    this.nomePessoa = nomePessoa;
  }

  /**
   * @return the cpf
   */
  public String getCpf() {
    return cpf;
  }

  /**
   * @param cpf the cpf to set
   */
  public void setCpf(final String cpf) {
    this.cpf = cpf;
  }

  /**
   * @return the dataNascimento
   */
  public String getDataNascimento() {
    return dataNascimento;
  }

  /**
   * @param dataNascimento the dataNascimento to set
   */
  public void setDataNascimento(final String dataNascimento) {
    this.dataNascimento = dataNascimento;
  }

  /**
   * @return the fotoPerfil
   */
  public String getFotoPerfil() {
    return fotoPerfil;
  }

  /**
   * @param fotoPerfil the fotoPerfil to set
   */
  public void setFotoPerfil(final String fotoPerfil) {
    this.fotoPerfil = fotoPerfil;
  }

  /**
   * @return the redesSociais
   */
  public String getRedesSociais() {
    return redesSociais;
  }

  /**
   * @param redesSociais the redesSociais to set
   */
  public void setRedesSociais(final String redesSociais) {
    this.redesSociais = redesSociais;
  }

  /**
   * @return the categoriasAcoes
   */
  public String getCategoriasAcoes() {
    return categoriasAcoes;
  }

  /**
   * @param categoriasAcoes the categoriasAcoes to set
   */
  public void setCategoriasAcoes(final String categoriasAcoes) {
    this.categoriasAcoes = categoriasAcoes;
  }

  /**
   * @return the descricaoGeral
   */
  public String getDescricaoGeral() {
    return descricaoGeral;
  }

  /**
   * @param descricaoGeral the descricaoGeral to set
   */
  public void setDescricaoGeral(final String descricaoGeral) {
    this.descricaoGeral = descricaoGeral;
  }

  /**
   * @return the telefone
   */
  public String getTelefone() {
    return telefone;
  }

  /**
   * @param telefone the telefone to set
   */
  public void setTelefone(final String telefone) {
    this.telefone = telefone;
  }

  /**
   * @return the endereco
   */
  public String getEndereco() {
    return endereco;
  }

  /**
   * @param endereco the endereco to set
   */
  public void setEndereco(final String endereco) {
    this.endereco = endereco;
  }

  /**
   * @return the email
   */
  public String getEmail() {
    return email;
  }

  /**
   * @param email the email to set
   */
  public void setEmail(final String email) {
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
}
