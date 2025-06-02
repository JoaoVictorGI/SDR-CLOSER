package com.server.vendas.server_vendas.atendimento;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import com.server.vendas.server_vendas.atendimento.dto.RequestAtendimentoDto;
import com.server.vendas.server_vendas.atendimento.dto.UpdateAtendimentoDto;
import com.server.vendas.server_vendas.contato.ContatoModel;
import com.server.vendas.server_vendas.contato.ContatoRepository;
import com.server.vendas.server_vendas.contato.Status;
import com.server.vendas.server_vendas.historicoatendimento.HistoricoAtendimentoModel;
import com.server.vendas.server_vendas.historicoatendimento.HistoricoAtendimentoRepository;
import com.server.vendas.server_vendas.produto.ProdutoModel;
import com.server.vendas.server_vendas.produto.ProdutoRepository;
import com.server.vendas.server_vendas.script.ScriptModel;
import com.server.vendas.server_vendas.usuario.Cargo;
import com.server.vendas.server_vendas.usuario.UsuarioModel;
import com.server.vendas.server_vendas.usuario.UsuarioRepository;
import jakarta.persistence.EntityManager;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@ExtendWith(MockitoExtension.class)
public class AtendimentoServiceTest {

  @Mock private AtendimentoRepository atendimentoRepository;
  @Mock private UsuarioRepository usuarioRepository;
  @Mock private ContatoRepository contatoRepository;
  @Mock private ProdutoRepository produtoRepository;
  @Mock private HistoricoAtendimentoRepository historicoAtendimentoRepository;
  @Mock private EntityManager entityManager;

  @InjectMocks AtendimentoService atendimentoService;

  @Nested
  class createAtendimento {
    @Test
    @DisplayName("Deve criar um atendimento com sucesso")
    void deveCriarUmAtendimentoComSucesso() {

      var inputAtendimentoSave =
          new RequestAtendimentoDto(UUID.randomUUID(), UUID.randomUUID(), 1L);

      var usuario =
          new UsuarioModel(
              inputAtendimentoSave.idUsuario(), "nome", "email@gmail.com", "senha", Cargo.CLOSER);
      doReturn(Optional.of(usuario))
          .when(usuarioRepository)
          .findById(inputAtendimentoSave.idUsuario());

      var contato =
          new ContatoModel(
              inputAtendimentoSave.idContato(),
              "Lucas",
              "Silva",
              new Date(),
              "lucas@gmail.com",
              "48 99456-3450",
              "Lucas Marcenaria",
              "10.196.167/0001-23",
              "Estrada Duílio Beltramini",
              "Valinhos",
              "Marcenaria",
              Status.NAO_AGENDADO,
              new Date());
      doReturn(Optional.of(contato))
          .when(contatoRepository)
          .findById(inputAtendimentoSave.idContato());

      var produto =
          new ProdutoModel(
              inputAtendimentoSave.idProduto(),
              "Marketing",
              new ScriptModel(UUID.randomUUID(), "script"));
      doReturn(Optional.of(produto))
          .when(produtoRepository)
          .findById(inputAtendimentoSave.idProduto());

      var atendimento = new AtendimentoModel(1L, usuario, contato, produto, new Date(), null);
      doReturn(atendimento).when(atendimentoRepository).saveAndFlush(any());

      var outputAtendimentoSave = atendimentoService.save(inputAtendimentoSave);

      assertNotNull(outputAtendimentoSave);
    }

    @Test
    @DisplayName("Deve retornar uma exceção quando ouver erro")
    void deveRetornarUmaExcecaoQuandoOuverErro() {

      var inputAtendimentoSave =
          new RequestAtendimentoDto(UUID.randomUUID(), UUID.randomUUID(), 1L);

      doReturn(Optional.empty()).when(usuarioRepository).findById(inputAtendimentoSave.idUsuario());

      var outputAtendimentoSave =
          assertThrows(
              ResponseStatusException.class, () -> atendimentoService.save(inputAtendimentoSave));

      assertEquals(HttpStatus.NOT_FOUND, outputAtendimentoSave.getStatusCode());
      verify(atendimentoRepository, never()).saveAndFlush(any());
    }
  }

  @Nested
  class updateAtendimento {

    @Test
    @DisplayName("Deve atualizar um atendimento")
    void deveAtualizarUmAtendimento() {

      var usuario =
          new UsuarioModel(UUID.randomUUID(), "nome", "email@gmail.com", "senha", Cargo.CLOSER);

      var contato =
          new ContatoModel(
              UUID.randomUUID(),
              "Lucas",
              "Silva",
              new Date(),
              "lucas@gmail.com",
              "48 99456-3450",
              "Lucas Marcenaria",
              "10.196.167/0001-23",
              "Estrada Duílio Beltramini",
              "Valinhos",
              "Marcenaria",
              Status.NAO_AGENDADO,
              new Date());

      var produto = new ProdutoModel(1L, "Marketing", new ScriptModel(UUID.randomUUID(), "script"));

      var input = new UpdateAtendimentoDto(contato.getIdContato(), Status.AGENDADO);

      var atendimentoFindByIdOutput =
          new AtendimentoModel(1L, usuario, contato, produto, new Date(), null);
      doReturn(Optional.of(atendimentoFindByIdOutput)).when(atendimentoRepository).findById(1L);

      doReturn(Optional.of(contato)).when(contatoRepository).findById(any(UUID.class));

      contato.setStatus(input.status());
      assertEquals(Status.AGENDADO, contato.getStatus());

      doReturn(contato).when(contatoRepository).saveAndFlush(contato);

      var historicoAtendimentoFindByIdAtendimento =
          new HistoricoAtendimentoModel(
              UUID.randomUUID(), atendimentoFindByIdOutput, null, Status.NAO_AGENDADO, new Date());
      doReturn(Optional.of(historicoAtendimentoFindByIdAtendimento))
          .when(historicoAtendimentoRepository)
          .findByIdAtendimento(any(AtendimentoModel.class));

      var historicoAtendimentoUpdated =
          new HistoricoAtendimentoModel(
              UUID.randomUUID(),
              atendimentoFindByIdOutput,
              Status.NAO_AGENDADO,
              Status.AGENDADO,
              new Date());
      doReturn(historicoAtendimentoUpdated)
          .when(historicoAtendimentoRepository)
          .save(any(HistoricoAtendimentoModel.class));

      atendimentoService.update(1L, input);

      assertEquals(historicoAtendimentoUpdated.getValorNovo(), contato.getStatus());
    }
  }
}
