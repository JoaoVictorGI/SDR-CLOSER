package com.server.vendas.server_vendas.historicoatendimento;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoricoAtendimentoRepository
    extends JpaRepository<HistoricoAtendimentoModel, UUID> {}
