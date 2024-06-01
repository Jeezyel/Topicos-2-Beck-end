package br.unitins.repository;

import br.unitins.model.Pagamento;
import br.unitins.model.TipoPagamento;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;


@ApplicationScoped
public class PagamentoRepository implements PanacheRepository<Pagamento> {

    public List<Pagamento> findByTipoPagamento(TipoPagamento tipoPagamento ){
        if (tipoPagamento == null)
            return null;
        return find("UPPER(tipoPagamento) ", tipoPagamento).list();
    }
}
