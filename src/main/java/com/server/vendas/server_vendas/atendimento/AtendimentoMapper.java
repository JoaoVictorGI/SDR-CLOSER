package com.server.vendas.server_vendas.atendimento;

import com.server.vendas.server_vendas.atendimento.dto.AtendimentoDto;

public class AtendimentoMapper {
  public static AtendimentoDto toDto(AtendimentoModel atendimentoModel) {
    return new AtendimentoDto(
        atendimentoModel.getIdUsuario(),
        atendimentoModel.getIdContato(),
        atendimentoModel.getDtCriacao(),
        atendimentoModel.getDtAtualizacao());
  }
}
