package core.kswelder.cliente;

import core.kswelder.cliente.model.Agencia;
import core.kswelder.cliente.model.Conta;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AgenciaApplicationTests {


    @Test
    void testAgenciaID() {
        Agencia agencia = new Agencia();
        agencia.setId(1L);
        Assertions.assertEquals(1L, agencia.getId());
    }

    @Test
    void testAgenciaIDError() {
        Agencia agencia = new Agencia();
        agencia.setId(1L);
        Assertions.assertNotEquals(2L, agencia.getId());
    }

    @Test
    void testAgenciaIDNull() {
        Agencia agencia = new Agencia();
        agencia.setId(null);
        Assertions.assertEquals(null, agencia.getAgencia());
    }

    @Test
    void testAgencia() {
        Conta p = new Conta();
        p.setAgencia("00012345-6");
        Assertions.assertEquals("00012345-6", p.getAgencia());
    }

    @Test
    void testAgenciaError() {
        Agencia agencia = new Agencia();
        agencia.setAgencia("11112345-7");
        Assertions.assertNotEquals("00012345-6", agencia.getAgencia());
    }

    @Test
    void testAgenciaNull() {
        Conta p = new Conta();
        p.setAgencia(null);
        Assertions.assertEquals(null, p.getAgencia());
    }
}
