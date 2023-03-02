package core.kswelder.cliente;

import core.kswelder.cliente.model.Endereco;
import core.kswelder.cliente.utils.EnderecoRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EnderecoApplicationTests {

    @Autowired
    private EnderecoRequest request;

    @Test
    void testLogradouro() {
        Endereco endereco = request.requestEndereco("13063240");
        Endereco test = new Endereco();
        test.setLogradouro(endereco.getLogradouro());
        Assertions.assertEquals("Rua João Rodrigues Serra", test.getLogradouro());
    }

    @Test
    void testLogradouroError() {
        Endereco test = new Endereco();
        Endereco endereco = request.requestEndereco("13063240");
        test.setLogradouro(endereco.getLogradouro());
        Assertions.assertNotEquals("Ruas Testes", test.getLogradouro());
    }

    @Test
    void testLogradouroNull() {
        Endereco test = new Endereco();
        Endereco endereco = request.requestEndereco("13063240");
        test.setLogradouro(null);
        Assertions.assertEquals(null, test.getLogradouro());
    }

    @Test
    void testBairro() {
        Endereco test = new Endereco();
        Endereco endereco = request.requestEndereco("13063240");
        test.setBairro(endereco.getBairro());
        Assertions.assertEquals("Jardim Eulina", test.getBairro());
    }

    @Test
    void testBairroError() {
        Endereco test = new Endereco();
        Endereco endereco = request.requestEndereco("13063240");
        test.setBairro(endereco.getBairro());
        Assertions.assertNotEquals("Bairros", test.getBairro());
    }

    @Test
    void testBairroNull() {
        Endereco test = new Endereco();
        Endereco endereco = request.requestEndereco("13063240");
        test.setBairro(null);
        Assertions.assertEquals(null, test.getBairro());
    }

    @Test
    void testLocalidade() {
        Endereco test = new Endereco();
        Endereco endereco = request.requestEndereco("13063240");
        test.setLocalidade(endereco.getLocalidade());
        Assertions.assertEquals("Campinas", test.getLocalidade());
    }

    @Test
    void testLocalidadeError() {
        Endereco test = new Endereco();
        Endereco endereco = request.requestEndereco("13063240");
        test.setLocalidade(endereco.getLocalidade());
        Assertions.assertNotEquals("Localidades", test.getLocalidade());
    }

    @Test
    void testLocalidadeNull() {
        Endereco test = new Endereco();
        Endereco endereco = request.requestEndereco("13063240");
        test.setLocalidade(null);
        Assertions.assertEquals(null, test.getLocalidade());
    }

    @Test
    void testUf() {
        Endereco test = new Endereco();
        Endereco endereco = request.requestEndereco("13063240");
        test.setUf(endereco.getUf());
        Assertions.assertEquals("SP", test.getUf());
    }

    @Test
    void testUfError() {
        Endereco test = new Endereco();
        Endereco endereco = request.requestEndereco("13063240");
        test.setUf(endereco.getUf());
        Assertions.assertNotEquals("UF", test.getUf());
    }

    @Test
    void testUfNull() {
        Endereco test = new Endereco();
        Endereco endereco = request.requestEndereco("13063240");
        test.setUf(null);
        Assertions.assertEquals(null, test.getUf());
    }

    @Test
    void testCep() {
        Endereco test = new Endereco();
        Endereco endereco = request.requestEndereco("13063240");
        test.setCep(endereco.getCep());
        Assertions.assertEquals("13063-240", test.getCep());
    }

    @Test
    void testCepError() {
        Endereco test = new Endereco();
        Endereco endereco = request.requestEndereco("13063240");
        test.setCep(endereco.getCep());
        Assertions.assertNotEquals("13063240", test.getCep());
    }

    @Test
    void testCepNull() {
        Endereco test = new Endereco();
        Endereco endereco = request.requestEndereco("13063240");
        test.setCep(null);
        Assertions.assertEquals(null, test.getCep());
    }
}
