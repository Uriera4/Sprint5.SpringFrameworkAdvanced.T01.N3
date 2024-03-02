package cat.itacademy.barcelonactiva.RieraLizcano.Oriol.s05.t01.n03.S05T01N03RieraLizcanoOriol.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(WebClientResponseException.class)
    public ResponseEntity<String> handleWebClientResponseException (WebClientResponseException e){
        return new ResponseEntity<>("Error: " + e.getMessage(), e.getStatusCode());
    }

}
