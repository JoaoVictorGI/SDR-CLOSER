package com.server.vendas.server_vendas.atendimento;

import com.server.vendas.server_vendas.atendimento.dto.AtendimentoDto;
import com.server.vendas.server_vendas.atendimento.dto.FindAllAtendimentoDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AtendimentoService {

  @Autowired AtendimentoRepository atendimentoRepository;

  public AtendimentoDto save(AtendimentoDto atendimentoDto) {
    var atendimentoModel = new AtendimentoModel();
    BeanUtils.copyProperties(atendimentoDto, atendimentoModel);

    return AtendimentoMapper.toDto(atendimentoRepository.save(atendimentoModel));
  }

  public FindAllAtendimentoDto findAll() {
    var atendimentos =
        atendimentoRepository.findAll().stream().map(AtendimentoMapper::toDto).toList();

    return new FindAllAtendimentoDto(atendimentos);
  }

  public AtendimentoDto findById(Long id) {
    var atendimentoModel =
        atendimentoRepository
            .findById(id)
            .orElseThrow(
                () ->
                    new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Atendimento não encontrado"));

    return AtendimentoMapper.toDto(atendimentoModel);
  }

  public AtendimentoDto update(Long id, AtendimentoDto atendimentoDto) {
    var atendimentoModel =
        atendimentoRepository
            .findById(id)
            .orElseThrow(
                () ->
                    new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Atendimento não encontrado"));
    BeanUtils.copyProperties(atendimentoDto, atendimentoModel);

    return AtendimentoMapper.toDto(atendimentoModel);
  }

  public void delete(Long id) {
    var atendimentoModel =
        atendimentoRepository
            .findById(id)
            .orElseThrow(
                () ->
                    new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Atendimento não encontrado"));

    atendimentoRepository.delete(atendimentoModel);
  }
}
