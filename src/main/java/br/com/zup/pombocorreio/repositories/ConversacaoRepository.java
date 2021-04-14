package br.com.zup.pombocorreio.repositories;

import br.com.zup.pombocorreio.models.Conta;
import br.com.zup.pombocorreio.models.Contato;
import br.com.zup.pombocorreio.models.Conversacao;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ConversacaoRepository extends CrudRepository<Conversacao, Long> {
    Boolean existsByContaAndContato(Conta conta, Contato contato);
    Optional<Conversacao> findByContaAndContato(Conta conta, Contato contato);
}
