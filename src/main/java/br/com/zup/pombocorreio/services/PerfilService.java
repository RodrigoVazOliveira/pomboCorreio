package br.com.zup.pombocorreio.services;

import br.com.zup.pombocorreio.models.Perfil;
import br.com.zup.pombocorreio.repositories.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PerfilService {

    private final PerfilRepository perfilRepository;

    @Autowired
    public PerfilService(PerfilRepository perfilRepository) {
        this.perfilRepository = perfilRepository;
    }

    public Perfil gravarNovoPerfil(Perfil perfil) {
        return perfilRepository.save(perfil);
    }

    public Perfil procurarPerfilPorNumeroTelefone(String numeroTelefone) {
        Optional<Perfil> optionalPerfil = perfilRepository.findByNumeroTelefone(numeroTelefone);

        if (optionalPerfil.isEmpty()) {
            throw new RuntimeException("Não existe perfil com o núemro de telefone " + numeroTelefone);
        }

        return optionalPerfil.get();
    }

    public Boolean verificarPerfilUnico(String numeroTelefone) {
        Optional<Perfil> optionalPerfil = perfilRepository.findByNumeroTelefone(numeroTelefone);
        return optionalPerfil.isPresent();
    }

    public Perfil procurarPerfilPorId(Long id) {
        Optional<Perfil> optionalPerfil = perfilRepository.findById(id);

        if (optionalPerfil.isEmpty()) {
            throw new RuntimeException("Não foi encontrado um perfil com o id " + id);
        }

        return optionalPerfil.get();
    }

    public Perfil atualizarPerfilCompleto(Perfil novoPerfil) {
        Perfil perfilAntigo = procurarPerfilPorId(novoPerfil.getId());
        perfilAntigo.setNomeCompleto(novoPerfil.getNomeCompleto());
        perfilAntigo.setNumeroTelefone(novoPerfil.getNumeroTelefone());
        perfilAntigo.setFoto(novoPerfil.getFoto());
        perfilAntigo.setRecado(novoPerfil.getRecado());
        perfilAntigo.setAtivo(novoPerfil.getAtivo());

        return perfilRepository.save(perfilAntigo);
    }
}
