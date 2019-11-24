package br.com.ligacao.persistence.model;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import org.junit.jupiter.api.Test;

class AcaoDAOTest {

    @Test
    void testDAOAcao() throws IOException, InterruptedException, ExecutionException {
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
        
        //consulta acao de teste no banco de dados Firestore
        Acao testeConsultaAcao = AcaoDAO.consultaAcao("nomeTeste", "nomeAcaoTeste");
        assertEquals(testeConsultaAcao.getNomeAcao(), "nomeAcaoTeste");
        assertEquals(AcaoDAO.consultaAcao("nomeTeste", "AcaoNaoExistente"), null);
        
        //exclui acao de teste no banco firestore
        AcaoDAO.excluiAcao("nomeTeste", "nomeAcaoTeste");
            
        //exclui cadastro de teste no banco firestore
        PromotorDAO.excluiPromotor("nomeTeste");
    }

}
