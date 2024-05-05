package abstratas;

import interfaces.*;


public class Estagiario extends Funcionario implements FolhaPagamento {
    
    private String supervisor;


    public Estagiario(int matricula, String nome, float valorHora, float horasTrab, String supervisor) {
        super(matricula, nome, valorHora, horasTrab);
        this.supervisor = supervisor;
    }


    public String getSupervisor() {
        return supervisor;
    }


    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    @Override
    public String toString() {
        return super.toString() +
        "\nSupervisor: " + supervisor +
        "\nSalário: " + calcularSalario();
    }

    @Override
    public float calcularSalario() {
        return valorHora * getHorasTrab();
    }

    @Override
    public void trabalhar() {
        if (getHorasTrab() > 120) {
            System.out.println( "\nEstagiário " + getNome() +
            " excedeu as horas legais de trabalho!");  
        }
        else {System.out.println("\nEstagiário " + getNome() + "cumpriu " + getHorasTrab() + 
            "h durante o mês, respeitando o limite legal.");}
        }


    @Override
    public void relatarProgresso() {
        System.out.println( "\nFez um ótimo progresso durante esse mês, desenvolvendo o que aprendeu na faculdade!");
    }
    
    }


