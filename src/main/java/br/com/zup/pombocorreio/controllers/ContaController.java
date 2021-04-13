package br.com.zup.pombocorreio.controllers;

import br.com.zup.pombocorreio.dtos.conta.AtualizarContaDTO;
import br.com.zup.pombocorreio.dtos.conta.CadastrarContaDTO;
import br.com.zup.pombocorreio.dtos.conta.SaidaCadastrarContaDTO;
import br.com.zup.pombocorreio.models.Conta;
import br.com.zup.pombocorreio.services.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.security.PublicKey;

@RestController
@RequestMapping("contas/")
public class ContaController {

    private final ContaService contaService;

    @Autowired
    public ContaController(ContaService contaService) {
        this.contaService = contaService;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SaidaCadastrarContaDTO gravarNovaConta(@RequestBody @Valid CadastrarContaDTO cadastrarContaDTO) {
        try {
            Conta conta = contaService.gravarNovaConta(cadastrarContaDTO.converterDtoParaModelo());
            return SaidaCadastrarContaDTO.converterModeloParaDto(conta);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public SaidaCadastrarContaDTO procurarContaPorTelefone(@RequestParam(name = "telefone") String telefone) {
        try {
            Conta conta = contaService.procurarContaPorNumeroTelefone(telefone);
            return SaidaCadastrarContaDTO.converterModeloParaDto(conta);
        }catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.OK, e.getMessage());
        }
    }

    @PutMapping("{id}/")
    public SaidaCadastrarContaDTO atualizarContaCompleta(@PathVariable Long id, @RequestBody AtualizarContaDTO atualizarContaDTO) {
        try {
            atualizarContaDTO.setId(id);
            Conta conta = contaService.atualizarConta(atualizarContaDTO.converterDtoParaModelo());
            return SaidaCadastrarContaDTO.converterModeloParaDto(conta);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

}
