import model.FilaDePrioridade;
import model.Paciente;

public class Main {
    public static void main(String[] args) {

        // Cenário de Teste 1: Triagem de Pacientes (Usando Comparable)
        FilaDePrioridade<Paciente> filaAtendimento = new FilaDePrioridade<>();
        System.out.println("Cenário 1: Atendimento de Pacientes (Implementação com Lista)");
        filaAtendimento.enfileirar(new Paciente("Carlos", 3));
        filaAtendimento.enfileirar(new Paciente("Maria", 5));
        filaAtendimento.enfileirar(new Paciente("Ana", 8));
        filaAtendimento.enfileirar(new Paciente("Sofia", 10));

        System.out.println("Próximo paciente: " + filaAtendimento.espiar());
        while (!filaAtendimento.estaVazia()) {
            System.out.println("Atendendo: " + filaAtendimento.desenfileirar());
        }
    }
}
