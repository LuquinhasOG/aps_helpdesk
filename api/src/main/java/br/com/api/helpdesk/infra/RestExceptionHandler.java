package br.com.api.helpdesk.infra;

import br.com.api.helpdesk.exception.IdPatrimonioBadRequest;
import br.com.api.helpdesk.exception.PatrimonioNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ResponseBody
    @ExceptionHandler(PatrimonioNotFound.class)
    public ResponseEntity<RestErrorMessage> patrimonioNotFoundHandler(PatrimonioNotFound exception) {
        RestErrorMessage responseMessage = new RestErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseMessage);
    }

    @ResponseBody
    @ExceptionHandler(IdPatrimonioBadRequest.class)
    public ResponseEntity<RestErrorMessage> idPatrimonioBadRequestHandler(IdPatrimonioBadRequest exception) {
        RestErrorMessage responseMessage = new RestErrorMessage(HttpStatus.BAD_REQUEST, exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseMessage);
    }
}




