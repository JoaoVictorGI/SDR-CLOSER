INSERT INTO
	usuario (id_usuario, nome, email, senha, cargo)
VALUES
	(
		'074bcf35-1a82-4491-9144-b5e976039677',
		'João Victor',
		'joao@gmail.com',
		'$2a$10$uprX5Nx/WTLEI9TDbC7TEev3SZkoMOnVr7MxJ5.a0/TiIfp3QmfpG',
		'SDR'
	);

INSERT INTO
	script (id_script, script)
VALUES
	(
		'da64bc44-1061-4e97-883c-0de742b95457',
		'Teste script'
	);

INSERT INTO
	produto (id_produto, id_script, nm_produto)
VALUES
	(1, 'da64bc44-1061-4e97-883c-0de742b95457', 'Loja');

INSERT INTO
	contato (
		id_contato,
		nome,
		sobrenome,
		dt_nascimento,
		nr_celular,
		nm_empresa,
		cnpj,
		endereco,
		cidade,
		segmento,
		status,
		dt_reuniao
	)
VALUES
	(
		'24baa049-9c1b-454e-94ab-d47ceceadcd3',
		'Bruno',
		'Fernandes',
		'1990-07-10T21:32:29.670Z',
		'48 99091-4054',
		'Gráfica Bruno',
		'30.484.895/0001-48',
		'Rua João de Barro',
		'Teresina',
		'Gráfica',
		'NAO_AGENDADO',
		'2025-05-08T21:32:29.670Z'
	);