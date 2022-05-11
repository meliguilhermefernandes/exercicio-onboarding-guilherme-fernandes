package br.com.meli.onboarding.configuration;

import br.com.meli.onboarding.commons.exception.CriarPreferenciaException;
import br.com.meli.onboarding.commons.exception.MPIntegrationException;
import br.com.meli.onboarding.commons.exception.ResponseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class RestHandlerException {

    ObjectMapper mapper = new ObjectMapper();

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity handlerRuntimeException() {
        return (ResponseEntity) ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(CriarPreferenciaException.class)
    public ResponseEntity handlerCriarPreferenciaException(CriarPreferenciaException ex) throws JsonProcessingException {
        return new ResponseEntity<>(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(
                new ResponseException(ex.getErrorCode(), ex.getMessage())), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MPIntegrationException.class)
    public ResponseEntity handlerMPIntegrationException(MPIntegrationException ex) throws JsonProcessingException {
        return new ResponseEntity<>(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(
                new ResponseException(ex.getErrorCode(), ex.getMessage())), HttpStatus.BAD_REQUEST);
    }
}
