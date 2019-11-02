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
 * Classe responsável por gerenciar os dados de ações no banco Firestore.
 */
public class AcaoDAO {
    
    /**
     * Método responsável por cadastrar ou atualizar uma nova 
     * ação de um promotor de ação no banco de dados Firebase.
     * Caso o registro não exista, um novo documento será criado,
     * caso já exista, as informações enviadas serão atualizadas.
     * 
     * @param promotor Objeto promotor de ação.
     * @param acao Objeto ação.
     */
    public static void cadastraAcao(Promotor promotor, Acao acao)
            throws IOException, InterruptedException, ExecutionException {

        String nomePromotor = promotor.getNomePromotor();
        String nomeAcao = acao.getNomeAcao();
        String categoriaAcao = acao.getCategoriaAcao();
        String dataRealizacao = acao.getDataRealizacao();
        String descricao = acao.getDescricao();
        String horaInicio = acao.getHoraInicio();
        String horaFim = acao.getHoraFim();
                
        Firestore db = Connection.db;
        
        DocumentReference referenciaAcao = db.collection("promotor de acao").document(nomePromotor)
                                               .collection("acoes").document(nomeAcao);
        
        // Add document data using a hashmap
        Map<String, Object> promotorAcao = new HashMap<>();
        promotorAcao.put("nomeAcao", nomeAcao);
        promotorAcao.put("categoriaAcao", categoriaAcao);
        promotorAcao.put("dataRealizacao", dataRealizacao);
        promotorAcao.put("descricao", descricao);
        promotorAcao.put("horaInicio", horaInicio);
        promotorAcao.put("horaFim", horaFim);
        //asynchronously write data
        ApiFuture<com.google.cloud.firestore.WriteResult> resultAcao = referenciaAcao.set(promotorAcao);
        // ...
        // result.get() blocks on response
        System.out.println("Update time : " + resultAcao.get().getUpdateTime());
        
    }
    
    /**
     * Método responsável por consultar ações cadastradas
     * em um promotor de ação.
     * 
     * @param nomePromotor Nome do promotor da ação.
     * 
     * @return Retorna uma lista de objetos Acao.
     */
    public static List<Acao> consultaAcoes(String nomePromotor)
            throws InterruptedException, ExecutionException {
                
        Firestore db = Connection.db;
        
        CollectionReference referenciaAcoes = db.collection("promotor de acao").document(nomePromotor)
                .collection("acoes");
        
      //asynchronously retrieve multiple documents
        ApiFuture<QuerySnapshot> future = referenciaAcoes.get();
        // future.get() blocks on response
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();
        List<Acao> acoes = new ArrayList<Acao>();
        for (DocumentSnapshot document : documents) {
          //System.out.println(document.getId() + " adicionado");
          acoes.add(document.toObject(Acao.class));
        }
        return acoes;        
    }
    
    /**
     * Método responsável por excluir uma ação.
     * 
     * @param nomePromotor Nome do promotor da ação.
     * @param nomeAcao Nome da ação a ser excluída.
     */
    public static void excluiAcao(String nomePromotor, 
            String nomeAcao) throws InterruptedException, ExecutionException {

        Firestore db = Connection.db;
        
        DocumentReference referenciaAcao = db.collection("promotor de acao").document(nomePromotor)
                .collection("acoes").document(nomeAcao);
        
     // asynchronously delete a document
        ApiFuture<WriteResult> writeResult = referenciaAcao.delete();
        // ...
        System.out.println("Update time : " + writeResult.get().getUpdateTime());
    }
    
    /**
     * Método responsável por consultar dados cadastrados
     * de uma ação.
     * 
     * @param nomePromotor Nome do promotor da ação.
     * @param nomeAcao Nome da ação.
     * 
     * @return Retorna uma classe Acao com os dados consultados.
     */
    public static Acao consultaAcao(String nomePromotor, String nomeAcao) throws InterruptedException, ExecutionException {
        Firestore db = Connection.db;
        
        DocumentReference docRef = db.collection("promotor de acao").document(nomePromotor)
                                    .collection("acoes").document(nomeAcao);
        // asynchronously retrieve the document
        ApiFuture<DocumentSnapshot> future = docRef.get();
        // ...
        
        DocumentSnapshot document1 = future.get();

        Acao acao = null;
        if (document1.exists()) {
          // convert document to POJO
          acao = document1.toObject(Acao.class);
          System.out.println(acao);
        } else {
          System.out.println("No such document!");
        }
        
        // future.get() blocks on response
        DocumentSnapshot document = null;
        try {
            document = future.get();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (document.exists()) {
            System.out.println("Document data: " + document.getData());
        } else {
            System.out.println("No such document!");
        }
        
        return acao;
    }
    
    /**
     * Método responsável por consultar dados cadastrados
     * de uma ação.
     * 
     * @param nomePromotor Nome do promotor da ação.
     * @param nomeAcao Nome da ação.
     * 
     * @return Retorna uma classe Acao com os dados consultados.
     */
    public static List<Acao> consultaTodasAcoes()
            throws InterruptedException, ExecutionException {
                
        Firestore db = Connection.db;
        
        List<Promotor> promotores = new ArrayList<Promotor>();
        List<Acao> acoes = new ArrayList<Acao>();
        promotores = PromotorDAO.consultaPromotores();
        
        for (Promotor documentoPromotor : promotores) {
        
            CollectionReference referenciaAcoes = db.collection("promotor de acao").document(documentoPromotor.getNomePromotor())
                    .collection("acoes");
            
          //asynchronously retrieve multiple documents
            ApiFuture<QuerySnapshot> future = referenciaAcoes.get();
            // future.get() blocks on response
            List<QueryDocumentSnapshot> documents = future.get().getDocuments();
            for (DocumentSnapshot document : documents) {
              //System.out.println(document.getId() + " adicionado");
              acoes.add(document.toObject(Acao.class));
            }
        }
        return acoes;        
    }
}
