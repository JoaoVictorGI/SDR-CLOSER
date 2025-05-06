package com.server.vendas.server_vendas.produto;

import com.server.vendas.server_vendas.produto.dto.ProdutoDto;

public class ProdutoMapper {
  public static ProdutoDto toDto(ProdutoModel produtoModel) {
    return new ProdutoDto(produtoModel.getNmProduto(), produtoModel.getIdScript());
  }
}
