package core.kswelder.cliente.exception;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestController
@RestControllerAdvice
public class ApplicacaoExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<ExceptionMensagem> handlerException(Exception ex, WebRequest request) {

        ExceptionMensagem exceptionMensagem = new ExceptionMensagem(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                HttpStatus.INTERNAL_SERVER_ERROR,
                new Date(),
                ex.getMessage());

        return new ResponseEntity<>(exceptionMensagem, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {EmptyResultDataAccessException.class})
    public ResponseEntity<ExceptionMensagem> handlerDeleteException(EmptyResultDataAccessException ex) {

        ExceptionMensagem exceptionMensagem = new ExceptionMensagem(
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND,
                new Date(),
                ex.getMessage());

        return new ResponseEntity<>(exceptionMensagem, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {RegraNegocioException.class})
    public ResponseEntity<ExceptionMensagem> handlerExceptionBadRequest(RuntimeException ex, WebRequest request) {

        ExceptionMensagem exceptionMensagem = new ExceptionMensagem(
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND,
                new Date(),
                ex.getMessage());

        return new ResponseEntity<>(exceptionMensagem, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {MethodArgumentTypeMismatchException.class})
    public ResponseEntity<ExceptionMensagem> handlerExceptionFormatNumber(MethodArgumentTypeMismatchException ex, WebRequest request) {

        ExceptionMensagem exceptionMensagem = new ExceptionMensagem(
                HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST,
                new Date(),
                ex.getMessage());

        return new ResponseEntity<>(exceptionMensagem, HttpStatus.BAD_REQUEST);
    }

}
