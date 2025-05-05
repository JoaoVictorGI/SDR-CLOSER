package com.server.vendas.server_vendas.usuario.dto;

import com.server.vendas.server_vendas.usuario.Cargo;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import java.util.UUID;

public record UsuarioDto(
    @NotNull UUID idUsuario,
    @NotNull String nome,
    @NotNull @Email String email,
    @NotNull Cargo cargo) {}
