package core.kswelder.cliente.utils;

import core.kswelder.cliente.model.Cartao;
import core.kswelder.cliente.model.Conta;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "conta-agencia", url = "localhost:8084")
public interface ContaRequest {

    @PostMapping(path = "/api/conta/save")
    Conta generateConta();

    @GetMapping(path = "/api/conta/{id}")
    Conta findContaByID(@PathVariable("id") Long id);

    @DeleteMapping(path = "/api/conta/delete/{id}")
    Conta deleteConta(@PathVariable("id") Long id);
}
