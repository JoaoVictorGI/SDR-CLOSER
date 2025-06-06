package com.server.vendas.server_vendas.atendimento.dto;

import com.server.vendas.server_vendas.contato.Status;
import jakarta.validation.constraints.NotNull;
import java.util.UUID;

public record UpdateAtendimentoDto(@NotNull UUID idContato, Status status) {}
