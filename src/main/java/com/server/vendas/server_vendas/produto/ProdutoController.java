package com.server.vendas.server_vendas.produto;

import com.server.vendas.server_vendas.produto.dto.FindAllProdutoDto;
import com.server.vendas.server_vendas.produto.dto.ProdutoDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("produto")
public class ProdutoController {

  private final ProdutoService produtoService;

  @PostMapping
  public ResponseEntity<ProdutoDto> create(@RequestBody @Valid ProdutoDto produtoDto) {
    return ResponseEntity.status(HttpStatus.OK).body(produtoService.save(produtoDto));
  }

  @GetMapping
  public ResponseEntity<FindAllProdutoDto> findAll() {
    return ResponseEntity.status(HttpStatus.OK).body(produtoService.findAll());
  }

  @GetMapping("{id}")
  public ResponseEntity<ProdutoDto> findById(@PathVariable Long id) {
    return ResponseEntity.status(HttpStatus.OK).body(produtoService.findById(id));
  }

  @PatchMapping("{id}")
  public ResponseEntity<ProdutoDto> update(
      @PathVariable Long id, @RequestBody @Valid ProdutoDto produtoDto) {
    return ResponseEntity.status(HttpStatus.OK).body(produtoService.update(id, produtoDto));
  }

  @DeleteMapping("{id}")
  public ResponseEntity<String> delete(@PathVariable Long id) {
    produtoService.delete(id);
    return ResponseEntity.status(HttpStatus.OK).body("Usuário removido com sucesso");
  }
}
