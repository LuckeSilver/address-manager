# 📍 Address Manager API (Spring Boot + H2)

API para gerenciamento de endereços com cadastro completo (CEP, logradouro, dados pessoais) e integração com ViaCEP.

## ⚙️ Configuração do Ambiente
 1. __Clone o repositório__: https://github.com/LuckeSilver/address-manager.git

## 🏃 Executando o Projeto
### Opção 1: IDE

- Importe como projeto Maven na sua IDE favorita

- Execute a classe __AddressManagerApplication__

### Opção 2: Terminal

- Vá para a pasta do projeto:

   __cd address-manager__
   
- Rode o comando: 

   __mvn spring-boot:run__

## Configure o banco de dados na url:

 http://localhost:8080/h2-console/

 ### com as informações abaixo

   Driver Class: org.h2.Driver

   JDBC URL: jdbc:h2:mem:testdb
   
   User Name: sa
   
   Password: password

## 🌐 Endpoints da API
A API estará disponível em: http://localhost:8080/api

### Rotas Principais
| Método | Endpoint                | Descrição                |
|--------|-------------------------|--------------------------|
| POST   | /api/addresses           | Cadastra novo endereço   |
| GET    | /api/addresses           | Lista todos endereços    |
| GET    | /api/addresses/{id}      | Busca endereço por ID    |
| PUT    | /api/addresses/{id}      | Atualiza endereço        |
| DELETE | /api/addresses/{id}      | Remove endereço          |

## 🚀 Tecnologias
- Java 17

- Spring Boot 3.1+

- Spring Data JPA

- H2 Database 

## 📋 Pré-requisitos

- JDK 17+

- Maven 3.8+


Desenvolvido com 💜 por Lucas Silva.