package com.server.vendas.server_vendas.anotacao;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnotacaoRepository extends JpaRepository<AnotacaoModel, UUID> {}
