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
     * Método responsável por cadastrar ou atualizar voluntários.
     *
     * @param voluntario Objeto voluntario.
     * @return uma referencia do voluntário cadastrado.
     * @throws IOException exceção de entrada e saída
     * @throws InterruptedException exceção de interrupção
     * @throws ExecutionException exceção de execução
     */
    public static DocumentReference cadastraVoluntario(final Voluntario voluntario)
                    throws IOException, InterruptedException, ExecutionException {

        String nomeVoluntario = voluntario.getNome();
        String emailVoluntario = voluntario.getEmail();
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
     * @param acao String com o nome do Objeto ação.
     * @param voluntario Objeto voluntario.
     * @throws IOException exceção de entrada e saída
     * @throws InterruptedException exceção de interrupção
     * @throws ExecutionException exceção de execução
     */
    public static void cadastraVoluntarioEmAcao(final String promotor, final String acao, final Voluntario voluntario)
                    throws IOException, InterruptedException, ExecutionException {

        Firestore db = Connection.db;

        DocumentReference referenciaVoluntario = cadastraVoluntario(voluntario);

        DocumentReference referenciaVoluntarioAcao = db.collection("promotor de acao").document(promotor)
                                               .collection("acoes").document(acao)
                                               .collection("voluntarios").document(voluntario.getNome());

        DocumentReference referenciaAcaoVoluntario = db.collection("voluntario").document(voluntario.getNome()).
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
     * @throws InterruptedException exceção de interrupção
     * @throws ExecutionException exceção de execução
     */
    public static List<Voluntario> consultaVoluntarios(final String nomePromotor,
            final String nomeAcao) throws InterruptedException, ExecutionException {

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

    /**
     * Método responsável por consultar a referência para
     * o cadastro de voluntarios cadastrados no banco.
     *
     * @param ponteiro referência de documento para um voluntário de uma ação.
     *
     * @return Retorna uma lista de objetos Voluntario.
     * @throws InterruptedException exceção de interrupção
     * @throws ExecutionException exceção de execução
     */
    public static DocumentReference consultaReferenciaVoluntario(
            final DocumentReference ponteiro) throws InterruptedException, ExecutionException {
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
     * @throws InterruptedException exceção de interrupção
     * @throws ExecutionException exceção de execução
     */
    public static void excluiVoluntario(final String nomePromotor,
        final String nomeAcao, final String voluntario)
        throws InterruptedException, ExecutionException {

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

    /**
     * Método responsável por consultar voluntários cadastrados.
     *
     * @return Retorna uma lista de objetos Promotor.
     * @throws InterruptedException exceção de interrupção
     * @throws ExecutionException exceção de execução
     */
    public static List<Voluntario> consultaVoluntarios()
            throws InterruptedException, ExecutionException {

        Firestore db = Connection.db;

        CollectionReference referenciaPromotores = db.collection("voluntario");

      //asynchronously retrieve multiple documents
        ApiFuture<QuerySnapshot> querySnapshot = referenciaPromotores.get();
        // future.get() blocks on response
        List<QueryDocumentSnapshot> documents = querySnapshot.get().getDocuments();
        List<Voluntario> voluntarios = new ArrayList<Voluntario>();
        for (DocumentSnapshot document : documents) {
          //System.out.println(document.getId() + " adicionado");
          voluntarios.add(document.toObject(Voluntario.class));
        }
        return voluntarios;
    }

    /**
     * Realiza as busca dos dados do Voluntario através de um usuario e senha
     * informado por parametro.
     *
     * @param user     nome de usuario cadastrado no perfil de voluntario.
     * @param password senha cadastrado no perfil de voluntario.
     *
     * @return caso seja encontrado o perfil de Voluntario com os parametros
     *             informados irá retornar uma instancia da classe com os atributos
     *             preenchidos. Caso contrario, deverá retornar NULL.
     * @throws InterruptedException exceção de interrupção
     * @throws ExecutionException exceção de execução
     */
    public static Voluntario login(final String user, final String password)
            throws InterruptedException, ExecutionException {
        List<Voluntario> voluntarios = new ArrayList<Voluntario>();

        voluntarios = consultaVoluntarios();

        for (Voluntario voluntario : voluntarios) {
            if (consultaUsuario(voluntario.getNome()).equals(user)
                    && consultaSenha(voluntario.getNome()).equals(password)) {
                    return voluntario;
            }
        }
        return null;
    }

    /**
     * Método responsável por consultar nome de usuário
     * do login de um voluntario.
     *
     * @param nomeVoluntario Nome do voluntario.
     *
     * @return Retorna uma String com o nome de usuário.
     * @throws ExecutionException exceção de execução
     * @throws InterruptedException exceção de interrupção
     */
    public static String consultaUsuario(final String nomeVoluntario)
     throws InterruptedException, ExecutionException {
        Firestore db = Connection.db;

        DocumentReference docRef = db.collection("voluntario").document(nomeVoluntario)
                                        .collection("login").document("dados");
        // asynchronously retrieve the document
        ApiFuture<DocumentSnapshot> future = docRef.get();
        // ...

        // future.get() blocks on response
        String document = null;
        try {
            document = future.get().getString("usuario");
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (document != null) {
            return document;
        } else {
            return null;
        }
    }

    /**
     * Método responsável por consultar senha
     * do login de um voluntario.
     *
     * @param nomeVoluntario Nome do voluntario.
     *
     * @return Retorna uma String com a senha de usuário.
     */
    public static String consultaSenha(final String nomeVoluntario) {
        Firestore db = Connection.db;

        DocumentReference docRef = db.collection("voluntario").document(nomeVoluntario)
                                        .collection("login").document("dados");
        // asynchronously retrieve the document
        ApiFuture<DocumentSnapshot> future = docRef.get();
        // ...

        // future.get() blocks on response
        String document = null;
        try {
            document = future.get().getString("senha");
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (document != null) {
            return document;
        } else {
            return null;
        }
    }
}
