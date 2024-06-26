import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DevMedicoAplicacao {
    private List<Medico> medicos;
    private MedicoCLI medicoCLI;
    private Scanner scanner;

    public DevMedicoAplicacao() {
        this.medicos = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        this.medicoCLI = new MedicoCLI();
    }

    public void executar() {
        Operacao operacao = null;

        while (operacao != Operacao.SAIR) {
            medicoCLI.exibirMenu();
            int opcao = medicoCLI.lerOpcao();

            try {
                operacao = Operacao.values()[opcao - 1];
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Opção inválida. Tente novamente.");
                continue;
            }

            switch (operacao) {
                case ADICIONAR:
                    adicionarMedico();
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


    private void adicionarMedico() {
        System.out.println("Digite o nome do médico:");
        String nome = scanner.nextLine();
        System.out.println("Digite o CRM do médico:");
        String crm = scanner.nextLine();

        boolean crmExistente = medicos.stream().anyMatch(medico -> medico.getCrm().equals(crm));

        if (crmExistente) {
            System.out.println("\n\nErro: CRM já cadastrado para outro médico. Médico não adicionado.\n\n");
            return;
        }

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

    private void listarMedicos() {
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
