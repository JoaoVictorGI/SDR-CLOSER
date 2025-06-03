package com.server.vendas.server_vendas.atendimento.dto;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;

public record RequestAtendimentoDto(
    @NotNull UUID idUsuario, @NotNull UUID idContato, @NotNull String nmProduto) {}
