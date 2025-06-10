package com.server.vendas.server_vendas.atendimento;

import com.server.vendas.server_vendas.atendimento.dto.AtendimentoDto;
import com.server.vendas.server_vendas.atendimento.dto.RequestAtendimentoDto;
import com.server.vendas.server_vendas.produto.ProdutoMapper;

public class AtendimentoMapper {
  public static AtendimentoDto toDto(AtendimentoModel atendimentoModel) {
    return new AtendimentoDto(
        atendimentoModel.getIdAtendimento(),
        atendimentoModel.getIdUsuario(),
        atendimentoModel.getIdContato(),
        ProdutoMapper.toDto(atendimentoModel.getIdProduto()));
  }

  public static RequestAtendimentoDto toCreateRequestDto(AtendimentoModel atendimentoModel) {
    return new RequestAtendimentoDto(
        atendimentoModel.getIdUsuario().getIdUsuario(),
        atendimentoModel.getIdContato().getIdContato(),
        atendimentoModel.getIdProduto().getNmProduto());
  }
}
