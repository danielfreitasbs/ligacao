package br.com.ligacao;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertThrows;

class MainTest {
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
    public void interfaceOpcao0()  {
        provideInput("0");
        assertThrows(NoSuchElementException.class, () -> {
            Main.main(new String [0]);
        });
    }

    @Test
    public void interfaceOpcao1()  {
        provideInput("1");
        assertThrows(NoSuchElementException.class, () -> {
            Main.main(new String [0]);
        });
    }

    @Test
    public void interfaceOpcao2() {
        provideInput("2");
        assertThrows(NoSuchElementException.class, () -> {
            Main.main(new String [0]);
        });
    }


}