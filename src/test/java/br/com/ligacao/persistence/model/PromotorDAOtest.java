package br.com.ligacao.persistence.model;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import org.junit.jupiter.api.Test;
/**
 * Testes da classe PromotorDAO.
 */
class PromotorDAOtest {
/**
 * Testes da classe PromotorDAO para promotores físicos.
 * @throws IOException exceção de entrada e saída
 * @throws InterruptedException exceção de interrupção
 * @throws ExecutionException exceção de execução
 */
    @Test
    void testDAOPromotorFisico() throws IOException, InterruptedException, ExecutionException {
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
        assertEquals(promotorFisicoTesteRetorno.getNomePessoa(), "nomeTeste");

        //test consulta de login de promotor fisico cadastrado
        PromotorFisico promotorFisicoTesteLogin = PromotorDAO.loginPromotorFisico("userTeste", "senhaTeste");
        assertEquals(promotorFisicoTesteLogin.getNomePessoa(), "nomeTeste");
        //Senha incorreta
        assertEquals(PromotorDAO.loginPromotorFisico("userTeste", "SenhaIncorreta"), null);
        assertEquals(PromotorDAO.loginPromotorFisico("userTeste", null), null);
        //Usuario incorreto
        assertEquals(PromotorDAO.loginPromotorFisico("userIncorreto", "senhaTeste"), null);
        assertEquals(PromotorDAO.loginPromotorFisico(null, "SenhaIncorreta"), null);

        //test altera senha
        PromotorDAO.alteraSenha("nomeTeste", "userTeste", "senhaAlterada");
        PromotorFisico promotorFisicoTesteSenhaAlterada = PromotorDAO.loginPromotorFisico("userTeste", "senhaAlterada");
        assertEquals(promotorFisicoTesteSenhaAlterada.getNomePessoa(), "nomeTeste");

        //exclui cadastro de teste no banco firestore
        PromotorDAO.excluiPromotor("nomeTeste");
    }

/**
 * Testes da classe PromotorDAO para promotores jurídicos.
 * @throws IOException exceção de entrada e saída
 * @throws InterruptedException exceção de interrupção
 * @throws ExecutionException exceção de execução
 */
    @Test
    void testDAOPromotorJuridico() throws IOException, InterruptedException, ExecutionException {
        PromotorJuridico promotorJuridicoTeste = new PromotorJuridico("userTesteJ",
         "senhaTesteJ", "testeNomeResponsavel", "325", "0001", "testeRazaoSocial", "31/12/2099",
          "img", "http", "categoriaTeste", "descricaoteste",
                "12345678", "av. teste", "teste@test");
        //cadastra promotor no banco firestore
        PromotorDAO.cadastraPromotorJuridico(promotorJuridicoTeste);

        //test o tipo de promotor cadastrado
        assertEquals(PromotorDAO.consultaTipoPromotor("testeRazaoSocial"),
                "juridica");

        //test consulta de login de promotor juridico cadastrado
        PromotorJuridico promotorJuridicoTesteLogin = PromotorDAO.loginPromotorJuridico("userTesteJ", "senhaTesteJ");
        assertEquals(promotorJuridicoTesteLogin.getNomePessoaResponsavel(), "testeNomeResponsavel");

        //test consulta de promotor juridico cadastrado
        PromotorJuridico promotorJuridicoTesteRetorno = PromotorDAO.retornaPromotorJuridico("testeRazaoSocial");
        assertEquals(promotorJuridicoTesteRetorno.getNomePessoaResponsavel(), "testeNomeResponsavel");

        //Senha incorreta
        assertEquals(PromotorDAO.loginPromotorJuridico("userTesteJ", "SenhaIncorreta"), null);
        assertEquals(PromotorDAO.loginPromotorJuridico("userTesteJ", null), null);
        //Usuario incorreto
        assertEquals(PromotorDAO.loginPromotorJuridico("userIncorreto", "senhaTesteJ"), null);
        assertEquals(PromotorDAO.loginPromotorJuridico(null, "SenhaIncorreta"), null);

        //test altera senha
        PromotorDAO.alteraSenha("testeRazaoSocial", "userTesteJ", "senhaAlterada");
        PromotorJuridico promotorJuridicoTesteSenhaAlterada = PromotorDAO.
                loginPromotorJuridico("userTesteJ", "senhaAlterada");
        assertEquals(promotorJuridicoTesteSenhaAlterada.getNomePessoaResponsavel(), "testeNomeResponsavel");

        //exclui cadastro de teste no banco firestore
        PromotorDAO.excluiPromotor("testeRazaoSocial");
    }

}
