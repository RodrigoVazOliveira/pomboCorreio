package br.com.zup.pombocorreio.repositories;

import br.com.zup.pombocorreio.models.Conta;
import br.com.zup.pombocorreio.models.Contato;
import br.com.zup.pombocorreio.models.Conversacao;
import org.springframework.data.repository.CrudRepository;

public interface ConversacaoRepository extends CrudRepository<Conversacao, Long> {
    Conversacao existsByContaAndContato(Conta conta, Contato contato);
}
