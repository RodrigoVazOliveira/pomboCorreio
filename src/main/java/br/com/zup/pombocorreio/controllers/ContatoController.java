package br.com.zup.pombocorreio.controllers;

import br.com.zup.pombocorreio.dtos.contato.CadastrarContatoDTO;
import br.com.zup.pombocorreio.dtos.contato.SaidaCadastrarContatoDTO;
import br.com.zup.pombocorreio.dtos.contato.SaidaContatoDTO;
import br.com.zup.pombocorreio.models.Conta;
import br.com.zup.pombocorreio.models.Contato;
import br.com.zup.pombocorreio.services.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("contatos/")
public class ContatoController {

    private final ContatoService contatoService;

    @Autowired
    public ContatoController(ContatoService contatoService) {
        this.contatoService = contatoService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SaidaCadastrarContatoDTO gravarNovoContato(@RequestBody @Valid CadastrarContatoDTO cadastrarContatoDTO) {
        try {
            Conta conta = new Conta();
            conta.setId(cadastrarContatoDTO.getIdConta());
            Contato contato = contatoService.gravarNovoContato(cadastrarContatoDTO.converterDtoParaModelo(), conta);
            return SaidaCadastrarContatoDTO.converterModeloParaDto(contato, conta.getId());
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @GetMapping("{id}/")
    @ResponseStatus(HttpStatus.CREATED)
    public Iterable<SaidaContatoDTO> obterContatosDeUmaContaPorId(@PathVariable Long id) {
        try {
            return SaidaContatoDTO.converterModeloparaListaDeDto(
                    contatoService.obterTodosContatosDeUmaContaPorId(id)
            );
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping("{idConta}/{idContato}/")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerContato(@PathVariable(name = "idConta") Long idConta
            , @PathVariable(name = "idContato") Long idContato) {
        try {
            contatoService.removerContato(idConta, idContato);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}
