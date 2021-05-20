package br.com.zupacademy.jonathan.transacao.cartao;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class CartaoRequest {

	@NotBlank
	private String numero;
	@Email
	private String email;

	public CartaoRequest(String numero, String email) {
		this.numero = numero;
		this.email = email;
	}
	
	@Deprecated
	public CartaoRequest() {}

	public String getNumero() {
		return numero;
	}

	public String getEmail() {
		return email;
	}
	
}
