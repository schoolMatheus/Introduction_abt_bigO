import model.ListaEncadeada;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("--- Demonstração Prática de Big O ---");
        System.out.print("Digite o valor de N (tamanho da lista): ");
        int n = scanner.nextInt();

        // 1. Criação da lista com N elementos aleatórios (operação rápida)
        ListaEncadeada<Integer> listaNumeros = new ListaEncadeada<>();
        // Gera números num intervalo menor que N para garantir duplicatas
        int limiteRamdom = n > 100 ? n/2 : n;
        for (int i = 0; i < n; i++) {
            listaNumeros.inserirNoInicio(random.nextInt(limiteRamdom));
        }
        System.out.println("Lista com " + n + " elementos criada");

        // Para N grande, a exibição da lista é omitida para não poluir o console.
        if (n<=20 ){
            System.out.println("Lista original: ");
            listaNumeros.exibir();
        }

        // 2. Medição de tempo da operação O(n^2)
        System.out.println("\nIniciando a operação O(n^2) de remover duplicatas...");

        long tempoInicial = System.nanoTime();
        listaNumeros.removerDuplicatasSimples();
        long tempoFinal = System.nanoTime();
        long duracaoEmNano = tempoFinal - tempoInicial;

        // Convertendo para milissegundos para melhor legibilidade
        double duracaoEmMs = duracaoEmNano / 1_000_000.0;

        System.out.printf("Operação concluída em: %.4f milissegundos.\n", duracaoEmMs);
        if (n <= 20) {
            System.out.print("Lista processada: ");
            listaNumeros.exibir();
        }

        System.out.println("\nExperimente executar com valores maiores de N (ex: 1000, 5000");
        System.out.println("e observe como o tempo de execução aumenta de forma não linear");
        scanner.close();

    }
}
