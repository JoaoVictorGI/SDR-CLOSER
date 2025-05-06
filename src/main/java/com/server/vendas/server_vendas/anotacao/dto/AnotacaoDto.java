package com.server.vendas.server_vendas.anotacao.dto;

import com.server.vendas.server_vendas.atendimento.AtendimentoModel;

public record AnotacaoDto(String anotacao, AtendimentoModel idAtendimento) {}
