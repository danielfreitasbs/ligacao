package br.com.ligacao.persistence.model;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import org.junit.jupiter.api.Test;

class VoluntarioDAOTest {

    @Test
    void testDAOVoluntario() throws IOException, InterruptedException, ExecutionException {
        PromotorFisico promotorFisicoTeste = new PromotorFisico("userTeste", "senhaTeste", "nomeTeste", 
                "325", "31/12/2099", "img", "http", "categoriaTeste", "descricaoTeste", 
                "12341234", "av. teste", "teste@teste");
        //cadastra promotor no banco firestore
        PromotorDAO.cadastraPromotorFisico(promotorFisicoTeste);

        Acao acaoTeste = new Acao("nomePromotorTeste", "nomeAcaoTeste", 
                "categoriaAcaoTest", "dataRealizacaoTeste", "descricaoTeste", 
                "horaInicioTeste", "horaFimTeste");
        //cadastra acao de teste no banco de dados Firestore
        AcaoDAO.cadastraAcao("nomeTeste", acaoTeste);
        
        Voluntario voluntarioTeste = new Voluntario("usuarioTest", "senhaTeste", 
                "nomeVoluntarioTeste", "emailVoluntarioTeste");
        //cadastra voluntario no banco firestore
        VoluntarioDAO.cadastraVoluntario(voluntarioTeste);
        VoluntarioDAO.cadastraVoluntarioEmAcao("nomeTeste", "nomeAcaoTeste", voluntarioTeste);
        
        
        //exclui voluntario de uma acao
        VoluntarioDAO.excluiVoluntario("nomeTeste", "nomeAcaoTeste", "nomeVoluntarioTeste");
    }

}
