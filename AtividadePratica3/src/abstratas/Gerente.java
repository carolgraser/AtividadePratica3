package abstratas;

import interfaces.*;

public class Gerente extends Funcionario implements FolhaPagamento {

    private float bonus;
    private String equipe;


    public Gerente(int matricula, String nome, float valorHora, float horasTrab, float bonus, String equipe) {
        super(matricula, nome, valorHora, horasTrab);
        this.bonus = bonus;
        this.equipe = equipe;
    }

    public float getBonus() {
        return bonus;
    }

    public String getEquipe() {
        return equipe;
    }

    public void setBonus(float bonus) {
        this.bonus = bonus;
    }

    public void setEquipe(String equipe) {
        this.equipe = equipe;
    }

    
    @Override
    public String toString() {
        return super.toString() +
        "\nBônus anual: " + bonus +
        "\nEquipe sob gerência: " + equipe +
        "\nSalário: " + calcularSalario();
    }
    

    @Override
    public float calcularSalario() {
        return valorHora * getHorasTrab() + (bonus / 12);
    }

    @Override
    public void trabalhar() {
        System.out.println("\nO gerente " + getNome() + " trabalhou " +
        getHorasTrab() + "h durante esse mês.");
    }

    @Override
    public void relatarProgresso() {
        System.out.println("\nSua equipe está progredindo muito! Parabéns!");
    }
    
}
