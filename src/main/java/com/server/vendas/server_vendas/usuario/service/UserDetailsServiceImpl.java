package com.server.vendas.server_vendas.usuario.service;

import com.server.vendas.server_vendas.usuario.UsuarioModel;
import com.server.vendas.server_vendas.usuario.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

  private final UsuarioRepository usuarioRepository;

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    var usuario =
        usuarioRepository
            .findByEmail(email)
            .orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));
    if (usuario == null) {
      throw new UsernameNotFoundException("Usuário não encontrado com o email: " + email);
    }
    return new UsuarioModel(
        usuario.getIdUsuario(),
        usuario.getNome(),
        usuario.getEmail(),
        usuario.getSenha(),
        usuario.getCargo());
  }
}
