package br.com.zup.bootcamp.bolao.novousuario;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class BloqueiaEmailDuplicadoValidator implements Validator {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return NovoUsuarioRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        NovoUsuarioRequest request = (NovoUsuarioRequest)target;

        String email = request.getLogin();
        Optional<Usuario> possivelUsuario =  usuarioRepository.findByLogin(email);

        if (possivelUsuario.isPresent()) {
            errors.rejectValue("login", null, "Este login já existe.");
        }
    }

}
