package com.server.vendas.server_vendas.atendimento;

import com.server.vendas.server_vendas.atendimento.dto.AtendimentoDto;
import com.server.vendas.server_vendas.atendimento.dto.RequestAtendimentoDto;

public class AtendimentoMapper {
  public static AtendimentoDto toDto(AtendimentoModel atendimentoModel) {
    return new AtendimentoDto(
        atendimentoModel.getIdAtendimento(),
        atendimentoModel.getIdUsuario(),
        atendimentoModel.getIdContato());
  }

  public static RequestAtendimentoDto toCreateRequestDto(AtendimentoModel atendimentoModel) {
    return new RequestAtendimentoDto(
        atendimentoModel.getIdUsuario().getIdUsuario(),
        atendimentoModel.getIdContato().getIdContato(),
        atendimentoModel.getIdProduto().getIdProduto());
  }
}
