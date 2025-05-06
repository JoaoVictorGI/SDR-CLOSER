package com.server.vendas.server_vendas.historicoatendimento.dto;

import com.server.vendas.server_vendas.atendimento.AtendimentoModel;
import com.server.vendas.server_vendas.contato.Status;

public record HistoricoAtendimentoDto(
    AtendimentoModel idAtendimento,
    Status valorAnterior,
    Status valorNovo,
    java.util.Date dtAtualizacao) {}
