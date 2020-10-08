package br.com.zup.bootcamp.bolao.novousuario;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 1 ponto - acoplamento com classes específicas
 * 1 ponto - branches(if,else,loops,switch,case,? ternario,: ternario)
 * 1 ponto - função como argumento (branch disfarçada)
 * @author albertoluizsouza
 *
 */

@RestController
// 2 pontos de entendimento

// 3 pontos de entendimento

// limite máximo de 7 pontos
public class NovoUsuarioController {
	
	@Autowired
	//1 UsuarioRepository
	private UsuarioRepository usuarioRepository;
	
	@PostMapping(value = "/usuarios")
	//dados de fora do sistema que querem entrar no sistema
	//1 NovoUsuarioRequest
	public Long novo(@RequestBody @Valid NovoUsuarioRequest request) {
		//1 Usuario
		Usuario novoUsuario = request.criaUsuario();
		usuarioRepository.save(novoUsuario);
				
		return novoUsuario.getId();
	}

}
