package com.server.vendas.server_vendas.anotacao;

import com.server.vendas.server_vendas.anotacao.dto.AnotacaoDto;

public class AnotacaoMapper {
  public static AnotacaoDto toDto(AnotacaoModel anotacaoModel) {
    return new AnotacaoDto(anotacaoModel.getAnotacao(), anotacaoModel.getIdAtendimento());
  }
}
