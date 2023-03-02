package core.kswelder.cliente.service;

import core.kswelder.cliente.dto.ClienteDTO;
import core.kswelder.cliente.exception.RegraNegocioException;
import core.kswelder.cliente.model.*;
import core.kswelder.cliente.repository.ClienteRepository;
import core.kswelder.cliente.status.ClienteStatus;
import core.kswelder.cliente.utils.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    ContaRequest contaRequest;

    @Autowired
    EnderecoRequest enderecoRequest;

    @Autowired
    CartaoRequest cartaoRequest;

    @Autowired
    PixRequest pixRequest;


    public ClienteDTO create(Cliente cliente) {

        cliente.setDataCadastro(new Date().toString());
        cliente.setDataAtualizacaoCadastro(new Date().toString());
        cliente.setStatus(ClienteStatus.ATIVO.toString());

        ClienteDTO dto = new ClienteDTO(cliente);

        clienteRepository.save(cliente);

        return dto;
    }

    public List<Cliente> findNome(String nome) {
        List<Cliente> fetchNome = clienteRepository.findByNome(nome);

        if (fetchNome.isEmpty()){
            throw new RegraNegocioException("Nome não encontrado");
        }
        return fetchNome;
    }

    public Cliente clienteActivo(String value, String status){
        Long id = ValidateParameter.validate(value);
        Optional<Cliente> findCliente = Optional
                .ofNullable(clienteRepository
                        .findById(id)
                        .orElseThrow(() -> new RegraNegocioException("Cliente ID: "+id+" NÃO ENCONTRADO")));

        if (findCliente.get().getStatus().equals(ClienteStatus.ATIVO.toString())){
            findCliente.get().setStatus(status);
            findCliente.get().setDataAtualizacaoCadastro(new Date().toString());
            clienteRepository.save(findCliente.get());
        }

        if (findCliente.get().getStatus().equals(ClienteStatus.INATIVO.toString())){
            findCliente.get().setStatus(status);
            findCliente.get().setDataAtualizacaoCadastro(new Date().toString());
            clienteRepository.save(findCliente.get());
        }

        return findCliente.get();
    }

    public ClienteDTO findByID(String value){
        Long id = ValidateParameter.validate(value);
        Optional<Cliente> find = Optional.of(clienteRepository.findById(id).orElseThrow(() -> new RegraNegocioException("Cliente ID: "+id+" NOT FOUND")));
        ClienteDTO dto = new ClienteDTO(find.get());
        Conta conta = contaRequest.findContaByID(id);
        Endereco endereco = enderecoRequest.requestEndereco(find.get().getEndereco());
        Cartao cartao = cartaoRequest.findCartao(id);
        Pix pix = pixRequest.requestPix(find.get().getChavePix());

        cartao.setTitular(find.get().getNome());

        dto.setConta(conta);
        dto.setEndereco(endereco);
        dto.setCartao(cartao);
        dto.setChavePix(pix);

        return dto;
    }

    public List<Cliente> list(){
        return clienteRepository
                .findAll()
                .stream()
                .filter(c->c.getStatus().equals(ClienteStatus.ATIVO.toString()))
                .collect(Collectors.toList());
    }

    public String delete(String value){
        Long id = ValidateParameter.validate(value);
        clienteRepository.deleteById(id);
        contaRequest.deleteConta(id);
        cartaoRequest.deleteCartao(id);
        pixRequest.deletePix(id);
        return "";
    }

}
