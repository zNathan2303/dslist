# Game List API Backend
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Apache Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)
![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)
![Postman](https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=postman&logoColor=white)

[![MIT license](https://img.shields.io/badge/License-MIT-blue.svg)](https://lbesson.mit-license.org/)
## Navegação
- [Sobre o Projeto](#sobre-o-projeto)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Executando o Projeto](#executando-o-projeto)
- [API Endpoints](#api-endpoints)
- [Configurando Perfis](#configurando-perfis)
- [Integrando com Frontend](#integrando-com-frontend)
- [Autor](#autor)
- [Licença](#licença)

## Sobre o Projeto
Este repositório contém a API backend desenvolvida durante o **Intensivão de Java com Spring Boot** da **DevSuperior**. A API tem como objetivo gerenciar uma lista de jogos, com funcionalidades como listagem de jogos, filtragem por gênero e reordenação de itens. O projeto foi construído como parte de um aprendizado prático, evoluindo ao longo de cinco aulas.

## Tecnologias Utilizadas
- **Java 21:** Linguagem de programação.
- **Spring Boot 3.5.4:** Framework para construção da aplicação.
- **Maven:** Gerenciador de dependências.
- **Spring Data JPA:** Acesso simplificado a dados.
- **PostgreSQL Database:** Banco de dados relacional (local e remoto).
- **H2 Database:** Banco de dados em memória para testes.
- **Postman:** Ferramenta para testes de API.

## Executando o Projeto

### Pré-requisitos
- **Java 21** ou superior.
- Uma **IDE** (ex.: **Spring Tool Suite**, **IntelliJ IDEA** ou **VS Code**)
- **Postman** (ou outra ferramenta para testes de API).

### Passos
1. Clone esse repositório:
```bash
git clone https://github.com/zNathan2303/dslist
```
2. Importe o projeto na sua IDE.
3. Execute a classe principal `DslistApplication`.
4. Teste os endpoints no Postman.

## API Endpoints
A API fornece os seguintes endpoints:

| Método | Endpoint | Descrição |
| --- | --- | --- |
| `GET` | `/games` | Retorna a lista completa de todos os jogos. |
| `GET` | `/games/{gameId}` | Retorna os detalhes de um jogo específico. |
| `GET` | `/lists` | Retorna a lista de gêneros. |
| `GET` | `/lists/{listId}/games`| Retorna os jogos de um gênero específico. |
| `PUT` | `/lists/{listId}/replacement` | Move um jogo de uma posição para outra dentro de uma lista. |

**Exemplo de Body para `PUT` `/lists/{listId}/replacement`:**
```json
{
    "sourceIndex": 3,
    "destinationIndex": 1
}
```

## Configurando Perfis
O projeto suporta três perfis: test (H2 em memória), dev (PostgreSQL local) e prod (PostgreSQL remoto). Para alterar, siga estas etapas:
1. Acesse o arquivo `application.properties` (src/main/resources/application.properties) e altere de `test` para `dev`:
```properties
# Define o perfil ativo
spring.profiles.active=${APP_PROFILE:dev}
```
2. Edite o arquivo `application-dev.properties` (src/main/resources/application-dev.properties) retirando a `#` das primeiras linhas:
```properties
spring.jpa.properties.jakarta.persistence.schema-generation.create-source=metadata
spring.jpa.properties.jakarta.persistence.schema-generation.scripts.action=create
spring.jpa.properties.jakarta.persistence.schema-generation.scripts.create-target=create.sql
spring.jpa.properties.hibernate.hbm2ddl.delimiter=;
```
3. Inicie a aplicação.
4. Pare a aplicação e veja na raiz que foi criado um arquivo chamado `create.sql`, que será responsável por fazer o seeding inicial nos bancos de dados.
5. Comente as linhas que foram descomentadas do arquivo `application-dev.properties`:
```properties
#spring.jpa.properties.jakarta.persistence.schema-generation.create-source=metadata
#spring.jpa.properties.jakarta.persistence.schema-generation.scripts.action=create
#spring.jpa.properties.jakarta.persistence.schema-generation.scripts.create-target=create.sql
#spring.jpa.properties.hibernate.hbm2ddl.delimiter=;
```

### Configurando o Perfil Dev
1. Edite `application.properties`:
```properties
spring.profiles.active=${APP_PROFILE:dev}
```
2. Configure o arquivo `application-dev.properties`:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/dslist
spring.datasource.username=postgres
spring.datasource.password=root
```
3. No banco de dados, insira os comandos do arquivo `create.sql`.

### Configurando o Perfil Prod
1. Edite `application.properties`:
```properties
spring.profiles.active=${APP_PROFILE:prod}
```
2. Configure um arquivo `config.properties` em `src/main/resources/config/config.properties`:
```properties
spring.datasource.url=
spring.datasource.username=
spring.datasource.password=
```
3. No banco de dados, insira os comandos do arquivo `create.sql`.

## Integrando com Frontend
O frontend correspondente está disponível [aqui](https://github.com/zNathan2303/frontend-game-list).

### Passos
1. Clone esse repositório:
```bash
git clone https://github.com/zNathan2303/frontend-game-list
```
2. Inicie o projeto Backend.
3. Inicie o projeto Frontend no VS Code com a extensão `Live Server`.

Certifique-se de que o frontend esteja configurado para a porta 5500 ou ajuste as anotações `@CrossOrigin` nas classes do pacote controllers no backend conforme necessário.

## Autor
[Nathan da Silva Costa](<https://www.linkedin.com/in/nathandasilvacosta/>)

## Licença
Este projeto está licenciado sob a [MIT License](https://opensource.org/license/MIT)
