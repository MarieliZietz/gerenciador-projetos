# API Gerenciadora de Projetos

API desenvolvida em Java com Spring Boot para gerenciamento de projetos e equipes.

## Funcionalidades

### Projetos
- Cadastrar projetos.
- Listar todos os projetos.
- Consultar um projeto por ID.
- Atualizar informações de um projeto.
- Excluir projetos.
- Validar campos obrigatórios e status.

### Equipes
- Cadastrar equipes.
- Listar todas as equipes.
- Consultar uma equipe por ID.
- Atualizar informações de uma equipe.
- Excluir equipes.
- Validar o nome do líder.

## Tecnologias utilizadas

- Java 21
- Spring Boot
- Maven

## Como executar o projeto

1. Clone o repositório.
2. Abra a pasta do projeto no terminal.
3. Execute o comando:

```bash
.\mvnw.cmd spring-boot:run
```

A aplicação será iniciada localmente na porta 8080.

## Endpoints

### Projetos

| Método | Endpoint | Descrição |
|---|---|---|
| POST | `/projetos` | Cadastrar projeto |
| GET | `/projetos` | Listar projetos |
| GET | `/projetos/{id}` | Consultar projeto |
| PUT | `/projetos/{id}` | Atualizar projeto |
| DELETE | `/projetos/{id}` | Excluir projeto |

### Equipes

| Método | Endpoint | Descrição |
|---|---|---|
| POST | `/equipes` | Cadastrar equipe |
| GET | `/equipes` | Listar equipes |
| GET | `/equipes/{id}` | Consultar equipe |
| PUT | `/equipes/{id}` | Atualizar equipe |
| DELETE | `/equipes/{id}` | Excluir equipe |

## Observação

Os dados são armazenados em memória e são perdidos quando a aplicação é reiniciada.
