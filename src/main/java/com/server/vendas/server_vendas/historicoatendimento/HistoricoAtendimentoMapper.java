package com.server.vendas.server_vendas.historicoatendimento;

import com.server.vendas.server_vendas.historicoatendimento.dto.HistoricoAtendimentoDto;

public class HistoricoAtendimentoMapper {
  public static HistoricoAtendimentoDto toDto(HistoricoAtendimentoModel historicoAtendimentoModel) {
    return new HistoricoAtendimentoDto(
        historicoAtendimentoModel.getIdAtendimento(),
        historicoAtendimentoModel.getValorAnterior(),
        historicoAtendimentoModel.getValorNovo());
  }
}
