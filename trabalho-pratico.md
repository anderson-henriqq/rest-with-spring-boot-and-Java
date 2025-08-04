# Trabalho Prático - Consultas Avançadas no Sistema Petcare 🐾

## Descrição da Atividade
Com o sucesso do PetCare, a clínica expandiu e passou a oferecer internações para pets. 
Sua dupla será responsável por implementar a funcionalidade de internamento, seguindo os 
padrões arquiteturais do projeto: Model, Repository, Service, Controller, uso de DTO, 
e um filtro simples com base no ID do pet internado.
## Entidade a ser implementada:
**Internamento**
- Representa o registro de pets que ficaram internados na clínica.

## Campos obrigatórios:

- id (Long) – identificador
- dataEntrada (LocalDate)
- dataSaida (LocalDate)
- motivo (String)
- pet (@ManyToOne)
- tutor (@ManyToOne)
- clinica (@ManyToOne)

## Requisitos
1. Criar a classe Internamento.java com as anotações JPA.

2. Criar as seguintes classes:

- Repository - InternamentoRepository.java
- Service	- InternamentoService.java
- Controller	- InternamentoController.java
- DTO (response)	- InternamentoDTO.java

3. Criar um endpoint para buscar internações por ID do pet:
> ```GET /api/internamentos/pet/{id}```
- Deve retornar todas as internações vinculadas ao pet com o ID informado.
  
4. Utilizar um DTO para retornar os seguintes dados:
```
public class InternamentoDTO {
    private Long id;
    private String motivo;
    private LocalDate dataEntrada;
    private LocalDate dataSaida;
    private String nomePet;
    private String nomeTutor;
}
```
5. Atualizar o Swagger para testar o endpoint.

## Assigment TP 5
<...>
