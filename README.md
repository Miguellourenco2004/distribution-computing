# Projeto Marcação Consultas Clínicas

## Descrição do Projeto
Este projeto tem como objetivo desenvolver um sistema distribuído para a marcação de consultas clínicas em várias especialidades, distribuídas por diferentes clínicas. [cite_start]O sistema foi concebido para facilitar o agendamento de diferentes especialidades médicas, abrangendo desde a interação com os utilizadores até ao armazenamento e processamento seguro dos dados[cite: 242, 247, 248].

### Clínicas Suportadas
[cite_start]O sistema foi desenhado para suportar as operações de quatro clínicas, cada uma com as suas especialidades médicas[cite: 249]:
* [cite_start]**Clínica A**: Clínica geral (10 médicos), pediatria (5 médicos), cardiologia (1 médico) e ginecologia (2 médicos)[cite: 249].
* [cite_start]**Clínica B**: Clínica geral (5 médicos), ginecologia (1 médico) e hematologia (1 médico)[cite: 250].
* [cite_start]**Clínica C**: Medicina tropical (1 médico) e neurologia (1 médico)[cite: 251].
* [cite_start]**Clínica D**: Oftalmologia (2 médicos), oncologia (3 médicos) e otorrinolaringologia (1 médico)[cite: 252].

### Funcionalidades Principais
[cite_start]As principais funcionalidades do sistema incluem[cite: 246, 253]:
* [cite_start]Reservar consultas [cite: 246, 253]
* [cite_start]Cancelar consultas [cite: 246, 253]
* [cite_start]Listar consultas reservadas [cite: 246, 253]
* [cite_start]Registar novos utilizadores [cite: 246, 253]

[cite_start]As consultas podem ser agendadas em intervalos de 1 hora, no horário compreendido entre as 08:00 e as 20:00[cite: 254].

## Arquitetura da Solução
[cite_start]O sistema possui uma arquitetura composta por um servidor **Frontend** e um servidor **Backend**, com comunicação entre ambos através de RMI (Remote Method Invocation)[cite: 243, 264].

### Frontend
* [cite_start]Ponto de interação dos utilizadores com o sistema[cite: 255].
* [cite_start]Disponibiliza dois tipos de clientes: Web Services REST e Web Services SOAP[cite: 244, 255].
* [cite_start]Ambos são suportados por um servidor Apache Tomcat, responsável também pelo registo e autenticação dos utilizadores[cite: 244, 256].
* [cite_start]Os dados de utilizador são armazenados numa base de dados SQL Server[cite: 257].
* [cite_start]Desenvolvido para ser compatível com sistemas operativos macOS e Windows[cite: 258, 271].
* [cite_start]A interface gráfica foi implementada utilizando bibliotecas Java e componentes JPanel[cite: 259, 324, 325].

### Backend
* [cite_start]Responsável por gerir e armazenar todas as informações relacionadas com as consultas, clínicas e médicos[cite: 260].
* [cite_start]Os dados são armazenados em bases de dados MySQL e SQL Server para compatibilidade (SQL Server para Linux x86_64 e MySQL para Linux ARM64)[cite: 261, 293, 294].
* [cite_start]Centraliza as fichas dos utilizadores associados às clínicas e detalhes das marcações e especialidades[cite: 263].
* [cite_start]Projetado para operar num ambiente Linux[cite: 265].

## Manual de Instalação e Configuração

### Requisitos de Instalação
* **Frontend**:
    * [cite_start]Eclipse 2022 (IDE) [cite: 272]
    * [cite_start]Apache Tomcat 9 (Servidor) [cite: 273]
    * [cite_start]Apache CXF 3.6.5 (para Web Services SOAP) [cite: 274]
    * [cite_start]Java (para comunicação RMI com o Backend) [cite: 291]
* **Backend**:
    * [cite_start]Java (para comunicação RMI com o Frontend) [cite: 296]
    * [cite_start]SQL Server (para Linux x86_64) ou MySQL (para Linux ARM64) [cite: 293, 294, 300]
    * [cite_start]IntelliJ IDEA (IDE, opcional, mas recomendado para facilitar as conexões) [cite: 313]

### Configuração do Frontend

#### Adicionar Apache Tomcat 9 no Eclipse
1.  [cite_start]Aceder ao Painel de Preferências do Eclipse[cite: 275].
2.  [cite_start]Pesquisar por "Server"[cite: 275].
3.  [cite_start]No submenu "Runtime Environments", clicar em "Add"[cite: 276].
4.  [cite_start]Selecionar "Apache Tomcat v9.0"[cite: 276].

#### Configurar Apache CXF no Eclipse
1.  [cite_start]Aceder ao Painel de Preferências do Eclipse[cite: 277].
2.  [cite_start]Pesquisar por "Web Services"[cite: 277].
3.  [cite_start]Selecionar a opção "CXF 2.x Preferences"[cite: 277].
4.  [cite_start]No campo "CXF Runtime", clicar em "Browse" e adicionar o caminho de instalação do Apache CXF[cite: 277].

#### Configurar o Servidor e o Runtime no Eclipse
1.  [cite_start]Aceder ao Painel de Preferências do Eclipse[cite: 278].
2.  [cite_start]Pesquisar por "Web Services"[cite: 278].
3.  [cite_start]Selecionar a opção "Server and Runtime"[cite: 279].
4.  [cite_start]Adicionar "Tomcat v9.0 Server" no campo "Server" e "Apache CXF 2.x Runtime" no campo "Runtime"[cite: 279, 280].

#### Importar Projetos
Após a configuração inicial do Eclipse, importe os projetos para os serviços SOAP e REST. [cite_start]Estes projetos estão em ficheiros separados[cite: 282, 283].

#### Configuração da Base de Dados (AuthServer)
1.  [cite_start]Criar uma base de dados chamada `AuthServer` em SQL Server (pode-se usar uma imagem Docker)[cite: 286, 287].
2.  [cite_start]A base de dados deve conter as colunas `id_usuario`, `email` e `senha_hash`[cite: 287].
3.  [cite_start]No ficheiro `AuthServerConn` (nos projetos REST e SOAP), alterar os campos correspondentes para permitir a comunicação com a base de dados[cite: 288, 289].

#### Comunicação RMI com o Backend
1.  [cite_start]Instalar Java no computador[cite: 291].
2.  [cite_start]No ficheiro `DatabaseService`, alterar o IP para o da máquina virtual Linux correspondente ao Backend[cite: 292].

### Configuração do Backend

#### Instalação do Java
1.  [cite_start]Verificar se o Java está instalado no Ubuntu (executar comando apropriado no terminal)[cite: 297].
2.  [cite_start]Caso contrário, proceder com a instalação[cite: 298].
3.  [cite_start]Pode ser necessário alterar o IP do Ubuntu no host para refletir o IP da máquina, seguido do nome de utilizador, para garantir a comunicação RMI[cite: 299].

#### Instalação e Configuração da Base de Dados
Instalar SQL Server ou MySQL. [cite_start]Recomenda-se o uso de Azure para SQL Server e DBeaver para MySQL para visualização[cite: 301].

[cite_start]**Código para criação das tabelas (SQL Server):** [cite: 302, 303, 304, 305, 306]
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
