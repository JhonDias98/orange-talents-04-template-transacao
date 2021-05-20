package br.com.zupacademy.jonathan.transacao.estabelecimento;

import javax.validation.constraints.NotBlank;

public class EstabelecimentoRequest {

	@NotBlank
	private String nome;
	@NotBlank
	private String cidade;
	@NotBlank
	private String endereco;

	public EstabelecimentoRequest(String nome, String cidade, String endereco) {
		this.nome = nome;
		this.cidade = cidade;
		this.endereco = endereco;
	}
	
	@Deprecated
	public EstabelecimentoRequest() {}

	public String getNome() {
		return nome;
	}

	public String getCidade() {
		return cidade;
	}

	public String getEndereco() {
		return endereco;
	}

}
