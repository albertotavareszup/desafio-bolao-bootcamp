package br.com.zup.bootcamp.bolao.novousuario;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

/**
 * limite máximo 9 
 * @author albertoluizsouza
 *
 */

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private @NotBlank @Email String login;
	private @NotBlank @Length(min = 6) String senha;

	@Deprecated
	public Usuario() {}

	//entrada de dados só que é do sistema para o sistema
	public Usuario(@NotBlank @Email String login,
			@NotBlank @Length(min = 6) String senha) {
				this.login = login;
				//TODO a gente precisa encodar a senha
				this.senha = "yyyyyyyyyyy";
	}

	@Override
	public String toString() {
		return "Usuario [login=" + login + "]";
	}

	public Long getId() {
		return id;
	}
	
	

}
