package br.com.zup.pombocorreio.repositories;

import br.com.zup.pombocorreio.models.Conta;
import org.springframework.data.repository.CrudRepository;

public interface ContaRepository extends CrudRepository<Conta, Long> {
}
