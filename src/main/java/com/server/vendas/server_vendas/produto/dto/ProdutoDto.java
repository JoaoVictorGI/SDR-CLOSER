package com.server.vendas.server_vendas.produto.dto;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;

public record ProdutoDto(Long idProduto, String nmProduto, UUID idScript, @NotNull String script) {}
