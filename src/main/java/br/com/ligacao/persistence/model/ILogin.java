package br.com.ligacao.persistence.model;

public interface ILogin {

    boolean logarPromotor(String usuario, String senha);

    boolean logarVoluntario(String usuario, String senha);

}
