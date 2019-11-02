package br.com.ligacao.persistence.connection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

/**
 * Classe responsável pela conexão com o Firestore.
 */
public class Connection {
    
    public static Firestore db = Connection.getConnection();
    
    /**
     * Método que retorna uma conexão com o banco Firestore
     *
     * @return objeto Firestore de conexão.
     */
    public static Firestore getConnection() {
        FileInputStream serviceAccount = null;
        try {
            serviceAccount = new FileInputStream("./.settings/ligacao-2121b-firebase-adminsdk-cpw8e-af2c81b80b.json");
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        FirebaseOptions options = null;
        try {
            options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
     // Initialize the default app
        FirebaseApp defaultApp = FirebaseApp.initializeApp(options);
        Firestore db = FirestoreClient.getFirestore(); 
        System.out.println(defaultApp.getName());  // "[DEFAULT]" 

        return db; 
    }
}
