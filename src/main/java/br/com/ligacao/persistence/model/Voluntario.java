package br.com.ligacao.persistence.model;

import java.util.Objects;

public class Voluntario extends Login  {
    private String nome;
    private String email;
    
    public Voluntario() {
        
    }
    
    public Voluntario(String usuario, String senha, String nome, String email) {
        super(usuario, senha);
        this.nome = nome;
        this.email = email;
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
   
    
    @Override
    public int hashCode() {
      return Objects.hash( nome,
               email);
  }
}
