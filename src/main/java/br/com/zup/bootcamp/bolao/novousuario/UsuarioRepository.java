package br.com.zup.bootcamp.bolao.novousuario;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// limite 3
@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long>{

}
