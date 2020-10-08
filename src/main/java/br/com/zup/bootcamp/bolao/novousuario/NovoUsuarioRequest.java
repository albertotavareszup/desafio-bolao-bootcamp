package br.com.zup.bootcamp.bolao.novousuario;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

//limite máximo 9 
public class NovoUsuarioRequest {

	@NotBlank
	@Email
	private String login;
	@NotBlank
	@Length(min = 6)
	private String senha;

	public NovoUsuarioRequest(String login, String senha) {
		this.login = login;
		this.senha = senha;
	}
	
	@Override
	public String toString() {
		return "NovoUsuarioRequest [login=" + login + "]";
	}

	public Usuario criaUsuario() {
		return new Usuario(this.login,this.senha);
	}

}
