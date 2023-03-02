package core.kswelder.cliente.dto;

import core.kswelder.cliente.model.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class ClienteDTO implements Serializable {

    private Long id;
    private String nome;
    private String dataDeNascimento;
    private String dataCadastro;
    private String dataAtualizacaoCadastro;

    private Conta conta;

    private Endereco endereco;

    private Cartao cartao;

    private Pix chavePix;
    private String status;

    public ClienteDTO(Cliente cliente) {

        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.dataDeNascimento = cliente.getDataDeNascimento();
        this.dataCadastro = cliente.getDataCadastro();
        this.dataAtualizacaoCadastro = cliente.getDataAtualizacaoCadastro();
        this.status = cliente.getStatus();
    }
}
