# dependencias

- Node.js v20.11.0
- React Router DOM
- Java JDK 21

# iniciar projeto

npm install react-router-dom

npm install

npm run dev

# Documentação da API com Swagger

- Inicializar API
- Entrar no localhost: http://localhost:8080/swagger-ui/index.html#/

# Lombok

- Precisa baixar o plugin "Lombok" para funcionar

# Como criar patrimônios

## 1: pgAdmin4:

  INSERT INTO patrimonio(id_patrimonio,data_criacao, descricao, nome_patrimonio, preco, quantidade) VALUES
    (gen_random_uuid(), NOW(), ?, ?, ?, ?);

## 2: SwaggerUI
  - Entrar em: http://localhost:8080/swagger-ui/index.html#/
  - Ir em "patrimonio-controller"
  - Ir em [POST] /patrimonio
  - Try it out
  - Editar o exemplo
  - EXEMPLO:
    
{
  "nomePatrimonio": "Gift card Ifood",
  "preco": 50.00,
  "quantidade": 123,
  "descricao": "GIFT CARD IFOOD 50 REAIS",
  "dataCriacao": "2024-05-24T12:26:14.447Z"
}

  - Apertar [EXECUTE]

## 3: Postman:
  - Ir em "Create new collection" -> "Blank Collection"
  - Apertar no nome da collection com o botao direito
  - Ir em "Add request"
  - Trocar de "GET" para "POST"
  - colocar a URL: localhost:8080/patrimonio
  - Ir em "Body" e depois "Raw"
  - Inserir os dados, EXEMPLO:
    
{
  "nomePatrimonio": "Gift card Nintendo",
  "preco": 500.00,
  "quantidade": 9,
  "descricao": "GIFT CARD NINTENDO 500 REAIS",
  "dataCriacao": "2024-05-24T12:26:14.447Z"
}

  - Apertar [SEND]

## IMPORTANTE: INDEPENDETE DA FORMA QUE FOR CRIAR O PATRIMONIO É NECESSÁRIO CRIAR UM COMANDO SQL PARA COLOCAR NO "Patrimonio.sql"

### Ver todos os patrimonios criados: localhost:8080/patrimonio
### Ver patrimonio expecifico criado: localhost:8080/patrimonio/{id}
### EXEMPLO GIFT CARD NINTENDO: http://localhost:8080/patrimonio/9933e778-5fcc-4b76-ba6b-cd05aa590356
