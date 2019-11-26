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
	void cadastrar() {
		provideInput("0");
		assertThrows(NoSuchElementException.class, () -> {
			PromotorJuridicoService.cadastroPromotorJuridico();
		});
	}

	@Test
	void editar() {
		assertThrows(NoSuchElementException.class, () -> {
			PromotorJuridicoService.editarPromotorJuridico();
		});
	}

	@Test
	void excluir() {
		provideInput("0");
		assertThrows(NoSuchElementException.class, () -> {
			PromotorJuridicoService.excluirPromotor();
		});
	}
}
