package br.com.zup.pombocorreio.controllers;

import br.com.zup.pombocorreio.dtos.conversacao.IniciarConversacaoDTO;
import br.com.zup.pombocorreio.dtos.conversacao.SaidaNovaConversacaoDTO;
import br.com.zup.pombocorreio.models.Conversacao;
import br.com.zup.pombocorreio.services.ConversacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("conversacoes/")
public class ConversacaoController {

    private final ConversacaoService conversacaoService;

    @Autowired
    public ConversacaoController(ConversacaoService conversacaoService) {
        this.conversacaoService = conversacaoService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SaidaNovaConversacaoDTO iniciarNovaConversacao(@RequestBody
                                                          @Valid
                                                          IniciarConversacaoDTO iniciarConversacaoDTO) {
        Conversacao conversacao = conversacaoService.gravarNovaConversacao(
                iniciarConversacaoDTO.converterDtoParaModelo()
        );
        return SaidaNovaConversacaoDTO.converterModeloParaDto(conversacao);
    }
}
