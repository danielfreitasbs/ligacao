package br.com.ligacao.services;

import static org.junit.jupiter.api.Assertions.assertThrows;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.concurrent.ExecutionException;
import javax.management.AttributeNotFoundException;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import br.com.ligacao.persistence.model.PromotorDAO;
import br.com.ligacao.persistence.model.PromotorJuridico;

public class PromotorJuridicoServiceTest {
  private final InputStream systemIn = System.in;
  private final PrintStream systemOut = System.out;

  private ByteArrayInputStream testIn;
  private ByteArrayOutputStream testOut;

  @Before
  public void setUpOutput() {
    testOut = new ByteArrayOutputStream();
    System.setOut(new PrintStream(testOut));
  }

  private void provideInput(String data) {
    testIn = new ByteArrayInputStream(data.getBytes());
    System.setIn(testIn);
  }

  private String getOutput() {
    return testOut.toString();
  }

  @After
  public void restoreSystemInputOutput() {
    System.setIn(systemIn);
    System.setOut(systemOut);
  }

  @Test
  void cadastrar() throws InterruptedException, ExecutionException {
    PromotorJuridico promotor = new PromotorJuridico("userTesteJ", "senhaTesteJ",
        "testeNomeResponsavel", "325", "", "testeRazaoSocial", "31/12/2099", "img", "http",
        "categoriaTeste", "descricaoteste", "12345678", "av. teste", "teste@test");

    assertThrows(AttributeNotFoundException.class, () -> {
      PromotorJuridicoService.cadastroPromotorJuridico(promotor);
    });

    promotor.setCnpj("111111111111");
    assertThrows(IOException.class, () -> {
      PromotorJuridicoService.cadastroPromotorJuridico(promotor);
    });

    assertThrows(ExecutionException.class, () -> {
      PromotorJuridicoService.cadastroPromotorJuridico(promotor);
    });

    assertThrows(ExecutionException.class, () -> {
      PromotorJuridicoService.cadastroPromotorJuridico(promotor);
    });

    // exclui cadastro de teste no banco firestore
    PromotorDAO.excluiPromotor("testeRazaoSocial");
  }

  @Test
  void editar()
      throws InterruptedException, ExecutionException, AttributeNotFoundException, IOException {
    PromotorJuridico promotor = new PromotorJuridico("userTesteJ", "senhaTesteJ",
        "testeNomeResponsavel", "325", "111111111111", "testeRazaoSocial", "31/12/2099", "img",
        "http", "categoriaTeste", "descricaoteste", "12345678", "av. teste", "teste@test");

    PromotorJuridicoService.cadastroPromotorJuridico(promotor);

    promotor.setRazaoSocial("");

    assertThrows(IllegalArgumentException.class, () -> {
      PromotorJuridicoService.editarPromotorJuridico(promotor);
    });

    promotor.setRazaoSocial("testeRazaoSocial");

    assertThrows(IOException.class, () -> {
      PromotorJuridicoService.editarPromotorJuridico(promotor);
    });

    assertThrows(ExecutionException.class, () -> {
      PromotorJuridicoService.editarPromotorJuridico(promotor);
    });

    assertThrows(ExecutionException.class, () -> {
      PromotorJuridicoService.editarPromotorJuridico(promotor);
    });

    // exclui cadastro de teste no banco firestore
    PromotorDAO.excluiPromotor("testeRazaoSocial");
  }

  @Test
  void excluir()
      throws InterruptedException, ExecutionException, AttributeNotFoundException, IOException {
    PromotorJuridico promotor = new PromotorJuridico("userTesteJ", "senhaTesteJ",
        "testeNomeResponsavel", "325", "111111111111", "testeRazaoSocial", "31/12/2099", "img",
        "http", "categoriaTeste", "descricaoteste", "12345678", "av. teste", "teste@test");

    PromotorJuridicoService.cadastroPromotorJuridico(promotor);

    promotor.setRazaoSocial("");

    assertThrows(IllegalArgumentException.class, () -> {
      PromotorJuridicoService.excluirPromotor(promotor);
    });

    promotor.setRazaoSocial("testeRazaoSocial");
    PromotorJuridicoService.cadastroPromotorJuridico(promotor);

    assertThrows(InterruptedException.class, () -> {
      PromotorJuridicoService.excluirPromotor(promotor);
    });

    assertThrows(ExecutionException.class, () -> {
      PromotorJuridicoService.excluirPromotor(promotor);
    });

    // exclui cadastro de teste no banco firestore
    PromotorDAO.excluiPromotor("testeRazaoSocial");
  }
}
