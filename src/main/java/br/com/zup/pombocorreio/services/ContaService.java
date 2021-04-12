package br.com.zup.pombocorreio.services;

import br.com.zup.pombocorreio.models.Conta;
import br.com.zup.pombocorreio.models.Perfil;
import br.com.zup.pombocorreio.repositories.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        Perfil novoPerfil = perfilService.gravarNovoPerfil(conta.getPerfil());
        conta.setPerfil(novoPerfil);
        return contaRepository.save(conta);
    }

    private void verificarPerfilExiste(Perfil perfil) {
        if (!perfilService.verificarPerfilUnico(perfil.getNumeroTelefone())) {
            throw new RuntimeException("O perfil com o número " + perfil.getNumeroTelefone() + " já existe!");
        }
    }
}
