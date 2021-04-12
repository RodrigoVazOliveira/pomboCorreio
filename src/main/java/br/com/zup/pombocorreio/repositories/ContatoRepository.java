package br.com.zup.pombocorreio.repositories;

import br.com.zup.pombocorreio.models.Contato;
import org.springframework.data.repository.CrudRepository;

public interface ContatoRepository extends CrudRepository<Contato, Long> {
}
