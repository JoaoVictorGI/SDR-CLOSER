package com.server.vendas.server_vendas.anotacao;

import com.server.vendas.server_vendas.anotacao.dto.AnotacaoDto;
import com.server.vendas.server_vendas.anotacao.dto.FindAllAnotacaoDto;
import jakarta.validation.Valid;
import java.util.UUID;
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
@RequestMapping("anotacao")
public class AnotacaoController {

  private final AnotacaoService anotacaoService;

  @PostMapping
  public ResponseEntity<AnotacaoDto> create(@RequestBody @Valid AnotacaoDto anotacaoDto) {
    return ResponseEntity.status(HttpStatus.OK).body(anotacaoService.save(anotacaoDto));
  }

  @GetMapping
  public ResponseEntity<FindAllAnotacaoDto> findAll() {
    return ResponseEntity.status(HttpStatus.OK).body(anotacaoService.findAll());
  }

  @GetMapping("{id}")
  public ResponseEntity<AnotacaoDto> findById(@PathVariable UUID id) {
    return ResponseEntity.status(HttpStatus.OK).body(anotacaoService.findById(id));
  }

  @PatchMapping("{id}")
  public ResponseEntity<AnotacaoDto> update(
      @PathVariable UUID id, @RequestBody @Valid AnotacaoDto anotacaoDto) {
    return ResponseEntity.status(HttpStatus.OK).body(anotacaoService.update(id, anotacaoDto));
  }

  @DeleteMapping("{id}")
  public ResponseEntity<String> delete(@PathVariable UUID id) {
    anotacaoService.delete(id);
    return ResponseEntity.status(HttpStatus.OK).body("Anotação removida com sucesso");
  }

  @GetMapping("atendimento/{id}")
  public ResponseEntity<AnotacaoDto> findByIdAtendimento(@PathVariable Long id) {
    return ResponseEntity.status(HttpStatus.OK).body(anotacaoService.findByIdAtendimento(id));
  }
}
