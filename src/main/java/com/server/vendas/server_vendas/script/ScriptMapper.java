package com.server.vendas.server_vendas.script;

import com.server.vendas.server_vendas.script.dto.ScriptDto;

public class ScriptMapper {
  public static ScriptDto toDto(ScriptModel scriptModel) {
    return new ScriptDto(scriptModel.getScript());
  }
}
