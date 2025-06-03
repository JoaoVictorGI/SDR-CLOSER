package com.server.vendas.server_vendas.produto.dto;

import jakarta.validation.constraints.NotNull;

public record NoIdProdutoDto(String nmProduto, @NotNull String idScript) {}
