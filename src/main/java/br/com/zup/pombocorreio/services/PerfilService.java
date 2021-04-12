package br.com.zup.pombocorreio.services;

import br.com.zup.pombocorreio.models.Perfil;
import br.com.zup.pombocorreio.repositories.PerfilRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PerfilService {

    private final PerfilRepository perfilRepository;

    public PerfilService(PerfilRepository perfilRepository) {
        this.perfilRepository = perfilRepository;
    }

    public Perfil procurarPerfilPorNumeroTelefone(String numeroTelefone) {
        Optional<Perfil> optionalPerfil = perfilRepository.findByNumeroTelefone(numeroTelefone);

        if (optionalPerfil.isEmpty()) {
            throw new RuntimeException("Um perfil já existe com o núemro de telefone " + numeroTelefone);
        }

        return optionalPerfil.get();
    }
}
