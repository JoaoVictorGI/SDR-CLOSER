package com.server.vendas.server_vendas.produto;

import com.server.vendas.server_vendas.produto.dto.NoIdProdutoDto;
import com.server.vendas.server_vendas.produto.dto.ProdutoDto;
import com.server.vendas.server_vendas.script.ScriptModel;

public class ProdutoMapper {

  public static ProdutoDto toDto(ProdutoModel produtoModel) {
    return new ProdutoDto(
        produtoModel.getIdProduto(),
        produtoModel.getNmProduto(),
        produtoModel.getIdScript().getIdScript(),
        produtoModel.getIdScript().getScript());
  }

  public static ProdutoModel toModel(ProdutoDto produtoDto) {
    return new ProdutoModel(
        produtoDto.idProduto(), produtoDto.nmProduto(), new ScriptModel(null, produtoDto.script()));
  }

  public static ProdutoModel NoIdProdutoDtotoModel(NoIdProdutoDto noIdProdutoDto) {
    return new ProdutoModel(
        null, noIdProdutoDto.nmProduto(), new ScriptModel(null, noIdProdutoDto.idScript()));
  }
}
