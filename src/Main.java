import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static List<Medico> medicos = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Operacao operacao = null;

        while (operacao != Operacao.SAIR) {
            exibirMenu();
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consome a nova linha

            try {
                operacao = Operacao.values()[opcao - 1];
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Opção inválida. Tente novamente.");
                continue;
            }

            switch (operacao) {
                case ADICIONAR:
                    adicionarMedico(scanner);
                    break;
                case LISTAR:
                    listarMedicos();
                    break;
                case SAIR:
                    System.out.println("Encerrando o sistema...");
                    break;
            }
        }

        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("Selecione uma operação:");
        System.out.println("1 - Adicionar Médico");
        System.out.println("2 - Listar Médicos");
        System.out.println("3 - Sair");
    }

    private static void adicionarMedico(Scanner scanner) {
        System.out.println("Digite o nome do médico:");
        String nome = scanner.nextLine();
        System.out.println("Digite o CRM do médico:");
        String crm = scanner.nextLine();
        System.out.println("Digite a idade do médico:");
        int idade = scanner.nextInt();
        scanner.nextLine(); // Consome a nova linha
        System.out.println("Digite o telefone do médico:");
        String telefone = scanner.nextLine();
        System.out.println("Digite a especialidade do médico:");
        String especialidade = scanner.nextLine();

        Medico medico = new Medico(nome, crm, idade, telefone, especialidade);
        medicos.add(medico);
        System.out.println("Médico adicionado com sucesso!");
    }

    private static void listarMedicos() {
        if (medicos.isEmpty()) {
            System.out.println("Nenhum médico cadastrado.");
        } else {
            System.out.println("Lista de Médicos:");
            for (Medico medico : medicos) {
                System.out.println(medico);
            }
        }
    }
}

