package br.com.zup.pombocorreio.services;

import br.com.zup.pombocorreio.models.Mensagem;
import br.com.zup.pombocorreio.repositories.MensagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MensagemService {

    private final MensagemRepository mensagemRepository;

    @Autowired
    public MensagemService(MensagemRepository mensagemRepository) {
        this.mensagemRepository = mensagemRepository;
    }

    public Mensagem gravarNovaMensagem(Mensagem mensagem) {
        mensagem.setDataHora(LocalDateTime.now());
        return mensagemRepository.save(mensagem);
    }
}
