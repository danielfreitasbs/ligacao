package br.com.ligacao.services;

import static org.junit.jupiter.api.Assertions.assertThrows;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;
import java.util.concurrent.ExecutionException;
import javax.management.AttributeNotFoundException;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import br.com.ligacao.persistence.model.PromotorDAO;
import br.com.ligacao.persistence.model.PromotorFisico;

public class PromotorFisicoServiceTest {
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
    PromotorFisico promotor = new PromotorFisico("userTeste", "senhaTeste", "", "325", "31/12/2099",
        "img", "http", "categoriaTeste", "descricaoTeste", "12341234", "av. teste", "teste@teste");
    assertThrows(AttributeNotFoundException.class, () -> {
      PromotorFisicoService.cadastroPromotorFisico(promotor);
    });

    promotor.setNomePessoa("Daniel");
    assertThrows(IOException.class, () -> {
      PromotorFisicoService.cadastroPromotorFisico(promotor);
    });

    assertThrows(ExecutionException.class, () -> {
      PromotorFisicoService.cadastroPromotorFisico(promotor);
    });

    assertThrows(ExecutionException.class, () -> {
      PromotorFisicoService.cadastroPromotorFisico(promotor);
    });

    // exclui cadastro de teste no banco firestore
    PromotorDAO.excluiPromotor("Daniel");
  }

  @Test
  void editar()
      throws AttributeNotFoundException, IOException, InterruptedException, ExecutionException {
    PromotorFisico promotor = new PromotorFisico("userTeste", "senhaTeste", "", "325", "31/12/2099",
        "img", "http", "categoriaTeste", "descricaoTeste", "12341234", "av. teste", "teste@teste");
    PromotorFisicoService.cadastroPromotorFisico(promotor);

    assertThrows(IllegalArgumentException.class, () -> {
      PromotorFisicoService.editarPromotorFisico(promotor);
    });

    promotor.setNomePessoa("Daniel");

    assertThrows(ExecutionException.class, () -> {
      PromotorFisicoService.editarPromotorFisico(promotor);
    });

    assertThrows(InterruptedException.class, () -> {
      PromotorFisicoService.editarPromotorFisico(promotor);
    });

    // exclui cadastro de teste no banco firestore
    PromotorDAO.excluiPromotor("Daniel");
  }

  @Test
  void excluir()
      throws AttributeNotFoundException, IOException, InterruptedException, ExecutionException {
    PromotorFisico promotor = new PromotorFisico("userTeste", "senhaTeste", "", "325", "31/12/2099",
        "img", "http", "categoriaTeste", "descricaoTeste", "12341234", "av. teste", "teste@teste");
    PromotorFisicoService.cadastroPromotorFisico(promotor);

    assertThrows(IllegalArgumentException.class, () -> {
      PromotorFisicoService.excluirPromotor(promotor);
    });

    promotor.setNomePessoa("Daniel");

    assertThrows(InterruptedException.class, () -> {
      PromotorFisicoService.excluirPromotor(promotor);
    });

    assertThrows(ExecutionException.class, () -> {
      PromotorFisicoService.editarPromotorFisico(promotor);
    });

    // exclui cadastro de teste no banco firestore
    PromotorDAO.excluiPromotor("Daniel");
  }
}
