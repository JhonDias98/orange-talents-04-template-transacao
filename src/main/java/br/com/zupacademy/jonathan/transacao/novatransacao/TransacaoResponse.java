package br.com.zupacademy.jonathan.transacao.novatransacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.com.zupacademy.jonathan.transacao.estabelecimento.EstabelecimentoResponse;

public class TransacaoResponse {
	
	private String id;
	private BigDecimal valor;
	private LocalDateTime efetivadaEm;
	private EstabelecimentoResponse estabelecimento;

	public TransacaoResponse(Transacao transacao) {
		this.id = transacao.getIdTransacao();
		this.valor = transacao.getValor();
		this.efetivadaEm = transacao.getEfetivadaEm();
		this.estabelecimento = new EstabelecimentoResponse(transacao.getEstabelecimento());
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

	public EstabelecimentoResponse getEstabelecimento() {
		return estabelecimento;
	}
	
}
