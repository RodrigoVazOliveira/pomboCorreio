package br.com.zup.pombocorreio.services;

import br.com.zup.pombocorreio.models.Conta;
import br.com.zup.pombocorreio.models.Contato;
import br.com.zup.pombocorreio.models.Conversacao;
import br.com.zup.pombocorreio.repositories.ConversacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public Conversacao gravarNovaConversacao(Conversacao conversacao) {
        Conta conta = contaService.procurarContaPorId(conversacao.getConta().getId());
        Contato contato = contatoService.procurarContatoPorId(conversacao.getContato().getId());
        conversacao.setConta(conta);
        conversacao.setContato(contato);
        return conversacaoRepository.save(conversacao);
    }

    public Conversacao procurarConversacaoPorContaEContato(Conta conta, Contato contato) {
        Optional<Conversacao> optionalConversacao = conversacaoRepository.findByContaAndContato(conta, contato);

        if (optionalConversacao.isEmpty()) {
            throw new RuntimeException("Nenhuma conversa foi encontrar com a conta e contato informado!");
        }

        return optionalConversacao.get();
    }
}
