package br.com.zup.pombocorreio.services;

import br.com.zup.pombocorreio.repositories.ConversacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConversacaoService {

    private final ConversacaoRepository conversacaoRepository;
    private final ContaService contaService;
    private final ContatoService contatoService;

    @Autowired
    public ConversacaoService(ConversacaoRepository conversacaoRepository, ContaService contaService, ContatoService contatoService) {
        this.conversacaoRepository = conversacaoRepository;
        this.contaService = contaService;
        this.contatoService = contatoService;
    }
}