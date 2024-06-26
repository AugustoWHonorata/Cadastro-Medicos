import java.util.Scanner;

public class MedicoCLI {
    private Scanner scanner;

    public MedicoCLI() {
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        System.out.println("===================================");
        System.out.println("           Sistema Médico          ");
        System.out.println("===================================");
        System.out.println("Selecione uma opção:");
        System.out.println("1 - Adicionar Médico");
        System.out.println("2 - Listar Médicos");
        System.out.println("3 - Sair");
        System.out.print("Opção: ");
    }

    public int lerOpcao() {
        int opcao = 0;
        boolean opcaoValida = false;

        while (!opcaoValida) {
            try {
                opcao = Integer.parseInt(scanner.nextLine());
                if (opcao < 1 || opcao > 3) {
                    System.out.print("Opção inválida. Digite novamente: ");
                } else {
                    opcaoValida = true;
                }
            } catch (NumberFormatException e) {
                System.out.print("Opção inválida. Digite novamente: ");
            }
        }

        return opcao;
    }
}
