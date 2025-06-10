package com.server.vendas.server_vendas.atendimento;

import com.server.vendas.server_vendas.anotacao.AnotacaoService;
import com.server.vendas.server_vendas.anotacao.dto.AnotacaoDto;
import com.server.vendas.server_vendas.atendimento.dto.AtendimentoDto;
import com.server.vendas.server_vendas.atendimento.dto.FindAllAtendimentoDto;
import com.server.vendas.server_vendas.atendimento.dto.RequestAtendimentoDto;
import com.server.vendas.server_vendas.atendimento.dto.UpdateAtendimentoDto;
import com.server.vendas.server_vendas.contato.ContatoRepository;
import com.server.vendas.server_vendas.contato.Status;
import com.server.vendas.server_vendas.historicoatendimento.HistoricoAtendimentoModel;
import com.server.vendas.server_vendas.historicoatendimento.HistoricoAtendimentoRepository;
import com.server.vendas.server_vendas.historicoatendimento.dto.HistoricoAtendimentoDto;
import com.server.vendas.server_vendas.produto.ProdutoMapper;
import com.server.vendas.server_vendas.produto.ProdutoService;
import com.server.vendas.server_vendas.produto.dto.ProdutoDto;
import com.server.vendas.server_vendas.script.ScriptService;
import com.server.vendas.server_vendas.script.dto.CreateScriptRequest;
import com.server.vendas.server_vendas.usuario.UsuarioRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class AtendimentoService {

  @PersistenceContext EntityManager entityManager;

  private final AtendimentoRepository atendimentoRepository;
  private final UsuarioRepository usuarioRepository;
  private final ContatoRepository contatoRepository;
  private final ProdutoService produtoService;
  private final HistoricoAtendimentoRepository historicoAtendimentoRepository;
  private final AnotacaoService anotacaoService;
  private final ScriptService scriptService;

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

    var script =
        scriptService.save(
            new CreateScriptRequest(
"""
        <ol>
  <li><strong>Abertura</strong><br>
    SDR: “Olá [Nome], aqui é [Seu Nome] da [Sua Empresa]. Posso tomar 2 minutos do seu tempo?”
  </li>

  <li><strong>Pergunta 1 – Processos Atuais</strong><br>
    SDR: “Como vocês coletam e centralizam feedbacks no Figma hoje?”
  </li>

  <li><strong>Pergunta 2 – Stakeholders</strong><br>
    SDR: “Quem são os principais envolvidos nesse processo (designers, desenvolvedores, PMs)?”
  </li>

  <li><strong>Pergunta 3 – Gargalos</strong><br>
    SDR: “Quais atrasos ou retrabalhos vocês enfrentam por falta de clareza nos comentários?”
  </li>

  <li><strong>Pergunta 4 – Métrica de Tempo</strong><br>
    SDR: “Quanto tempo, em média, vocês levam em cada ciclo de revisão de um wireframe?”
  </li>

  <li><strong>Pergunta 5 – Prazo</strong><br>
    SDR: “Vocês possuem uma data-limite para finalizar o ciclo de revisões deste sprint?”
  </li>

  <li><strong>Pergunta 6 – Aprovação Interna</strong><br>
    SDR: “Quais etapas internas são necessárias para aprovar a adoção de uma nova ferramenta de design?”
  </li>

  <li><strong>Pergunta 7 – Impacto Negativo</strong><br>
    SDR: “Qual seria o impacto no roadmap ou no planejamento de produto se esse processo não for agilizado?”
  </li>

  <li><strong>Call to Action</strong><br>
    SDR: “Gostaria de agendar uma demonstração de 15 minutos com nosso especialista em Figma para mostrar o protótipo interativo?”
  </li>
</ol>
"""));

    var produto =
        produtoService.save(
            new ProdutoDto(null, atendimentoDto.nmProduto(), script.idScript(), script.script()));

    var atendimentoModel = new AtendimentoModel();
    BeanUtils.copyProperties(
        atendimentoDto,
        atendimentoModel,
        "idUsuario",
        "idContato",
        "idProduto",
        "nmProduto",
        "dtCriacao",
        "dtAtualizacao");
    atendimentoModel.setIdUsuario(usuarioModel);
    atendimentoModel.setIdContato(contatoModel);
    atendimentoModel.setIdProduto(ProdutoMapper.toModel(produto));

    var saved = atendimentoRepository.saveAndFlush(atendimentoModel);
    entityManager.refresh(saved);

    anotacaoService.save(new AnotacaoDto(null, saved));

    var historicoAtendimentoModel = new HistoricoAtendimentoModel();
    var historicoAtendimentoDto =
        new HistoricoAtendimentoDto(saved, null, contatoModel.getStatus(), new Date());
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

    var historicoAnterior =
        historicoAtendimentoRepository
            .findFirstByIdAtendimentoOrderByDtAtualizacaoDesc(atendimentoModel)
            .orElseThrow(
                () ->
                    new ResponseStatusException(HttpStatus.NOT_FOUND, "Histórico não encontrado"));

    var valorAnterior = historicoAnterior.getValorNovo();
    var historicoNovo = new HistoricoAtendimentoModel();
    historicoNovo.setIdAtendimento(atendimentoModel);
    historicoNovo.setValorAnterior(valorAnterior);
    historicoNovo.setValorNovo(contatoModel.getStatus());

    entityManager.persist(historicoNovo);

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

    var contatoModel = atendimentoModel.getIdContato();
    contatoModel.setStatus(Status.NAO_AGENDADO);

    contatoRepository.save(contatoModel);

    atendimentoRepository.delete(atendimentoModel);
  }

  public List<AtendimentoDto> findByIdUsuario(UUID id) {
    var atendimentoModel =
        atendimentoRepository
            .findByIdUsuario(id)
            .orElseThrow(
                () ->
                    new ResponseStatusException(HttpStatus.NOT_FOUND, "Atendimento não encontrado"))
            .stream()
            .map(AtendimentoMapper::toDto)
            .toList();

    return atendimentoModel;
  }
}
