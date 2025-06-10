package com.server.vendas.server_vendas.contato;

import com.server.vendas.server_vendas.contato.dto.ContatoDto;

public class ContatoMapper {
  public static ContatoDto toDto(ContatoModel contatoModel) {
    return new ContatoDto(
        contatoModel.getIdContato(),
        contatoModel.getNome(),
        contatoModel.getSobrenome(),
        contatoModel.getDtNascimento(),
        contatoModel.getEmail(),
        contatoModel.getNrCelular(),
        contatoModel.getNmEmpresa(),
        contatoModel.getCnpj(),
        contatoModel.getEndereco(),
        contatoModel.getCidade(),
        contatoModel.getSegmento(),
        contatoModel.getStatus(),
        contatoModel.getDtReuniao());
  }
}
