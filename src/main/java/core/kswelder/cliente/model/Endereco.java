package core.kswelder.cliente.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class Endereco implements Serializable {

    //private Long id;

    private String logradouro;

    private String bairro;

    private String localidade;

    private String uf;

    private String cep;
}
