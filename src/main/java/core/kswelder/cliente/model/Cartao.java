package core.kswelder.cliente.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Cartao implements Serializable {

    private Long id;

    private String titular;

    private String numeroCartao;

    private Integer cvv;

    private String bandeira;
}
