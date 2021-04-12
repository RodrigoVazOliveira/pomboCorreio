package br.com.zup.pombocorreio.controllers;

import br.com.zup.pombocorreio.dtos.contato.CadastrarContatoDTO;
import br.com.zup.pombocorreio.models.Conta;
import br.com.zup.pombocorreio.models.Contato;
import br.com.zup.pombocorreio.services.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("contatos/")
public class ContatoController {

    private final ContatoService contatoService;

    @Autowired
    public ContatoController(ContatoService contatoService) {
        this.contatoService = contatoService;
    }

    public SaidaCadastroContato gravarNovoContato(@RequestBody @Valid CadastrarContatoDTO cadastrarContatoDTO) {
        Conta conta = new Conta();
        conta.setId(cadastrarContatoDTO.getIdConta());
        Contato contato = contatoService.gravarNovoContato(
                cadastrarContatoDTO.converterDtoParaModelo(), conta
        );
    }
}
