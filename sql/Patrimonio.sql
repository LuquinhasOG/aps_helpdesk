-- CRIAÇÃO DE PATRIMONIO
INSERT INTO patrimonio(id_patrimonio,data_criacao, descricao, nome_patrimonio, preco, quantidade) VALUES
    (gen_random_uuid(), NOW(), ?, ?, ?, ?);

-- PATRIMONIOS CRIADOS:

INSERT INTO patrimonio(id_patrimonio,data_criacao, descricao, nome_patrimonio, preco, quantidade) VALUES
    (gen_random_uuid() ,'2024-05-24T12:26:14.447+00:00','GIFT CARD XBOX 100 REAIS', 'Gift card Games Pass', 100.00, 24);

INSERT INTO patrimonio(id_patrimonio,data_criacao, descricao, nome_patrimonio, preco, quantidade) VALUES
    (gen_random_uuid() ,'2024-05-24T12:37:14.447+00:00','GIFT CARD PLAYSTATION 300 REAIS', 'Gift card Playstation', 300.00, 42);

INSERT INTO patrimonio(id_patrimonio,data_criacao, descricao, nome_patrimonio, preco, quantidade) VALUES
    (gen_random_uuid() ,'2024-05-24T12:26:14.447+00:00','GIFT CARD NINTENDO 500 REAIS', 'Gift card Nintendo', 500.00, 9);

INSERT INTO patrimonio(id_patrimonio,data_criacao, descricao, nome_patrimonio, preco, quantidade) VALUES
    (gen_random_uuid() ,'2024-05-24T12:26:14.447+00:00' ,'GIFT CARD IFOOD 50 REAIS', 'Gift card Ifood', 50.00, 123);

