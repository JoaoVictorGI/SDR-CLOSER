package com.server.vendas.server_vendas.usuario;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcType;
import org.hibernate.dialect.PostgreSQLEnumJdbcType;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "usuario")
public class UsuarioModel {

  @Id
  @Column(name = "id_usuario")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID idUsuario;

  @NotNull private String nome;

  @NotNull @Email private String email;

  @NotBlank private String senha;

  @NotNull
  @Enumerated(EnumType.STRING)
  @JdbcType(value = PostgreSQLEnumJdbcType.class)
  private Cargo cargo;
}
