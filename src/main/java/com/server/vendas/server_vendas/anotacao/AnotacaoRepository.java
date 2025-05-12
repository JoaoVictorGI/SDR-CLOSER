package com.server.vendas.server_vendas.anotacao;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.stereotype.Repository;

@Repository
public interface AnotacaoRepository extends JpaRepository<AnotacaoModel, UUID> {

  @NativeQuery(value = "SELECT * FROM anotacao WHERE id_atendimento = ?1")
  Optional<AnotacaoModel> findByIdAtendimento(Long id);
}
