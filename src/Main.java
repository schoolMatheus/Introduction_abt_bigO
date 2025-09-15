import model.RPNCalculadora;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        RPNCalculadora calculadora = new RPNCalculadora();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a expressão RPN ('5 1 2 + 4 * +') ou 'sair' para encerrar:");

        while (true) {
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("sair")) {
                break;
            }

            try {
                double resultado = calculadora.evaluateRPN(input);
                System.out.println("Resultado: " + resultado);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

            System.out.println("Digite outra expressão RPN ou 'sair' para encerrar:");
        }

        scanner.close();
    }
}
