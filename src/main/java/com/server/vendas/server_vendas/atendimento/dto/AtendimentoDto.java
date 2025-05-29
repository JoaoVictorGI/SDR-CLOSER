package com.server.vendas.server_vendas.atendimento.dto;

import com.server.vendas.server_vendas.contato.ContatoModel;
import com.server.vendas.server_vendas.usuario.UsuarioModel;

public record AtendimentoDto(Long idAtendimento, UsuarioModel idUsuario, ContatoModel idContato) {}
