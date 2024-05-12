CREATE DATABASE aps_helpdesk
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Portuguese_Brazil.1252'
    LC_CTYPE = 'Portuguese_Brazil.1252'
    LOCALE_PROVIDER = 'libc'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;

CREATE TABLE usuarios (
	id_usuario SERIAL PRIMARY KEY,
	nome VARCHAR(255) NOT NULL,
	senha VARCHAR(255) NOT NULL,
	email VARCHAR(255),
	data_nascimento DATE,
	data_criacao_usuario DATE,
	nivel_permissao INT DEFAULT 1
);

CREATE TABLE estadotickets (
	id_estado_ticket SERIAL PRIMARY KEY,
	descricao VARCHAR(40)
);

CREATE TABLE tickets (
	id_ticket SERIAL PRIMARY KEY,
	id_usuario_abertura INT REFERENCES usuarios(id_usuario),
	id_estado_ticket INT REFERENCES estadotickets(id_estado_ticket) DEFAULT 1,
	data_abertura TIMESTAMPTZ,
	data_fechamento TIMESTAMPTZ,
	titulo VARCHAR(150),
	descricao VARCHAR(2000)
);

CREATE TABLE comentarios (
	id_comentario SERIAL PRIMARY KEY,
	conteudo_comentario VARCHAR(2000),
	data_publicacao TIMESTAMPTZ,
	id_ticket_comentario INT REFERENCES tickets(id_ticket),
	id_usuario_comentario INT REFERENCES usuarios(id_usuario)
);

INSERT INTO estadotickets (id_estado_ticket, descricao) VALUES
(1, 'Aberto'),
(2, 'Cancelado pelo usuário de abertura'),
(3, 'Resolvido'),
(4, 'Fechado automaticamente');