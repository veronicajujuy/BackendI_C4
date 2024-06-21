package dh.backend.clinicamvc.exception;

import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> recursoNoEncontrado(ResourceNotFoundException e){
        return ResponseEntity.status(HttpStatusCode.valueOf(404)).body(e.getMessage());
    }

}
