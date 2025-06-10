insert into usuario (
  id_usuario,
  nome,
  email,
  senha,
  cargo
)
values (
  '074bcf35-1a82-4491-9144-b5e976039677', 
  'João Victor', 
  'joao@gmail.com', 
  '$2a$10$8ld4wkg1gFBZzosSvZqDKuOZStSR05LVV8RupWW/KDrNNiZBAHmFy', 
  'SDR'
);
insert into script (id_script, script)
values (
  'da64bc44-1061-4e97-883c-0de742b95457', 
  '<ol>
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
'
);
insert into produto (id_produto, id_script, nm_produto)
values (
  1, 
  'da64bc44-1061-4e97-883c-0de742b95457', 
  'Loja'
);
insert into contato (
  id_contato,
  nome,
  sobrenome,
  dt_nascimento,
  email,
  nr_celular,
  nm_empresa,
  cnpj,
  endereco,
  cidade,
  segmento,
  status,
  dt_reuniao
)
values (
  '24baa049-9c1b-454e-94ab-d47ceceadcd3', 
  'Bruno', 
  'Fernandes', 
  '1990-07-10T21:32:29.670Z', 
  'bruno@gmail.com', 
  '48 99091-4054', 
  'Gráfica Bruno', 
  '30.484.895/0001-48', 
  'Rua João de Barro', 
  'Teresina', 
  'Gráfica', 
  'NAO_AGENDADO', 
  '2025-05-08T21:32:29.670Z'
), (
  '979c7e1c-4c1b-4450-8cde-1e3e9a1f1001', 
  'Lucas', 
  'Silva', 
  '1988-04-12T08:12:00.000Z', 
  'lucas.silva@email.com', 
  '11 91234-5678', 
  'TechLucas', 
  '11.222.333/0001-44', 
  'Av. Paulista, 500', 
  'São Paulo', 
  'Tecnologia', 
  'AGENDADO', 
  '2025-06-10T15:00:00.000Z'
), (
  'c40bfa8e-9c1d-4c7d-8e20-2c1ea123a0a2', 
  'Fernanda', 
  'Costa', 
  '1995-09-30T13:45:00.000Z', 
  'fernanda.costa@email.com', 
  '21 92345-6789', 
  'Costa Design', 
  '22.333.444/0001-55', 
  'Rua das Laranjeiras, 200', 
  'Rio de Janeiro', 
  'Design', 
  'NAO_AGENDADO', 
  '2025-06-15T11:00:00.000Z'
), (
  '075d0ad6-6d9d-4c56-8c07-7e3beacb12e3', 
  'Marcos', 
  'Oliveira', 
  '1976-01-22T19:00:00.000Z', 
  'marcos.oliveira@email.com', 
  '31 93456-7890', 
  'Oliveira Transportes', 
  '33.444.555/0001-66', 
  'Av. Amazonas, 1200', 
  'Belo Horizonte', 
  'Transporte', 
  'FECHADO', 
  '2025-07-18T10:30:00.000Z'
), (
  'b1e8e5c7-3f4a-4d0c-8a2a-5e9f8a7b11c4', 
  'Patricia', 
  'Mendes', 
  '1992-11-05T22:45:00.000Z', 
  'patricia.mendes@email.com', 
  '41 94567-8901', 
  'Mendes Papelaria', 
  '44.555.666/0001-77', 
  'Praça Central, 50', 
  'Curitiba', 
  'Papelaria', 
  'AGUARDANDO', 
  '2025-07-01T09:15:00.000Z'
), (
  'ea8d2715-6214-4c4b-8d8b-16b98c9a7c9a', 
  'João', 
  'Ferreira', 
  '1982-07-19T05:30:00.000Z', 
  'joao.ferreira@email.com', 
  '51 95678-9012', 
  'Ferreira Construções', 
  '55.666.777/0001-88', 
  'Rua das Palmeiras, 300', 
  'Porto Alegre', 
  'Construção', 
  'CANCELADO', 
  '2025-05-30T08:00:00.000Z'
), (
  '6e9c8b2a-1d9b-4e3a-8d80-7b8d7e6b1e0f', 
  'Aline', 
  'Rocha', 
  '1990-05-14T17:20:00.000Z', 
  'aline.rocha@email.com', 
  '61 96789-0123', 
  'Rocha Eventos', 
  '66.777.888/0001-99', 
  'Rua do Sol, 110', 
  'Brasília', 
  'Eventos', 
  'NAO_AGENDADO', 
  '2025-06-21T13:00:00.000Z'
), (
  'c8f7a2e1-3d2c-4f3e-8b13-3e1b9c2a8c2a', 
  'Beatriz', 
  'Santos', 
  '1987-03-17T10:00:00.000Z', 
  'beatriz.santos@email.com', 
  '71 97890-1234', 
  'Santos Advogados', 
  '77.888.999/0001-10', 
  'Av. Sete de Setembro, 700', 
  'Salvador', 
  'Jurídico', 
  'FECHADO', 
  '2025-07-12T11:30:00.000Z'
), (
  'a2b7c8d9-4e2a-4f1c-8b5d-8e7b1f9c2e4d', 
  'Gabriel', 
  'Barbosa', 
  '1991-12-01T09:45:00.000Z', 
  'gabriel.barbosa@email.com', 
  '81 98901-2345', 
  'Barbosa Consultoria', 
  '88.999.000/0001-21', 
  'Rua das Flores, 15', 
  'Recife', 
  'Consultoria', 
  'AGENDADO', 
  '2025-06-05T16:00:00.000Z'
), (
  'd3f8e7c2-2c4b-4f2a-8b9d-7e1c8a3b7e2f', 
  'Larissa', 
  'Ribeiro', 
  '1984-10-11T20:10:00.000Z', 
  'larissa.ribeiro@email.com', 
  '91 99012-3456', 
  'Ribeiro Moda', 
  '99.000.111/0001-32', 
  'Av. Independência, 42', 
  'Belém', 
  'Moda', 
  'AGUARDANDO', 
  '2025-06-18T17:45:00.000Z'
), (
  'f7e6c5b4-9a8d-4b3c-8e2f-6d7e8b9c1a2b', 
  'Thiago', 
  'Martins', 
  '1979-08-23T11:55:00.000Z', 
  'thiago.martins@email.com', 
  '51 99123-4567', 
  'Martins Engenharia', 
  '10.111.222/0001-43', 
  'Rua dos Andradas, 600', 
  'Porto Alegre', 
  'Engenharia', 
  'NAO_AGENDADO', 
  '2025-07-20T14:00:00.000Z'
), (
  'e2d1c0b3-5a6c-4d8e-8f1c-7e2b3c4a5d6f', 
  'Sabrina', 
  'Carvalho', 
  '1986-06-07T06:40:00.000Z', 
  'sabrina.carvalho@email.com', 
  '61 99234-5678', 
  'Carvalho Arquitetura', 
  '12.222.333/0001-54', 
  'Rua do Farol, 80', 
  'Brasília', 
  'Arquitetura', 
  'CANCELADO', 
  '2025-06-28T15:30:00.000Z'
), (
  'b0f9e8d7-3c2a-4f1e-8b7c-8e2f1a9c2d3b', 
  'Felipe', 
  'Azevedo', 
  '1983-02-18T14:25:00.000Z', 
  'felipe.azevedo@email.com', 
  '11 99345-6789', 
  'Azevedo Finanças', 
  '13.333.444/0001-65', 
  'Av. Brigadeiro, 90', 
  'São Paulo', 
  'Financeiro', 
  'AGENDADO', 
  '2025-06-15T18:00:00.000Z'
), (
  'f0e1d2c3-4b5a-4e6d-8f0c-7e1b2c3a4d5f', 
  'Vanessa', 
  'Lopes', 
  '1996-07-29T21:50:00.000Z', 
  'vanessa.lopes@email.com', 
  '51 99456-7890', 
  'Lopes Comunicação', 
  '14.444.555/0001-76', 
  'Rua Grande, 44', 
  'Porto Alegre', 
  'Comunicação', 
  'FECHADO', 
  '2025-07-25T08:00:00.000Z'
), (
  'b7c6d5e4-1a2b-4c3d-8e4f-5d6e7c8b9a0f', 
  'Renata', 
  'Siqueira', 
  '1997-05-13T18:35:00.000Z', 
  'renata.siqueira@email.com', 
  '21 99567-8901', 
  'Siqueira Turismo', 
  '15.555.666/0001-87', 
  'Praia do Leme, 4', 
  'Rio de Janeiro', 
  'Turismo', 
  'CANCELADO', 
  '2025-06-30T10:30:00.000Z'
);
insert into atendimento (
  id_atendimento,
  id_usuario,
  id_contato,
  id_produto,
  dt_criacao,
  dt_atualizacao
)
values (
  1, 
  '074bcf35-1a82-4491-9144-b5e976039677', 
  '24baa049-9c1b-454e-94ab-d47ceceadcd3', 
  1, 
  current_date, 
  current_date
), (
  5, 
  '074bcf35-1a82-4491-9144-b5e976039677', 
  '979c7e1c-4c1b-4450-8cde-1e3e9a1f1001', 
  1, 
  current_date, 
  current_date
), (
  6, 
  '074bcf35-1a82-4491-9144-b5e976039677', 
  'c40bfa8e-9c1d-4c7d-8e20-2c1ea123a0a2', 
  1, 
  current_date, 
  current_date
), (
  7, 
  '074bcf35-1a82-4491-9144-b5e976039677', 
  '075d0ad6-6d9d-4c56-8c07-7e3beacb12e3', 
  1, 
  current_date, 
  current_date
), (
  8, 
  '074bcf35-1a82-4491-9144-b5e976039677', 
  'b1e8e5c7-3f4a-4d0c-8a2a-5e9f8a7b11c4', 
  1, 
  current_date, 
  current_date
), (
  9, 
  '074bcf35-1a82-4491-9144-b5e976039677', 
  'ea8d2715-6214-4c4b-8d8b-16b98c9a7c9a', 
  1, 
  current_date, 
  current_date
), (
  10, 
  '074bcf35-1a82-4491-9144-b5e976039677', 
  '6e9c8b2a-1d9b-4e3a-8d80-7b8d7e6b1e0f', 
  1, 
  current_date, 
  current_date
), (
  11, 
  '074bcf35-1a82-4491-9144-b5e976039677', 
  'c8f7a2e1-3d2c-4f3e-8b13-3e1b9c2a8c2a', 
  1, 
  current_date, 
  current_date
), (
  12, 
  '074bcf35-1a82-4491-9144-b5e976039677', 
  'a2b7c8d9-4e2a-4f1c-8b5d-8e7b1f9c2e4d', 
  1, 
  current_date, 
  current_date
), (
  13, 
  '074bcf35-1a82-4491-9144-b5e976039677', 
  'd3f8e7c2-2c4b-4f2a-8b9d-7e1c8a3b7e2f', 
  1, 
  current_date, 
  current_date
), (
  14, 
  '074bcf35-1a82-4491-9144-b5e976039677', 
  'f7e6c5b4-9a8d-4b3c-8e2f-6d7e8b9c1a2b', 
  1, 
  current_date, 
  current_date
), (
  15, 
  '074bcf35-1a82-4491-9144-b5e976039677', 
  'e2d1c0b3-5a6c-4d8e-8f1c-7e2b3c4a5d6f', 
  1, 
  current_date, 
  current_date
), (
  16, 
  '074bcf35-1a82-4491-9144-b5e976039677', 
  'b0f9e8d7-3c2a-4f1e-8b7c-8e2f1a9c2d3b', 
  1, 
  current_date, 
  current_date
), (
  17, 
  '074bcf35-1a82-4491-9144-b5e976039677', 
  'f0e1d2c3-4b5a-4e6d-8f0c-7e1b2c3a4d5f', 
  1, 
  current_date, 
  current_date
), (
  18, 
  '074bcf35-1a82-4491-9144-b5e976039677', 
  'b7c6d5e4-1a2b-4c3d-8e4f-5d6e7c8b9a0f', 
  1, 
  current_date, 
  current_date
);

