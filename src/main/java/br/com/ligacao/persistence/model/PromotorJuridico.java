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
   * @param usuarioConstructor para acesso.
   * @param senhaConstructor para acesso.
   * @param nomePessoaResponsavelConstructor nome da pessoa fisica responsavel.
   * @param cpfResponsavelConstructor cpf da pessoa fisica responsavel.
   * @param cnpjConstructor do promotor.
   * @param razaoSocialConstructor do promotor.
   * @param dataFundacaoConstructor do cnpj do promotor.
   * @param fotoPerfilConstructor string representando foto.
   * @param redesSociaisConstructor string representando lista de links de redes sociais.
   * @param categoriasAcoesConstructor string representando categoria de acoes atendidas pelo
   *        promotor.
   * @param descricaoGeralConstructor string representando descricao geral do promotor.
   * @param telefoneConstructor string para telefone.
   * @param enderecoConstructor string para endereco completo.
   * @param emailConstructor de contato do promotor.
   */
  public PromotorJuridico(final String usuarioConstructor, final String senhaConstructor,
      final String nomePessoaResponsavelConstructor, final String cpfResponsavelConstructor,
      final String cnpjConstructor, final String razaoSocialConstructor,
      final String dataFundacaoConstructor, final String fotoPerfilConstructor,
      final String redesSociaisConstructor, final String categoriasAcoesConstructor,
      final String descricaoGeralConstructor, final String telefoneConstructor,
      final String enderecoConstructor, final String emailConstructor) {
    super(usuarioConstructor, senhaConstructor);
    this.nomePessoaResponsavel = nomePessoaResponsavelConstructor;
    this.cpfResponsavel = cpfResponsavelConstructor;
    this.cnpj = cnpjConstructor;
    this.razaoSocial = razaoSocialConstructor;
    this.dataFundacao = dataFundacaoConstructor;
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
  public PromotorJuridico() {

  }

  /**
   * @return the nomePessoaResponsavel
   */
  public String getNomePessoaResponsavel() {
    return nomePessoaResponsavel;
  }

  /**
   * @param nomePessoaResponsavelSet the nomePessoaResponsavel to set
   */
  public void setNomePessoaResponsavel(final String nomePessoaResponsavelSet) {
    this.nomePessoaResponsavel = nomePessoaResponsavelSet;
  }

  /**
   * @return the cpfResponsavel
   */
  public String getCpfResponsavel() {
    return cpfResponsavel;
  }

  /**
   * @param cpfResponsavelSet the cpfResponsavel to set
   */
  public void setCpfResponsavel(final String cpfResponsavelSet) {
    this.cpfResponsavel = cpfResponsavelSet;
  }

  /**
   * @return the cnpj
   */
  public String getCnpj() {
    return cnpj;
  }

  /**
   * @param cnpjSet the cnpj to set
   */
  public void setCnpj(final String cnpjSet) {
    this.cnpj = cnpjSet;
  }

  /**
   * @return the razaoSocial
   */
  public String getRazaoSocial() {
    return razaoSocial;
  }

  /**
   * @param razaoSocialSet the razaoSocial to set
   */
  public void setRazaoSocial(final String razaoSocialSet) {
    this.razaoSocial = razaoSocialSet;
  }

  /**
   * @return the dataFundacao
   */
  public String getDataFundacao() {
    return dataFundacao;
  }

  /**
   * @param dataFundacaoSet the dataFundacao to set
   */
  public void setDataFundacao(final String dataFundacaoSet) {
    this.dataFundacao = dataFundacaoSet;
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
    this.email = emailSet;
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

  /**
   * metodo equals.
   */
  @Override
  public boolean equals(final Object obj) {
    if (obj instanceof PromotorFisico) {
      PromotorJuridico qualquer = (PromotorJuridico) obj;
      return this.razaoSocial.equals(qualquer.getRazaoSocial());
    } else {
      return false;
    }
  }
}
