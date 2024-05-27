# Sobre o projeto

Projeto para a APS de Banco de Dados, em que o objetivo era criar um helpdesk. O nosso projeto é uma aplicação web onde o Back End foi desenvolvido em Java com SpringBoot para a API e PostgreSQL para o banco de dados, e o Front End feito em TypeScript usando a biblioteca React.

# Dependências

- PostegreSQL
- Node.js v20.11.0
- React e React Router DOM (instruções de instalação na seção abaixo)
- Java JDK 21
- Maven
- Spring Boot, Beans, JPA e Hibernate (serão instaladas automaticamente pelo maven)

# Preparando para iniciar a aplicação pela primeira vez

## 1: Inicializando a API

Abra a pasta "api" como um projeto em uma IDE para desenvolvimento em Java, após encontre o arquivo "application.properties" em "api\src\main\resources" e abra ele. Este arquivo apresenta algumas configurações essenciais para a execução correta do projeto. A configuração "spring.datasource.url" diz qual banco de dados que vamos usar para armazenar as informações do helpdesk, depois é preciso colocar o nome e senha do usuário para se conectar ao SGBD, que são os campos "spring.datasource.username" e "spring.datasource.password", respectimente. Agora, basta compilar o projeto pelo método principal no arquivo "HelpdeskApplication.java" e rodar pela primeira vez, assim automaticamente as tabelas serão criadas. Após isso, interrompa a execução e insira os valores necessários que se encontram no final do script "sql/BancoDados_Helpdesk.sql". Feito isso a API estará funcionando corretamente na porta 8080 do host local.

## 2: Inicializando o site

Abra a pasta "front" na console e digite "npm install", assim as primeiras dependências do React serão instaladas, após digite "npm install react-router-dom" para adicionar o React Router DOM. Com a instalação das biblitecas feita use o comando "npm run dev", feito isso o servidor web estará rodando na porta 5173, a qual deve ser acessado pelo navegador

# Documentação da API com Swagger

- Inicializar API
- Entrar no localhost: http://localhost:8080/swagger-ui/index.html#/