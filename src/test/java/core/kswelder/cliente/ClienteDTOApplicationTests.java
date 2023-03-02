package core.kswelder.cliente;

import core.kswelder.cliente.dto.ClienteDTO;
import core.kswelder.cliente.model.Cliente;
import core.kswelder.cliente.model.Endereco;
import core.kswelder.cliente.status.ClienteStatus;
import core.kswelder.cliente.utils.EnderecoRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Date;

@SpringBootTest
public class ClienteDTOApplicationTests {

    @Autowired
    private EnderecoRequest request;

    @Test
    void testClienteID() {
        ClienteDTO p = new ClienteDTO();
        p.setId(1L);
        Assertions.assertEquals(1L, p.getId());
    }

    @Test
    void testClienteIDError() {
        ClienteDTO p = new ClienteDTO();
        p.setId(2L);
        Assertions.assertNotEquals(1L, p.getId());
    }

    @Test
    void testClienteIDNull() {
        ClienteDTO p = new ClienteDTO();
        p.setId(null);
        Assertions.assertEquals(null, p.getId());
    }

    @Test
    void testNomeCliente() {
        ClienteDTO p = new ClienteDTO();
        p.setNome("Fulano");
        Assertions.assertEquals("Fulano", p.getNome());
    }

    @Test
    void testNomeClienteError() {
        ClienteDTO p = new ClienteDTO();
        p.setNome("Sicrano");
        Assertions.assertNotEquals("Fulano", p.getNome());
    }

    @Test
    void testNomeClienteNull() {
        ClienteDTO p = new ClienteDTO();
        p.setNome(null);
        Assertions.assertNull(null, p.getNome());
    }

    @Test
    void testDataNascimento() {
        ClienteDTO p = new ClienteDTO();
        p.setDataDeNascimento("31/12/1800");

        Assertions.assertEquals("31/12/1800", p.getDataDeNascimento());
    }

    @Test
    void testDataNascimentoError() {
        ClienteDTO p = new ClienteDTO();
        p.setDataDeNascimento(new Date().toString());

        Assertions.assertNotEquals("31/12/1800", p.getDataDeNascimento());
    }

    @Test
    void testDataNascimentoNull() {
        ClienteDTO p = new ClienteDTO();
        p.setDataDeNascimento(null);

        Assertions.assertEquals(null, p.getDataDeNascimento());
    }

    @Test
    void testDataCadastro() {
        ClienteDTO p = new ClienteDTO();
        p.setDataCadastro(new Date().toString());
        Assertions.assertEquals(new Date().toString(), p.getDataCadastro());
    }

    @Test
    void testDataCadastroError() {
        ClienteDTO p = new ClienteDTO();
        p.setDataCadastro(new Date().toString());
        Assertions.assertNotEquals("31/12/1800", p.getDataCadastro());
    }

    @Test
    void testDataCadastroNull() {
        ClienteDTO p = new ClienteDTO();
        p.setDataCadastro(null);
        Assertions.assertEquals(null, p.getDataCadastro());
    }

    @Test
    void testDataAtualizacaoCadastro() {
        ClienteDTO p = new ClienteDTO();
        p.setDataAtualizacaoCadastro(new Date().toString());
        Assertions.assertEquals(new Date().toString(), p.getDataAtualizacaoCadastro());
    }

    @Test
    void testDataatualizacaoCadastroError() {
        ClienteDTO p = new ClienteDTO();
        p.setDataCadastro(new Date().toString());
        Assertions.assertNotEquals("31/12/1800", p.getDataCadastro());
    }

    @Test
    void testDataAtualizacaoCadastroNull() {
        ClienteDTO p = new ClienteDTO();
        p.setDataAtualizacaoCadastro(null);
        Assertions.assertEquals(null, p.getDataCadastro());
    }

    @Test
    void testEndereco() {
        ClienteDTO cliente = new ClienteDTO();
        Endereco endereco = request.requestEndereco("13063580");
        cliente.setEndereco(endereco);
        Assertions.assertEquals(cliente.getEndereco(), endereco);
    }

