package br.com.ligacao.persistence.model;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import org.junit.jupiter.api.Test;

class DAOtest {

    @Test
    void testPromotorDAO() throws IOException, InterruptedException, ExecutionException {
        PromotorFisico promotorFisicoTeste = new PromotorFisico("userTeste", "senhaTeste", "nomeTeste", 
                "325", "31/12/2099", "img", "http", "categoriaTeste", "descricaoTeste", 
                "12341234", "av. teste", "teste@teste");
        //cadastra promotor no banco firestore
        PromotorDAO.cadastraPromotorFisico(promotorFisicoTeste);
        
        //test o tipo de promotor cadastrado
        assertEquals(PromotorDAO.consultaTipoPromotor("nomeTeste"),
                "fisica");
        
        //test consulta de promotor fisico cadastrado
        PromotorFisico promotorFisicoTesteRetorno = PromotorDAO.retornaPromotorFisico("nomeTeste");
        assertEquals(promotorFisicoTesteRetorno.getNomePessoa(),"nomeTeste");
                
        //test consulta de login de promotor fisico cadastrado
        PromotorFisico promotorFisicoTesteLogin = PromotorDAO.loginPromotorFisico("userTeste", "senhaTeste");
        assertEquals(promotorFisicoTesteLogin.getNomePessoa(),"nomeTeste");
        //Senha incorreta
        assertEquals(PromotorDAO.loginPromotorFisico("userTeste", "SenhaIncorreta"), null);
        assertEquals(PromotorDAO.loginPromotorFisico("userTeste", null), null);
        //Usuario incorreto
        assertEquals(PromotorDAO.loginPromotorFisico("userIncorreto", "senhaTeste"), null);
        assertEquals(PromotorDAO.loginPromotorFisico(null, "SenhaIncorreta"), null);
                
        //test altera senha
        PromotorDAO.alteraSenha("nomeTeste", "userTeste", "senhaAlterada");
        PromotorFisico promotorFisicoTesteSenhaAlterada = PromotorDAO.loginPromotorFisico("userTeste", "senhaAlterada");
        assertEquals(promotorFisicoTesteSenhaAlterada.getNomePessoa(),"nomeTeste");

        //exclui cadastro de teste no banco firestore
        PromotorDAO.excluiPromotor("nomeTeste");
    }

}
