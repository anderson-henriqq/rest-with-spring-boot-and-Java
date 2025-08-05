
# 🐾 Sistema PetCare - Gestão de Clínicas Veterinárias

## 📚 Sobre o Projeto

O **PetCare** é o **back-end** de um sistema de gestão de clínicas veterinárias, desenvolvido em **Java** com o framework **Spring Boot** e utilizando **PostgreSQL** como banco de dados relacional. A documentação da API é fornecida via **Swagger**, facilitando o teste e a visualização dos endpoints.

Este sistema foi construído colaborativamente pela turma de **Análise e Desenvolvimento de Sistemas (ADS) 2023.2** do IFRN - Instituto Federal do Rio Grande do Norte, durante a disciplina de **Administração de Banco de Dados**.

A proposta da disciplina foi desenvolver um sistema completo, onde cada grupo ficou responsável por implementar uma funcionalidade específica, utilizando boas práticas de desenvolvimento, arquitetura em camadas e integração com banco de dados.

Este repositório contém o sistema desenvolvido pela equipe composta por **Anderson Henrique**, **Giovanna**, **Laura Luna**, **Luiz** e **Samuel**.

---

## 💡 Objetivo

Desenvolver todas as entidades e funcionalidades necessárias para o funcionamento completo do sistema PetCare. Isso inclui a implementação de diversas entidades como Pet, Tutor, Veterinário, Clínica, Atendimento, Medicamento, Internamento, entre outras.

Cada funcionalidade foi estruturada seguindo os princípios da arquitetura em camadas, utilizando:

- **Model**
- **Repository**
- **Service**
- **Controller**
- **DTO (Response)**

Além disso, foi adotado o uso de boas práticas como a documentação com Swagger e a padronização dos endpoints REST.

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

## 👨‍💻 Equipe

- **Anderson Henrique**
- **Giovanna**
- **Laura Luna**
- **Luiz**
- **Samuel**
