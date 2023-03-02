package core.kswelder.cliente.utils;

import core.kswelder.cliente.model.Cartao;
import core.kswelder.cliente.model.Pix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "pix", url = "localhost:8083")
public interface PixRequest {

    @GetMapping(path = "/api/pix/find/{chave}")
    Pix requestPix(@PathVariable("chave") String chave);

    @DeleteMapping(path = "/api/pix/delete/{id}")
    Pix deletePix(@PathVariable("id") Long id);
}
