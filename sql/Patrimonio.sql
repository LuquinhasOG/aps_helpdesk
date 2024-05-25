-- CRIAÇÃO DE PATRIMONIO
INSERT INTO patrimonio(id_patrimonio,data_criacao, descricao, nome_patrimonio, preco, quantidade) VALUES
    (gen_random_uuid(), NOW(), ?, ?, ?, ?);

-- PATRIMONIOS CRIADOS:

INSERT INTO patrimonio(id_patrimonio,data_criacao, descricao, nome_patrimonio, preco, quantidade) VALUES
    ('11007eb7-ee2d-41e5-b349-18b8e33f040f','2024-05-24T12:26:14.447+00:00','GIFT CARD XBOX 100 REAIS', 'Gift card Games Pass', 100.00, 24);

INSERT INTO patrimonio(id_patrimonio,data_criacao, descricao, nome_patrimonio, preco, quantidade) VALUES
    ('3c79be4d-bc95-4600-9faa-b67f1d98522d','2024-05-24T12:37:14.447+00:00','GIFT CARD PLAYSTATION 300 REAIS', 'Gift card Playstation', 300.00, 42);

INSERT INTO patrimonio(id_patrimonio,data_criacao, descricao, nome_patrimonio, preco, quantidade) VALUES
    ('9933e778-5fcc-4b76-ba6b-cd05aa590356','2024-05-24T12:26:14.447+00:00','GIFT CARD NINTENDO 500 REAIS', 'Gift card Nintendo', 500.00, 9);

INSERT INTO patrimonio(id_patrimonio,data_criacao, descricao, nome_patrimonio, preco, quantidade) VALUES
    ('8a4be5dc-328c-4edc-9f94-3554b7a07a54','2024-05-24T12:26:14.447+00:00' ,'GIFT CARD IFOOD 50 REAIS', 'Gift card Ifood', 50.00, 123);

