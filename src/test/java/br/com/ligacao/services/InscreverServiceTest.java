package br.com.ligacao.services;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import br.com.ligacao.persistence.model.Acao;

public class InscreverServiceTest {

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

    @After
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }

    @Test
    void cadastrar() {
    	Acao acao = new Acao();
    	acao.setNomeAcao("Banho do Bem");
    	acao.setNomePromotor("Banho do Bem");
        provideInput("1");
        assertThrows(NoSuchElementException.class, () -> {
            InscreverService.inscreverEmAcao(acao);
        });
    }
}
