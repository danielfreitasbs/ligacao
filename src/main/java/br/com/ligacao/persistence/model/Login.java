package br.com.ligacao.persistence.model;

import java.util.Objects;

/**
 * Classe representa a entidade de login do sistema.
 * 
 * @author danielfreitasbs.
 *
 */
public class Login {
  /**
   * Atributo representa o usuario do sistema.
   */
  private String usuario;
  /**
   * Atributo representa a senha do usuario.
   */
  private String senha;

  /**
   * Construtor default.
   */
  public Login() {

  }

  /**
   * Construtor com atributos.
   * 
   * @param usuario string representando o nome de usuario.
   * @param senha string representando a senha do usuario.
   */
  public Login(final String usuario, final String senha) {
    super();
    this.usuario = usuario;
    this.senha = senha;
  }

  /**
   * @return the usuario
   */
  public String getUsuario() {
    return usuario;
  }

  /**
   * @param usuario the usuario to set
   */
  public void setUsuario(final String usuario) {
    this.usuario = usuario;
  }

  /**
   * @return the senha
   */
  public String getSenha() {
    return senha;
  }

  /**
   * @param senha the senha to set
   */
  public void setSenha(final String senha) {
    this.senha = senha;
  }

  @Override
  public int hashCode() {
    return Objects.hash(usuario, senha);
  }
}
