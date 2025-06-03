package com.server.vendas.server_vendas.historicoatendimento;

import com.server.vendas.server_vendas.historicoatendimento.dto.FindAllHistoricoAtendimentoDto;
import com.server.vendas.server_vendas.historicoatendimento.dto.HistoricoAtendimentoDto;
import jakarta.validation.Valid;
import java.util.List;
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
@RequestMapping("historicoatendimento")
public class HistoricoAtendimentoController {

  private final HistoricoAtendimentoService historicoAtendimentoService;

  @PostMapping
  public ResponseEntity<HistoricoAtendimentoDto> create(
      @RequestBody @Valid HistoricoAtendimentoDto historicoAtendimentoDto) {
    return ResponseEntity.status(HttpStatus.OK)
        .body(historicoAtendimentoService.save(historicoAtendimentoDto));
  }

  @GetMapping
  public ResponseEntity<FindAllHistoricoAtendimentoDto> findAll() {
    return ResponseEntity.status(HttpStatus.OK).body(historicoAtendimentoService.findAll());
  }

  @GetMapping("{id}")
  public ResponseEntity<HistoricoAtendimentoDto> findById(@PathVariable UUID id) {
    return ResponseEntity.status(HttpStatus.OK).body(historicoAtendimentoService.findById(id));
  }

  @GetMapping("/atendimento/{id}")
  public ResponseEntity<List<HistoricoAtendimentoDto>> findByAtendimentoId(@PathVariable Long id) {
    return ResponseEntity.status(HttpStatus.OK)
        .body(historicoAtendimentoService.findByIdAtendimento(id));
  }

  @PatchMapping("{id}")
  public ResponseEntity<HistoricoAtendimentoDto> update(
      @PathVariable UUID id, @RequestBody @Valid HistoricoAtendimentoDto historicoAtendimentoDto) {
    return ResponseEntity.status(HttpStatus.OK)
        .body(historicoAtendimentoService.update(id, historicoAtendimentoDto));
  }

  @DeleteMapping("{id}")
  public ResponseEntity<String> delete(@PathVariable UUID id) {
    historicoAtendimentoService.delete(id);
    return ResponseEntity.status(HttpStatus.OK).body("Histórico removido com sucesso");
  }
}
