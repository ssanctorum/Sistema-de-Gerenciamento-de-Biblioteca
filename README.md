# Sistema de Gerenciamento de Biblioteca 📚

Este projeto consiste em uma aplicação de console desenvolvida para a 2ª fase do projeto de **Análise e Desenvolvimento de Sistemas (ADS)** na **Unifacisa**. O objetivo é gerenciar o acervo de uma biblioteca, aplicando os conceitos fundamentais de Programação Orientada a Objetos (POO) em Java.

## 🎯 Objetivo do Projeto

Implementar um sistema capaz de gerenciar dois tipos de materiais: **Livros** e **Revistas**. O sistema permite a manutenção do acervo através de operações de inclusão, pesquisa, exclusão e listagem de materiais.

## 🛠️ Conceitos de POO Aplicados

O projeto foi estruturado para demonstrar o domínio técnico nos seguintes pilares:

- **Abstração e Herança:** Uso de uma classe base abstrata `Material` para representar atributos comuns (`titulo`, `autor`), herdada pelas subclasses específicas `Livro` e `Revista`.
- **Polimorfismo:** A classe `Biblioteca` utiliza uma `ArrayList<Material>` para gerenciar os itens de forma genérica, permitindo que métodos de listagem e busca operem sobre diferentes tipos de objetos de forma unificada.
- **Encapsulamento:** Todos os atributos das classes utilizam modificadores de acesso privados com métodos Getters e Setters para manipulação segura dos dados.
- **Enumerações:** Implementação do `Enum Genero` para padronizar as categorias dos livros.

## 📋 Funcionalidades

- **Cadastro:** Validação de campos obrigatórios (Título e Autor) antes de efetivar o registro.
- **Pesquisa:** Localização de materiais por múltiplos critérios (Título, Autor, Gênero ou ISSN).
- **Exclusão:** Remoção de materiais do acervo com confirmação visual para o usuário.
- **Listagem:** Exibição formatada de todos os itens cadastrados no sistema.

## 🏗️ Estrutura de Arquivos

- `Material.java`: Classe base abstrata.
- `Livro.java`: Subclasse com atributo específico `Genero`.
- `Revista.java`: Subclasse com atributo específico `numeroISSN`.
- `Genero.java`: Enum com as categorias de livros.
- `Biblioteca.java`: Classe de controle do acervo e lógica de negócio.
- `Main.java`: Ponto de entrada com menu interativo via terminal.

## 🚀 Como Executar

1. Compile os arquivos:
   ```bash
   javac *.java
