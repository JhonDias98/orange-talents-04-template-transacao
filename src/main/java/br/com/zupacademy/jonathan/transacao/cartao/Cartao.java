package br.com.zupacademy.jonathan.transacao.cartao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
public class Cartao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	//@NotBlank
	private String numero;
	@Email
	private String email;

	public Cartao(String numero, String email) {
		this.numero = numero;
		this.email = email;
	}
	
	@Deprecated
	public Cartao() {}

	public Long getId() {
		return id;
	}

	public String getNumero() {
		return numero;
	}

	public String getEmail() {
		return email;
	}
	
}
