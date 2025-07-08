# Projeto Marcação Consultas Clínicas

## Descrição do Projeto

Este projeto tem como objetivo desenvolver um sistema distribuído para a marcação de consultas clínicas em várias especialidades, distribuídas por diferentes clínicas. O sistema foi concebido para facilitar o agendamento de diferentes especialidades médicas, abrangendo desde a interação com os utilizadores até ao armazenamento e processamento seguro dos dados.

### Clínicas Suportadas

O sistema foi desenhado para suportar as operações de quatro clínicas, cada uma com as suas especialidades médicas:

  * **Clínica A**: Clínica geral (10 médicos), pediatria (5 médicos), cardiologia (1 médico) e ginecologia (2 médicos).
  * **Clínica B**: Clínica geral (5 médicos), ginecologia (1 médico) e hematologia (1 médico).
  * **Clínica C**: Medicina tropical (1 médico) e neurologia (1 médico).
  * **Clínica D**: Oftalmologia (2 médicos), oncologia (3 médicos) e otorrinolaringologia (1 médico).

### Funcionalidades Principais

As principais funcionalidades do sistema incluem:

  * Reservar consultas
  * Cancelar consultas
  * Listar consultas reservadas
  * Registar novos utilizadores

As consultas podem ser agendadas em intervalos de 1 hora, no horário compreendido entre as 08:00 e as 20:00.

## Arquitetura da Solução

O sistema possui uma arquitetura composta por um servidor **Frontend** e um servidor **Backend**, com comunicação entre ambos através de RMI (Remote Method Invocation).

### Frontend

  * Ponto de interação dos utilizadores com o sistema.
  * Disponibiliza dois tipos de clientes: Web Services REST e Web Services SOAP.
  * Ambos são suportados por um servidor Apache Tomcat, responsável também pelo registo e autenticação dos utilizadores.
  * Os dados de utilizador são armazenados numa base de dados SQL Server.
  * Desenvolvido para ser compatível com sistemas operativos macOS e Windows.
  * A interface gráfica foi implementada utilizando bibliotecas Java e componentes JPanel.

### Backend

  * Responsável por gerir e armazenar todas as informações relacionadas com as consultas, clínicas e médicos.
  * Os dados são armazenados em bases de dados MySQL e SQL Server para compatibilidade (SQL Server para Linux x86\_64 e MySQL para Linux ARM64).
  * Centraliza as fichas dos utilizadores associados às clínicas e detalhes das marcações e especialidades.
  * Projetado para operar num ambiente Linux.

## Manual de Instalação e Configuração

### Requisitos de Instalação

  * **Frontend**:
      * Eclipse 2022 (IDE)
      * Apache Tomcat 9 (Servidor)
      * Apache CXF 3.6.5 (para Web Services SOAP)
      * Java (para comunicação RMI com o Backend)
  * **Backend**:
      * Java (para comunicação RMI com o Frontend)
      * SQL Server (para Linux x86\_64) ou MySQL (para Linux ARM64)
      * IntelliJ IDEA (IDE, opcional, mas recomendado para facilitar as conexões)

### Configuração do Frontend

#### Adicionar Apache Tomcat 9 no Eclipse

1.  Aceder ao Painel de Preferências do Eclipse.
2.  Pesquisar por "Server".
3.  No submenu "Runtime Environments", clicar em "Add".
4.  Selecionar "Apache Tomcat v9.0".

#### Configurar Apache CXF no Eclipse

1.  Aceder ao Painel de Preferências do Eclipse.
2.  Pesquisar por "Web Services".
3.  Selecionar a opção "CXF 2.x Preferences".
4.  No campo "CXF Runtime", clicar em "Browse" e adicionar o caminho de instalação do Apache CXF.

#### Configurar o Servidor e o Runtime no Eclipse

1.  Aceder ao Painel de Preferências do Eclipse.
2.  Pesquisar por "Web Services".
3.  Selecionar a opção "Server and Runtime".
4.  Adicionar "Tomcat v9.0 Server" no campo "Server" e "Apache CXF 2.x Runtime" no campo "Runtime".

#### Importar Projetos

Após a configuração inicial do Eclipse, importe os projetos para os serviços SOAP e REST. Estes projetos estão em ficheiros separados.

#### Configuração da Base de Dados (AuthServer)

1.  Criar uma base de dados chamada `AuthServer` em SQL Server (pode-se usar uma imagem Docker).
2.  A base de dados deve conter as colunas `id_usuario`, `email` e `senha_hash`.
3.  No ficheiro `AuthServerConn` (nos projetos REST e SOAP), alterar os campos correspondentes para permitir a comunicação com a base de dados.

#### Comunicação RMI com o Backend

1.  Instalar Java no computador.
2.  No ficheiro `DatabaseService`, alterar o IP para o da máquina virtual Linux correspondente ao Backend.

### Configuração do Backend

#### Instalação do Java

1.  Verificar se o Java está instalado no Ubuntu (executar comando apropriado no terminal).
2.  Caso contrário, proceder com a instalação.
3.  Pode ser necessário alterar o IP do Ubuntu no host para refletir o IP da máquina, seguido do nome de utilizador, para garantir a comunicação RMI.

