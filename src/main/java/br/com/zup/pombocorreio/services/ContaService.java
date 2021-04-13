package br.com.zup.pombocorreio.services;

import br.com.zup.pombocorreio.models.Conta;
import br.com.zup.pombocorreio.models.Contato;
import br.com.zup.pombocorreio.models.Perfil;
import br.com.zup.pombocorreio.repositories.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ContaService {

    private final ContaRepository contaRepository;
    private final PerfilService perfilService;

    @Autowired
    public ContaService(ContaRepository contaRepository, PerfilService perfilService) {
        this.contaRepository = contaRepository;
        this.perfilService = perfilService;
    }

    public Conta gravarNovaConta(Conta conta) {
        verificarPerfilExiste(conta.getPerfil());
        conta.setPerfil(obterPerfilDaConta(conta.getPerfil()));
        return contaRepository.save(conta);
    }

    private void verificarPerfilExiste(Perfil perfil) {
        if (contaRepository.existsByPerfilNumeroTelefone(perfil.getNumeroTelefone())) {
            throw new RuntimeException("Uma conta com o número " + perfil.getNumeroTelefone() + " já existe!");
        }
    }

    private Perfil obterPerfilDaConta(Perfil perfil) {
        if (perfilService.verificarPerfilUnico(perfil.getNumeroTelefone())) {
            Perfil perfilAntigo = perfilService.procurarPerfilPorNumeroTelefone(perfil.getNumeroTelefone());
            perfilAntigo.setFoto(perfil.getFoto());
            perfilAntigo.setRecado(perfil.getRecado());
            return perfilAntigo;
        }
        return perfilService.gravarNovoPerfil(perfil);
    }

    public Conta procurarContaPorNumeroTelefone(String numeroTelefone) {
        Optional<Conta> optionalConta = contaRepository.findByPerfilNumeroTelefone(numeroTelefone);

        if (optionalConta.isEmpty()) {
            throw new RuntimeException("Não existe conta com o número de telefone " + numeroTelefone);
        }

        return optionalConta.get();
    }

    public Conta procurarContaPorId(Long id) {
        Optional<Conta> optionalConta = contaRepository.findById(id);

        if (optionalConta.isEmpty()) {
            throw new RuntimeException("Não existe conta com o id " + id);
        }

        return optionalConta.get();
    }

    public Conta atualizarConta(Conta conta) {
        return contaRepository.save(conta);
    }

    public Iterable<Contato> obterTodosContatosDeUmaConta(Long id) {
        Conta conta = procurarContaPorId(id);
        return conta.getContatos();
    }

    public void removerContatoDaConta(Long idConta, Long idContato) {
        Conta conta = procurarContaPorId(idConta);
        conta.setContatos(removerContatoDaLista(idContato, conta.getContatos()));
        atualizarConta(conta);
    }

    private List<Contato> removerContatoDaLista(Long idContato, List<Contato> contatos) {
        for (Contato contato : contatos) {
            if (contato.getId() == idContato) {
                contatos.remove(contato);
                return contatos;
            }
        }
        return contatos;
    }
}
