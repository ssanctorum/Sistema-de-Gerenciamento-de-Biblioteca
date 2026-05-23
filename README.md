# Sistema de Gerenciamento de Biblioteca 

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Unifacisa](https://img.shields.io/badge/Unifacisa-2025-blue?style=for-the-badge)

Sistema de Gerenciamento de Biblioteca desenvolvido em **Java** utilizando os conceitos de **Programação Orientada a Objetos (POO)**.

Projeto acadêmico da 2ª fase do curso de **Análise e Desenvolvimento de Sistemas (ADS)** - Unifacisa.

---

## Sobre o Projeto

Este projeto consiste em uma aplicação de console para gerenciar o acervo de uma biblioteca. O sistema permite o cadastro, pesquisa, exclusão e listagem de **Livros** e **Revistas**, aplicando fortemente os pilares da Programação Orientada a Objetos.

---

## Funcionalidades

- **Cadastro** de Livros e Revistas (com validação de campos obrigatórios)
- **Pesquisa** por Título, Autor, Gênero ou ISSN
- **Exclusão** de materiais do acervo
- **Listagem** completa e formatada de todos os itens
- **Menu interativo** via terminal

---

## Tecnologias e Conceitos Aplicados

- **Java** (JDK 17+)
- **Programação Orientada a Objetos (POO)**:
  - Abstração
  - Herança
  - Polimorfismo
  - Encapsulamento
- **Enum** (`Genero`)
- **ArrayList** para gerenciamento de coleções
- **Console Application**

---

## Estrutura do Projeto

```bash
src/
├── Main.java              # Ponto de entrada e menu principal
├── Biblioteca.java        # Classe de controle do acervo e regras de negócio
├── Material.java          # Classe abstrata base
├── Livro.java             # Subclasse de Material (com Gênero)
├── Revista.java           # Subclasse de Material (com ISSN)
└── Genero.java            # Enum com categorias de livros
```
## Como Executar

1. Clone o repositório:
```
git clone https://github.com/ssanctorum/Sistema-de-Gerenciamento-de-Biblioteca.git
```

2. Entre na pasta do projeto e compile os arquivos:
```
javac src/*.java
```

3. Execute o programa:
```
java src.Main
```
