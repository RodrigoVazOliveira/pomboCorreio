package br.com.zup.pombocorreio.services;

import br.com.zup.pombocorreio.repositories.PerfilRepository;
import org.springframework.stereotype.Service;

@Service
public class PerfilService {

    private final PerfilRepository perfilRepository;

    public PerfilService(PerfilRepository perfilRepository) {
        this.perfilRepository = perfilRepository;
    }
}
