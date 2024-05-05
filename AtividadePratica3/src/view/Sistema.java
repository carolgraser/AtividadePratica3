package view;
import abstratas.*;
import java.util.ArrayList;

public class Sistema {

    private ArrayList<Funcionario> funcionarios;

    public Sistema() {

        this.funcionarios = new ArrayList<>();

    }

    public void cadastrarFuncionario(Funcionario funcionario) {

        funcionarios.add(funcionario);

    }

    public void cadastrarFuncionario() {

        System.out.println("\n* Cadastro de Funcionário *");

        System.out.print("\nNome: ");
        String nome = Console.lerString();

        System.out.print("Matrícula: ");
        int matricula = Console.lerInt();
        
        System.out.println("\nCargo:");
        System.out.println("1. Gerente");
        System.out.println("2. Desenvolvedor");
        System.out.println("3. Estagiário");
        System.out.print("Opção: ");
        int cargo = Console.lerInt();

        switch (cargo) {

            case 1:

                System.out.print("Bônus anual: ");
                float bonus = Console.lerFloat();

                System.out.print("Equipe: ");
                String equipe = Console.lerString();

                System.out.print("Quantidade de horas trabalhadas: ");
                float horasTrabalhadas = Console.lerFloat();

                System.out.println("Valor da hora: R$ ");
                float valorHoraGer = Console.lerFloat();

                
                cadastrarFuncionario(new Gerente(matricula, nome, valorHoraGer, horasTrabalhadas, bonus, equipe));
                break;

            case 2:

                System.out.print("Especialidade: ");
                String especialidade = Console.lerString();

                System.out.print("Quantidade de horas trabalhadas: ");
                horasTrabalhadas = Console.lerInt();

                System.out.println("Valor da hora: R$ ");
                float valorHoraDev = Console.lerFloat();

                cadastrarFuncionario(new Desenvolvedor(matricula, nome, valorHoraDev, horasTrabalhadas, especialidade));
                break;

            case 3:

                System.out.print("Supervisor: ");
                String supervisor = Console.lerString();

                System.out.print("Quantidade de horas trabalhadas: ");
                horasTrabalhadas = Console.lerInt();

                System.out.println("Valor da hora: R$ ");
                float valorHoraEstag = Console.lerFloat();

                cadastrarFuncionario(new Estagiario(matricula, nome, valorHoraEstag, horasTrabalhadas, supervisor));
                break;

            default:

                System.out.println("Opção inválida.");
        }
    }
    
    public void excluirFuncionario(int matricula) {

        for (int i = 0; i < funcionarios.size(); i++) {

            Funcionario func = funcionarios.get(i);

            if (func.getMatricula() == matricula) {

                funcionarios.remove(i);

                System.out.println("Funcionário removido!");

                return;

            }
        }
        
        System.out.println("Funcionário não encontrado!");

    }


    public String buscarFuncionario(int matricula) {

        for (Funcionario func : funcionarios) {

            if (func.getMatricula() == matricula) {

                System.out.println("\n* Registro do funcionário *");

                return func.toString();
            }
        }

        return "\nFuncionário não encontrado!";
    }


    public void exibirFuncionarios() {

        if (funcionarios.isEmpty()) {

            System.out.println("\nNão há funcionários cadastrados");

        } else {

            System.out.println("\nLista de Funcionários");

            for (Funcionario func : funcionarios) {

                System.out.println(func.toString());

                System.out.println();

            }
        }
    }
    

    public void statusFuncionario(int matricula) {

        for (Funcionario func : funcionarios) {
            
            if (func.getMatricula() == matricula) {

                System.out.println();
                func.trabalhar();

                return;

            }
        }

        System.out.println("\nFuncionário não encontrado!");
        
    }


    public void relatarProgresso(int matricula) {

        for (Funcionario func : funcionarios) {
            
            if (func.getMatricula() == matricula) {

                System.out.println();
                func.relatarProgresso();

                return;

            }
        }
        System.out.println("\nFuncionário não encontrado!");
    }
    

    public void executar() {

        int op;

        do {
            System.out.println("\nMENU");
            System.out.println("1. Cadastrar funcionário");
            System.out.println("2. Excluir funcionário");
            System.out.println("3. Buscar funcionário");
            System.out.println("4. Exibir todos os funcionários");
            System.out.println("5. Relatar progresso");
            System.out.println("6. Status do funcionário");
            System.out.println("0. Sair");
            System.out.print("Sua opção: ");
            op = Console.lerInt();

            switch (op) {

                case 1:

                    cadastrarFuncionario();
                    break;

                case 2:
                    System.out.print("\nDigite a matrícula do funcionário: ");

                    int matricula = Console.lerInt();
                    excluirFuncionario(matricula);
                    
                    break;

                case 3:

                    System.out.print("\nMatrícula do funcionário: ");
                    int matBusc = Console.lerInt();
                    System.out.println(buscarFuncionario(matBusc));

                    break;

                case 4:

                    exibirFuncionarios();
                    break;

                case 5:

                    System.out.print("\nDigite a matrícula do funcionário: ");
                    int matriculaProg = Console.lerInt();
                    relatarProgresso(matriculaProg);

                    break;

                case 6:

                    System.out.print("\nDigite a matrícula do funcionário: ");
                    int matStatus = Console.lerInt();
                    statusFuncionario(matStatus);

                    break;

                case 0:

                    System.out.println("\n!PROGRAMA FINALIZADO!");

                    break;

                default:

                    System.out.println("\nOpção inválida, digite novamente!");

            }

        } while (op != 0);
    }
}
