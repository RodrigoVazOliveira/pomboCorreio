package br.com.zup.pombocorreio.controllers;

import br.com.zup.pombocorreio.services.ConversacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("conversacoes/")
public class ConversacaoController {

    private final ConversacaoService conversacaoService;

    @Autowired
    public ConversacaoController(ConversacaoService conversacaoService) {
        this.conversacaoService = conversacaoService;
    }


}
