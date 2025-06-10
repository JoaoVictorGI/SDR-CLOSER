package com.server.vendas.server_vendas.historicoatendimento;

import com.server.vendas.server_vendas.atendimento.AtendimentoModel;
import com.server.vendas.server_vendas.contato.Status;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.domain.Persistable;
import org.springframework.lang.Nullable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "historico_atendimento")
public class HistoricoAtendimentoModel implements Persistable<UUID> {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id_historico_atendimento")
  private UUID idHistoricoAtendimento;

  @ManyToOne
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JoinColumn(name = "id_atendimento")
  private AtendimentoModel idAtendimento;

  @Column(name = "valor_anterior")
  @Enumerated(EnumType.STRING)
  private Status valorAnterior;

  @Column(name = "valor_novo")
  @Enumerated(EnumType.STRING)
  private Status valorNovo;

  @UpdateTimestamp
  @Column(name = "dt_atualizacao")
  private Date dtAtualizacao;

  @Override
  public boolean isNew() {
    return true;
  }

  @Override
  @Nullable
  public UUID getId() {
    return this.idHistoricoAtendimento;
  }
}
