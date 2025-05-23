package com.server.vendas.server_vendas.historicoatendimento;

import com.server.vendas.server_vendas.atendimento.AtendimentoModel;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoricoAtendimentoRepository
    extends JpaRepository<HistoricoAtendimentoModel, UUID> {
  Optional<HistoricoAtendimentoModel> findByIdAtendimento(AtendimentoModel idAtendimento);
}
