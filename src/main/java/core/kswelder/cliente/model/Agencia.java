package core.kswelder.cliente.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class Agencia implements Serializable {

    private Long id;
    private String agencia;

}
