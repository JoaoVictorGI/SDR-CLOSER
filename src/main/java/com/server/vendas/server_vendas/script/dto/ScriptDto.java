package com.server.vendas.server_vendas.script.dto;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;

public record ScriptDto(UUID idScript, @NotNull String script) {}
