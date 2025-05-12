package com.server.vendas.server_vendas.usuario;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, UUID> {

  Optional<UsuarioModel> findByEmail(String email);

  boolean existsByEmail(String email);
}
