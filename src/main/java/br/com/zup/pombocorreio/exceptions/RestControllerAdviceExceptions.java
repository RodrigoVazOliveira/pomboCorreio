package br.com.zup.pombocorreio.exceptions;

import br.com.zup.pombocorreio.exceptions.validacao.CampoExcecao;
import br.com.zup.pombocorreio.exceptions.validacao.ValidacaoDeArgumentoException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class RestControllerAdviceExceptions  extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ValidacaoDeArgumentoException validacaoDeArgumentoException = new ValidacaoDeArgumentoException(
            "validação de cmapos",
            status.value(),
            status.getReasonPhrase(),
            obterValidacaoDeCampos(ex)
        );
        return ResponseEntity.status(status).body(validacaoDeArgumentoException);
    }

    private List<CampoExcecao> obterValidacaoDeCampos(MethodArgumentNotValidException e) {
        List<CampoExcecao> campoExcecaos = new ArrayList<>();
        for (FieldError fieldError : e.getFieldErrors()) {
            campoExcecaos.add(new CampoExcecao(fieldError.getField(), fieldError.getDefaultMessage()));
        }
        return campoExcecaos;
    }
}
