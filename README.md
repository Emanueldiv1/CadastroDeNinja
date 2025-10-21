# 🥷 Cadastro de Ninjas

> Aplicação Spring Boot para gerenciamento de ninjas e suas missões

[![Java](https://img.shields.io/badge/Java-17-orange)](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.0-brightgreen)](https://spring.io/projects/spring-boot)
[![Maven](https://img.shields.io/badge/Maven-3.6+-blue)](https://maven.apache.org/)
[![H2 Database](https://img.shields.io/badge/H2-Database-blue)](https://www.h2database.com/)
[![Docker](https://img.shields.io/badge/Docker-Container-blue?logo=docker)](https://www.docker.com/)



## 📋 Sobre o Projeto

O **Cadastro de Ninjas** é uma aplicação web desenvolvida em Spring Boot como parte da "Aula de Batismo de Java". A aplicação permite gerenciar um cadastro de ninjas e suas missões, oferecendo tanto uma API REST quanto uma interface web usando Thymeleaf.

### ✨ Funcionalidades

- 👤 **Gestão de Ninjas**: Cadastro, listagem, edição e exclusão de ninjas
- 🎯 **Gestão de Missões**: Gerenciamento de missões para os ninjas
- 🌐 **Interface Web**: Interface amigável usando Thymeleaf
- 🔌 **API REST**: Endpoints para integração externa
- 💾 **Banco de Dados**: Persistência usando H2 Database (desenvolvimento) e PostgreSQL (produção)
- 🐳 **Docker**: Containerização da aplicação com Docker Compose
- 🐘 **PostgreSQL**: Banco de dados para ambiente containerizado

## 🏗️ Arquitetura

A aplicação segue uma arquitetura em camadas bem estruturada:

```
src/
├── main/
│   ├── java/dev/java10x/cadastroDeNinjas/
│   │   ├── CadastroDeNinjasApplication.java
│   │   ├── Ninjas/
│   │   │   ├── Controller/          # Controllers REST
│   │   │   ├── UI/                  # Controllers Web (Thymeleaf)
│   │   │   ├── Dto/                 # Data Transfer Objects
│   │   │   ├── Model/               # Entidades JPA
│   │   │   ├── Repository/          # Repositories
│   │   │   ├── Service/             # Camada de Negócios
│   │   │   └── Mapper/              # Mapeadores DTO/Model
│   │   └── Missoes/
│   │       ├── Controller/
│   │       ├── DTO/
│   │       ├── Model/
│   │       ├── Repository/
│   │       ├── Service/
│   │       └── Mapper/
│   └── resources/
│       └── application.properties
└── test/
```

## 🎯 Entidades

### Ninja
- **ID**: Identificador único
- **Nome**: Nome do ninja
- **Email**: Email único
- **Idade**: Idade do ninja
- **Rank**: Classificação (Genin, Chunin, Jonin, etc.)
- **URL da Imagem**: Link para imagem do ninja
- **Missão**: Missão associada ao ninja

### Missão
- **ID**: Identificador único
- **Nome**: Nome da missão
- **Dificuldade**: Nível de dificuldade
- **Descrição**: Detalhes da missão
- **Ninjas**: Lista de ninjas associados

## 🚀 Como Executar

### Pré-requisitos

- Java 17+
- Maven 3.6+
- Docker (opcional)

### Variáveis de Ambiente

Configure as seguintes variáveis de ambiente:

#### Para H2 Database (desenvolvimento local):
```bash
DATABASE_URL=jdbc:h2:mem:ninja_db
DATABASE_USERNAME=sa
DATABASE_PASSWORD=
```

#### Para PostgreSQL (Docker):
```bash
DATABASE_USERNAME_POSTGRESQL=ninja_user
DATABASE_PASSWORD_POSTGRESQL=ninja_password
```

### Executando Localmente

1. Clone o repositório:
```bash
git clone <url-do-repositorio>
cd cadastroDeNinjas
```

2. Configure as variáveis de ambiente ou crie um arquivo `.env`

3. Execute a aplicação:
```bash
./mvnw spring-boot:run
```

### Executando com Docker

#### Opção 1: Docker Compose (Recomendado)

1. Configure as variáveis de ambiente para PostgreSQL:
```bash
# Crie um arquivo .env na raiz do projeto
DATABASE_USERNAME_POSTGRESQL=ninja_user
DATABASE_PASSWORD_POSTGRESQL=ninja_password
```

2. Execute com Docker Compose:
```bash
# Subir apenas o banco PostgreSQL
docker-compose up postgres -d

# Para executar a aplicação completa (após implementar o serviço da aplicação)
docker-compose up -d
```

#### Opção 2: Docker manual

1. Build da aplicação:
```bash
./mvnw clean package -DskipTests
```

2. Build da imagem Docker:
```bash
docker build -t cadastro-ninjas .
```

3. Execute o container:
```bash
docker run -p 8080:8080 \
  -e DATABASE_URL=jdbc:h2:mem:ninja_db \
  -e DATABASE_USERNAME=sa \
  -e DATABASE_PASSWORD= \
  cadastro-ninjas
```

## 📚 API Endpoints

### Ninjas

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| GET | `/ninja` | Rota geral |
| POST | `/ninja/criar` | Criar novo ninja |
| GET | `/ninja/listar` | Listar todos os ninjas |
| GET | `/ninja/listar/{id}` | Buscar ninja por ID |
| PUT | `/ninja/alterar/{id}` | Atualizar ninja |
| DELETE | `/ninja/deletar/{id}` | Deletar ninja |

### Missões

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| POST | `/missoes/criar` | Criar nova missão |
| GET | `/missoes/listar` | Listar todas as missões |
| GET | `/missoes/listar/{id}` | Buscar missão por ID |
| PUT | `/missoes/alterar/{id}` | Atualizar missão |
| DELETE | `/missoes/deletar/{id}` | Deletar missão |

### Interface Web

| Endpoint | Descrição |
|----------|-----------|
| `/ninjas/ui/listar` | Lista todos os ninjas |
| `/ninjas/ui/adicionar` | Formulário para adicionar ninja |
| `/ninjas/ui/alterar/{id}` | Formulário para editar ninja |
| `/ninjas/ui/listar/{id}` | Detalhes de um ninja |
| `/ninjas/ui/deletar/{id}` | Deletar ninja |

## 🛠️ Tecnologias Utilizadas

- **Java 17**: Linguagem de programação
- **Spring Boot 3.5.0**: Framework principal
- **Spring Data JPA**: Persistência de dados
- **Spring Web**: API REST
- **Thymeleaf**: Template engine para interface web
- **H2 Database**: Banco de dados em memória (desenvolvimento)
- **PostgreSQL**: Banco de dados relacional (produção)
- **Flyway**: Migração de banco de dados
- **Lombok**: Redução de boilerplate
- **Maven**: Gerenciamento de dependências
- **Docker**: Containerização
- **Docker Compose**: Orquestração de containers

## 🔧 Configurações

### Banco de Dados

#### H2 Database (Desenvolvimento Local)
A aplicação utiliza H2 Database em memória para desenvolvimento. O console H2 está disponível em:
- URL: `http://localhost:8080/h2`
- JDBC URL: `jdbc:h2:mem:ninja_db`
- Username: `sa`
- Password: (vazio)

#### PostgreSQL (Docker)
Quando executada via Docker Compose, a aplicação utiliza PostgreSQL:
- Host: `localhost`
- Porta: `5431`
- Database: `cadastrodocker`
- Container: `cadastroDeNinjasDocker`
- Username/Password: Configurados via variáveis de ambiente

### Flyway

O Flyway está configurado mas atualmente desabilitado (`spring.flyway.enabled=false`). Para habilitar:

1. Altere `spring.flyway.enabled=true` no `application.properties`
2. Adicione scripts de migração em `src/main/resources/db/migrations`

### Docker Compose

O arquivo `docker-compose.yml` configura:
- **PostgreSQL**: Banco de dados principal
- **Porta personalizada**: 5431 (para evitar conflitos)
- **Persistência**: Volume para dados do PostgreSQL
- **Variáveis de ambiente**: Configuração flexível via `.env`

## 🧪 Testes

Execute os testes com:

```bash
./mvnw test
```

## 📦 Build para Produção

```bash
./mvnw clean package
```

O arquivo JAR será gerado em `target/cadastroDeNinjas-0.0.1-SNAPSHOT.jar`

## 🐳 Docker e Containerização

### Estrutura Docker

O projeto inclui:

#### Dockerfile
```dockerfile
FROM eclipse-temurin:21
LABEL maintainer="emanuelrodrigueser@gmail.com"
WORKDIR /app
COPY target/cadastroDeNinjas-0.0.1-SNAPSHOT.jar /app/cadastro_de_ninja_docker.jar
ENTRYPOINT ["java", "-jar", "cadastro_de_ninja_docker.jar"]
```

#### Docker Compose
```yaml
version: '3.8'
services:
  postgres:
    image: postgres:latest
    container_name: cadastroDeNinjasDocker
    environment:
      POSTGRES_DB: cadastrodocker
      POSTGRES_USER: ${DATABASE_USERNAME_POSTGRESQL}
      POSTGRES_PASSWORD: ${DATABASE_PASSWORD_POSTGRESQL}
    ports:
      - "5431:5432"
    restart: always
```

### Comandos Docker Úteis

```bash
# Verificar containers em execução
docker ps

# Ver logs do PostgreSQL
docker logs cadastroDeNinjasDocker

# Conectar ao banco PostgreSQL
docker exec -it cadastroDeNinjasDocker psql -U ninja_user -d cadastrodocker

# Parar todos os serviços
docker-compose down

# Parar e remover volumes
docker-compose down -v
```

## 📄 Licença

Projeto desenvolvido para fins educacionais.

## 👨‍💻 Autor

**Emanuel Rodrigues**

---

*Projeto desenvolvido como parte do curso "Batismo de Java" 🥷*