package com.server.vendas.server_vendas.script;

import com.server.vendas.server_vendas.script.dto.NoIdScriptDto;
import com.server.vendas.server_vendas.script.dto.ScriptDto;

public class ScriptMapper {
  public static ScriptDto toDto(ScriptModel scriptModel) {
    return new ScriptDto(scriptModel.getIdScript(), scriptModel.getScript());
  }

  public static ScriptModel toModel(ScriptDto scriptDto) {
    return new ScriptModel(scriptDto.idScript(), scriptDto.script());
  }

  public static NoIdScriptDto toNoIdScriptDto(ScriptModel scriptModel) {
    return new NoIdScriptDto(scriptModel.getScript());
  }
}
