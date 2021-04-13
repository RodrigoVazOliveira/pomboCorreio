package br.com.zup.pombocorreio.services;

import br.com.zup.pombocorreio.models.Conta;
import br.com.zup.pombocorreio.models.Contato;
import br.com.zup.pombocorreio.models.Perfil;
import br.com.zup.pombocorreio.repositories.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
