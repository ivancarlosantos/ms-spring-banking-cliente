package core.kswelder.cliente;

import core.kswelder.cliente.model.Cliente;
import core.kswelder.cliente.model.Conta;
import core.kswelder.cliente.status.ClienteStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Date;

@SpringBootTest
public class ClienteApplicationTests {

    @Test
    void testNomeCliente() {
        Cliente p = new Cliente();
        p.setNome("Fulano");
        Assertions.assertEquals("Fulano", p.getNome());
    }

    @Test
    void testNomeClienteNull() {
        Cliente p = new Cliente();
        p.setNome(null);
        Assertions.assertEquals(null, p.getNome());
    }

    @Test
    void testDataNascimento() {
        Cliente p = new Cliente();
        p.setDataDeNascimento("31/12/1800");
        Assertions.assertEquals("31/12/1800", p.getDataDeNascimento());
    }

    @Test
    void testDataNascimentoNull() {
        Cliente p = new Cliente();
        p.setDataDeNascimento(null);
        Assertions.assertEquals(null, p.getDataDeNascimento());
    }

    @Test
    void testSaldo() {
        Cliente p = new Cliente();
        p.setSaldo(BigDecimal.valueOf(1000));
        Assertions.assertEquals(BigDecimal.valueOf(1000), p.getSaldo());
    }

    @Test
    void testSaldoNull() {
        Cliente p = new Cliente();
        p.setSaldo(null);
        Assertions.assertEquals(null, p.getSaldo());
    }

    @Test
    void testDataCadastro() {
        Cliente p = new Cliente();
        p.setDataCadastro(new Date().toString());
        Assertions.assertEquals(new Date().toString(), p.getDataCadastro());
    }

    @Test
    void testDataCadastroError() {
        Cliente p = new Cliente();
        p.setDataCadastro(new Date().toString());
        Assertions.assertNotEquals(p.getDataCadastro(), "31/12/1800");
    }

    @Test
    void testDataCadastroNull() {
        Cliente p = new Cliente();
        p.setDataCadastro(null);
        Assertions.assertEquals(null, p.getDataCadastro());
    }

    @Test
    void testDataAtualizacaoCadastro() {
        Cliente p = new Cliente();
        p.setDataAtualizacaoCadastro(new Date().toString());
        Assertions.assertEquals(new Date().toString(), p.getDataAtualizacaoCadastro());
    }

    @Test
    void testDataAtualizacaoCadastroError() {
        Cliente p = new Cliente();
        p.setDataCadastro(new Date().toString());
        Assertions.assertNotEquals(p.getDataAtualizacaoCadastro(), "31/12/1800");
    }

    @Test
    void testDataAtualizacaoCadastroNull() {
        Cliente p = new Cliente();
        p.setDataAtualizacaoCadastro(null);
        Assertions.assertEquals(null, p.getDataAtualizacaoCadastro());
    }

    @Test
    void testEndereco() {
        Cliente p = new Cliente();
        p.setEndereco("13063580");
        Assertions.assertEquals("13063580", p.getEndereco());
    }

    @Test
    void testEnderecoError() {
        Cliente p = new Cliente();
        p.setEndereco("13063580");
        Assertions.assertNotEquals("13063240", p.getDataCadastro());
    }

    @Test
    void testEnderecoNull() {
        Cliente p = new Cliente();
        p.setEndereco(null);
        Assertions.assertEquals(null, p.getDataCadastro());
    }

    @Test
    void testClienteAtivo() {
        Cliente p = new Cliente();
        p.setStatus(ClienteStatus.ATIVO.toString());
        Assertions.assertEquals("ATIVO", p.getStatus());
    }

    @Test
    void testClienteInativo() {
        Cliente p = new Cliente();
        p.setStatus(ClienteStatus.INATIVO.toString());
        Assertions.assertEquals("INATIVO", p.getStatus());
    }

    @Test
    void testClienteStatusNull() {
        Cliente p = new Cliente();
        p.setStatus(null);
        Assertions.assertEquals(null, p.getStatus());
    }

    @Test
    void ContaID() {
        Conta conta = new Conta();
        Cliente cliente = new Cliente();
        cliente.setId(1L);
        conta.setId(1L);

        Assertions.assertEquals(conta.getId(), cliente.getId());
    }

}
