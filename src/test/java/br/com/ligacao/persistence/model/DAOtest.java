package br.com.ligacao.persistence.model;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import org.junit.jupiter.api.Test;

class DAOtest {

    @Test
    void test() throws IOException, InterruptedException, ExecutionException {
        PromotorFisico promotorFisicoTeste = new PromotorFisico("userTeste", "senhaTeste", "nomeTeste", 
                "325", "31/12/2099", "img", "http", "categoriaTeste", "descricaoTeste", 
                "12341234", "av. teste", "teste@teste");
        //cadastra promotor no banco firestore
        PromotorDAO.cadastraPromotorFisico(promotorFisicoTeste);
        //testa o tipo de promotor cadastrado
        assertEquals(PromotorDAO.consultaTipoPromotor("nomeTeste"),
                "fisica");
        
        //exclui cadastro de teste no banco firestore
        PromotorDAO.excluiPromotor("nomeTeste");
    }

}
