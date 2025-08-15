# 🧠 Product API - DDD com Spring Boot

Este projeto é uma API REST construída com **Java + Spring Boot**, aplicando os princípios de **DDD (Domain-Driven Design)** de forma prática e organizada.

## 📚 Sobre o Projeto

A API permite operações básicas de gerenciamento de produtos:

- ✅ Criar produto
- ✅ Listar todos os produtos
- ✅ Buscar produto por ID

O foco principal está na **estrutura da aplicação**, separando bem as camadas e responsabilidades segundo os conceitos de DDD.

---

## 🏗️ Arquitetura do Projeto

O projeto é dividido por **módulos de negócio** (por exemplo, `product`) e **camadas funcionais**:

```
src/main/java/com/mateus/productapi
│
├── product
│ ├── domain # Regras de negócio, entidades e interfaces
│ ├── application # Casos de uso e serviços de aplicação
│ ├── infrastructure # Implementações técnicas (JPA, banco, etc.)
│ └── interface # Controllers, DTOs, entrada e saída da API
│
└── config # Configurações globais (Swagger, etc.)
```
### 🧱 Camadas no DDD

| Camada         | Descrição |
|----------------|-----------|
| `domain`       | Entidades, regras de negócio e contratos (sem dependência de frameworks) |
| `application`  | Casos de uso da aplicação (ex: criar produto) |
| `interface`    | Ponto de entrada da aplicação (controllers REST) |
| `infrastructure` | Implementações concretas (persistência com JPA, integrações, etc) |

---

## 🚀 Como Executar

### Pré-requisitos

- Java 21+
- Gradle 8.10
- Banco de dados H2 (in-memory)
- IntelliJ, Eclipse ou VS Code (opcional)

### Passos

```bash
# Clone o repositório
git clone https://github.com/seu-usuario/product-api-ddd.git
cd product-api-ddd

# Rode a aplicação
./gradlew bootRun

# Acesse
http://localhost:8080/swagger-ui/index.html