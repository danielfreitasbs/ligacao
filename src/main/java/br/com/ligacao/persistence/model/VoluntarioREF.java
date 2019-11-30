package br.com.ligacao.persistence.model;

import java.util.Objects;

import com.google.cloud.firestore.DocumentReference;
/**
 * Classe responsável por gerenciar os dados de referência
 * de voluntários cadastrados em ação no banco Firestore.
 */
public class VoluntarioREF {
    /**
     * Atributo da referência ao objeto Voluntario no banco.
     */
    private DocumentReference referencia;

    /**
     * Método construtor da classe.
     * @param referencia path da referência.
     */
    public VoluntarioREF(final DocumentReference referencia) {
        this.referencia = referencia;
    }

    /**
     * Método construtor da classe.
     */
    public VoluntarioREF() {
    }

    /**
     * Método get do atributo referência.
     * @return Path da referência.
     */
    public DocumentReference getReferencia() {
        return referencia;
    }

    /**
     * Método set do atributo referência.
     * @param referencia path da referência.
     */
    public void setReferencia(final DocumentReference referencia) {
        this.referencia = referencia;
    }

    @Override
    public int hashCode() {
      return Objects.hash(referencia);
  }
}
