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
    "id": 1,
    "cpf": "12345678978",
    "nome": "João Henrique",
    "boletim"{
        "primeiraNota": 10,
        "segundaNota": 3,
        "media": 6.5,
        "status": "REPROVADO"
    }
  }

  {
    "id": 2,
    "cpf": "12655678978",
    "nome": "João Lucas",
    "boletim"{
        "primeiraNota": 10,
        "segundaNota": 5,
        "media": 7.5,
        "status": "APROVADO"
    }
  }
]
```

### 2. Criar estudante

**POST** `/add`

Cria um novo estudante.

**Corpo da requisição:**
```json
{
    "cpf": "32165498798",
    "nome": "João Marcos"
}
```

### 3. Atualizar estudante

**PUT** `/edit/{id}`

Atualiza um estudante existente.

**Corpo da requisição:**
```json
{
    "cpf": "32165498798",
    "nome": "João Marcos"
}
```

### 4. Remover estudante

**DELETE** `/delete/{id}`

Remove um estudante pelo ID.

### 5. Procurar estudante por id

**GET** `/{id}`

Retorna um estudante existente.

**Exemplo de resposta:**
```json
[
  {
    "id": 1,
    "cpf": "12345678978",
    "nome": "João Henrique",
    "boletim"{
        "primeiraNota": 10,
        "segundaNota": 3,
        "media": 6.5,
        "status": "REPROVADO"
    }
  }
]
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
[
  {
    "id": 1,
    "cpf": "12345678978",
    "nome": "João Henrique",
    "boletim"{
        "primeiraNota": 10,
        "segundaNota": 3,
        "media": 6.5,
        "status": "REPROVADO"
    }
  }
]
```
### 7. Atualizar boletim

**PUT** `/boletim/edit/{id}`

Atualiza um boletim pelo id do estudante.

**Corpo da requisição:**
```json
{
    "primeiraNota": "10",
    "segundaNota": "2"
}
```

### 8. Procurar boletim por id do estudante

**GET** `/boletim/{id}`

Procura um boletim pelo id do estudante.

**Exemplo de resposta:**
```json
[
  {
    "primeiraNota": 10,
    "segundaNota": 3,
    "media": 6.5,
    "status": "REPROVADO"
    }
]


