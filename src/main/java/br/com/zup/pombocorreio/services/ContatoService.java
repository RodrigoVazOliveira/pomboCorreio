package br.com.zup.pombocorreio.services;

import br.com.zup.pombocorreio.repositories.ContatoRepository;
import org.springframework.stereotype.Service;

@Service
public class ContatoService {

    private final ContatoRepository contatoRepository;

    public ContatoService(ContatoRepository contatoRepository) {
        this.contatoRepository = contatoRepository;
    }

    
}