#### Instalação e Configuração da Base de Dados

Instalar SQL Server ou MySQL. Recomenda-se o uso de Azure para SQL Server e DBeaver para MySQL para visualização.

**Código para criação das tabelas (SQL Server):**

```sql
CREATE DATABASE [SaudeDB]
CREATE TABLE Clinicas (
 ClinicaID int IDENTITY(1,1) PRIMARY KEY ,
 Nome varchar(255) NOT NULL ,
 Morada varchar(255),);
CREATE TABLE Especialidades (
 EspecialidadeID int IDENTITY(1,1) PRIMARY KEY,
 Nome varchar(255) NOT NULL);
CREATE TABLE Medicos (
 MedicoID int IDENTITY(1,1) PRIMARY KEY,
 PrimeiroNome varchar(255) NOT NULL,
 UltimoNome varchar(255) NOT NULL,
 EspecialidadeFK int FOREIGN KEY REFERENCES Especialidades(EspecialidadeID));
CREATE TABLE Pacientes (
 PacienteID int IDENTITY(1,1) PRIMARY KEY,
 PrimeiroNome varchar(255) NOT NULL,
 UltimoNome varchar(255) NOT NULL,);
CREATE TABLE Consultas (
 ConsultaID int IDENTITY(1,1) PRIMARY KEY,
 PacienteFK int FOREIGN KEY REFERENCES Pacientes(PacienteID),
 MedicoFK int FOREIGN KEY REFERENCES Medicos(MedicoID),
 DataConsulta DATETIME NOT NULL,
 Sintomas varchar(255),
 ClinicaFK int FOREIGN KEY REFERENCES Clinicas(ClinicaID),);
```

**Código para criação das tabelas (MySQL):**

```sql
CREATE DATABASE [SaudeDB]
CREATE TABLE Clinicas (
 ClinicaID int IDENTITY(1,1) PRIMARY KEY ,
 Nome varchar(255) NOT NULL ,
 Morada varchar(255),);
CREATE TABLE Especialidades (
 EspecialidadeID int IDENTITY(1,1) PRIMARY KEY,
 Nome varchar(255) NOT NULL);
CREATE TABLE Medicos (
 MedicoID int IDENTITY(1,1) PRIMARY KEY,
 PrimeiroNome varchar(255) NOT NULL,
 UltimoNome varchar(255) NOT NULL,
 EspecialidadeFK int FOREIGN KEY REFERENCES Especialidades(EspecialidadeID)
);
CREATE TABLE Pacientes (
 PacienteID int IDENTITY(1,1) PRIMARY KEY,
 PrimeiroNome varchar(255) NOT Nacional,
 UltimoNome varchar(255) NOT NULL,);
CREATE TABLE Consultas (
 ConsultaID int IDENTITY(1,1) PRIMARY KEY,
 PacienteFK int FOREIGN KEY REFERENCES Pacientes(PacienteID),
 MedicoFK int FOREIGN KEY REFERENCES Medicos(MedicoID),
 DataConsulta DATETIME NOT NULL,
 Sintomas varchar(255),
 ClinicaFK int FOREIGN KEY REFERENCES Clinicas(ClinicaID),);
```

#### Configuração do IntelliJ IDEA (Exemplo)

  * No IntelliJ, haverá dois ficheiros: `DatabaseService` (comum ao frontend e backend, demonstra funções RMI) e `DatabaseServer` (responsável pela conexão com a base de dados e criação do serviço RMI).
  * Em `DatabaseServer`, alterar os campos de URL, usuário e senha de acordo com os valores da base de dados.
  * Colocar o driver MySQL no diretório do projeto para acesso à base de dados.

## Inicialização dos Web Services

### SOAP

1.  Criar um Web Service na classe `MathUtility` dentro da pasta `Projeto de Computação`.
2.  Abrir a página correspondente no navegador (após o passo anterior).
3.  No ficheiro `MathConsumer` na pasta `ProjetoComputaçãoClient`, criar um WebServiceClient.
4.  Executar o `MathConsumer` como uma Java Application.

### REST

1.  Executar a pasta `novoRest` como um servidor.
2.  Executar o ficheiro `MathConsumer` da pasta `cliente` como uma Java Application.

## Guia de Utilização

### Registo de Novo Usuário

O sistema permite o registo de novos utilizadores.

### Login Usuário

Os utilizadores registados podem efetuar login no sistema.

### Marcar Consulta

Os utilizadores podem marcar consultas.

### Listar Consultas

É possível listar as consultas agendadas.

### Cancelar Consultas

Os utilizadores podem cancelar consultas.

## Conclusão

O desenvolvimento deste projeto aprofundou o conhecimento sobre RMI e Web Services, que foram fundamentais. Houve também contato com novas tecnologias como JPanel. Os resultados esperados foram alcançados, com a criação do cliente SOAP e REST, ambos com conexão RMI.

## Autores

  * Miguel Lourenço 
  * Vasco Pereira 

## Ano

2024/2025

## Universidade

Universidade Lusófona
