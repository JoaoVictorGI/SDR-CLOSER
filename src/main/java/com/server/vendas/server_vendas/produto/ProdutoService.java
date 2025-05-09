package com.server.vendas.server_vendas.produto;

import com.server.vendas.server_vendas.produto.dto.FindAllProdutoDto;
import com.server.vendas.server_vendas.produto.dto.ProdutoDto;
import com.server.vendas.server_vendas.script.ScriptMapper;
import com.server.vendas.server_vendas.script.ScriptService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class ProdutoService {

  private final ProdutoRepository produtoRepository;
  private final ScriptService scriptService;

  public ProdutoDto save(ProdutoDto produtoDto) {
    var scriptModel = ScriptMapper.toModel(scriptService.findById(produtoDto.idScript()));

    var produtoModel = new ProdutoModel();
    BeanUtils.copyProperties(produtoDto, produtoModel, "idScript");
    produtoModel.setIdScript(scriptModel);

    return ProdutoMapper.toDto(produtoRepository.save(produtoModel));
  }

  public ProdutoDto findById(Long id) {
    var produtoModel =
        this.produtoRepository
            .findById(id)
            .orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado"));
    return ProdutoMapper.toDto(produtoModel);
  }

  public FindAllProdutoDto findAll() {
    var produtos = produtoRepository.findAll().stream().map(ProdutoMapper::toDto).toList();
    return new FindAllProdutoDto(produtos);
  }

  public ProdutoDto update(Long id, ProdutoDto produtoDto) {
    var produtoModel =
        produtoRepository
            .findById(id)
            .orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado"));

    BeanUtils.copyProperties(produtoDto, produtoModel);

    return ProdutoMapper.toDto(produtoModel);
  }

  public void delete(Long id) {
    var produtoModel =
        produtoRepository
            .findById(id)
            .orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado"));

    produtoRepository.delete(produtoModel);
  }
}
