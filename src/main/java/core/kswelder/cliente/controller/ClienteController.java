package core.kswelder.cliente.controller;

import core.kswelder.cliente.dto.ClienteDTO;
import core.kswelder.cliente.model.*;
import core.kswelder.cliente.service.ClienteService;
import core.kswelder.cliente.utils.CartaoRequest;
import core.kswelder.cliente.utils.ContaRequest;
import core.kswelder.cliente.utils.EnderecoRequest;
import core.kswelder.cliente.utils.PixRequest;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.QueryParam;
import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @Autowired
    ContaRequest contaRequest;

    @Autowired
    EnderecoRequest request;

    @Autowired
    CartaoRequest cartaoRequest;

    @Autowired
    PixRequest pixRequest;

    @Autowired
    RabbitTemplate template;

    @PostMapping(path = "/cliente/save")
    public ResponseEntity<ClienteDTO> create(@RequestBody Cliente cliente) {

        template.convertAndSend("cliente_exchange", "cliente_rk", cliente);

        ClienteDTO dto = clienteService.create(cliente);

        Conta conta = contaRequest.generateConta();
        Endereco endereco = request.requestEndereco(cliente.getEndereco());
        Cartao cartao = cartaoRequest.requestCartao();
        Pix chavePix = pixRequest.requestPix(cliente.getChavePix());

        dto.setId(cliente.getId());
        cartao.setTitular(cliente.getNome());
        dto.setConta(conta);
        dto.setEndereco(endereco);
        dto.setCartao(cartao);
        dto.setChavePix(chavePix);

        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @GetMapping(path = "/cliente/list")
    public ResponseEntity<List<Cliente>> list() {
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.list());
    }

    @GetMapping(path = "/cliente/fetch/{id}")
    public ResponseEntity<ClienteDTO> fetchClienteByID(@PathVariable("id") String id) {

        return ResponseEntity.status(HttpStatus.OK).body(clienteService.findByID(id));
    }

    @GetMapping(path = "/cliente/find")
    public ResponseEntity<List<Cliente>> findNome(@QueryParam("nome") String nome) {
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.findNome(nome));
    }

    @PutMapping(path = "/cliente/{id}/{status}")
    public ResponseEntity<Cliente> statusCliente(@PathVariable("id") String id, @PathVariable("status") String status){
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.clienteActivo(id, status));
    }

    @DeleteMapping(path = "/cliente/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") String id){
        clienteService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Cliente DELETADO");
    }
}
