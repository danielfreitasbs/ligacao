package br.com.ligacao.persistence.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;

import br.com.ligacao.persistence.connection.Connection;

/**
 * Classe responsável por gerenciar os dados de voluntários no banco Firestore.
 */
public class VoluntarioDAO {
    
    /**
     * Método responsável por cadastrar ou atualizar voluntários
     * em ações cadastradas no banco de dados Firebase.
     * Caso o registro não exista, um novo documento será criado,
     * caso já exista, as informações enviadas serão atualizadas.
     * 
     * @param promotor Objeto promotor de ação.
     * @param acao Objeto ação.
     * @param voluntario Objeto voluntario.
     */
    public static void cadastraVoluntario(Promotor promotor, 
            Acao acao, Voluntario voluntario) 
                    throws IOException, InterruptedException, ExecutionException {
        
        String nomePromotor = promotor.getNomePromotor();
        String nomeAcao = acao.getNomeAcao();
        String nomeVoluntario = voluntario.getNomeVoluntario();
        String emailVoluntario = voluntario.getEmailVoluntario();

        Firestore db = Connection.db;
        
        DocumentReference referenciaVoluntario = db.collection("promotor de acao").document(nomePromotor)
                                               .collection("acoes").document(nomeAcao)
                                               .collection("voluntarios").document(nomeVoluntario);
        
        // Add document data using a hashmap
        Map<String, Object> voluntarios = new HashMap<>();
        voluntarios.put("nome", nomeVoluntario);
        voluntarios.put("email", emailVoluntario);
        //asynchronously write data
        ApiFuture<com.google.cloud.firestore.WriteResult> resultVoluntario = referenciaVoluntario.set(voluntarios);
        // ...
        // result.get() blocks on response
        System.out.println("Update time : " + resultVoluntario.get().getUpdateTime());
        
    }
    
    /**
     * Método responsável por consultar voluntarios cadastrados
     * em uma ação.
     * 
     * @param nomePromotor Nome do promotor da ação.
     * @param nomeAcao Nome da ação.
     * 
     * @return Retorna uma lista de objetos Voluntario.
     */
    public static List<Voluntario> consultaVoluntarios(String nomePromotor, 
            String nomeAcao) throws InterruptedException, ExecutionException {
                
        Firestore db = Connection.db;
        
        CollectionReference referenciaVoluntarios = db.collection("promotor de acao").document(nomePromotor)
                .collection("acoes").document(nomeAcao)
                .collection("voluntarios");
        
      //asynchronously retrieve multiple documents
        ApiFuture<QuerySnapshot> future = referenciaVoluntarios.get();
        // future.get() blocks on response
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();
        List<Voluntario> voluntarios = new ArrayList<Voluntario>();
        for (DocumentSnapshot document : documents) {
          //System.out.println(document.getId() + " adicionado");
          voluntarios.add(document.toObject(Voluntario.class));
        }
        return voluntarios;        
    }
    
    /**
     * Método responsável por excluir um voluntário de uma ação.
     * 
     * @param nomePromotor Nome do promotor da ação.
     * @param nomeAcao Nome da ação.
     * @param voluntario Voluntario a ser excluído
     */
    public static void excluiVoluntario(String nomePromotor, 
            String nomeAcao, String voluntario) throws InterruptedException, ExecutionException {

        Firestore db = Connection.db;
        
        DocumentReference referenciaVoluntario = db.collection("promotor de acao").document(nomePromotor)
                .collection("acoes").document(nomeAcao)
                .collection("voluntarios").document(voluntario);
        
     // asynchronously delete a document
        ApiFuture<WriteResult> writeResult = referenciaVoluntario.delete();
        // ...
        System.out.println("Update time : " + writeResult.get().getUpdateTime());
    }
}
