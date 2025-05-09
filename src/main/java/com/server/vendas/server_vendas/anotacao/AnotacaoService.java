package com.server.vendas.server_vendas.anotacao;

import com.server.vendas.server_vendas.anotacao.dto.AnotacaoDto;
import com.server.vendas.server_vendas.anotacao.dto.FindAllAnotacaoDto;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class AnotacaoService {

  private final AnotacaoRepository anotacaoRepository;

  public AnotacaoDto save(AnotacaoDto anotacaoDto) {
    var anotacaoModel = new AnotacaoModel();
    BeanUtils.copyProperties(anotacaoDto, anotacaoModel);

    return AnotacaoMapper.toDto(anotacaoRepository.save(anotacaoModel));
  }

  public FindAllAnotacaoDto findAll() {
    var anotacoes = anotacaoRepository.findAll().stream().map(AnotacaoMapper::toDto).toList();

    return new FindAllAnotacaoDto(anotacoes);
  }

  public AnotacaoDto findById(UUID id) {
    var anotacaoModel =
        anotacaoRepository
            .findById(id)
            .orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Anotação não encontrada"));

    return AnotacaoMapper.toDto(anotacaoModel);
  }

  public AnotacaoDto update(UUID id, AnotacaoDto anotacaoDto) {
    var anotacaoModel =
        anotacaoRepository
            .findById(id)
            .orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Anotação não encontrada"));
    BeanUtils.copyProperties(anotacaoDto, anotacaoModel);

    return AnotacaoMapper.toDto(anotacaoRepository.save(anotacaoModel));
  }

  public void delete(UUID id) {
    var anotacaoModel =
        anotacaoRepository
            .findById(id)
            .orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Anotação não encontrada"));

    anotacaoRepository.delete(anotacaoModel);
  }
}
