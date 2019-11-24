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
     *
     * @param voluntario Objeto voluntario.
     * @return 
     */
    public static DocumentReference cadastraVoluntario(Voluntario voluntario) 
                    throws IOException, InterruptedException, ExecutionException {
        
        
        String nomeVoluntario = voluntario.getNomeVoluntario();
        String emailVoluntario = voluntario.getEmailVoluntario();
        String usuario = voluntario.getUsuario();
        String senha = voluntario.getSenha();

        Firestore db = Connection.db;
        
        DocumentReference referenciaVoluntario = db.collection("voluntario").document(nomeVoluntario);
        
        // Add document data using a hashmap
        Map<String, Object> voluntarios = new HashMap<>();
        voluntarios.put("nome", nomeVoluntario);
        voluntarios.put("email", emailVoluntario);
        //asynchronously write data
        ApiFuture<com.google.cloud.firestore.WriteResult> resultVoluntario = referenciaVoluntario.set(voluntarios);
        // ...
        // result.get() blocks on response
        System.out.println("Update time : " + resultVoluntario.get().getUpdateTime());
        
     // Add document data using a hashmap
        Map<String, Object> login = new HashMap<String, Object>();
        login.put("usuario", usuario);
        login.put("senha", senha);
        
        DocumentReference referenciaLogin = db.collection("voluntario").document(nomeVoluntario)
                .collection("login").document("dados");
        
        ApiFuture<com.google.cloud.firestore.WriteResult> resultLogin = referenciaLogin.set(login);
        // ...
           // result.get() blocks on response
           System.out.println("Update time : " + resultLogin.get().getUpdateTime());
        
        return referenciaVoluntario;
        
    }
    
    /**
     * Método responsável por cadastrar ou atualizar voluntários
     * em ações cadastradas no banco de dados Firebase.
     * Caso o registro não exista, um novo documento será criado,
     * caso já exista, as informações enviadas serão atualizadas.
     * Caso o voluntario não tenha cadastro, um novo cadastro será
     * criado automaticamente.
     * 
     * @param promotor String com o nome do promotor de ação.
     * @param String com o nome do Objeto ação.
     * @param voluntario Objeto voluntario.
     */
    public static void cadastraVoluntarioEmAcao(String promotor, String acao, Voluntario voluntario) 
                    throws IOException, InterruptedException, ExecutionException {
        
        Firestore db = Connection.db;
        
        DocumentReference referenciaVoluntario = cadastraVoluntario(voluntario);
        
        DocumentReference referenciaVoluntarioAcao = db.collection("promotor de acao").document(promotor)
                                               .collection("acoes").document(acao)
                                               .collection("voluntarios").document(voluntario.getNomeVoluntario());
        
        DocumentReference referenciaAcaoVoluntario = db.collection("voluntario").document(voluntario.getNomeVoluntario()).
                                                collection("acoes").document(acao);
                
        // Add document data using a hashmap
        Map<String, Object> voluntarios = new HashMap<>();
        voluntarios.put("referencia", referenciaVoluntario);
        //asynchronously write data
        ApiFuture<com.google.cloud.firestore.WriteResult> resultVoluntario = referenciaVoluntarioAcao.set(voluntarios);
        // ...
        // result.get() blocks on response
        System.out.println("Update time : " + resultVoluntario.get().getUpdateTime());
        
     // Add document data using a hashmap
        Map<String, Object> acaoReg = new HashMap<>();
        acaoReg.put(acao, referenciaVoluntarioAcao);
        //asynchronously write data
        ApiFuture<com.google.cloud.firestore.WriteResult> resultAcaoVoluntario = referenciaAcaoVoluntario.set(acaoReg);
        // ...
        // result.get() blocks on response
        System.out.println("Update time : " + resultAcaoVoluntario.get().getUpdateTime());
        
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
         // System.out.println(document.getId() + " consultado");
            DocumentReference ref = (consultaReferenciaVoluntario(
                    referenciaVoluntarios.document(document.getId()))
                    );
            ApiFuture<DocumentSnapshot> future2 = ref.get();
            DocumentSnapshot document1 = future2.get();
            
          voluntarios.add(document1.toObject(Voluntario.class));
        }
        return voluntarios;        
    }
    
    public static DocumentReference consultaReferenciaVoluntario(
            DocumentReference ponteiro) throws InterruptedException, ExecutionException {
        ApiFuture<DocumentSnapshot> future = ponteiro.get();
        
        DocumentSnapshot document1 = future.get();
        
        VoluntarioREF ref = document1.toObject(VoluntarioREF.class);
        DocumentReference path = ref.getReferencia();
        return path;
        
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
        
        DocumentReference referenciaAcaoVoluntario = db.collection("promotor de acao").document(nomePromotor)
                .collection("acoes").document(nomeAcao)
                .collection("voluntarios").document(voluntario);
        
        DocumentReference referenciaVoluntarioAcao = db.collection("voluntario").document(voluntario)
                .collection("acoes").document(nomeAcao);
        
     // asynchronously delete a document
        ApiFuture<WriteResult> writeResult = referenciaAcaoVoluntario.delete();
     // asynchronously delete a document
        ApiFuture<WriteResult> writeResult2 = referenciaVoluntarioAcao.delete();
        // ...
        System.out.println("Update time : " + writeResult.get().getUpdateTime());
        System.out.println("Update time : " + writeResult2.get().getUpdateTime());
    }
}
