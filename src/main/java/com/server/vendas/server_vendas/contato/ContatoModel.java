package com.server.vendas.server_vendas.contato;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcType;
import org.hibernate.dialect.PostgreSQLEnumJdbcType;

@Entity
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "contato")
public class ContatoModel {

  @Id
  @Column(name = "id_contato")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID idContato;

  @NonNull private String nome;

  @NonNull private String sobrenome;

  @Column(name = "dt_nascimento")
  private Date dtNascimento;

  @NonNull
  @Column(name = "nr_celular")
  private String nrCelular;

  @Column(name = "nm_empresa")
  private String nmEmpresa;

  private String cnpj;

  private String endereco;

  private String cidade;

  private String segmento;

  @NonNull
  @Enumerated(EnumType.STRING)
  @JdbcType(value = PostgreSQLEnumJdbcType.class)
  private Status status;

  @Column(name = "dt_reuniao")
  private Date dtReuniao;
}
