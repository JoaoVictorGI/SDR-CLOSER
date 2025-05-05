package com.server.vendas.server_vendas.script;

import com.server.vendas.server_vendas.script.dto.FindAllScriptDto;
import com.server.vendas.server_vendas.script.dto.ScriptDto;
import java.util.UUID;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ScriptService {

  @Autowired ScriptRepository scriptRepository;

  public ScriptDto save(ScriptDto scriptDto) {
    var scriptModel = new ScriptModel();
    BeanUtils.copyProperties(scriptDto, scriptModel);

    return ScriptMapper.toDto(scriptRepository.save(scriptModel));
  }

  public ScriptDto findById(UUID id) {
    var scriptModel =
        scriptRepository
            .findById(id)
            .orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Script não encontrado"));
    return ScriptMapper.toDto(scriptModel);
  }

  public FindAllScriptDto findAll() {
    var scripts = scriptRepository.findAll().stream().map(ScriptMapper::toDto).toList();

    return new FindAllScriptDto(scripts);
  }

  public ScriptDto update(UUID id, ScriptDto scriptDto) {
    ScriptModel scriptModel =
        scriptRepository
            .findById(id)
            .orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Script não encontrado"));

    BeanUtils.copyProperties(scriptDto, scriptModel);

    return ScriptMapper.toDto(scriptRepository.save(scriptModel));
  }

  public void delete(UUID id) {
    var scriptModel =
        scriptRepository
            .findById(id)
            .orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Script não encontrado"));
    scriptRepository.delete(scriptModel);
  }
}
