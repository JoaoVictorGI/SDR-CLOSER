package com.server.vendas.server_vendas.script;

import com.server.vendas.server_vendas.script.dto.FindAllScriptDto;
import com.server.vendas.server_vendas.script.dto.ScriptDto;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("script")
public class ScriptController {

  @Autowired ScriptService scriptService;

  @PostMapping
  public ResponseEntity<ScriptDto> create(@RequestBody @Valid ScriptDto scriptDto) {
    return ResponseEntity.status(HttpStatus.OK).body(scriptService.save(scriptDto));
  }

  @GetMapping
  public ResponseEntity<FindAllScriptDto> findAll() {
    return ResponseEntity.status(HttpStatus.OK).body(scriptService.findAll());
  }

  @GetMapping("{id}")
  public ResponseEntity<ScriptDto> findById(@PathVariable @Valid UUID id) {
    return ResponseEntity.status(HttpStatus.OK).body(scriptService.findById(id));
  }

  @PatchMapping("{id}")
  public ResponseEntity<ScriptDto> update(
      @PathVariable @Valid UUID id, @RequestBody @Valid ScriptDto scriptDto) {
    return ResponseEntity.status(HttpStatus.OK).body(scriptService.update(id, scriptDto));
  }

  @DeleteMapping("{id}")
  public ResponseEntity<String> delete(@PathVariable UUID id) {
    scriptService.delete(id);
    return ResponseEntity.status(HttpStatus.OK).body("Usuário removido com sucesso");
  }
}
