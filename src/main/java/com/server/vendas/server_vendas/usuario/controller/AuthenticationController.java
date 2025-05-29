package com.server.vendas.server_vendas.usuario.controller;

import com.server.vendas.server_vendas.security.JwtUtil;
import com.server.vendas.server_vendas.usuario.UsuarioModel;
import com.server.vendas.server_vendas.usuario.UsuarioRepository;
import com.server.vendas.server_vendas.usuario.dto.LoginDto;
import com.server.vendas.server_vendas.usuario.dto.LoginRequestDto;
import com.server.vendas.server_vendas.usuario.dto.NoIdUsuarioDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequiredArgsConstructor
public class AuthenticationController {

  private final AuthenticationManager authenticationManager;
  private final UsuarioRepository usuarioRepository;
  private final PasswordEncoder passwordEncoder;
  private final JwtUtil jwtUtil;

  @PostMapping("auth/signin")
  public ResponseEntity<LoginDto> authenticateUsuario(@RequestBody LoginRequestDto usuario) {

    var savedPassword =
        usuarioRepository
            .findByEmail(usuario.email())
            .orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));

    if (new BCryptPasswordEncoder().matches(usuario.senha(), savedPassword.getPassword())) {
      var authentication =
          authenticationManager.authenticate(
              new UsernamePasswordAuthenticationToken(usuario.email(), usuario.senha()));
      UserDetails userDetails = (UserDetails) authentication.getPrincipal();
      return ResponseEntity.status(HttpStatus.OK)
          .body(
              new LoginDto(
                  savedPassword.getIdUsuario(), jwtUtil.generateToken(userDetails.getUsername())));
    }

    throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Error: e-mail ou senha incorreta");
  }

  @PostMapping("auth/signup")
  public ResponseEntity<String> registerUsuario(@RequestBody NoIdUsuarioDto usuario) {
    if (usuarioRepository.existsByEmail(usuario.email())) {
      return ResponseEntity.status(HttpStatus.CONFLICT).body("Error: usuário já existe");
    }

    var hashSenha = new BCryptPasswordEncoder().encode(usuario.senha());

    var novoUsuario =
        new UsuarioModel(null, usuario.nome(), usuario.email(), hashSenha, usuario.cargo());
    usuarioRepository.save(novoUsuario);
    return ResponseEntity.status(HttpStatus.OK).body("Usuário salvo com sucesso!");
  }
}
