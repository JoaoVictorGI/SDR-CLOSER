package com.server.vendas.server_vendas.usuario.dto;

import com.server.vendas.server_vendas.usuario.UsuarioModel;
import java.util.List;

public record FindAllUsuarioDto(List<UsuarioModel> usuarios) {}
