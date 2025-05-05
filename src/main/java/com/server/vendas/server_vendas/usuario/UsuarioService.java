package com.server.vendas.server_vendas.usuario;

import com.server.vendas.server_vendas.usuario.dto.CompleteUsuarioDto;
import com.server.vendas.server_vendas.usuario.dto.FindAllUsuarioDto;
import com.server.vendas.server_vendas.usuario.dto.NoIdUsuarioDto;
import com.server.vendas.server_vendas.usuario.dto.UsuarioDto;
import java.util.UUID;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UsuarioService {

  @Autowired UsuarioRepository usuarioRepository;

  public UsuarioDto save(NoIdUsuarioDto noIdUsuarioDto) {
    var hashSenha = new BCryptPasswordEncoder().encode(noIdUsuarioDto.senha());
    var usuarioModel = new UsuarioModel();
    BeanUtils.copyProperties(noIdUsuarioDto, usuarioModel);

    usuarioModel.setSenha(hashSenha);

    return UsuarioMapper.toUsuarioDto(usuarioRepository.save(usuarioModel));
  }

  public FindAllUsuarioDto findAll() {
    var usuarios = usuarioRepository.findAll();
    return new FindAllUsuarioDto(usuarios);
  }

  public CompleteUsuarioDto findById(UUID id) {
    UsuarioModel usuarioModel =
        usuarioRepository
            .findById(id)
            .orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));

    return UsuarioMapper.toComplUsuarioDto(usuarioModel);
  }

  public UsuarioDto update(UUID id, NoIdUsuarioDto usuarioDto) {
    var usuarioModel =
        usuarioRepository
            .findById(id)
            .orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));
    BeanUtils.copyProperties(usuarioDto, usuarioModel);
    usuarioRepository.save(usuarioModel);

    return UsuarioMapper.toUsuarioDto(usuarioModel);
  }

  public void delete(UUID id) {
    var usuarioModel =
        usuarioRepository
            .findById(id)
            .orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));
    usuarioRepository.delete(usuarioModel);
  }
}
