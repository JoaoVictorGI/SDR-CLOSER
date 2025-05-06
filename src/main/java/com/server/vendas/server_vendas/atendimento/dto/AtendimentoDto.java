package com.server.vendas.server_vendas.atendimento.dto;

import com.server.vendas.server_vendas.contato.ContatoModel;
import com.server.vendas.server_vendas.usuario.UsuarioModel;
import java.util.Date;

public record AtendimentoDto(
    UsuarioModel idUsuario, ContatoModel idContato, Date dtCriacao, Date dtAtualizacao) {}
