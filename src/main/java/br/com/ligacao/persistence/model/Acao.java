package br.com.ligacao.persistence.model;

import java.util.ArrayList;
import java.util.Objects;

public class Acao {

    /**
     * Atributo representando nome do promotor.
     */
    private String nomePromotor;

    /**
     * Atributo representando nome da ação.
     */
    private String nomeAcao;

    /**
     * Atributo com categoria da ação.
     */
    private String categoriaAcao;

    /**
     * Atributo da data de realização da ação.
     */
    private String dataRealizacao;

    /**
     * Atributo que descreve ação.
     */
    private String descricao;

    /**
     * Atributo de hora de início da ação.
     */
    private String horaInicio;

    /**
     * Atributo de hora de fim da ação.
     */
    private String horaFim;

    /**
     * Atributo com emails dos voluntários.
     */
    private ArrayList<String> emails = new ArrayList<String>();

    /**
     * Construtuor de ação.
     */
    public Acao() {

    }

    /**
     * Construtor com todos os atributos da classe ação.
     *
     * @param nomePromotor1 o nome do promotor da ação
     * @param nomeAcao1 o nome da ação
     * @param categoriaAcao1 a categoria da ação
     * @param dataRealizacao1 a data de realiação da ação
     * @param descricao1 a descrição da ação
     * @param horaInicio1 a hora de inicio da ação
     * @param horaFim1 a hora de fim da ação
     */
    public Acao(final String nomePromotor1, final String nomeAcao1,
                final String categoriaAcao1,
                final String dataRealizacao1, final String descricao1,
                final String horaInicio1,
                final String horaFim1) {
        super();
        this.nomePromotor = nomePromotor1;
        this.nomeAcao = nomeAcao1;
        this.categoriaAcao = categoriaAcao1;
        this.dataRealizacao = dataRealizacao1;
        this.descricao = descricao1;
        this.horaInicio = horaInicio1;
        this.horaFim = horaFim1;
    }

    /**
     * Método para obter o nome do promotor.
     * @return o nome do promotor
     */
    public String getNomePromotor() {
        return nomePromotor;
    }

    /**
     * Set o nome do promotor.
     * @param nomePromotor1 nome do promotor
     */
    public void setNomePromotor(final String nomePromotor1) {
        this.nomePromotor = nomePromotor1;
    }

    /**
     * Obtém o nome da ação.
     * @return o nome da ação
     */
    public String getNomeAcao() {
        return nomeAcao;
    }

    /**
     * Set o nome da ação.
     * @param nomeAcao1 o nome da ação
     */
    public void setNomeAcao(final String nomeAcao1) {
        this.nomeAcao = nomeAcao1;
    }

    /**
     * Obtém a categoria da ação.
     * @return a categoria da ação
     */
    public String getCategoriaAcao() {
        return categoriaAcao;
    }

    /**
     * Set a categoria da ação.
     * @param categoriaAcao1 a categoria da ação
     */
    public void setCategoriaAcao(final String categoriaAcao1) {
        this.categoriaAcao = categoriaAcao1;
    }

    /**
     * Obtém a data de realiação da ação.
     * @return a data de realização
     */
    public String getDataRealizacao() {
        return dataRealizacao;
    }

    /**
     * Set a data de realização da ação.
     * @param dataRealizacao1 a data de realização
     */
    public void setDataRealizacao(final String dataRealizacao1) {
        this.dataRealizacao = dataRealizacao1;
    }

    /**
     * Obtém a descrição da da ação.
     * @return a descritação da ação
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Set a descrição da ação.
     * @param descricao1 a descrição da ação
     */
    public void setDescricao(final String descricao1) {
        this.descricao = descricao1;
    }

    /**
     * Obtém a hora de início.
     * @return hora de início da ação
     */
    public String getHoraInicio() {
        return horaInicio;
    }

    /**
     * Set a hora de início.
     * @param horaInicio1 hora de final da ação
     */
    public void setHoraInicio(final String horaInicio1) {
        this.horaInicio = horaInicio1;
    }

    /**
     * Obtém hora de fim da ação.
     * @return hora de fim da ação
     */
    public String getHoraFim() {
        return horaFim;
    }

    /**
     * Set hora de fim da ação.
     * @param horaFim1 hora de fim da ação
     */
    public void setHoraFim(final String horaFim1) {
        this.horaFim = horaFim1;
    }

    /**
     * Obtém os e-mails dos voluntário.
     * @return array com emails dos voluntários
     */
    public ArrayList<String> getEmails() {
        return emails;
    }

    /**
     * Set emails.
     * @param emails1 emails dos voluntarios
     */
    public void setEmails(final ArrayList<String> emails1) {
        this.emails = emails1;
    }

    /**
     * Hashcode.
     * @return o objeto hash
     */
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
