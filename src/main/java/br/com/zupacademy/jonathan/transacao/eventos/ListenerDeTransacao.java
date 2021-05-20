package br.com.zupacademy.jonathan.transacao.eventos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import br.com.zupacademy.jonathan.transacao.novatransacao.TransacaoRepository;
import br.com.zupacademy.jonathan.transacao.novatransacao.TransacaoMensagem;

@Component
public class ListenerDeTransacao {

	@Autowired
	private TransacaoRepository transacaoRepository;

	@KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void ouvir(TransacaoMensagem eventoDeTransacao) {
		System.out.println("---------------------------------");
        System.out.println("Nova Trasação");
        transacaoRepository.save(eventoDeTransacao.toModel());
        System.out.println("Concluído");    
        }
}
