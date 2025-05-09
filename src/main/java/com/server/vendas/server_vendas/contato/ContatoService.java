package com.server.vendas.server_vendas.contato;

import com.server.vendas.server_vendas.contato.dto.ContatoDto;
import com.server.vendas.server_vendas.contato.dto.FindAllContatoDto;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class ContatoService {

  private final ContatoRepository contatoRepository;

  public ContatoDto save(ContatoDto contatoDto) {
    var contatoModel = new ContatoModel();
    BeanUtils.copyProperties(contatoDto, contatoModel);

    return ContatoMapper.toDto(contatoRepository.save(contatoModel));
  }

  public ContatoDto findById(UUID id) {
    var contatoModel =
        contatoRepository
            .findById(id)
            .orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contato não encontrado"));

    return ContatoMapper.toDto(contatoModel);
  }

  public FindAllContatoDto findAll() {
    var contatos = contatoRepository.findAll().stream().map(ContatoMapper::toDto).toList();

    return new FindAllContatoDto(contatos);
  }

  public ContatoDto update(UUID id, ContatoDto contatoDto) {
    var contatoModel =
        contatoRepository
            .findById(id)
            .orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contato não encontrado"));

    BeanUtils.copyProperties(contatoDto, contatoModel);

    return ContatoMapper.toDto(contatoRepository.save(contatoModel));
  }

  public void delete(UUID id) {
    var contatoModel =
        contatoRepository
            .findById(id)
            .orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contato não encontrado"));

    contatoRepository.delete(contatoModel);
  }
}
