## Api Gestão De Alunos

## Sobre

Tive como objetivo desenvolver uma API que proporcionasse ao usuário total controle sobre o gerenciamento de alunos e seus boletins. Durante o projeto, consegui aplicar meus conhecimentos em APIs RESTful e no framework Spring Boot. 

## Base URL

```
/students
```

## Endpoints

### 1. Listar estudantes

**GET** 

Retorna todos os estudantes cadastrados.

**Exemplo de resposta:**
```json
[
  {
    "cpf": "32165498765",
    "name": "Thays Linhares"
  }
  {
    "cpf": "12655678978",
    "nome": "João Lucas",
  }
]
```

### 2. Criar estudante

**POST** ``

Cria um novo estudante.

**Corpo da requisição:**
```json
{
    "cpf": "32165498798",
    "nome": "João Marcos"
}
```

### 3. Atualizar estudante

**PUT** `/{id}`

Atualiza um estudante existente.

**Corpo da requisição:**
```json
{
    "cpf": "32165498798",
    "nome": "João Marcos"
}
```

### 4. Remover estudante

**DELETE** `/{id}`

Remove um estudante pelo ID.

### 5. Procurar estudante por id

**GET** `/{id}`

Retorna um estudante existente.

**Exemplo de resposta:**
```json

  {
    "cpf": "12345678978",
    "nome": "João Henrique"
  }

```

### 6. Procurar estudante por CPF

**GET** `/cpf`

Retorna um estudante existente.

**Request Param:**
```json
cpf:"12345678978"
```

**Exemplo de resposta:**
```json
  {
    "id": 1,
    "cpf": "12345678978",
    "nome": "João Henrique"
  }
```
## Base URL

```
/report-card
```

## Endpoints
### 1. Atualizar report card

**PUT** `/{id}`

Atualiza um report card pelo id do estudante.

**Corpo da requisição:**
```json
{
    "primeiraNota": "10",
    "segundaNota": "2"
}
```

### 2. Procurar report card por id do estudante

**GET** `/student_id/{studentId}`

Procura um report card pelo id do estudante.

**Exemplo de resposta:**
```json
  {
    "primeiraNota": 10,
    "segundaNota": 3,
    "media": 6.5,
    "status": "REPROVADO"
    }
```
### 3. Procurar report card por id.

**GET** `/{id}`

Procura um report card pelo seu id.

**Exemplo de resposta:**
```json
{
    "firstTest": 10.00,
    "secondTest": 2.00,
    "media": 6.00,
    "status": "REPROVADO"
}
```

