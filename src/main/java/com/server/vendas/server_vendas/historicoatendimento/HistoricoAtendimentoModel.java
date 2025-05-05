package com.server.vendas.server_vendas.historicoatendimento;

import com.server.vendas.server_vendas.atendimento.AtendimentoModel;
import com.server.vendas.server_vendas.contato.Status;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Date;
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
@Table(name = "historico_atendimento")
public class HistoricoAtendimentoModel {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id_historico_atendimento")
  private UUID idHistoricoAtendimento;

  @ManyToOne
  @JoinColumn(name = "id_atendimento")
  private AtendimentoModel idAtendimento;

  @Column(name = "valor_anterior")
  private Status valorAnterior;

  @Column(name = "valor_novo")
  private Status valorNovo;

  @Column(name = "dt_atualizacao")
  private Date dtAtualizacao;
}