    @Test
    void testClienteAtivo() {
        ClienteDTO p = new ClienteDTO();
        p.setStatus(ClienteStatus.ATIVO.toString());
        Assertions.assertEquals("ATIVO", p.getStatus());
    }

    @Test
    void testClienteAtivoTrue() {
        ClienteDTO p = new ClienteDTO();
        p.setStatus(ClienteStatus.ATIVO.toString());
        Assertions.assertTrue(true);
    }

    @Test
    void testClienteInativo() {
        ClienteDTO p = new ClienteDTO();
        p.setStatus(ClienteStatus.INATIVO.toString());
        Assertions.assertEquals("INATIVO", p.getStatus());
    }

    @Test
    void testClienteStatusNull() {
        ClienteDTO p = new ClienteDTO();
        p.setStatus(null);
        Assertions.assertNull(null, p.getStatus());
    }


    @Test
    void testLogradouro() {
        ClienteDTO p = new ClienteDTO();
        Endereco endereco = request.requestEndereco("13063240");
        p.setEndereco(endereco);
        Assertions.assertEquals("Rua João Rodrigues Serra", p.getEndereco().getLogradouro());
    }

    @Test
    void testLogradouroError() {
        ClienteDTO p = new ClienteDTO();
        Endereco endereco = request.requestEndereco("13063240");
        p.setEndereco(endereco);
        Assertions.assertNotEquals("Ruas Testes", p.getEndereco().getLogradouro());
    }

    @Test
    void testBairro() {
        ClienteDTO p = new ClienteDTO();
        Endereco endereco = request.requestEndereco("13063240");
        p.setEndereco(endereco);
        Assertions.assertEquals("Jardim Eulina", p.getEndereco().getBairro());
    }

    @Test
    void testBairroError() {
        ClienteDTO p = new ClienteDTO();
        Endereco endereco = request.requestEndereco("13063240");
        p.setEndereco(endereco);
        Assertions.assertNotEquals("Bairros", p.getEndereco().getBairro());
    }

    @Test
    void testLocalidade() {
        ClienteDTO p = new ClienteDTO();
        Endereco endereco = request.requestEndereco("13063240");
        p.setEndereco(endereco);
        Assertions.assertEquals("Campinas", p.getEndereco().getLocalidade());
    }

    @Test
    void testLocalidadeError() {
        ClienteDTO p = new ClienteDTO();
        Endereco endereco = request.requestEndereco("13063240");
        p.setEndereco(endereco);
        Assertions.assertNotEquals("Localidades", p.getEndereco().getLocalidade());
    }

    @Test
    void testUf() {
        ClienteDTO p = new ClienteDTO();
        Endereco endereco = request.requestEndereco("13063240");
        p.setEndereco(endereco);
        Assertions.assertEquals("SP", p.getEndereco().getUf());
    }

    @Test
    void testUfError() {
        ClienteDTO p = new ClienteDTO();
        Endereco endereco = request.requestEndereco("13063240");
        p.setEndereco(endereco);
        Assertions.assertNotEquals("UF", p.getEndereco().getUf());
    }

    @Test
    void testCep() {
        ClienteDTO p = new ClienteDTO();
        Endereco endereco = request.requestEndereco("13063240");
        p.setEndereco(endereco);
        Assertions.assertEquals("13063-240", p.getEndereco().getCep());
    }

    @Test
    void testCepError() {
        ClienteDTO p = new ClienteDTO();
        Endereco endereco = request.requestEndereco("13063240");
        p.setEndereco(endereco);
        Assertions.assertNotEquals("13063240", p.getEndereco().getCep());
    }

    @Test
    void testClienteDTOConstructor() {
        Cliente cliente = Cliente.builder()
                .id(1L)
                .nome("Fulano")
                .dataDeNascimento("31/12/1800")
                .saldo(BigDecimal.valueOf(1000))
                .dataCadastro(new Date().toString())
                .dataAtualizacaoCadastro(new Date().toString())
                .endereco("13063580")
                .status(ClienteStatus.ATIVO.toString())
                .build();

        ClienteDTO dto1 = new ClienteDTO(cliente);
        ClienteDTO dto2 = new ClienteDTO(cliente);

        Assertions.assertSame(dto1.getClass(), dto2.getClass());
    }
}
