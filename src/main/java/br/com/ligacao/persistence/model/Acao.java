package br.com.ligacao.persistence.model;

import java.util.ArrayList;
import java.util.Objects;

public class Acao {
    private String nomePromotor;
    private String nomeAcao;
    private String categoriaAcao;
    private String dataRealizacao;
    private String descricao;
    private String horaInicio;
    private String horaFim;
    private ArrayList<String> emails = new ArrayList<String>();
    
    public Acao() {
        
    }

    public Acao(String nomePromotor, String nomeAcao, String categoriaAcao,
            String dataRealizacao, String descricao, String horaInicio,
            String horaFim) {
        super();
        this.nomePromotor = nomePromotor;
        this.nomeAcao = nomeAcao;
        this.categoriaAcao = categoriaAcao;
        this.dataRealizacao = dataRealizacao;
        this.descricao = descricao;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
    }
    public String getNomePromotor() {
        return nomePromotor;
    }
    public void setNomePromotor(String nomePromotor) {
        this.nomePromotor = nomePromotor;
    }
    public String getNomeAcao() {
        return nomeAcao;
    }
    public void setNomeAcao(String nomeAcao) {
        this.nomeAcao = nomeAcao;
    }
    public String getCategoriaAcao() {
        return categoriaAcao;
    }
    public void setCategoriaAcao(String categoriaAcao) {
        this.categoriaAcao = categoriaAcao;
    }
    public String getDataRealizacao() {
        return dataRealizacao;
    }
    public void setDataRealizacao(String dataRealizacao) {
        this.dataRealizacao = dataRealizacao;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String getHoraInicio() {
        return horaInicio;
    }
    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }
    public String getHoraFim() {
        return horaFim;
    }
    public void setHoraFim(String horaFim) {
        this.horaFim = horaFim;
    }
    public ArrayList<String> getEmails() {
		return emails;
	}
	public void setEmails(ArrayList<String> emails) {
		this.emails = emails;
	}

	@Override
    public int hashCode() {
      return Objects.hash(nomePromotor,
              nomeAcao,
              categoriaAcao,
              dataRealizacao,
              descricao,
              horaInicio,
              horaFim,
              emails);
  }

}
