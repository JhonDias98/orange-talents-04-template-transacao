package br.com.zupacademy.jonathan.transacao.novatransacao;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.jonathan.transacao.cartao.CartaoRequest;
import br.com.zupacademy.jonathan.transacao.gateway.transacao.TransacaoClient;
import feign.FeignException;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

	@Autowired
	private TransacaoClient transacaoClient;

	@PostMapping
	public ResponseEntity<?> enviarTransacao(@RequestBody @Valid CartaoRequest request) {
		try {
			transacaoClient.efetuarTransacao(request);
			return ResponseEntity.ok("Transação iniciada");
		} catch (FeignException.FeignServerException | FeignException.FeignClientException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ocorreu um erro");
		}

	}
	
	@DeleteMapping("{id}")
    public ResponseEntity<?> parar(@PathVariable("id") String id){
        try{
            transacaoClient.encerrarTransacao(id);
            return ResponseEntity.ok("Transação Finalizada");
        }catch (FeignException.FeignServerException | FeignException.FeignClientException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ocorreu um erro");
        }
    }
}
