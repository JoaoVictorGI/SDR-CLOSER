package com.server.vendas.server_vendas.usuario.dto;

import jakarta.validation.constraints.NotNull;

public record LoginRequestDto(@NotNull String email, @NotNull String senha) {}
