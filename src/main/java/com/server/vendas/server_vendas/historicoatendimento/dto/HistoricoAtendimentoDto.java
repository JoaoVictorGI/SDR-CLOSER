package com.server.vendas.server_vendas.historicoatendimento.dto;

import com.server.vendas.server_vendas.atendimento.AtendimentoModel;
import com.server.vendas.server_vendas.contato.Status;
import jakarta.validation.constraints.NotNull;
import java.util.Date;

public record HistoricoAtendimentoDto(
    @NotNull AtendimentoModel idAtendimento,
    Status valorAnterior,
    @NotNull Status valorNovo,
    Date dtAtualizacao) {}
