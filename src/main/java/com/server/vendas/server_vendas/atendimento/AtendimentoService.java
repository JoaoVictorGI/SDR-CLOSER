package com.server.vendas.server_vendas.atendimento;

import com.server.vendas.server_vendas.anotacao.AnotacaoService;
import com.server.vendas.server_vendas.anotacao.dto.AnotacaoDto;
import com.server.vendas.server_vendas.atendimento.dto.AtendimentoDto;
import com.server.vendas.server_vendas.atendimento.dto.FindAllAtendimentoDto;
import com.server.vendas.server_vendas.atendimento.dto.RequestAtendimentoDto;
import com.server.vendas.server_vendas.atendimento.dto.UpdateAtendimentoDto;
import com.server.vendas.server_vendas.contato.ContatoRepository;
import com.server.vendas.server_vendas.historicoatendimento.HistoricoAtendimentoModel;
import com.server.vendas.server_vendas.historicoatendimento.HistoricoAtendimentoRepository;
import com.server.vendas.server_vendas.historicoatendimento.dto.HistoricoAtendimentoDto;
import com.server.vendas.server_vendas.produto.ProdutoRepository;
import com.server.vendas.server_vendas.usuario.UsuarioRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class AtendimentoService {

  private final AtendimentoRepository atendimentoRepository;
  private final UsuarioRepository usuarioRepository;
  private final ContatoRepository contatoRepository;
  private final ProdutoRepository produtoRepository;
  private final HistoricoAtendimentoRepository historicoAtendimentoRepository;
  private final AnotacaoService anotacaoService;
  private final EntityManager entityManager;

  @Transactional
  public AtendimentoDto save(RequestAtendimentoDto atendimentoDto) {

    var usuarioModel =
        usuarioRepository
            .findById(atendimentoDto.idUsuario())
            .orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));

    var contatoModel =
        contatoRepository
            .findById(atendimentoDto.idContato())
            .orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contato não encontrado"));

    var produtoModel =
        produtoRepository
            .findById(atendimentoDto.idProduto())
            .orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado"));

    var atendimentoModel = new AtendimentoModel();
    BeanUtils.copyProperties(
        atendimentoDto,
        atendimentoModel,
        "idUsuario",
        "idContato",
        "idProduto",
        "dtCriacao",
        "dtAtualizacao");
    atendimentoModel.setIdUsuario(usuarioModel);
    atendimentoModel.setIdContato(contatoModel);
    atendimentoModel.setIdProduto(produtoModel);

    var saved = atendimentoRepository.saveAndFlush(atendimentoModel);
    entityManager.refresh(saved);

    var historicoAtendimentoModel = new HistoricoAtendimentoModel();
    var historicoAtendimentoDto =
        new HistoricoAtendimentoDto(saved, null, contatoModel.getStatus());
    BeanUtils.copyProperties(historicoAtendimentoDto, historicoAtendimentoModel);

    historicoAtendimentoRepository.save(historicoAtendimentoModel);

    var anotacaoDto = new AnotacaoDto("", saved);
    anotacaoService.save(anotacaoDto);

    return AtendimentoMapper.toDto(saved);
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

  @Transactional
  public AtendimentoDto update(Long id, UpdateAtendimentoDto atendimentoDto) {
    var atendimentoModel =
        atendimentoRepository
            .findById(id)
            .orElseThrow(
                () ->
                    new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Atendimento não encontrado"));

    var contatoModel =
        contatoRepository
            .findById(atendimentoDto.idContato())
            .orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contato não encontrado"));

    contatoModel.setStatus(atendimentoDto.status());
    var savedContato = contatoRepository.saveAndFlush(contatoModel);
    entityManager.refresh(savedContato);

    BeanUtils.copyProperties(atendimentoDto, atendimentoModel);

    var historicoAtendimentoModel =
        historicoAtendimentoRepository
            .findByIdAtendimento(atendimentoModel)
            .orElseThrow(
                () ->
                    new ResponseStatusException(HttpStatus.NOT_FOUND, "Histórico não encontrado"));

    historicoAtendimentoModel.setValorAnterior(historicoAtendimentoModel.getValorNovo());
    historicoAtendimentoModel.setValorNovo(contatoModel.getStatus());
    historicoAtendimentoRepository.save(historicoAtendimentoModel);

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

  public List<AtendimentoDto> findByIdUsuario(UUID id, Pageable pageable) {
    var atendimentoModel =
        atendimentoRepository
            .findByIdUsuario(id, PageRequest.of(0, 5))
            .orElseThrow(
                () ->
                    new ResponseStatusException(HttpStatus.NOT_FOUND, "Atendimento não encontrado"))
            .stream()
            .map(AtendimentoMapper::toDto)
            .toList();

    return atendimentoModel;
  }
}
