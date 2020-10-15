# Loja de Peças do Seu José
## Gerenciador de estoque e vendas

**Autores**: *Gabriel Garcia* e *Paulo Sousa*

**Contato**: *gabriel_garcia@zup.com.br*, *paulo_sousa@zup.com.br*

**Ano**: *2020*.

## Função

- `Gerenciador de peças e vendas` tem como principal função o manejo organizacional do estoque e das vendas em uma loja de peças.

### Como funciona?

- A navegação é feita por meio de `Menus` com opções dadas numericamente. Após selecionar a opção, bastar digitar `Enter`;

- São dois `menus`:
	#### Gestão de peças:
	- Cadastrar;
	- Consultar;
	- Listar: 
		- Todo estoque;
		- Com filtro de letras;
		- Por modelo de carro;
		- Por categoria.
	- Remover;

	#### Gestão de vendas:
	- Registrar;
	- Extrair extrato;

## Estrutura

### MySQL

#### script.sql

- Contém a estrutura para criarmos, além do banco de dados da loja em si, cinco peças já solicitadas pelo cliente.

### JAVA

#### ConnectionFactory.java
- Conexão direta com o banco de dados por meio do JDBC;

#### Peca.java
- Objeto com atributos e métodos relacionados a uma peça;

#### PecaDAO.java
- Objeto de acesso aos dados do banco;

#### Categoria.java
- Enums usados para designar a categoria de uma peça;

#### Venda.java
- Objeto criado para centralizar operações de venda;

#### ProgramaPrincipal.java
- Classe responsável por concentrar métodos e atributos para inicializar o programa;

## Sprint #1
### O queridíssimo MVP
- A partir de um planejamento prévio, foram tomadas decisões organizacionais e técnicas que direcionaria o programa ao MVP; 

- Em relação a ordem das tarefas:
	- Planejar;
	- Modelar banco de dados;
	- Estruturar: ConnectionFactory, POJO e DAO;
	- Gestão de peças;
	- Gestão de vendas;
	- Revisão.

## O que esperamos para o Sprint #2
### Melhorias e mais melhorias (sempre)
- Blindar o programa:
	- Para o segundo `Sprint` traremos a capacidade do programa de trabalhar, não só com `Regex`, mas principalmente com o gerenciamento das `Exceptions`. Elas serão capazes de tratar qualquer tipo de problema que o programa poderá enfrentar durante o `RunTime`. 

- Caracteres:
	- Uma `String` permitirá caracteres especiais, espaços e qualquer letra, minúsculas ou maiúsculas, sem distinção entre elas.

- Repetições:
	- Acabar com certas repetições de códigos por meio de mais `Métodos`.

## Sugestão

- Fornecedores e pedidos:
	- Um novo `Menu`capaz de controlar o número de peças necessárias para o contato com o fornecedor e, além disso, se o valor em caixa é acordado com o preço dos pedidos.