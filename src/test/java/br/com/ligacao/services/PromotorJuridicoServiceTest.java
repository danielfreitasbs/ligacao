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
        "testeNomeResponsavel", "325", "", "", "31/12/2099", "img", "http", "categoriaTeste",
        "descricaoteste", "12345678", "av. teste", "teste@test");

    assertThrows(AttributeNotFoundException.class, () -> {
      PromotorJuridicoService.cadastroPromotorJuridico(promotor);
    });

  }

  @Test
  void editar()
      throws InterruptedException, ExecutionException, AttributeNotFoundException, IOException {
    PromotorJuridico promotor = new PromotorJuridico("userTesteJ", "senhaTesteJ",
        "testeNomeResponsavel", "325", "111111111111", "", "31/12/2099", "img", "http",
        "categoriaTeste", "descricaoteste", "12345678", "av. teste", "teste@test");

    assertThrows(IllegalArgumentException.class, () -> {
      PromotorJuridicoService.editarPromotorJuridico(promotor);
    });

  }

  @Test
  void excluir()
      throws InterruptedException, ExecutionException, AttributeNotFoundException, IOException {
    PromotorJuridico promotor = new PromotorJuridico("userTesteJ", "senhaTesteJ",
        "testeNomeResponsavel", "325", "111111111111", "", "31/12/2099", "img", "http",
        "categoriaTeste", "descricaoteste", "12345678", "av. teste", "teste@test");

    assertThrows(IllegalArgumentException.class, () -> {
      PromotorJuridicoService.excluirPromotor(promotor);
    });

  }
}
