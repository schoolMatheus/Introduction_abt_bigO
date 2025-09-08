package model;

public class Paciente implements Comparable<Paciente> {
    //Variáveis
    private String nome;
    private int gravidade;

    //Construtor
    public Paciente(String nome, int gravidade) {
        this.nome = nome;
        this.gravidade = gravidade;
    }

    //GET
    public String getNome() {
        return nome;
    }

    public int getGravidade() {
        return gravidade;
    }

    //Métodos
    @Override
    public int compareTo(Paciente outro) {
        // A ordem natural é baseada na gravidade.
        // Retorna positivo se a nossa gravidade for maior.
        return Integer.compare(this.gravidade, outro.gravidade);
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "nome='" + nome + '\'' +
                ", gravidade=" + gravidade +
                '}';
    }

}
