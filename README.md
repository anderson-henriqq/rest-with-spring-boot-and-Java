
# 🐾 Trabalho Prático - Consultas Avançadas no Sistema PetCare

## 📚 Sobre o Projeto

O **PetCare** é um sistema de gestão de clínicas veterinárias construído colaborativamente pela turma de **Análise e Desenvolvimento de Sistemas (ADS) 2023.2** do IFRN - Instituto Federal do Rio Grande do Norte, durante a disciplina de **Administração de Banco de Dados**.

A proposta da disciplina foi desenvolver um sistema completo, onde **cada grupo ficou responsável por implementar uma funcionalidade específica** e preparar um **trabalho prático (TP)** para que os demais colegas pudessem implementar e consolidar os conhecimentos em banco de dados e boas práticas de desenvolvimento.

Este repositório contém o trabalho prático da equipe composta por **Anderson Henrique**, **Giovanna**, **Laura Luna**, **Luiz** e **Samuel**. Nossa contribuição foi a implementação do módulo de **Internamento de Pets**.

Com o crescimento do sistema **PetCare**, a clínica passou a oferecer internações para pets. Este trabalho prático tem como objetivo implementar a funcionalidade de **internamento**, utilizando conceitos de **consultas avançadas** e aplicando os padrões arquiteturais já adotados no sistema.

---

---
## 📌 O que são Consultas Avançadas?

Consultas avançadas são operações de leitura no banco de dados que vão além do simples `findAll()` ou `findById()`. Elas permitem **filtrar, agrupar, ordenar ou relacionar dados** de forma mais específica e poderosa.

### ✅ Por que usar consultas avançadas?
- Quando queremos **filtrar** informações específicas (ex: internações de um pet específico).
- Quando precisamos **trazer dados combinando múltiplas entidades**.
- Quando desejamos retornar **somente campos selecionados** (via DTOs), e não o objeto completo.

### 🧪 Exemplo prático com Spring Data JPA

#### Suponha que queremos buscar internações de um pet pelo seu ID:

**Repository:**

```java
@Query("SELECT new com.exemplo.dto.InternamentoDTO(i.id, i.motivo, i.dataEntrada, i.dataSaida, i.pet.nome, i.tutor.nome) " +
       "FROM Internamento i WHERE i.pet.id = :petId")
List<InternamentoDTO> findByPetId(@Param("petId") Long petId);
```

**Explicação:**
- A anotação `@Query` permite escrever uma consulta personalizada em JPQL.
- A instrução `new InternamentoDTO(...)` cria diretamente objetos DTO com os campos desejados.
- Utilizamos `JOIN` implícito para acessar campos de entidades relacionadas (`i.pet.nome`, `i.tutor.nome`).

Essa abordagem melhora a performance e deixa o retorno mais leve, pois só os campos necessários são buscados no banco.
## 💡 Objetivo

Implementar a entidade `Internamento` com as camadas:

- **Model**
- **Repository**
- **Service**
- **Controller**
- **DTO (Response)**

E criar um **endpoint de consulta avançada** para listar internações com base no **ID do pet**.

---

## 🏥 Entidade: Internamento

Representa o registro de pets internados na clínica. A entidade deve conter os seguintes campos:

```java
private Long id;
private LocalDate dataEntrada;
private LocalDate dataSaida;
private String motivo;

@ManyToOne
private Pet pet;

@ManyToOne
private Tutor tutor;

@ManyToOne
private Clinica clinica;
```

---

## 🔍 Endpoint Avançado

Criar o seguinte endpoint na API:

```http
GET /api/internamentos/pet/{id}
```

Esse endpoint deve retornar uma lista de internações associadas ao **ID do pet** informado.

### 🧾 DTO de Resposta

```java
public class InternamentoDTO {
    private Long id;
    private String motivo;
    private LocalDate dataEntrada;
    private LocalDate dataSaida;
    private String nomePet;
    private String nomeTutor;
}
```

---

## 🛠 Pré-requisitos

Antes de começar, instale as seguintes ferramentas:

- **Java 21** - [Download](https://adoptium.net/)
- **PostgreSQL 12+** - [Download](https://www.postgresql.org/download/)
- **Git** - [Download](https://git-scm.com/)
- **Postman** (para testes manuais de API) - [Download](https://www.postman.com/downloads/)

---

## 🧰 Ferramentas Utilizadas

- **Java 21**
- **Spring Boot 3.4.0**
- **Postman**

### ⚙️ Configurações no Spring Initializr

- **Project:** Maven
- **Language:** Java
- **Spring Boot:** 3.4.0
- **Packaging:** Jar
- **Java:** 21
- **Dependencies:** Spring Web, Spring DevTools

---

## 🚀 Instalação

### 1. Clone o repositório

```bash
git clone https://(ver qual o link que vamos pegar o projeto)
cd petcare
```

### 2. Configure o banco de dados

Crie um banco de dados chamado `petcare` no PostgreSQL com usuário e senha padrão `postgres`.

### 3. Ajuste o `application.properties`

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/petcare
spring.datasource.username=postgres
spring.datasource.password=postgres

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

server.port=8080
```

---

## ▶️ Executando o Projeto

No terminal, execute:

```bash
./mvnw spring-boot:run
```

Ou no Windows:

```cmd
mvnw.cmd spring-boot:run
```

---

## 🧪 Testando o Endpoint

Abra o navegador ou o Postman e acesse:

> [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

Busque pela rota:

```http
GET /api/internamentos/pet/{id}
```

Substitua `{id}` pelo ID de um pet existente para visualizar suas internações.

---

## 👨‍💻 Equipe

- **Anderson Henrique**
- **Giovanna**
- **Laura Luna**
- **Luiz**
- **Samuel**
