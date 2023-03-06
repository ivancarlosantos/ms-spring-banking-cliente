package core.kswelder.cliente.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.net.InetAddress;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class ConnetionTest {

    private InetAddress address;
    private String dateCreateAt;
}
