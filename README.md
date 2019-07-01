# Cardatabase

[![Build Status](https://travis-ci.org/davyguedes/cardatabase.svg?branch=master)](https://travis-ci.org/davyguedes/cardatabase)

Projeto de exemplo usando Spring Data REST, construída no decorrer do livro de Juha Hinkula, [Hands-On Full Stack Development with Spring Booot 2.0 and React](https://www.amazon.com/Hands-Stack-Development-Spring-React/dp/1789138086/), com algumas alterações.

## Tecnologias utilizadas

- [Java 11](https://openjdk.java.net/)
- [Maven](https://maven.apache.org)
- [Spring Boot](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/)
- [Spring Data REST](https://docs.spring.io/spring-data/rest/docs/current/reference/html/)
- [Spring Security](https://docs.spring.io/spring-security/site/docs/current/reference/htmlsingle/)
- [Swagger](https://swagger.io/docs/)
- [Docker](https://docs.docker.com)
- [Travis CI](https://docs.travis-ci.com)

## Utilização e build

Após a inicialização da aplicação, independente da forma, a mesma pode ser acessada ou ter a sua documentação acessada pelo link `http://localhost:PORTA_INICIADA/swagger-ui.html`, exemplo: `http://localhost:9999/swagger-ui.html`.

### Build usando artefatos locais (GIT)

**OBS:** Os arquivos e ferramentas de build, estão contidas dentro do projeto, então para execução do build, só é necessário ter o [Java](https://www.oracle.com/br/java/index.html) ou o Docker instalado. 

### Build local com Maven

```shell
# Execução do build
./mvnw build
# Execução da aplicação
java -jar  target/cardatabase-0.0.1-SNAPSHOT.jar
```

**OBS:** Com esses comandos a aplicação será iniciada, na porta 8080, mas isso pode ser alterado, informando o parâmetro: `-Dserver.port=$PORTA_DESEJADA`.

### Build local com Docker

```shell
# Execução do build
docker build -t marcosdavy/cardatabase:latest .
# Execução da aplicação
docker run -d -p 8080:8080 marcosdavy/cardatabase:latest
```

**OBS:** Com esses comandos a aplicação será iniciada, na porta 8080,  mas isso pode ser alterado, informando o parâmetro docker: `-p $PORTA_DESEJADA:9999`.

### Utilização com Docker (imagem remota do DockerHub)

```shell
# Execução da aplicação
docker run -d -p 8080:8080 marcosdavy/cardatabase:latest
```

**OBS:** Com esse comando a aplicação será iniciada, na porta 8080, mas isso pode ser alterado, informando o parâmetro docker: `-p $PORTA_DESEJADA:9999`.

## Arquivo e artefatos do projeto

| Arquivo ou diretório  |  Descrição |
| ------------ | ------------ |
| .mvn/*, mvnw, mvnw.cmd | Arquivos e diretórios de instalação do Maven, com eles no projeto, não é necessário instalar o Maven separadamente |
|  pom.xml | Arquivo com as configurações de dependências e de build do Maven |
| Dockerfile | Arquivo com as configurações para criação da imagem Docker, nesse Dockerfile é utilizado a estratégia multi-stage builds |
| .travis.yml  | Arquivo com as configurações de build contínuo, no caso desse projeto possui as configurações de build, testes e push da imagem Docker para o DockerHub |
| src/main/**/domain/{CarRepository, OwnerRepository, UserRepository}.java | Interfaces com as funcionalidades referentes aos endpoints da aplicação |
| src/main/**/domain/{Car, Owner, User}.java | Interfaces com as funcionalidades referentes aos endpoints da aplicação |
| src/main/resources | Diretório com as configurações da aplicação |
| src/main/resources/application.properties | Arquivo de configuração do Spring Boot |

## To Do

- [x] Configurar projeto
- [X] Entidade Car
- [X] Entidade Owner
- [ ] Implement JSON Web Token (JWT)
- [ ] Create units tests

## Créditos

- { README.md, Dockerfile } inspirado em [@justiandre/justiandre-exemplo-kotlin-paineltarefas](https://github.com/justiandre/justiandre-exemplo-kotlin-paineltarefas)
