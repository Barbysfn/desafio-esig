# Gerenciador de Tarefas

📜 **Sobre o Desafio**  
Este projeto tem como objetivo o desenvolvimento de um gerenciador de tarefas. A aplicação permite que os usuários criem, editem e excluam tarefas, além de gerenciar seu status de forma simples e eficiente. A solução foi construída utilizando Java, JPA (Java Persistence API), Hibernate e PostgreSQL, com uma arquitetura baseada em MVC para um desenvolvimento organizado e escalável.

⚙️ **Pré-requisitos**  
Para rodar o projeto localmente, é necessário que as seguintes ferramentas estejam instaladas:

- **Java 17** ou superior: Para compilar e rodar o código.
- **Maven 3.x**: Para gerenciamento de dependências e build do projeto.
- **PostgreSQL**: Banco de dados utilizado para persistir as informações.
- **IDE** (IntelliJ IDEA, Eclipse, ou similar): Para facilitar o desenvolvimento e execução do projeto.

Além disso, é necessário configurar o banco de dados com as credenciais que podem ser encontradas no arquivo `persistence.xml`.

🛠️ **Tecnologias Usadas**  
- **Java 17**: Linguagem de programação utilizada no backend.
- **JPA (Java Persistence API)**: Para mapeamento objeto-relacional e comunicação com o banco de dados.
- **Hibernate**: Framework para implementar a JPA.
- **PostgreSQL**: Banco de dados relacional utilizado para armazenar as tarefas.
- **Maven**: Para gerenciamento de dependências e automação de build.
- **IntelliJ IDEA**: IDE utilizada para o desenvolvimento do projeto.

⚠️ **Erros de Execução**  
Atualmente, o projeto não está funcionando corretamente devido a alguns erros identificados na configuração de persistência e outras falhas relacionadas. Abaixo estão os possiveis erros que estão impedindo o funcionamento adequado:

1. 🚫 **Erro no Reconhecimento do persistence.xml**  
O arquivo `persistence.xml`, responsável pela configuração do provedor de persistência e da unidade de persistência, não está sendo reconhecido corretamente pelo projeto. Este erro ocorre principalmente porque a configuração do arquivo no módulo `gerenciador-tarefas-web` não está sendo carregada da maneira esperada. Embora o arquivo esteja presente em `src/main/resources/META-INF/persistence.xml`, o projeto não está conseguindo localizar a unidade de persistência, o que impede a inicialização correta do `EntityManager` e as operações de banco de dados.

2. 🛑 **Problema de Conexão com o Banco de Dados (PostgreSQL)**  
Embora a configuração de conexão no `persistence.xml` esteja especificando a URL, o usuário e a senha do banco de dados PostgreSQL, o sistema ainda apresenta dificuldades ao tentar estabelecer a conexão com o banco. Isso resulta em falhas nas operações de persistência de dados, como salvar ou recuperar tarefas. Esse erro é causado por problemas na interação entre o Hibernate e o banco de dados, que pode estar relacionado à configuração do provedor de persistência ou à forma como a aplicação tenta conectar-se ao banco de dados durante a execução.

3. ⛔ **Dependências do Maven Não Baixadas ou Não Resolvidas**  
As dependências essenciais para o funcionamento do JPA e Hibernate podem não ter sido baixadas corretamente pelo Maven. Isso pode ocorrer se o Maven não tiver sincronizado corretamente ou se houver algum erro no processo de download das dependências. Como resultado, as classes do JPA não estarão disponíveis para o projeto, causando erros nos imports, como o `import javax.persistence.*;`, que não são reconhecidos.

4. 🔧 **Falhas na Configuração do Maven ou IntelliJ IDEA**  
Mesmo que as dependências estejam corretamente declaradas no `pom.xml`, o Maven pode não ter sido configurado corretamente ou o IntelliJ IDEA pode não ter sincronizado adequadamente as configurações. Isso pode resultar em falhas no reconhecimento das dependências durante a execução do projeto, levando a problemas no carregamento das classes de persistência e na execução das operações de banco de dados.

---

🚀 **Contribuições** são bem-vindas! Se você encontrou algum erro ou gostaria de sugerir melhorias, fique à vontade para abrir uma *issue* ou enviar um *pull request*.
