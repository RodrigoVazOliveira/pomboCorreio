package br.com.zup.pombocorreio.services;

import br.com.zup.pombocorreio.models.Conta;
import br.com.zup.pombocorreio.models.Perfil;
import br.com.zup.pombocorreio.repositories.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
            return perfilService.procurarPerfilPorNumeroTelefone(perfil.getNumeroTelefone());
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
}
