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
     * @param nomePromotor   o nome do promotor da ação
     * @param nomeAcao       o nome da ação
     * @param categoriaAcao  a categoria da ação
     * @param dataRealizacao a data de realiação da ação
     * @param descricao      a descrição da ação
     * @param horaInicio     a hora de inicio da ação
     * @param horaFim        a hora de fim da ação
     */
    public Acao(final String nomePromotor, final String nomeAcao,
                final String categoriaAcao,
                final String dataRealizacao, final String descricao,
                final String horaInicio,
                final String horaFim) {
        super();
        this.nomePromotor = nomePromotor;
        this.nomeAcao = nomeAcao;
        this.categoriaAcao = categoriaAcao;
        this.dataRealizacao = dataRealizacao;
        this.descricao = descricao;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
    }

    /**
     * Método para obter o nome do promotor.
     *
     * @return o nome do promotor
     */
    public String getNomePromotor() {
        return nomePromotor;
    }

    /**
     * Set o nome do promotor.
     *
     * @param nomePromotor nome do promotor
     */
    public void setNomePromotor(final String nomePromotor) {
        this.nomePromotor = nomePromotor;
    }

    /**
     * Obtém o nome da ação.
     *
     * @return o nome da ação
     */
    public String getNomeAcao() {
        return nomeAcao;
    }

    /**
     * Set o nome da ação.
     *
     * @param nomeAcao o nome da ação
     */
    public void setNomeAcao(final String nomeAcao) {
        this.nomeAcao = nomeAcao;
    }

    /**
     * Obtém a categoria da ação.
     *
     * @return a categoria da ação
     */
    public String getCategoriaAcao() {
        return categoriaAcao;
    }

    /**
     * Set a categoria da ação.
     *
     * @param categoriaAcao a categoria da ação
     */
    public void setCategoriaAcao(final String categoriaAcao) {
        this.categoriaAcao = categoriaAcao;
    }

    /**
     * Obtém a data de realiação da ação.
     *
     * @return a data de realização
     */
    public String getDataRealizacao() {
        return dataRealizacao;
    }

    /**
     * Set a data de realização da ação.
     *
     * @param dataRealizacao a data de realização
     */
    public void setDataRealizacao(final String dataRealizacao) {
        this.dataRealizacao = dataRealizacao;
    }

    /**
     * Obtém a descrição da da ação.
     *
     * @return a descritação da ação
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Set a descrição da ação.
     *
     * @param descricao a descrição da ação
     */
    public void setDescricao(final String descricao) {
        this.descricao = descricao;
    }

    /**
     * Obtém a hora de início.
     *
     * @return hora de início da ação
     */
    public String getHoraInicio() {
        return horaInicio;
    }

    /**
     * Set a hora de início.
     *
     * @param horaInicio hora de final da ação
     */
    public void setHoraInicio(final String horaInicio) {
        this.horaInicio = horaInicio;
    }

    /**
     * Obtém hora de fim da ação.
     *
     * @return hora de fim da ação
     */
    public String getHoraFim() {
        return horaFim;
    }

    /**
     * Set hora de fim da ação.
     *
     * @param horaFim hora de fim da ação
     */
    public void setHoraFim(final String horaFim) {
        this.horaFim = horaFim;
    }

    /**
     * Obtém os e-mails dos voluntário.
     *
     * @return array com emails dos voluntários
     */
    public ArrayList<String> getEmails() {
        return emails;
    }

    /**
     * Set emails.
     *
     * @param emails emails dos voluntarios
     */
    public void setEmails(final ArrayList<String> emails) {
        this.emails = emails;
    }

    /**
     * Hashcode.
     *
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
