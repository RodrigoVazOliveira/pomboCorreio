package br.com.zup.pombocorreio.repositories;

import br.com.zup.pombocorreio.models.Conta;
import br.com.zup.pombocorreio.models.Contato;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ContaRepository extends CrudRepository<Conta, Long> {
    Optional<Conta> findByPerfilNumeroTelefone(String numeroTelefone);
    Boolean existsByPerfilNumeroTelefone(String numeroTelefone);
}