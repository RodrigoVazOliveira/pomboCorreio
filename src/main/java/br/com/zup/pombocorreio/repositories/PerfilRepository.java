package br.com.zup.pombocorreio.repositories;

import br.com.zup.pombocorreio.models.Perfil;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PerfilRepository extends CrudRepository<Perfil, Long> {
    Optional<Perfil> findByNumeroTelefone(String numeroTelefone);
}
