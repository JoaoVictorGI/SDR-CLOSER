package com.server.vendas.server_vendas.produto.dto;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;

public record ProdutoDto(String nmProduto, @NotNull UUID idScript) {}
