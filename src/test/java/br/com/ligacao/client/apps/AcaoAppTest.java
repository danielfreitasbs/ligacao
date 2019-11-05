package br.com.ligacao.client.apps;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AcaoAppTest {

    @Test
    public void simuladorInterface() {

        InputStream sysInBackup = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
        System.setIn(in);

        AcaoApp acaoApp = new AcaoApp();
        //acaoApp.simuladorInterface();

        int test = 1;

        //assertEquals(0, 1);
        System.setIn(sysInBackup);
    }
}