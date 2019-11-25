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
     * @param nomePromotor Objeto promotor de ação.
     * @param acao Objeto ação.
     *
     * @throws IOException exceção de entrada e saída
     * @throws InterruptedException exceção de interrupção
     * @throws ExecutionException exceção de execução
     */
    public static void cadastraAcao(final String nomePromotor, final Acao acao)
            throws IOException, InterruptedException, ExecutionException {

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
        Map<String, Object> cadastroAcao = new HashMap<>();
        cadastroAcao.put("nomeAcao", nomeAcao);
        cadastroAcao.put("categoriaAcao", categoriaAcao);
        cadastroAcao.put("dataRealizacao", dataRealizacao);
        cadastroAcao.put("descricao", descricao);
        cadastroAcao.put("horaInicio", horaInicio);
        cadastroAcao.put("horaFim", horaFim);
        //asynchronously write data
        ApiFuture<com.google.cloud.firestore.WriteResult> resultAcao = referenciaAcao.set(cadastroAcao);
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
     *
     * @throws InterruptedException exceção de interrupção
     * @throws ExecutionException exceção de execução
     */
    public static List<Acao> consultaAcoes(final String nomePromotor)
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
     *
     * @throws InterruptedException exceção de interrupção
     * @throws ExecutionException exceção de execução
     */
    public static void excluiAcao(final String nomePromotor,
            final String nomeAcao) throws InterruptedException, ExecutionException {

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
     *
     * @throws InterruptedException exceção de interrupção
     * @throws ExecutionException exceção de execução
     */
    public static Acao consultaAcao(final String nomePromotor, final String nomeAcao)
    throws InterruptedException, ExecutionException {
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
        } catch (NullPointerException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (!document.exists()) {
            return null;
        }

        return acao;
    }

    /**
     * Método responsável por consultar todas as ações existentes.
     *
     * @return Retorna uma list de Acao com todas as ações.
     *
     * @throws InterruptedException exceção de interrupção
     * @throws ExecutionException exceção de execução
     */
    public static List<Acao> consultaTodasAcoes()
            throws InterruptedException, ExecutionException {

        Firestore db = Connection.db;

        List<Acao> acoes = new ArrayList<Acao>();

        List<PromotorFisico> promotoresF = new ArrayList<PromotorFisico>();
        promotoresF = PromotorDAO.consultaPromotoresFisicos();

        for (PromotorFisico documentoPromotor : promotoresF) {

            CollectionReference referenciaAcoes = db.collection("promotor de acao")
            .document(documentoPromotor.getNomePessoa())
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

        List<PromotorJuridico> promotoresJ = new ArrayList<PromotorJuridico>();
        promotoresJ = PromotorDAO.consultaPromotoresJuridicos();

        for (PromotorJuridico documentoPromotor : promotoresJ) {

            CollectionReference referenciaAcoes = db.collection("promotor de acao")
            .document(documentoPromotor.getRazaoSocial())
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
