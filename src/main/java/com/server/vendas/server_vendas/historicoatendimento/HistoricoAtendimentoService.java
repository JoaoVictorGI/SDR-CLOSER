package com.server.vendas.server_vendas.historicoatendimento;

import com.server.vendas.server_vendas.atendimento.AtendimentoModel;
import com.server.vendas.server_vendas.atendimento.AtendimentoRepository;
import com.server.vendas.server_vendas.historicoatendimento.dto.FindAllHistoricoAtendimentoDto;
import com.server.vendas.server_vendas.historicoatendimento.dto.HistoricoAtendimentoDto;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class HistoricoAtendimentoService {

  private final HistoricoAtendimentoRepository historicoAtendimentoRepository;
  private final AtendimentoRepository atendimentoRepository;

  public HistoricoAtendimentoDto save(HistoricoAtendimentoDto historicoAtendimentoDto) {
    var historicoModel = new HistoricoAtendimentoModel();
    BeanUtils.copyProperties(historicoAtendimentoDto, historicoModel);

    return HistoricoAtendimentoMapper.toDto(historicoModel);
  }

  public FindAllHistoricoAtendimentoDto findAll() {
    var historico =
        historicoAtendimentoRepository.findAll().stream()
            .map(HistoricoAtendimentoMapper::toDto)
            .toList();

    return new FindAllHistoricoAtendimentoDto(historico);
  }

  public HistoricoAtendimentoDto findById(UUID id) {
    var historico =
        historicoAtendimentoRepository
            .findById(id)
            .orElseThrow(
                () ->
                    new ResponseStatusException(HttpStatus.NOT_FOUND, "Histórico não encontrado"));
    return HistoricoAtendimentoMapper.toDto((historico));
  }

  public HistoricoAtendimentoDto update(UUID id, HistoricoAtendimentoDto historicoAtendimentoDto) {
    var historicoAtendimentoModel =
        historicoAtendimentoRepository
            .findById(id)
            .orElseThrow(
                () ->
                    new ResponseStatusException(HttpStatus.NOT_FOUND, "Histórico não encontrado"));
    BeanUtils.copyProperties(historicoAtendimentoDto, historicoAtendimentoModel);

    return HistoricoAtendimentoMapper.toDto(
        historicoAtendimentoRepository.save(historicoAtendimentoModel));
  }

  public void delete(UUID id) {
    var historicoModel =
        historicoAtendimentoRepository
            .findById(id)
            .orElseThrow(
                () ->
                    new ResponseStatusException(HttpStatus.NOT_FOUND, "Histórico não encontrado"));

    historicoAtendimentoRepository.delete(historicoModel);
  }

  public List<HistoricoAtendimentoDto> findByIdAtendimento(Long id) {
    AtendimentoModel atendimentoModel =
        atendimentoRepository
            .findById(id)
            .orElseThrow(
                () ->
                    new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Atendimento não encontrado"));
    var historico =
        historicoAtendimentoRepository.findByIdAtendimento(atendimentoModel).stream()
            .map(HistoricoAtendimentoMapper::toDto)
            .toList();

    if (historico.isEmpty()) {
      new ResponseStatusException(HttpStatus.NOT_FOUND, "Histórico de atendimento não encontrado");
    }

    return historico;
  }
}
