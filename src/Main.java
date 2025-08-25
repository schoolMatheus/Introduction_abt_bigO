import model.ListaEncadeada;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*

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

         */

        System.out.println("--- Atividade Complementar: Testes dos Novos Métodos ---");
        ListaEncadeada<String> agenda = new ListaEncadeada<>();

        // Testando inserções
        agenda.inserirNoInicio("Marcar reunião"); // Início
        agenda.inserirNoFim("Preparar apresentação"); // Fim
        agenda.inserirNoInicio("Revisar e-mails"); // Novo início
        agenda.inserirNoFim("Enviar relatório"); // Novo fim
        System.out.print("Estado da lista: ");
        agenda.exibir(); // Esperado: Revisar e-mails -> Marcar reunião -> Preparar apresentação -> Enviar relatório -> null

        System.out.println("Tamanho atual (O(1)): " + agenda.tamanho()); // Esperado: 4

        // Testando obtenção por índice (O(n))
        System.out.println("\n--- Testando obterEm(indice) ---");
        try {
            System.out.println("Elemento no índice 0: " + agenda.obterEm(0)); // Esperado: Revisar e-mails
            System.out.println("Elemento no índice 2: " + agenda.obterEm(2)); // Esperado: Preparar apresentação
            System.out.println("Elemento no último índice (3): " + agenda.obterEm(agenda.tamanho() - 1)); // Esperado: Enviar relatório
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        // Testando remoções (O(1) e O(n))
        System.out.println("\n--- Testando Remoções ---");
        agenda.removerDoInicio(); // Remove "Revisar e-mails"
        System.out.print("Após remover do início: ");
        agenda.exibir(); // Esperado: Marcar reunião -> Preparar apresentação -> Enviar relatório -> null
        System.out.println("Tamanho: " + agenda.tamanho()); // Esperado: 3

        agenda.removerValor("Preparar apresentação"); // Remove um elemento do meio
        System.out.print("Após remover 'Preparar apresentação': ");
        agenda.exibir(); // Esperado: Marcar reunião -> Enviar relatório -> null
        System.out.println("Tamanho: " + agenda.tamanho()); // Esperado: 2

        agenda.removerValor("Enviar relatório"); // Remove o último elemento
        System.out.print("Após remover o último elemento: ");
        agenda.exibir(); // Esperado: Marcar reunião -> null
        System.out.println("Tamanho: " + agenda.tamanho()); // Esperado: 1
    }
}
