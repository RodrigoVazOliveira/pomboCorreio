package br.com.zup.pombocorreio.controllers;

import br.com.zup.pombocorreio.dtos.conta.AtualizarContaDTO;
import br.com.zup.pombocorreio.dtos.conta.CadastrarContaDTO;
import br.com.zup.pombocorreio.dtos.conta.SaidaCadastrarContaDTO;
import br.com.zup.pombocorreio.models.Conta;
import br.com.zup.pombocorreio.services.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
        Conta conta = contaService.gravarNovaConta(cadastrarContaDTO.converterDtoParaModelo());
        return SaidaCadastrarContaDTO.converterModeloParaDto(conta);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public SaidaCadastrarContaDTO procurarContaPorTelefone(@RequestParam(name = "telefone") String telefone) {
        Conta conta = contaService.procurarContaPorNumeroTelefone(telefone);
        return SaidaCadastrarContaDTO.converterModeloParaDto(conta);
    }

    @PutMapping("{id}/")
    @ResponseStatus(HttpStatus.CREATED)
    public SaidaCadastrarContaDTO atualizarContaCompleta(@PathVariable Long id, @RequestBody AtualizarContaDTO atualizarContaDTO) {
        atualizarContaDTO.setId(id);
        Conta conta = contaService.atualizarConta(atualizarContaDTO.converterDtoParaModelo());
        return SaidaCadastrarContaDTO.converterModeloParaDto(conta);
    }

    @PatchMapping("{id}/")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public SaidaCadastrarContaDTO ativarOuDesativarConta(@PathVariable(name = "id") Long idConta) {
        Conta conta  = new Conta();
        conta.setId(idConta);
        return SaidaCadastrarContaDTO.converterModeloParaDto(contaService.ativarOuDesativarConta(conta));
    }
}
