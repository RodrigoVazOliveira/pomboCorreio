package br.com.zup.pombocorreio.services;

import br.com.zup.pombocorreio.exceptions.conversacao.ConversacaoNaoExisteExcecao;
import br.com.zup.pombocorreio.models.Conta;
import br.com.zup.pombocorreio.models.Contato;
import br.com.zup.pombocorreio.models.Conversacao;
import br.com.zup.pombocorreio.models.Mensagem;
import br.com.zup.pombocorreio.repositories.ConversacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ConversacaoService {

    private final ConversacaoRepository conversacaoRepository;
    private final ContaService contaService;
    private final ContatoService contatoService;
    private final MensagemService mensagemService;

    @Autowired
    public ConversacaoService(ConversacaoRepository conversacaoRepository,
                              ContaService contaService,
                              ContatoService contatoService,
                              MensagemService mensagemService) {
        this.conversacaoRepository = conversacaoRepository;
        this.contaService = contaService;
        this.contatoService = contatoService;
        this.mensagemService = mensagemService;
    }

    public Conversacao gravarNovaConversacao(Conversacao conversacao) {
        conversacao.setConta(contaService.procurarContaPorId(conversacao.getConta().getId()));
        conversacao.setContato(contatoService.procurarContatoPorId(conversacao.getContato().getId()));

        if (conversacaoRepository.existsByContaAndContato(conversacao.getConta(), conversacao.getContato())) {
            return procurarConversacaoPorContaEContato(conversacao.getConta(), conversacao.getContato());
        }

        return conversacaoRepository.save(conversacao);
    }

    public Conversacao procurarConversacaoPorContaEContato(Conta conta, Contato contato) {
        Optional<Conversacao> optionalConversacao = conversacaoRepository.findByContaAndContato(conta, contato);

        if (optionalConversacao.isEmpty()) {
            throw new ConversacaoNaoExisteExcecao("Nenhuma conversa foi encontrar com a conta e contato informado!");
        }

        return optionalConversacao.get();
    }

    public Iterable<Conversacao> obterTodasConversasPorIdDaConta(Long id) {
        Conta contaAntiga = contaService.procurarContaPorId(id);
        return conversacaoRepository.findByConta(contaAntiga);
    }

    public Conversacao procurarConversacaoPorId(Long id) {
        Optional<Conversacao> optionalConversacao = conversacaoRepository.findById(id);

        if (optionalConversacao.isEmpty()) {
            throw new ConversacaoNaoExisteExcecao("Não existe uma conversa como id " + id);
        }

        return optionalConversacao.get();
    }

    public Conversacao enviarMensagem(Long id, Mensagem mensagem) {
        Conversacao conversacao = procurarConversacaoPorId(id);
        Mensagem novaMensagem = mensagemService.gravarNovaMensagem(mensagem);
        conversacao.getMensagems().add(novaMensagem);
        return conversacaoRepository.save(conversacao);
    }
}
