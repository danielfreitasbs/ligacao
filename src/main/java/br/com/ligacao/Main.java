package br.com.ligacao;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import br.com.ligacao.persistence.connection.Connection;
import br.com.ligacao.persistence.model.Database;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
    /*    Database.cadastraPromotor("Vida Lata", "Apoio Animais", "32132131",
        "13/01/1988", "ONG de auxilio a animais abandonados",
        "vidalata@gmail.com", "", "facebook/vidalata", "432141432", "vidalata", "123456");


Database.cadastraAcao("Vida Lata", "Campanha de adocao", "apoio animais", "12/10/2019",
        "Precisamos de voluntários para auxiliar nas tarefas doaçoes de animais", "12PM", "18PM");

Database.consultaPromotor("Vida Lata"); 
*/
        Database.cadastraVoluntario("Vida Lata", "Campanha de adocao", "otto", "otto@gmail.com");
        
      //  System.out.println(Database.consultaSenha("Vida Lata"));

    }

}
