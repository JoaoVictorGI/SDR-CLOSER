package com.server.vendas.server_vendas.atendimento;

import com.server.vendas.server_vendas.atendimento.dto.AtendimentoDto;
import com.server.vendas.server_vendas.atendimento.dto.FindAllAtendimentoDto;
import com.server.vendas.server_vendas.atendimento.dto.RequestAtendimentoDto;
import com.server.vendas.server_vendas.atendimento.dto.UpdateAtendimentoDto;
import jakarta.validation.Valid;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
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
@RequestMapping("atendimento")
public class AtendimentoController {

  private final AtendimentoService atendimentoService;

  @PostMapping
  public ResponseEntity<AtendimentoDto> create(
      @RequestBody @Valid RequestAtendimentoDto atendimentoDto) {
    return ResponseEntity.status(HttpStatus.OK).body(atendimentoService.save(atendimentoDto));
  }

  @GetMapping
  public ResponseEntity<FindAllAtendimentoDto> findAll() {
    return ResponseEntity.status(HttpStatus.OK).body(atendimentoService.findAll());
  }

  @GetMapping("{id}")
  public ResponseEntity<AtendimentoDto> findById(@PathVariable Long id) {
    return ResponseEntity.status(HttpStatus.OK).body(atendimentoService.findById(id));
  }

  @PatchMapping("{id}")
  public ResponseEntity<AtendimentoDto> update(
      @PathVariable Long id, @RequestBody @Valid UpdateAtendimentoDto atendimentoDto) {
    return ResponseEntity.status(HttpStatus.OK).body(atendimentoService.update(id, atendimentoDto));
  }

  @DeleteMapping("{id}")
  public ResponseEntity<String> delete(@PathVariable Long id) {
    atendimentoService.delete(id);
    return ResponseEntity.status(HttpStatus.OK).body("Atendimento deletado com sucesso");
  }

  @GetMapping("user/{id}")
  public ResponseEntity<List<AtendimentoDto>> findByIdUsuario(
      @PathVariable UUID id, Pageable pageable) {
    return ResponseEntity.status(HttpStatus.OK)
        .body(atendimentoService.findByIdUsuario(id, pageable));
  }
}
