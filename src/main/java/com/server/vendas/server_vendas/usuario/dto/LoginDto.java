package com.server.vendas.server_vendas.usuario.dto;

import java.util.UUID;

public record LoginDto(UUID usuarioId, String jwt) {}
