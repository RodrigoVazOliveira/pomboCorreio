package br.com.zup.pombocorreio.services;

import br.com.zup.pombocorreio.models.Conta;
import br.com.zup.pombocorreio.models.Contato;
import br.com.zup.pombocorreio.models.Perfil;
import br.com.zup.pombocorreio.repositories.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContatoService {

    private final ContatoRepository contatoRepository;
    private final PerfilService perfilService;
    private final ContaService contaService;

    @Autowired
    public ContatoService(ContatoRepository contatoRepository, PerfilService perfilService, ContaService contaService) {
        this.contatoRepository = contatoRepository;
        this.perfilService = perfilService;
        this.contaService = contaService;
    }

    public Contato gravarNovoContato(Contato contato, Conta conta) {
        Perfil perfil = verificarSePerfilExisteParaUsar(contato.getPerfil());
        contato.setPerfil(perfil);
        Contato novoContato = contatoRepository.save(contato);
        adicionarNovoContatoNaConta(conta.getId(), novoContato);
        return novoContato;
    }

    private Perfil verificarSePerfilExisteParaUsar(Perfil perfil) {
        if (perfilService.verificarPerfilUnico(perfil.getNumeroTelefone())) {
            return perfilService.procurarPerfilPorNumeroTelefone(perfil.getNumeroTelefone());
        }
        return perfilService.gravarNovoPerfil(perfil);
    }

    private void adicionarNovoContatoNaConta(Long id, Contato novoContato) {
        Conta conta = contaService.procurarContaPorId(id);
        conta.getContatos().add(novoContato);
        contaService.atualizarConta(conta);
    }

    public Iterable<Contato> obterTodosContatosDeUmaContaPorId(Long id) {
        return contaService.obterTodosContatosDeUmaConta(id);
    }

    public Contato procurarContatoPorId(Long id) {
        Optional<Contato> optionalContato = contatoRepository.findById(id);

        if (optionalContato.isEmpty()) {
            throw new RuntimeException("Não existe contato com o id " + id);
        }

        return optionalContato.get();
    }

    public void removerContato(Long idConta, Long idContato) {
        contaService.removerContatoDaConta(idConta, idContato);
        Contato contato = procurarContatoPorId(idContato);
        contatoRepository.delete(contato);
    }

    public void bloquearOuDesbloquearContato(Long id) {
        Contato contato = procurarContatoPorId(id);

        if (contato.getBloqueio().equals(true)) {
            contato.setBloqueio(false);
        } else {
            contato.setBloqueio(true);
        }

        contatoRepository.save(contato);
    }
}
