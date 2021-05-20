package br.com.zupacademy.jonathan.transacao.gateway.transacao;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.zupacademy.jonathan.transacao.cartao.CartaoRequest;

@FeignClient(value = "transacao", url = "${transacao.host}")
public interface TransacaoClient {

	@PostMapping
	void efetuarTransacao(@RequestBody CartaoRequest transacao);

	@DeleteMapping("/{id}")
	void encerrarTransacao(@PathVariable("id") String id);
}
