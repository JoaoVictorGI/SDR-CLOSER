package com.server.vendas.server_vendas.produto;

import com.server.vendas.server_vendas.script.ScriptModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "produto")
public class ProdutoModel {

  @Id
  @Column(name = "id_produto")
  private Long idProduto;

  @Column(name = "nm_produto")
  private String nmProduto;

  @ManyToOne
  @JoinColumn(name = "id_script")
  private ScriptModel idScript;
}
