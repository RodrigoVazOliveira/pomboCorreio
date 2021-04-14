package br.com.zup.pombocorreio.exceptions;

import br.com.zup.pombocorreio.exceptions.conta.ContaJaExisteExcecao;
import br.com.zup.pombocorreio.exceptions.conta.ContaNaoExisteExcecao;
import br.com.zup.pombocorreio.exceptions.contato.ContatoNaoExisteExcecao;
import br.com.zup.pombocorreio.exceptions.conversacao.ConversacaoNaoExisteExcecao;
import br.com.zup.pombocorreio.exceptions.perfil.PerfilNaoExisteExcecao;
import br.com.zup.pombocorreio.exceptions.validacao.CampoExcecao;
import br.com.zup.pombocorreio.exceptions.validacao.ValidacaoDeArgumentoException;
import br.com.zup.pombocorreio.exceptions.validacao.ValidacaoDeSemArgsException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
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
            "validação de campos",
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

    @ExceptionHandler({PerfilNaoExisteExcecao.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ValidacaoDeSemArgsException perfilNaoExisteExcecao(PerfilNaoExisteExcecao ex) {
        ValidacaoDeSemArgsException validacaoDeSemArgsException = new ValidacaoDeSemArgsException(
            ex.getTipoDeErro(),
            ex.getStatus(),
            ex.getDescricaoStatus(),
            ex.getMessage()
        );
        return validacaoDeSemArgsException;
    }

    @ExceptionHandler({ContaJaExisteExcecao.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ValidacaoDeSemArgsException contaJaExisteExcecao(ContaJaExisteExcecao ex) {
        ValidacaoDeSemArgsException validacaoDeSemArgsException = new ValidacaoDeSemArgsException(
                ex.getTipoDeErro(),
                ex.getStatus(),
                ex.getDescricaoStatus(),
                ex.getMessage()
        );
        return validacaoDeSemArgsException;
    }

    @ExceptionHandler({ContaNaoExisteExcecao.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ValidacaoDeSemArgsException contaNaoExisteExcecao(ContaNaoExisteExcecao ex) {
        ValidacaoDeSemArgsException validacaoDeSemArgsException = new ValidacaoDeSemArgsException(
                ex.getTipoDeErro(),
                ex.getStatus(),
                ex.getDescricaoStatus(),
                ex.getMessage()
        );
        return validacaoDeSemArgsException;
    }

    @ExceptionHandler({ContatoNaoExisteExcecao.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ValidacaoDeSemArgsException contatoNaoExisteExcecao(ContatoNaoExisteExcecao ex) {
        ValidacaoDeSemArgsException validacaoDeSemArgsException = new ValidacaoDeSemArgsException(
                ex.getTipoDeErro(),
                ex.getStatus(),
                ex.getDescricaoStatus(),
                ex.getMessage()
        );
        return validacaoDeSemArgsException;
    }

    @ExceptionHandler({ConversacaoNaoExisteExcecao.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ValidacaoDeSemArgsException conversacaoNaoExisteExcecao(ConversacaoNaoExisteExcecao ex) {
        ValidacaoDeSemArgsException validacaoDeSemArgsException = new ValidacaoDeSemArgsException(
                ex.getTipoDeErro(),
                ex.getStatus(),
                ex.getDescricaoStatus(),
                ex.getMessage()
        );
        return validacaoDeSemArgsException;
    }
}
