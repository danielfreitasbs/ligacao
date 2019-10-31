package br.com.ligacao.persistence.model;

import java.util.Objects;

public class Voluntario {
    private String nome;
    private String email;
    
    public Voluntario() {
        
    }
    
    public Voluntario(String nome, String email) {
        super();
        this.nome = nome;
        this.email = email;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nomePromotor) {
        this.nome = nomePromotor;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String categoriaAcao) {
        this.email = categoriaAcao;
    }
   
    
    @Override
    public int hashCode() {
      return Objects.hash( nome,
               email);
  }
}
