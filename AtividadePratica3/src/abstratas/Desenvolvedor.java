package abstratas;

import interfaces.*;


public class Desenvolvedor extends Funcionario implements FolhaPagamento {
    
    private String tecnologia;


    public Desenvolvedor(int matricula, String nome, float valorHora, float horasTrab, String tecnologia) {
        super(matricula, nome, valorHora, horasTrab);
        this.tecnologia = tecnologia;
    }

    public String getTecnologia() {
        return tecnologia;
    }

    public void setTecnologia(String tecnologia) {
        this.tecnologia = tecnologia;
    }

    @Override
    public String toString() {
        return super.toString() +
        "\nTecnologias que domina: " + tecnologia +
        "\nSalário: " + calcularSalario();
    }

    @Override
    public float calcularSalario() {
        return valorHora * getHorasTrab();
    }

    @Override
    public void trabalhar() {
        System.out.println("\nDesenvolvedor " + getNome() + 
        " foi selecionado para o projeto com especialidade em " + tecnologia + "!");
    }

    @Override
    public void relatarProgresso() {
        System.out.println( "\nDesenvolvedor " + getNome() + " dedicou " + 
        getHorasTrab() + "h durante esse mês no projeto, aplicando seus conhecimentos em " 
        + tecnologia + "!");
    }
    
}
