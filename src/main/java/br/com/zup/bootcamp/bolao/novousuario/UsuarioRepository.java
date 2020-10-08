package br.com.zup.bootcamp.bolao.novousuario;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// limite 3
@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long>{

	Optional<Usuario> findByLogin(String email);
}
