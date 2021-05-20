package br.com.zupacademy.jonathan.transacao.cartao;

public class CartaoResponse {

	private String numero;

    private String email;

	public CartaoResponse(String numero, String email) {
		this.numero = numero;
		this.email = email;
	}
	
	@Deprecated
	public CartaoResponse() {}

	public String getNumero() {
		return numero;
	}

	public String getEmail() {
		return email;
	}
    
	public Cartao toModel() {
		return new Cartao(numero, email);
	}
}
