package com.server.vendas.server_vendas.usuario;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.server.vendas.server_vendas.usuario.dto.NoIdUsuarioDto;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UsuarioServiceTest {

  @InjectMocks UsuarioService service;

  @Mock UsuarioRepository repository;

  @Test
  @DisplayName("Should create a new user")
  public void testCreateUsuarioCase1() {
    var usuarioDto = new NoIdUsuarioDto("João", "joao@gmail.com", "teste", Cargo.CLOSER);

    var usuarioModel = new UsuarioModel();
    BeanUtils.copyProperties(usuarioDto, usuarioModel);
    usuarioModel.setIdUsuario(UUID.randomUUID());

    when(repository.save(any(UsuarioModel.class))).thenReturn(usuarioModel);

    var serviceSave = service.save(usuarioDto);

    assertEquals(usuarioModel.getIdUsuario(), serviceSave.idUsuario());
  }

  @Test
  @DisplayName("Should return an Exception")
  public void testCreateUsuarioCase2() {
    var usuarioDto1 = new NoIdUsuarioDto("João", "joao@gmail.com", "teste", Cargo.CLOSER);
    var usuarioModel1 = new UsuarioModel();
    BeanUtils.copyProperties(usuarioDto1, usuarioModel1);
    usuarioModel1.setIdUsuario(UUID.randomUUID());

    var usuarioDto2 = new NoIdUsuarioDto("João", "joao@gmail.com", "teste", Cargo.SDR);
    var usuarioModel2 = new UsuarioModel();
    BeanUtils.copyProperties(usuarioDto1, usuarioModel2);
    usuarioModel2.setIdUsuario(UUID.randomUUID());

    when(repository.save(any(UsuarioModel.class))).thenReturn(usuarioModel2);

    var serviceSave = service.save(usuarioDto2);

    assertNotEquals(usuarioModel1.getIdUsuario(), serviceSave.idUsuario());
  }
}
