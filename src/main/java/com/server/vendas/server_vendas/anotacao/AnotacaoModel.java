package com.server.vendas.server_vendas.anotacao;

import com.server.vendas.server_vendas.atendimento.AtendimentoModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "anotacao")
public class AnotacaoModel {

  @Id
  @Column(name = "id_anotacao")
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID idAnotacao;

  private String anotacao;

  @ManyToOne
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JoinColumn(name = "id_atendimento")
  private AtendimentoModel idAtendimento;
}
