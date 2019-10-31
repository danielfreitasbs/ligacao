package br.com.ligacao.persistence.model;

import java.util.Objects;

public class Login {
    private String usuario;
    private String senha;
    
    public Login() {
        
    }
    
    public Login(String usuario, String senha) {
        super();
        this.usuario = usuario;
        this.senha = senha;
    }
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String nomePromotor) {
        this.usuario = nomePromotor;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String categoriaAcao) {
        this.senha = categoriaAcao;
    }
   
    
    @Override
    public int hashCode() {
      return Objects.hash( usuario,
               senha);
  }
}
