package core.kswelder.cliente;

import core.kswelder.cliente.model.Conta;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class ContaApplicationTests {


    @Test
    void testContaID() {
        Conta p = new Conta();
        p.setId(1L);
        Assertions.assertEquals(1L, p.getId());
    }

    @Test
    void testContaIDNull() {
        Conta p = new Conta();
        p.setId(null);
        Assertions.assertEquals(null, p.getConta());
    }

    @Test
    void testConta() {
        Conta p = new Conta();
        p.setConta("000012345");
        Assertions.assertEquals("000012345", p.getConta());
    }

    @Test
    void testContaNull() {
        Conta p = new Conta();
        p.setConta(null);
        Assertions.assertEquals(null, p.getConta());
    }

    @Test
    void testAgencia() {
        Conta p = new Conta();
        p.setAgencia("00012345-6");
        Assertions.assertEquals("00012345-6", p.getAgencia());
    }

    @Test
    void testAgenciaNull() {
        Conta p = new Conta();
        p.setAgencia(null);
        Assertions.assertEquals(null, p.getAgencia());
    }

    @Test
    void testAgenciaError() {
        Conta p = new Conta();
        p.setAgencia("00012345-6");
        Assertions.assertNotEquals("11112345-6", p.getAgencia());
    }

    @Test
    void testDataCriacaoError() {
        Conta conta = new Conta();
        conta.setDataCriacao(new Date().toString());
        Assertions.assertNotEquals(new Date().toString(), "31/12/1800");
    }

    @Test
    void testDataCriacaoNull() {
        Conta p = new Conta();
        p.setDataCriacao(null);
        Assertions.assertEquals(null, p.getDataCriacao());
    }

    @Test
    void testDataAtualizacao() {
        Conta p = new Conta();
        p.setDataCriacao(new Date().toString());
        Assertions.assertEquals(new Date().toString(), p.getDataCriacao());
    }

    @Test
    void testDataAtualizacaoError() {
        Conta p = new Conta();
        p.setDataCriacao(new Date().toString());
        Assertions.assertNotEquals(p.getDataAtualizacao(), "12/12/1800");
    }

    @Test
    void testDataAtualizacaoNull() {
        Conta p = new Conta();
        p.setDataAtualizacao(null);
        Assertions.assertEquals(null, p.getDataCriacao());
    }
}
