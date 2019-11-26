package br.com.ligacao.persistence.model;

import java.util.Objects;

/**
 * Classe representante da entidade de promotor do tipo pessoa jurídica.
 * 
 * @author developer
 *
 */
public class PromotorJuridico extends Login {

  /**
   * Atributo representando nome da pessoa fisica responsável.
   */
  private String nomePessoaResponsavel;
  /**
   * Atributo representando cpf da pessoa fisica responsavel.
   */
  private String cpfResponsavel;
  /**
   * Atributo representando cnpj do promotor.
   */
  private String cnpj;
  /**
   * Atributo representando razao social do promotor.
   */
  private String razaoSocial;
  /**
   * Atributo representando data de fundacao do cnpj do promotor.
   */
  private String dataFundacao;
  /**
   * Atributo representando foto de perfil do promotor.
   */
  private String fotoPerfil;
  /**
   * Atributo representando link das redes sociais do promotor.
   */
  private String redesSociais;
  /**
   * Atributo representando lista de categorias atendidas pelo promotor.
   */
  private String categoriasAcoes;
  /**
   * Atributo representando descricao geral do promotor.
   */
  private String descricaoGeral;
  /**
   * Atributo representando numero de contato.
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
   * Metodo construtor utilizando de todos atributos da classe.
   * 
   * @param usuario para acesso.
   * @param senha para acesso.
   * @param nomePessoaResponsavel nome da pessoa fisica responsavel.
   * @param cpfResponsavel cpf da pessoa fisica responsavel.
   * @param cnpj do promotor.
   * @param razaoSocial do promotor.
   * @param dataFundacao do cnpj do promotor.
   * @param fotoPerfil string representando foto.
   * @param redesSociais string representando lista de links de redes sociais.
   * @param categoriasAcoes string representando categoria de acoes atendidas pelo promotor.
   * @param descricaoGeral string representando descricao geral do promotor.
   * @param telefone string para telefone.
   * @param endereco string para endereco completo.
   * @param email de contato do promotor.
   */
  public PromotorJuridico(final String usuario, final String senha,
      final String nomePessoaResponsavel, final String cpfResponsavel, final String cnpj,
      final String razaoSocial, final String dataFundacao, final String fotoPerfil,
      final String redesSociais, final String categoriasAcoes, final String descricaoGeral,
      final String telefone, final String endereco, final String email) {
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

  /**
   * construtor default.
   */
  public PromotorJuridico() {
    
  }

  /**
   * @return the nomePessoaResponsavel
   */
  public String getNomePessoaResponsavel() {
    return nomePessoaResponsavel;
  }

  /**
   * @param nomePessoaResponsavel the nomePessoaResponsavel to set
   */
  public void setNomePessoaResponsavel(final String nomePessoaResponsavel) {
    this.nomePessoaResponsavel = nomePessoaResponsavel;
  }

  /**
   * @return the cpfResponsavel
   */
  public String getCpfResponsavel() {
    return cpfResponsavel;
  }

  /**
   * @param cpfResponsavel the cpfResponsavel to set
   */
  public void setCpfResponsavel(final String cpfResponsavel) {
    this.cpfResponsavel = cpfResponsavel;
  }

  /**
   * @return the cnpj
   */
  public String getCnpj() {
    return cnpj;
  }

  /**
   * @param cnpj the cnpj to set
   */
  public void setCnpj(final String cnpj) {
    this.cnpj = cnpj;
  }

  /**
   * @return the razaoSocial
   */
  public String getRazaoSocial() {
    return razaoSocial;
  }

  /**
   * @param razaoSocial the razaoSocial to set
   */
  public void setRazaoSocial(final String razaoSocial) {
    this.razaoSocial = razaoSocial;
  }

  /**
   * @return the dataFundacao
   */
  public String getDataFundacao() {
    return dataFundacao;
  }

  /**
   * @param dataFundacao the dataFundacao to set
   */
  public void setDataFundacao(final String dataFundacao) {
    this.dataFundacao = dataFundacao;
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
   * hashcode com todos atributos do promotor.
   */
  @Override
  public int hashCode() {
    return Objects.hash(nomePessoaResponsavel, cpfResponsavel, cnpj, razaoSocial, dataFundacao,
        fotoPerfil, redesSociais, categoriasAcoes, descricaoGeral, telefone, endereco, email,
        tipoPessoa);
  }
}
