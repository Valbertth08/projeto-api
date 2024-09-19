package empre.rubik.api.infra.exceptions;


import jakarta.persistence.EntityNotFoundException;
import jakarta.xml.bind.ValidationException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratorDeErros {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity tratar404(){
        return ResponseEntity.notFound().build();
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public  ResponseEntity tratar500(MethodArgumentNotValidException ex){
        var erros=ex.getFieldErrors();
     return ResponseEntity.badRequest().body(erros.stream().map(DadosErroValidacao::new).toList());
    }
    @ExceptionHandler(ValidationException.class)
    public ResponseEntity tratarValidacao(ValidationException ex){
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
    public record DadosErroValidacao(String campo, String msg){
        public  DadosErroValidacao( FieldError e){
            this(e.getField(),e.getDefaultMessage());
        }

    }






}
