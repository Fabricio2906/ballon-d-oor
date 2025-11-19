API REST desenvolvida com Spring Boot, simulando um sistema de gerenciamento de jogadores e seus títulos, inspirado na premiação Ballon d'Or.
O projeto utiliza arquitetura limpa com DTOs, Mappers, Services, além de banco em memória H2. Mas em breve haverá atualizações desse projeto, com JavaSecurity e também Hexagonal

🚀 Tecnologias utilizadas

Java 17+

Spring Boot

Spring Web

Spring Data JPA

H2 Database

Lombok

DTO + Mapper Pattern

📌 Funcionalidades
👤 Jogador

Criar jogador

Listar todos os jogadores

Buscar jogador por ID

Atualizar jogador

Excluir jogador

Associar títulos ao jogador

🏅 Títulos

Cadastro de títulos vinculados ao jogador

Cada título possui um nível de importância

Relação OneToMany entre Jogador → Título
orphanRemoval = true: remove títulos antigos automaticamente quando você der o .clear()

🗂️ Estrutura do Projeto
src/main/java/com/example/Ballon.D.oor
│
├── controller
│     └── JogadorController.java
│
├── dto
│     ├── JogadorDto.java
│     └── TituloDto.java
│
├── entity
│     ├── Jogador.java
│     └── Titulo.java
│
├── mapper
│     ├── JogadorMapper.java
│     └── TituloMapper.java
│
├── repository
│     ├── JogadorRepository.java
│     └── TituloRepository.java
│
└── service
      └── JogadorService.java

🧩 Modelo de Dados
🧍 Jogador
{
  "id": 1,
  "nome": "Lionel Messi",
  "idade": 36,
  "gols": 750,
  "assistencia": 350,
  "time": "Inter Miami",
  "ga": 1100,
  "titulo": [
    {
      "id": 10,
      "nome": "Copa do Mundo",
      "importancia": 5
    }
  ]
}

🏆 Título

nome: nome do título (ex: Champions League)

importancia: número representando relevância (1 a 10)

🛠️ Como rodar o projeto

Clone o repositório:

git clone https://github.com/Fabricio2906/ballon-d-oor.git


Abra no IntelliJ ou VS Code.

Rode o projeto:

mvn spring-boot:run


Acesse o H2:

http://localhost:8080/h2-console


JDBC URL: jdbc:h2:mem:testdb

📎 Endpoints Principais
Criar jogador

POST /jogadores

Listar jogadores

GET /jogadores

Buscar por ID

GET /jogadores/{id}

Atualizar

PUT /jogadores/{id}

Deletar

DELETE /jogadores/{id}

🎯 Objetivo do Projeto

Este projeto foi criado para estudar e praticar:

Boas práticas de API REST

DTOs e Mappers com Java Records

Mapeamento JPA (OneToMany, ManyToOne)

Camadas bem definidas (Controller → Service → Repository)

Uso do H2 como ambiente de testes

Estrutura limpa e escalável

✨ Desenvolvido por

Fabricio Batista
