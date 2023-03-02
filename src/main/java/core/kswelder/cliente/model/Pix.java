package core.kswelder.cliente.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class Pix implements Serializable {

    private Long id;

    private String chave;

    private String dataDeCriacaoChave;
}
