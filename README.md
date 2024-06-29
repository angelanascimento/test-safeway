# Projeto de Sistema de Transações


- [Descrição](#descrição)
  - [Funcionalidades Principais](#funcionalidades-principais)
  - [Tecnologias Utilizadas](#tecnologias-utilizadas)
  - [Estrutura do Projeto](#estrutura-do-projeto)
  - [DER (Diagrama de Entidade-Relacionamento)](#der-diagrama-de-entidade-relacionamento)
  - [Documentação da API (Swagger)](#documentação-da-api-swagger)
- [Pré-requisitos](#pré-requisitos)
- [Como Rodar o Projeto](#como-rodar-o-projeto)

## Descrição:

Este projeto foi desenvolvido como resposta a um desafio técnico. Trata-se de um sistema de transações que gerencia operações de saque e depósito para empresas e clientes. O sistema foi construído utilizando a linguagem Java com o framework Spring Boot e segue uma arquitetura organizada em camadas, com controllers, dtos, models, repositories e services.

### Objetivos Principais:

- **Validação de CPF e CNPJ:** O sistema valida os números de CPF para clientes e CNPJ para empresas utilizando anotações específicas do Spring.
- **Taxas de Sistema:** Cada empresa possui pelo menos um tipo de taxa que é aplicada durante as transações (saque ou depósito).
- **Gestão de Saldos:** O saldo das empresas é atualizado com base nos depósitos e saques realizados pelos clientes, descontando as taxas de administração.
- **Transações:** Clientes podem realizar depósitos e saques nas empresas, dependendo do saldo disponível.
- **Notificações:** Após uma transação bem-sucedida, o sistema envia um e-mail de notificação ao cliente utilizando o serviço de e-mail do Gmail (SMTP Gmail). As informações das transações são armazenadas no banco de dados.

### Tecnologias Utilizadas:

- **Java**
- **Spring Boot** com as seguintes dependências:
  - `spring-boot-starter-data-jpa`
  - `spring-boot-starter-validation`
  - `spring-boot-starter-web`
  - `spring-boot-devtools`
  - `mysql-connector-j`
  - `spring-boot-starter-test`
  - `springdoc-openapi-starter-webmvc-ui` (versão 2.2.0)
  - `spring-context-support` (versão 6.1.5)
  - `spring-boot-starter-mail`
- **MySQL**
- **Swagger** para a documentação da API

### Estrutura do Projeto:

- **Controllers:** Controladores para gerenciar as requisições HTTP.
- **DTOs:** Objetos de Transferência de Dados utilizados para transportar dados entre as camadas do sistema.
- **Models:** Entidades representando as tabelas do banco de dados, incluindo `Account`, `Company`, `Customer` e `Email`.
- **Repositories:** Interfaces para acesso ao banco de dados.
- **Services:** Serviços contendo a lógica de negócio do sistema.

### DER (Diagrama de Entidade-Relacionamento):
...

### Documentação da API (Swagger):
...

### Pré-requisitos:

- **Java 17**
- **Maven 4.0.0**
- **MySQL 8.0**
- **Conta Gmail** (para envio de e-mails)
  
### Como Rodar o Projeto:

1. Clone o repositório:
   
   ```sh
   git clone https://github.com/angelanascimento/test-safeway.git

2. Configure as credenciais do banco de dados MySQL para persistência dos dados.

3. Configure as credenciais do Gmail no application.properties para o envio de e-mails.

4. Instale as dependências e inicie a aplicação:
   
   ```sh
   ./mvnw spring-boot:run

## Licença:
Este projeto está licenciado sob a Licença MIT 
