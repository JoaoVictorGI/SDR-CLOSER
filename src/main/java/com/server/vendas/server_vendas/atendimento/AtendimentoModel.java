package com.server.vendas.server_vendas.atendimento;

import com.server.vendas.server_vendas.contato.ContatoModel;
import com.server.vendas.server_vendas.produto.ProdutoModel;
import com.server.vendas.server_vendas.usuario.UsuarioModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "atendimento")
public class AtendimentoModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_atendimento")
  private Long idAtendimento;

  @ManyToOne
  @JoinColumn(name = "id_usuario")
  private UsuarioModel idUsuario;

  @ManyToOne
  @JoinColumn(name = "id_contato")
  private ContatoModel idContato;

  @ManyToOne
  @JoinColumn(name = "id_produto")
  private ProdutoModel idProduto;

  @CreationTimestamp
  @Column(name = "dt_criacao")
  private Date dtCriacao;

  @UpdateTimestamp
  @Column(name = "dt_atualizacao")
  private Date dtAtualizacao;
}
