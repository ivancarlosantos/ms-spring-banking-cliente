package core.kswelder.cliente;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.HttpStatus;

@Slf4j
@SpringBootApplication
@EnableFeignClients
public class ClienteApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClienteApplication.class, args);
        log.info("\n[Pessoa - Tomcat ATIVO] " + HttpStatus.OK);
    }

}
