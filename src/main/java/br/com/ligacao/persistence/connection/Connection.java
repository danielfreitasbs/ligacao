package br.com.ligacao.persistence.connection;

import java.io.FileInputStream;
import java.io.IOException;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.common.collect.Lists;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;


/**
 * Classe responsável pela conexão com o Firestore.
 */
public class Connection {

    /**
     * Atributo do tipo Firestore que contém uma conexão com o banco.
     */
    public static final Firestore db = Connection.getConnection();

    /**
     * Método que retorna uma conexão com o banco Firestore.
     * Caso não haja json no caminho especificado, o método
     * busca a chave na variavel de ambiente GOOGLE_APPLICATION_CREDENTIALS
     *
     * @return objeto Firestore de conexão.
     * @throws IOException
     */
    public static Firestore getConnection() {
        GoogleCredentials credentials = null;
        try {
            credentials = GoogleCredentials
                    .fromStream(new FileInputStream(
                        "./.settings/ligacao-2121b-firebase-adminsdk-cpw8e-af2c81b80b.json"))
                    .createScoped(Lists.newArrayList("https://www.googleapis.com/auth/cloud-platform"));
        } catch (IOException e) {
            try {
                credentials = GoogleCredentials.getApplicationDefault();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }

        FirebaseOptions options = null;
        options = new FirebaseOptions.Builder()
                .setCredentials(credentials)
                .build();
     // Initialize the default app
        FirebaseApp defaultApp = FirebaseApp.initializeApp(options);
        Firestore conexao = FirestoreClient.getFirestore();
        System.out.println(defaultApp.getName());  // "[DEFAULT]"

        return conexao;
    }
}
