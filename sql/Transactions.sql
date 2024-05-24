-- criação usuário
BEGIN;
INSERT INTO usuarios (nome, senha, email, data_nascimento) VALUES
    (?, ?, ?, ?);
COMMIT;

-- abertura de ticket
BEGIN;
INSERT INTO tickets (id_usuario_abertura, titulo, descricao) VALUES
    (?, ?, ?);
COMMIT;

-- inserir comentário em ticket
BEGIN;
INSERT INTO comentarios (id_ticket_comentario, id_usuario_comentario, conteudo_comentario) VALUES
    (?, ?, ?);
COMMIT;