import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);
        int opcaoEscolhida = 0;

        System.out.println("\n—————————— Bem-vindo ao Sistema de Gerenciamento de Biblioteca ——————————");

        do{
            System.out.println("\n——— OPÇÕES ———");
            System.out.println("\n[1] Adicionar novo Material");
            System.out.println("[2] Pesquisar Material");
            System.out.println("[3] Excluir Material");
            System.out.println("[4] Listar todos os Materiais");
            System.out.println("[5] Sair do Sistema");

            try {
                System.out.print("\nDigite a opção desejada: ");
                opcaoEscolhida = scanner.nextInt();
                scanner.nextLine();

                switch (opcaoEscolhida) {

                    case 1:
                        biblioteca.addNovoMaterial(scanner);
                        break;

                    case 2:
                        biblioteca.pesquisarMaterial(scanner);
                        break;

                    case 3:
                        biblioteca.excluirMaterial(scanner);
                        break;

                    case 4:
                        biblioteca.listarMaterial();
                        break;

                    case 5:
                        opcaoEscolhida = 5;
                        break;

                    default:
                        System.out.println("\nAVISO:");
                        System.out.println("Opção inexistente. Tente novamente.");
                }
            } catch (Exception e) {
                System.out.println("\nAVISO:");
                System.out.println("Erro na opção escolhida. Tente novamente.");
                scanner.nextLine();
            }
        } while (opcaoEscolhida != 5);

        System.out.println("\nVocê decidiu sair, bye-bye!");
    }
}
