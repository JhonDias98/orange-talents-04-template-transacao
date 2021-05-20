package br.com.zupacademy.jonathan.transacao.novatransacao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepository extends JpaRepository<Transacao, Long>{

	List<Transacao> findFirst10ByCartaoNumeroOrderByEfetivadaEmDesc(String numero);
}
