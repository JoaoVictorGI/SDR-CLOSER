package com.server.vendas.server_vendas.contato.dto;

import com.server.vendas.server_vendas.contato.Status;
import io.micrometer.common.lang.NonNull;
import jakarta.validation.constraints.Email;
import java.util.Date;

public record ContatoDto(
    @NonNull String nome,
    @NonNull String sobrenome,
    Date dtNascimento,
    @NonNull @Email String email,
    @NonNull String nrCelular,
    String nmEmpresa,
    String cnpj,
    String endereco,
    String cidade,
    String segmento,
    @NonNull Status status,
    Date dtReuniao) {}
