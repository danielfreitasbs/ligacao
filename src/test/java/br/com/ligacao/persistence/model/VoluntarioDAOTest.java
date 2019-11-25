package br.com.ligacao.persistence.model;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.List;
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
                "nomeVoluntarioTeste", "emailVoluntarioTeste", "imagemTeste", "redeSocialTeste",
                "enderecoTeste", "areaDeAtuacaoTeste", "categoriaInteresseTeste");
        //cadastra voluntario no banco firestore
        VoluntarioDAO.cadastraVoluntario(voluntarioTeste);
        VoluntarioDAO.cadastraVoluntarioEmAcao("nomeTeste", "nomeAcaoTeste", voluntarioTeste);
        
        Voluntario voluntarioTeste2 = new Voluntario("usuarioTest2", "senhaTeste2", 
                "nomeVoluntarioTeste2", "emailVoluntarioTeste2", "imagemTeste2", "redeSocialTeste2",
                "enderecoTeste2", "areaDeAtuacaoTeste2", "categoriaInteresseTeste2");
        //cadastra voluntario no banco firestore
        VoluntarioDAO.cadastraVoluntario(voluntarioTeste2);
        
        //cadastra voluntarios em acao
        VoluntarioDAO.cadastraVoluntarioEmAcao("nomeTeste", "nomeAcaoTeste", voluntarioTeste);
        VoluntarioDAO.cadastraVoluntarioEmAcao("nomeTeste", "nomeAcaoTeste", voluntarioTeste2);
        
        //consulta voluntario
        List<Voluntario> voluntariosTeste = VoluntarioDAO.consultaVoluntarios("nomeTeste", "nomeAcaoTeste");
        assertEquals(voluntariosTeste.get(0).getNomeVoluntario(),"nomeVoluntarioTeste");
        assertEquals(voluntariosTeste.get(1).getNomeVoluntario(),"nomeVoluntarioTeste2");
        
        //exclui voluntario de uma acao
        VoluntarioDAO.excluiVoluntario("nomeTeste", "nomeAcaoTeste", "nomeVoluntarioTeste");
      //exclui voluntario de uma acao
        VoluntarioDAO.excluiVoluntario("nomeTeste", "nomeAcaoTeste", "nomeVoluntarioTeste2");
        //exclui acao de teste no banco firestore
        AcaoDAO.excluiAcao("nomeTeste", "nomeAcaoTeste");
        //exclui promotor de teste no banco firestore
        PromotorDAO.excluiPromotor("nomeTeste");
    }

}
