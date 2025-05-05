package com.server.vendas.server_vendas.anotacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnotacaoService {

  @Autowired AnotacaoRepository anotacaoRepository;

  public AnotacaoModel save(AnotacaoModel anotacaoModel) {
    return anotacaoRepository.save(anotacaoModel);
  }
}
