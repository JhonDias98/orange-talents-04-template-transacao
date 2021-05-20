package br.com.zupacademy.jonathan.transacao.novatransacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.hibernate.annotations.CreationTimestamp;

import br.com.zupacademy.jonathan.transacao.cartao.Cartao;
import br.com.zupacademy.jonathan.transacao.estabelecimento.Estabelecimento;

@Entity
public class Transacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String idTransacao;
	@NotNull
	@Positive
	private BigDecimal valor;
	@NotNull
	@CreationTimestamp
	private LocalDateTime efetivadaEm;
	@NotNull
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private Cartao cartao;
	@NotNull
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private Estabelecimento estabelecimento;
	
	public Transacao(String idTransacao, BigDecimal valor, LocalDateTime efetivadaEm, Cartao cartao, Estabelecimento estabelecimento) {
		this.idTransacao = idTransacao;
		this.valor = valor;
		this.efetivadaEm = efetivadaEm;
		this.cartao = cartao;
		this.estabelecimento = estabelecimento;
	}
	
	@Deprecated
	public Transacao() {}

	public Long getId() {
		return id;
	}

	public String getIdTransacao() {
		return idTransacao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public LocalDateTime getEfetivadaEm() {
		return efetivadaEm;
	}

	public Cartao getCartao() {
		return cartao;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}
	
}
