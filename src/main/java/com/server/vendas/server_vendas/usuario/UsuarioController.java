package com.server.vendas.server_vendas.usuario;

import com.server.vendas.server_vendas.usuario.dto.CompleteUsuarioDto;
import com.server.vendas.server_vendas.usuario.dto.FindAllUsuarioDto;
import com.server.vendas.server_vendas.usuario.dto.NoIdUsuarioDto;
import com.server.vendas.server_vendas.usuario.dto.UsuarioDto;
import jakarta.validation.Valid;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("usuario")
public class UsuarioController {

  @Autowired UsuarioService usuarioService;

  @PostMapping
  public ResponseEntity<UsuarioDto> createUsuario(@RequestBody @Valid NoIdUsuarioDto usuario) {
    return ResponseEntity.status(HttpStatus.CREATED).body(this.usuarioService.save(usuario));
  }

  @GetMapping
  public ResponseEntity<FindAllUsuarioDto> findAllUsuarios() {
    return ResponseEntity.status(HttpStatus.OK).body(this.usuarioService.findAll());
  }

  @GetMapping("{id}")
  public ResponseEntity<CompleteUsuarioDto> findById(@PathVariable UUID id) {
    return ResponseEntity.status(HttpStatus.OK).body(this.usuarioService.findById(id));
  }

  @PatchMapping("{id}")
  public ResponseEntity<UsuarioDto> updateUsuario(
      @PathVariable UUID id, @RequestBody @Valid NoIdUsuarioDto usuarioDto) {
    return ResponseEntity.status(HttpStatus.OK).body(this.usuarioService.update(id, usuarioDto));
  }

  @DeleteMapping("{id}")
  public ResponseEntity<Object> deleteUsuario(@PathVariable UUID id) {
    this.usuarioService.delete(id);
    return ResponseEntity.status(HttpStatus.OK).body("Usuário removido com sucesso");
  }
}
