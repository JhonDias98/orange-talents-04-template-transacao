package br.com.zupacademy.jonathan.transacao.novatransacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.com.zupacademy.jonathan.transacao.cartao.CartaoResponse;
import br.com.zupacademy.jonathan.transacao.estabelecimento.EstabelecimentoResponse;

public class TransacaoMensagem {

	private String id;
	private BigDecimal valor;
	private LocalDateTime efetivadaEm;
	private CartaoResponse cartao;
	private EstabelecimentoResponse estabelecimento;

	public TransacaoMensagem(Transacao transacao) {
		this.id = transacao.getIdTransacao();
		this.valor = transacao.getValor();
		this.efetivadaEm = transacao.getEfetivadaEm();
		this.cartao = new CartaoResponse(transacao.getCartao().getNumero(), transacao.getCartao().getEmail());
		this.estabelecimento = new EstabelecimentoResponse(transacao.getEstabelecimento().getNome(),
														   transacao.getEstabelecimento().getCidade(),
														   transacao.getEstabelecimento().getEndereco());
	}

	@Deprecated
	public TransacaoMensagem() {
	}

	public String getId() {
		return id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public LocalDateTime getEfetivadaEm() {
		return efetivadaEm;
	}

	public CartaoResponse getCartao() {
		return cartao;
	}

	public EstabelecimentoResponse getEstabelecimento() {
		return estabelecimento;
	}

	public Transacao toModel() {
		return new Transacao(id, valor, efetivadaEm, cartao.toModel(), estabelecimento.toModel());
	}
}
