package br.com.zup.pombocorreio.services;

import br.com.zup.pombocorreio.models.Conta;
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
        perfilService.procurarPerfilPorNumeroTelefone(conta.getPerfil().getNumeroTelefone());
        return contaRepository.save(conta);
    }
}
