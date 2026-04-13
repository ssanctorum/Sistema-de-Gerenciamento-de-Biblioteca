import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {

    private ArrayList<Material> materialLista = new ArrayList<>();

    public void addNovoMaterial(Scanner scanner) {
        System.out.println("\n——— ADICIONAR NOVO MATERIAL ———");

        System.out.println("[1] — LIVRO");
        System.out.println("[2] — REVISTA");
        System.out.print("Digite o tipo do material: ");

        String tipoMaterial = scanner.nextLine().trim();

        if (tipoMaterial.equals("1")) {
            System.out.println("\nMaterial: LIVRO");
            System.out.print("Digite o título do livro: ");
            String tituloLivro = scanner.nextLine().trim();

            if (tituloLivro.isEmpty()) {
                System.out.println("\nAVISO:");
                System.out.println("O livro DEVE conter um título, tente novamente.");
                return;
            }

            for (int i = 0; i < materialLista.size(); i++) {
                if (tituloLivro.equalsIgnoreCase(materialLista.get(i).getTitulo())) {
                    System.out.println("\nAVISO:");
                    System.out.println("Material com esse nome já existente, tente novamente.");
                    return;
                }
            }

            System.out.print("Digite o autor do livro: ");
            String autorLivro = scanner.nextLine().trim();

            if (autorLivro.isEmpty()) {
                System.out.println("\nAVISO:");
                System.out.println("O livro DEVE conter um autor, tente novamente.");
                return;
            }

            System.out.print("\nTemos os seguintes gêneros:\n");
            for (int i = 0; i < Genero.values().length; i++) {
                System.out.printf("[%s] — %s\n", i + 1, Genero.values()[i].getNome().toUpperCase());
            }

            int generoSelecionado = 0;

            try {
                System.out.print("\nDigite o ID do lado do gênero correspondente: ");
                generoSelecionado = scanner.nextInt();
                scanner.nextLine();

                if (generoSelecionado < 1 || generoSelecionado > Genero.values().length) {
                    System.out.println("\nAVISO:");
                    System.out.println("Selecione um dos IDs de gênero listados.");
                    return;
                }

            } catch (Exception e) {
                System.out.println("\nAVISO:");
                System.out.println("Digite o ID do gênero corretamente.");
                scanner.nextLine();
                return;
            }

            Genero generoLivro = Genero.values()[generoSelecionado - 1];

            Livro livro = new Livro(tituloLivro, autorLivro, generoLivro);
            materialLista.add(livro);

            System.out.print("\nLivro adicionado com sucesso!\n");

            System.out.printf(livro.toString());

        } else if (tipoMaterial.equals("2")) {
            System.out.println("\nMaterial: REVISTA");
            System.out.print("Digite o título da revista: ");
            String tituloRevista = scanner.nextLine().trim();

            if (tituloRevista.isEmpty()) {
                System.out.println("\nAVISO:");
                System.out.println("A revista DEVE conter um título, tente novamente.");
                return;
            }

            for (int i = 0; i < materialLista.size(); i++) {
                if (tituloRevista.equalsIgnoreCase(materialLista.get(i).getTitulo())) {
                    System.out.println("\nAVISO:");
                    System.out.println("Material com esse nome já existente, tente novamente.");
                    return;
                }
            }

            System.out.print("Digite o autor da revista: ");
            String autorRevista = scanner.nextLine().trim();

            if (autorRevista.isEmpty()) {
                System.out.println("\nAVISO:");
                System.out.println("A revista DEVE conter um autor, tente novamente.");
                return;
            }

            System.out.print("Digite o Código (ISSN) da revista (caso possua): ");
            String codISSNRevista = scanner.nextLine().trim().strip();

            for (int i = 0; i < materialLista.size(); i++) {
                Material material = materialLista.get(i);

                if (material instanceof Revista) {
                    Revista revistaM = (Revista) material;

                    if (codISSNRevista.equalsIgnoreCase(revistaM.getNumeroISSN())) {
                        System.out.println("\nAVISO:");
                        System.out.println("Revista com esse código já existente, tente novamente.");
                        return;
                    }
                }
            }

            if (codISSNRevista.isBlank()) {
                codISSNRevista = "Não possui ou não definido.";
            }

            Revista revista = new Revista(tituloRevista, autorRevista, codISSNRevista);
            materialLista.add(revista);

            System.out.print("\nRevista adicionada com sucesso!\n");

            System.out.printf(revista.toString());


        } else {
            System.out.println("\nAVISO:");
            System.out.println("Tipo de material inválido! Tente novamente.");
        }
    }

    public void pesquisarMaterial(Scanner scanner) {
        System.out.println("\n——— PESQUISAR MATERIAL ———");

        if (materialLista.isEmpty()) {
            System.out.println("\nAVISO:");
            System.out.println("Não há nenhum material para pesquisar. Tente adicionar um material.");
            return;
        }

        System.out.println("[1] — TÍTULO (Livros e Revistas)");
        System.out.println("[2] — AUTOR (Livros e Revistas)");
        System.out.println("[3] — GÊNERO (Livros)");
        System.out.println("[4] — CÓD. ISSN (Revistas) ");
        System.out.print("Selecione o tipo de pesquisa: ");

        String tipoDePesquisa = scanner.nextLine().trim();

        if (tipoDePesquisa.equals("1")) {
            System.out.println("\nPesquisa por: TÍTULO");
            System.out.print("Insira o título do material: ");
            String tituloPesquisa = scanner.nextLine().trim();

            for (Material materialTitulo : materialLista) {
                if (tituloPesquisa.equalsIgnoreCase(materialTitulo.getTitulo())) {
                    System.out.println(materialTitulo);
                    return;
                }
            }

            System.out.println("\nAVISO:");
            System.out.println("Material não encontrado por título, tente novamente.");

        } else if (tipoDePesquisa.equals("2")) {
            System.out.println("\nPesquisa por: AUTOR");
            System.out.print("Insira o autor do material: ");
            String autorPesquisa = scanner.nextLine().trim();

            for (Material materialAutor : materialLista) {
                if (autorPesquisa.equalsIgnoreCase(materialAutor.getAutor())) {
                    System.out.println(materialAutor);
                } else {
                    System.out.println("\nAVISO:");
                    System.out.println("Material não encontrado por autor, tente novamente.");
                    return;
                }
            }

        } else if (tipoDePesquisa.equals("3")) {
            System.out.println("\nPesquisa por: GÊNERO");
            System.out.print("Insira o gênero do material: ");
            String generoPesquisa = scanner.nextLine().trim();

            for (Material materialGenero : materialLista) {
                if (materialGenero instanceof Livro) {
                    Livro livro = (Livro) materialGenero;

                    if (generoPesquisa.equalsIgnoreCase(livro.getGenero().getNome())) {
                        System.out.println(livro.toString());
                    } else {
                        System.out.println("\nAVISO:");
                        System.out.println("Material não encontrado por gênero, tente novamente.");
                        return;
                    }
                }
            }


        } else if (tipoDePesquisa.equals("4")) {
            System.out.println("\nPesquisa por: CÓD. ISSN");
            System.out.print("Insira o código ISSN da revista: ");
            String codISSNPesquisa = scanner.nextLine().trim().strip();

            for (Material materialCodISSN : materialLista) {
                if (materialCodISSN instanceof Revista) {
                    Revista revistaM = (Revista) materialCodISSN;

                    if (codISSNPesquisa.equalsIgnoreCase(revistaM.getNumeroISSN())) {
                        System.out.println(materialCodISSN);
                        return;
                    }
                }
            }

            System.out.println("\nAVISO:");
            System.out.println("Revista não encontrada por Cód. ISSN, tente novamente.");

        } else {
            System.out.println("\nAVISO:");
            System.out.println("Opção de pesquisa inválida, tente novamente.");
        }
    }

    public void excluirMaterial(Scanner scanner) {
        System.out.println("\n——— EXCLUIR MATERIAL ———");

        if (materialLista.isEmpty()) {
            System.out.println("\nAVISO:");
            System.out.println("Não há nenhum material para excluir. Tente adicionar um material.");
            return;
        }

        System.out.println("[1] — TÍTULO (Livros e Revistas)");
        System.out.println("[2] — CÓD. ISSN (Revistas) ");
        System.out.print("Selecione o tipo de exclusão: ");

        String tipoDeExclusao = scanner.nextLine().trim();

        if (tipoDeExclusao.equals("1")) {
            System.out.println("\nExclusão por: TÍTULO");
            System.out.print("Insira o título do material: ");
            String tituloExclusao = scanner.nextLine().trim();

            for (Material materialTitulo : materialLista) {
                if (tituloExclusao.equalsIgnoreCase(materialTitulo.getTitulo())) {
                    System.out.print("\nITEM:");
                    System.out.println(materialTitulo);
                    System.out.println("EXCLUÍDO com sucesso.");
                    materialLista.remove(materialTitulo);
                    return;
                }
            }
            System.out.println("\nAVISO:");
            System.out.println("Material não encontrado por título, tente novamente.");

        } else if (tipoDeExclusao.equals("2")) {
            System.out.println("\nExclusão por: CÓD. ISSN");
            System.out.print("Insira o código ISSN da revista: ");
            String codISSNExclusao = scanner.nextLine().trim().strip();

            for (Material codExcluir : materialLista) {
                if (codExcluir instanceof Revista) {
                    Revista revista = (Revista) codExcluir;

                    if (codISSNExclusao.equalsIgnoreCase(((Revista) codExcluir).getNumeroISSN())) {
                        System.out.print("\nITEM:");
                        System.out.println(codExcluir);
                        System.out.println("EXCLUÍDO com sucesso.");
                        materialLista.remove(codExcluir);
                        return;
                    }
                }
            }

            System.out.println("\nAVISO:");
            System.out.println("Revista não encontrada por código ISSN, tente novamente.");

        } else {
            System.out.println("\nAVISO:");
            System.out.println("Opção de exclusão inválida, tente novamente.");
        }
    }

    public void listarMaterial(){
        System.out.println("\n——— LISTAR MATERIAL ———");

        if (materialLista.isEmpty()) {
            System.out.println("\nAVISO:");
            System.out.println("Não há nenhum material para ser listado. Tente adicionar um material.");
            return;
        }

        for (Material material : materialLista){
            System.out.println(material);
        }
    }
}


