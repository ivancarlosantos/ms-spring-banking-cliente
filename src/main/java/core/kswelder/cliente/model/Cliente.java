package core.kswelder.cliente.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cliente_id")
    private Long id;

    private String nome;

    private String dataDeNascimento;

    private BigDecimal saldo;

    private String dataCadastro;

    @JsonIgnore
    private String dataAtualizacaoCadastro;

    private String endereco;

    private String chavePix;

    private String status;

}
