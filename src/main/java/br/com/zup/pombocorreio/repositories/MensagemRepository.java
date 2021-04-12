package br.com.zup.pombocorreio.repositories;

import br.com.zup.pombocorreio.models.Mensagem;
import org.springframework.data.repository.CrudRepository;

public interface MensagemRepository extends CrudRepository<Mensagem, Long> {
}
