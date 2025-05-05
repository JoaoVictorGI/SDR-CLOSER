package com.server.vendas.server_vendas.usuario;

import com.server.vendas.server_vendas.usuario.dto.CompleteUsuarioDto;
import com.server.vendas.server_vendas.usuario.dto.UsuarioDto;

public class UsuarioMapper {
  public static UsuarioDto toUsuarioDto(UsuarioModel usuarioModel) {
    return new UsuarioDto(
        usuarioModel.getIdUsuario(),
        usuarioModel.getNome(),
        usuarioModel.getEmail(),
        usuarioModel.getCargo());
  }

  public static CompleteUsuarioDto toComplUsuarioDto(UsuarioModel usuarioModel) {
    return new CompleteUsuarioDto(
        usuarioModel.getIdUsuario(),
        usuarioModel.getNome(),
        usuarioModel.getEmail(),
        usuarioModel.getSenha(),
        usuarioModel.getCargo());
  }
}