insert into historico_atendimento (
  id_historico_atendimento,
  id_atendimento,
  valor_anterior,
  valor_novo,
  dt_atualizacao
)
values (
  gen_random_uuid(), 
  1, 
  null, 
  'NAO_AGENDADO', 
  current_timestamp
), (
  gen_random_uuid(), 
  5, 
  null, 
  'AGENDADO', 
  current_timestamp
), (
  gen_random_uuid(), 
  6, 
  null, 
  'AGENDADO', 
  current_timestamp
), (
  gen_random_uuid(), 
  7, 
  null, 
  'AGENDADO', 
  current_timestamp
), (
  gen_random_uuid(), 
  8, 
  null, 
  'AGENDADO', 
  current_timestamp
), (
  gen_random_uuid(), 
  9, 
  null, 
  'AGENDADO', 
  current_timestamp
), (
  gen_random_uuid(), 
  10, 
  null, 
  'AGENDADO', 
  current_timestamp
), (
  gen_random_uuid(), 
  11, 
  null, 
  'AGENDADO', 
  current_timestamp
), (
  gen_random_uuid(), 
  12, 
  null, 
  'AGENDADO', 
  current_timestamp
), (
  gen_random_uuid(), 
  13, 
  null, 
  'AGENDADO', 
  current_timestamp
), (
  gen_random_uuid(), 
  14, 
  null, 
  'AGENDADO', 
  current_timestamp
), (
  gen_random_uuid(), 
  15, 
  null, 
  'AGENDADO', 
  current_timestamp
), (
  gen_random_uuid(), 
  16, 
  null, 
  'AGENDADO', 
  current_timestamp
), (
  gen_random_uuid(), 
  17, 
  null, 
  'AGENDADO', 
  current_timestamp
), (
  gen_random_uuid(), 
  18, 
  null, 
  'AGENDADO', 
  current_timestamp
);

insert into anotacao(id_atendimento, id_anotacao, anotacao)
values (1, '24baa049-9c1b-454e-94ab-d47ceceadcd3', 'teste');

select setval(
  pg_get_serial_sequence('produto','id_produto'),
  (select max(id_produto) from produto)
);

select setval(
  pg_get_serial_sequence('atendimento','id_atendimento'),
  (select max(id_atendimento) from atendimento)
);