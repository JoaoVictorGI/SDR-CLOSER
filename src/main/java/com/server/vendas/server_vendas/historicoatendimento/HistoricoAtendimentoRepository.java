package com.server.vendas.server_vendas.historicoatendimento;

import com.server.vendas.server_vendas.atendimento.AtendimentoModel;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoricoAtendimentoRepository
    extends JpaRepository<HistoricoAtendimentoModel, UUID> {
  List<HistoricoAtendimentoModel> findByIdAtendimento(AtendimentoModel idAtendimento);

  Optional<HistoricoAtendimentoModel> findFirstByIdAtendimentoOrderByDtAtualizacaoDesc(
      AtendimentoModel idAtendimento);
}
