package com.server.vendas.server_vendas.contato;

import com.server.vendas.server_vendas.contato.dto.ContatoDto;
import com.server.vendas.server_vendas.contato.dto.FindAllContatoDto;
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
@RequestMapping("contato")
public class ContatoController {

  private final ContatoService contatoService;

  @PostMapping
  public ResponseEntity<ContatoDto> createUsuario(@RequestBody @Valid ContatoDto contato) {
    return ResponseEntity.status(HttpStatus.CREATED).body(contatoService.save(contato));
  }

  @GetMapping
  public ResponseEntity<FindAllContatoDto> findAllUsuarios() {
    return ResponseEntity.status(HttpStatus.OK).body(contatoService.findAll());
  }

  @GetMapping("{id}")
  public ResponseEntity<ContatoDto> findById(@PathVariable UUID id) {
    return ResponseEntity.status(HttpStatus.OK).body(contatoService.findById(id));
  }

  @PatchMapping("{id}")
  public ResponseEntity<ContatoDto> updateUsuario(
      @PathVariable UUID id, @RequestBody @Valid ContatoDto contatoDto) {
    return ResponseEntity.status(HttpStatus.OK).body(contatoService.update(id, contatoDto));
  }

  @DeleteMapping("{id}")
  public ResponseEntity<Object> deleteUsuario(@PathVariable UUID id) {
    contatoService.delete(id);
    return ResponseEntity.status(HttpStatus.OK).body("Usuário removido com sucesso");
  }
}
