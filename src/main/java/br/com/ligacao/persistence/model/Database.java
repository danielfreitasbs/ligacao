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

import br.com.ligacao.persistence.connection.Connection;

/**
 * Classe responsável por gerenciar os dados com o banco Firestore.
 */
public class Database {  
    
    /**
     * Conexão com o banco Firestore
     */
    static Firestore db = Connection.getConnection();
        
    /**
     * Método responsável por cadastrar ou atualizar um novo 
     * promotor de ação no banco de dados Firebase.
     * Caso o registro não exista, um novo documento será criado,
     * caso já exista, as informações enviadas serão atualizadas.
     * 
     * @param promotor Objeto promotor de ação.
     * @param loginUsuario Objeto login do usuário.
     */
    public static void cadastraPromotor(Promotor promotor, Login loginUsuario) 
            throws IOException, InterruptedException, ExecutionException {
        
        String nomePromotor = promotor.getNomePromotor();
        String categoriaAcao = promotor.getCategoriaAcao();
        String cpfResponsavel = promotor.getCpfResponsavel();
        String dataFundacao = promotor.getDataFundacao();
        String descricao = promotor.getDescricao();
        String email = promotor.getEmail();
        String imagem = promotor.getImagem();
        String redeSocial = promotor.getRedeSocial();
        String telefone = promotor.getTelefone();
        String usuario = loginUsuario.getUsuario();
        String senha = loginUsuario.getSenha();
        
        Firestore db = Database.db;
        
        DocumentReference referenciaPromotor = db.collection("promotor de acao").document(nomePromotor);
        // Add document data using a hashmap
        Map<String, Object> promotorAcao = new HashMap<>();
        promotorAcao.put("nomePromotor", nomePromotor);
        promotorAcao.put("categoriaAcao", categoriaAcao);
        promotorAcao.put("cpfResponsavel", cpfResponsavel);
        promotorAcao.put("dataFundacao", dataFundacao);
        promotorAcao.put("descricao", descricao);
        promotorAcao.put("email", email);
        promotorAcao.put("imagem", imagem);
        promotorAcao.put("redeSocial", redeSocial);
        promotorAcao.put("telefone", telefone);
        //asynchronously write data
        ApiFuture<com.google.cloud.firestore.WriteResult> resultPromotor = referenciaPromotor.set(promotorAcao);
     // ...
        // result.get() blocks on response
        System.out.println("Update time : " + resultPromotor.get().getUpdateTime());
        
        DocumentReference referenciaLogin = db.collection("promotor de acao").document(nomePromotor)
                .collection("login").document("dados");
        
        // Add document data using a hashmap
        Map<String, Object> login = new HashMap<>();
        login.put("usuario", usuario);
        login.put("senha", senha);
        
        ApiFuture<com.google.cloud.firestore.WriteResult> resultLogin = referenciaLogin.set(login);
        // ...
           // result.get() blocks on response
           System.out.println("Update time : " + resultLogin.get().getUpdateTime());
    }

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
        
        Firestore db = Database.db;
        
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
        String nomeVoluntario = voluntario.getNome();
        String emailVoluntario = voluntario.getEmail();

        Firestore db = Database.db;
        
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
                
        Firestore db = Database.db;
        
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
     * Método responsável por consultar dados cadastrados
     * de um promotor de ação.
     * 
     * @param nomePromotor Nome do promotor da ação.
     * 
     * @return Retorna uma classe Promotor com os dados consultados.
     */
    public static Voluntario consultaPromotor(String nomePromotor) throws InterruptedException, ExecutionException {
        Firestore db = Database.db;
        
        DocumentReference docRef = db.collection("promotor de acao").document(nomePromotor);
        // asynchronously retrieve the document
        ApiFuture<DocumentSnapshot> future = docRef.get();
        // ...
        
        DocumentSnapshot document1 = future.get();

        Voluntario voluntario = null;
        if (document1.exists()) {
          // convert document to POJO
          voluntario = document1.toObject(Voluntario.class);
          System.out.println(voluntario);
        } else {
          System.out.println("No such document!");
        }
        
        //System.out.println(promotor.getRedeSocial());
        
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
        
        return voluntario;
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
        Firestore db = Database.db;
        
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
     * Método responsável por consultar nome de usuário
     * do login de um promotor de ação.
     * 
     * @param nomePromotor Nome do promotor da ação.
     * 
     * @return Retorna uma String com o nome de usuário.
     */
    public static String consultaUsuario(String nomePromotor) {
        Firestore db = Database.db;
        
        DocumentReference docRef = db.collection("promotor de acao").document(nomePromotor)
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
     * do login de um promotor de ação.
     * 
     * @param nomePromotor Nome do promotor da ação.
     * 
     * @return Retorna uma String com a senha de usuário.
     */
    public static String consultaSenha(String nomePromotor) {
        Firestore db = Database.db;
        
        DocumentReference docRef = db.collection("promotor de acao").document(nomePromotor)
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
    
    /**
     * Método responsável por alterar senha
     * do login de um promotor de ação.
     * 
     * @param nomePromotor Nome do promotor da ação.
     * @param senha Senha do usuário do promotor da ação.
     */
    public static void alteraSenha(Promotor promotor,
                            Login login) throws IOException, InterruptedException, ExecutionException {
        
        String nomePromotor = promotor.getNomePromotor();
        String senha = login.getSenha();
        
        Firestore db = Database.db;
        
       DocumentReference referenciaLogin = db.collection("promotor de acao").document(nomePromotor)
                .collection("login").document("dados");
        
        // Add document data using a hashmap
        Map<String, Object> loginMap = new HashMap<>();
        loginMap.put("senha", senha);
        
        ApiFuture<com.google.cloud.firestore.WriteResult> resultLogin = referenciaLogin.set(loginMap);
        // ...
           // result.get() blocks on response
           System.out.println("Update time : " + resultLogin.get().getUpdateTime());
    }

}

