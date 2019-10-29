package br.com.ligacao.persistence.model;

public class InscritoEmAcao {

	private String nomeVoluntario;
	private String emailVoluntario;
	private String nomeAcao;
	private String nomePromotor;
	
	public InscritoEmAcao(String nomeVoluntario, String emailVoluntario, String nomeAcao, String nomePromotor) {
		this.nomeVoluntario = nomeVoluntario;
		this.emailVoluntario = emailVoluntario;
		this.nomeAcao = nomeAcao;
		this.nomePromotor = nomePromotor;
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
	public String getNomeAcao() {
		return nomeAcao;
	}
	public void setNomeAcao(String nomeAcao) {
		this.nomeAcao = nomeAcao;
	}
	public String getNomePromotor() {
		return nomePromotor;
	}
	public void setNomePromotor(String nomePromotor) {
		this.nomePromotor = nomePromotor;
	}
}
