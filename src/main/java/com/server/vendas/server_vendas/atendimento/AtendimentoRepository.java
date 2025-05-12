package com.server.vendas.server_vendas.atendimento;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.stereotype.Repository;

@Repository
public interface AtendimentoRepository extends JpaRepository<AtendimentoModel, Long> {

  @NativeQuery(
      value = "SELECT * FROM atendimento WHERE id_usuario = ?1",
      countQuery = "SELECT COUNT(*) FROM atendimento WHERE id_usuario = ?1")
  Optional<List<AtendimentoModel>> findByIdUsuario(UUID idUsuario, Pageable pageable);
}
