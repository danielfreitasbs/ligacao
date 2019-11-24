package br.com.ligacao.persistence.model;

import java.util.Objects;

import com.google.cloud.firestore.DocumentReference;

public class VoluntarioREF {
    private DocumentReference referencia;

    public VoluntarioREF(DocumentReference referencia) {
        this.referencia = referencia;
    }
    
    public VoluntarioREF() {
    }

    public DocumentReference getReferencia() {
        return referencia;
    }

    public void setReferencia(DocumentReference referencia) {
        this.referencia = referencia;
    }
    
    @Override
    public int hashCode() {
      return Objects.hash( referencia);
  }
    
}
