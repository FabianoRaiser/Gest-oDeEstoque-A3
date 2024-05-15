# GestaoDeEstoque-A3

> Status do Projeto: em Andamento

### Tópicos

▶️ [Descrição do Projeto](#descrição-do-projeto)

▶️ [Descrição do Cenário](#descrição-do-cenário)

▶️ [Como Executar](#como-executar)

▶️ [Equipe de Desenvolvimento](#equipe-de-desenvolvimento)

▶️ [Licença](#licença)

## Descrição do Projeto

Trabalho A3 desenvolvido durante a UC de Programação de Soluções Computacionais de 2024/01. O Objetivo é a criação de um Sistema de Gestão de Estoque de uma Oficina Mecânica, com o gerenciamento de quantidade de peças em estoque, pedidos de reposição, cadastro de clientes e de ordens de serviço.

O Sistema será desenvolvido em Java, utilizando o banco de dados MySQL para armazenamento de dados.

## Como Executar

### Pré-requisitos

Antes de executar o sistema, certifique-se de ter o seguintes recursos instalados:

- **Java Development Kit (JDK)**: Versão 17 ou superior.
- **Gerencidor de DB MySQL**: XAAMP ou Similar, para execução do DB localmente.

### 1. Clone esse repositório

`git clone "https://github.com/FabianoRaiser/GestaoDeEstoque-A3.git"`

### [...]

## Equipe de Desenvolvimento

<!-- prettier-ignore -->
|Nome  | Atuação |
|-|-|
|Fabiano Raiser | Documentação, Front-end|
|Isabella Corrêa | Banco de Dados |
|Guilherme Borges | |
| César Matias | |

## Descrição do cenário

**Problema:** Sistema Integrado de Controle de Estoque e Ordem de Serviço Automotiva

> _Você é responsável por desenvolver um sistema integrado de controle de estoque de peças automotivas e ordens de serviço para uma oficina mecânica. O sistema deve permitir o cadastro de peças, consulta de estoque, solicitação de baixa de estoque, criação de pedidos de compras, cadastro de clientes, abertura de ordens de serviço e controle do faturamento._

### Requisitos

<!-- prettier-ignore -->
| Requisitos Funcionais             | Descrição|
| --------------------------------- | --------------- |
| Cadastro de peças no estoque      | O sistema deve permitir o cadastro de novas peças, incluindo as informações de código da peça, nome da peça, descrição, etc. |
| Consulta de Estoque               | Deve ser possível visualizar o estoque atual de todas as peças cadastradas, incluindo a quantidade disponível de cada uma.                                                                                                                                                                                                                                                                                                                                          |
| Solicitação de Baixa de Estoque   | Os usuários devem poder solicitar a baixa de estoque de uma determinada peça, informando a quantidade a ser removida do estoque (isto não caracteriza que a peça foi vendida, por exemplo: peças com defeito).                                                                                                                                                                                                                                                      |
| Criação de Pedido de Compras      | Deve ser possível criar um pedido de compras para nosso estoque, selecionando as peças desejadas e suas respectivas quantidades. Ao efetuar um pedido de compras, o sistema deve atualizar o estoque SOMENTE quando o pedido de compra for setado para CONCLUÍDO, aumentando assim a quantidade das peças incluídas no pedido. Logo, você precisará ter uma opção para listar todos os pedidos de compras que foram concluídos e os que não foram concluídos ainda. |
| Cadastro de Clientes              | Deve ser possível cadastrar novos clientes da oficina, incluindo informações como nome, endereço, telefone, etc.                                                                                                                                                                                                                                                                                                                                                    |
| Abertura de Ordem de Serviço (OS) | Os usuários devem poder abrir uma OS, associando-a a um cliente e incluindo uma descrição do serviço a ser realizado.                                                                                                                                                                                                                                                                                                                                               |
| Controle do Faturamento           | O sistema deve permitir o registro do faturamento de cada ordem de serviço que for CONCLUÍDA, incluindo o valor do serviço realizado e o valor das peças utilizadas. Após o registro do faturamento, o sistema deve atualizar o estoque das peças utilizadas na ordem de serviço (somente se a OS for concluída).                                                                                                                                                   |

<!-- prettier-ignore -->
| Resquisitos Não Funcionais |
| -------------------------- |
| O sistema deve ser desenvolvido em Java, utilizando o banco de dados MySQL para armazenamento dos dados.      |
| Deve ser implementada uma interface gráfica intuitiva para facilitar a interação dos usuários com o sistema.  |
| Todas as operações de CRUD (Create, Read, Update, Delete) devem ser implementadas de forma segura e eficiente |

## Contribuição

Sinta-se à vontade para contribuir com melhorias, correções de bugs ou novas funcionalidades. Abra uma **issue** ou envie um **pull request**!

## Licença

Este projeto está licenciado sob a [...].
