package br.com.ligacao.persistence.model;

import java.util.Objects;

public class Voluntario {
    private String nomeVoluntario;
    private String emailVoluntario;
    
    public Voluntario() {
        
    }
    
    public Voluntario(String nomeVoluntario, String emailVoluntario) {
        super();
        this.nomeVoluntario = nomeVoluntario;
        this.emailVoluntario = emailVoluntario;
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
   
    
    @Override
    public int hashCode() {
      return Objects.hash( nomeVoluntario,
               emailVoluntario);
  }
}
