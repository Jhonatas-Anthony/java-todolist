# To-do list
Esse projeto está sendo feito com base nas vídeo aulas gratuitas disponibilizadas pela Rocketseat, sera uma semana ensinando desenvolvimento backend com Java. 

## Informações
Projeto desenvolvido na linguagem Java com o framework spring.

Estarei usando uma database chamada H2 database, que é similar ao SQLite, guardando os dados na memória. Sempre que o servidor reiniciar, os dados serão apagados.
___
## Como executar?
Para rodar esse repositório localmente você precisará usar a versão 17 do java na sua máquina, e **opcionalmente**, você pode usar também as extensões do VSCode: 
- **vscjava.vscode-java-pack**
    - vscjava.vscode-java-debug
    - vscjava.vscode-java-test
    - vscjava.vscode-java-dependency
    - vscjava.vscode-maven
    - redhat.java
- **vscjava.vscode-spring-initializr**
- **vmware.vscode-spring-boot**
- **vscjava.vscode-spring-boot-dashboard**

Com essas extenções, indo no arquivo <u>**src/main/java/br/com/jhonatas/todolist/TodolistApplication.java**</u> irá aparecer uma opção de run/debug em cima da função principal. Podendo clicar em **run** para rodar localmente.

Invés disso, você pode optar por rodar manualmente.
via cli sem build
```bash
nvm spring-boot:run # com o maven instaldo
```
Com build
```bash
mvn clean install # faz a build da aplicação // gera um executável
java -jar /target/todolist-1.0.0.jar #executa o build do projeto
```
___
## Rotas Disponíveis

### URL Padrão:
**Online:** [https://todolist-java-9wud.onrender.com](https://todolist-java-9wud.onrender.com)  
**Local:** `http://localhost:8080`

### Usuário:
- **POST:** `/user/`

### Tasks: 
   :wink: Precisa usar configurar o basic auth com username e password do usuário espesífico
- **POST:** `/tasks/`
- **GET:** `/tasks/`        ###Pega as tarefas de cada usuário 
- **PUT:** `/tasks/{id}`
___
## Como criar uma nova funcionalidade? 

Para criar uma nova funcionalidade é até que simples: 
1. Primeiro, crie um novo arquivo dentro do controler - <u>**src/main/java/br/com/jhonatas/todolist/controller**</u>
2. Dentro desse arquivo crie uma pasta #name#Model.java, aqui será definido os atributos dessa entidade no banco.
3. Crie um arquivo #name#Controller.java, aqui serão definido os métodos de criação, edição e exclusão. 
4. Crie um arquivo I#name#Repository.java, ao exportar no arquivo #name#Controller.java com a notação @Autowired, é exportado uma série de dependências e ajuda a tornar o código mais limpo. Aqui dentro podem ser definidas funções mais específicas. 

Seguindo esse roteiro, será capaz de criar mais alguma funcionalidade dentro desse projeto. 
