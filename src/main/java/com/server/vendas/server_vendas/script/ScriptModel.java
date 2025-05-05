package com.server.vendas.server_vendas.script;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "script")
public class ScriptModel {

  @Id
  @Column(name = "id_script")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID idScript;

  private String script;
}
