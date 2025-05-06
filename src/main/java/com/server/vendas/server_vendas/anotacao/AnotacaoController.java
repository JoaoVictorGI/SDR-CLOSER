package com.server.vendas.server_vendas.anotacao;

import com.server.vendas.server_vendas.anotacao.dto.AnotacaoDto;
import com.server.vendas.server_vendas.anotacao.dto.FindAllAnotacaoDto;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("anotacao")
public class AnotacaoController {

  @Autowired AnotacaoService anotacaoService;

  @PostMapping
  public ResponseEntity<AnotacaoDto> create(@RequestBody @Valid AnotacaoDto anotacaoDto) {
    return ResponseEntity.status(HttpStatus.OK).body(anotacaoService.save(anotacaoDto));
  }

  @GetMapping
  public ResponseEntity<FindAllAnotacaoDto> findAll() {
    return ResponseEntity.status(HttpStatus.OK).body(anotacaoService.findAll());
  }

  @GetMapping("{id}")
  public ResponseEntity<AnotacaoDto> findById(@RequestParam UUID id) {
    return ResponseEntity.status(HttpStatus.OK).body(anotacaoService.findById(id));
  }

  @PatchMapping("{id}")
  public ResponseEntity<AnotacaoDto> update(
      @RequestParam UUID id, @RequestBody @Valid AnotacaoDto anotacaoDto) {
    return ResponseEntity.status(HttpStatus.OK).body(anotacaoService.update(id, anotacaoDto));
  }

  @DeleteMapping
  public ResponseEntity<String> delete(@RequestBody UUID id) {
    anotacaoService.delete(id);
    return ResponseEntity.status(HttpStatus.OK).body("Anotação removida com sucesso");
  }
}
