package core.kswelder.cliente.utils;

import core.kswelder.cliente.model.Cartao;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@FeignClient(name = "global-card", url = "localhost:8082")
public interface CartaoRequest {

    @PostMapping(path = "/api/cartao/save")
    Cartao requestCartao();

    @GetMapping(path = "/api/cartao/{id}")
    Cartao findCartao(@PathVariable("id") Long id);

    @DeleteMapping(path = "/api/cartao/delete/{id}")
    Cartao deleteCartao(@PathVariable("id") Long id);

}
