# Pombo correio

---

### Objetivo:
    
    O projeto é um POC para uso do Spring Boot com banco de dados mariaDB.
    A API consiste em envios de mensagens entre duas pessoas. Possuindo criação de conta,
    cadastrar contatos e enviar as mensagens respectivamente. 
    Abaixo maior detalhe para uso da API.

---

### Tabela de endpoint:

ENDPOINT | FUNÇÃO | HTTP METHOD | BODY 
---------|--------|-------------|-------
contas/ | cadastrar conta | POST | JSON
contas/?telefone={numerotelefone} | pesquisar conta por telefone | GET | NÃO
contas/{id}/ | atualizar uma conta | PUT | JSON
contas/{id}/ | ativar ou desativar perfil | PATCH | NÃO
contatos/ | cadastrar novo contato | POST | JSON
contatos/{id}/ | mostrar contatos de uma conta | GET | NÃO
contatos/{idConta}/{idContatos} | deletar contato | DELETE | NÃO
contatos/{id}/ | bloquear ou desbloquear contato | PATCH | NÃO
conversacoes/ | iniciar nova conversa | POST | JSON
conversacoes/{id}/ | mostra todas conversas de uma conta | GET | JSON
conversacoes/{id}/ | enviar mensagem | PUT | JSON

### Exemplo de uso de JSON

1. Contas
    ~~~json
   {
        "nomeCompleto":"Paulo Sergio",
        "numeroTelefone": "(11)1111-1111",
        "foto":"foto.png",
        "recado":"DISPONIVEL",
        "senha": "123456"
    }
   ~~~
2. Pesquisa de contas por telefone - resultado:
    url: contas/?telefone=(11)1111-1111
   ~~~json
   {
       "id": 1,
       "nomeCompleto":"Paulo Sergio",
       "numeroTelefone": "(11)1111-1111",
       "foto":"foto.png",
       "recado":"DISPONIVEL",
       "senha": "123456",
       "ativo": true
   }
   ~~~   
3. Atualização de conta
    url: contas/1/
   ~~~json
   {
       "nomeCompleto":"Paulo Sergio",
       "numeroTelefone": "(11)1111-1111",
       "foto":"foto.png",
       "recado":"DISPONIVEL",
       "senha": "123456"
   }
   ~~~
4. Ativar ou desativar conta: url: contas/1/

5. Cadastrar um contato:
   
    ~~~json
   {
        "nomeCompleto":"Jhon Dee",
        "numeroTelefone": "(11)1111-1112",
        "idConta": 1
    }
   ~~~ 
   saída
    ~~~json
   {
        "id": 5,
        "nomeCompleto": "Jhon Dee",
        "numeroTelefone": "(11)1111-1112",
        "bloqueio": false,
        "idConta": 1
    }
   ~~~
6. Mostrar contatos de uma conta: url: contatos/1/ (o id é da conta)
    ~~~json
    [
        {
            "id": 1,
            "nomeCompleto": "Janaina Silva",
            "numeroTelefone": "(34)99650-9890",
            "bloqueio": false
        },
        {
            "id": 2,
            "nomeCompleto": "Ronan Silva",
            "numeroTelefone": "(34)1211-2133",
            "bloqueio": false
        },
        {
            "id": 3,
            "nomeCompleto": "iris Santos",
            "numeroTelefone": "(34)99857-0848",
            "bloqueio": false
        },
        {
            "id": 5,
            "nomeCompleto": "Jhon Dee",
            "numeroTelefone": "(11)1111-1112",
            "bloqueio": false
        }
    ]
   ~~~
7. Deletar um contato: contatos/1/1/

8. Cadastrar nova conversa
    ~~~json
   {
        "idConta": 1,
        "idContato": 5
    }
    ~~~
    saída:
   ~~~json
    {
        "idConversacao": 3,
        "idContato": 5,
        "nomeContato": "Jhon Dee",
        "fotoContato": null
    }
   ~~~
9. Enviar mensagem com id da conversa:
    ~~~json
    {
      "mensagem": "Olá, tudo bom?"
    }
    ~~~
    saída:
   ~~~json
   {
    "idConversacao": 1,
    "idContato": 1,
    "nomeContato": "Janaina Silva",
    "fotoContato": null,
    "mensagens": [
        {
            "id": 4,
            "mensagem": "Olá, tudo bom?",
            "dataHora": "2021-04-15T10:46:29.0062464"
        }
      ]
    }
   ~~~