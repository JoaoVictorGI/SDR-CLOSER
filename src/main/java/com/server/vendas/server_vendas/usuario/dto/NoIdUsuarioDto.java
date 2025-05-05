package com.server.vendas.server_vendas.usuario.dto;

import com.server.vendas.server_vendas.usuario.Cargo;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record NoIdUsuarioDto(
    @NotNull String nome,
    @NotNull @Email String email,
    @NotBlank String senha,
    @NotNull Cargo cargo) {}
