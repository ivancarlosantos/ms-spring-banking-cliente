package core.kswelder.cliente.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
public class ExceptionMensagem implements Serializable {

    private Integer statusNumber;
    private HttpStatus errorStatus;
    private String timeError;
    private String message;

    public ExceptionMensagem(Integer statusNumber, HttpStatus errorStatus, Date timeError, String message) {
        this.statusNumber = statusNumber;
        this.errorStatus = errorStatus;
        this.timeError = timeError.toString();
        this.message = message;
    }

}
