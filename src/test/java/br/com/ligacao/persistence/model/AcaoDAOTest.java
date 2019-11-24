package br.com.ligacao.persistence.model;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
        
        Acao acaoTeste2 = new Acao("nomePromotorTeste", "nomeAcaoTeste2", 
                "categoriaAcaoTest", "dataRealizacaoTeste2", "descricaoTeste2", 
                "horaInicioTeste", "horaFimTeste");
        //cadastra segunda acao de teste no banco de dados Firestore
        AcaoDAO.cadastraAcao("nomeTeste", acaoTeste2);
        
        //consulta acao de teste no banco de dados Firestore
        Acao testeConsultaAcao = AcaoDAO.consultaAcao("nomeTeste", "nomeAcaoTeste");
        assertEquals(testeConsultaAcao.getNomeAcao(), "nomeAcaoTeste");
        assertEquals(AcaoDAO.consultaAcao("nomeTeste", "AcaoNaoExistente"), null);
        
        //consulta todas as acoes de um promotor
        List<Acao> acoes = new ArrayList<Acao>();
        acoes = AcaoDAO.consultaAcoes("nomeTeste");
        assertEquals(acoes.get(0).getNomeAcao(), "nomeAcaoTeste");
        assertEquals(acoes.get(1).getNomeAcao(), "nomeAcaoTeste2");
        
        //consulta todas as acoes existentes no banco de dados
        List<Acao> todasAcoes = new ArrayList<Acao>();
        todasAcoes = AcaoDAO.consultaTodasAcoes();
        assertFalse(todasAcoes.isEmpty());
        
        //exclui acao de teste no banco firestore
        AcaoDAO.excluiAcao("nomeTeste", "nomeAcaoTeste");
      //exclui acao de teste no banco firestore
        AcaoDAO.excluiAcao("nomeTeste2", "nomeAcaoTeste");
        //exclui promotor de teste no banco firestore
        PromotorDAO.excluiPromotor("nomeTeste");
    }

}
