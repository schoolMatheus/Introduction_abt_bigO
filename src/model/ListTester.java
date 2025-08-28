package model;
import java.util.List;
import java.util.Random;

public class ListTester {
    private static final int NUM_OPERACOES = 1_000;

    public static void runAllTests(List<Integer> list) {
        System.out.println("Testando " + list.getClass().getSimpleName() + " com " + NUM_OPERACOES + " operações.");
        testarAdicaoNoFinal(list);
        testarAdicaoNoInicio(list);
        testarAcessoAleatorio(list);
        testarRemocaoDoInicio(list);
        testarRemocaoDoFinal(list);
    }

    private static void testarAdicaoNoFinal(List<Integer> list) {
        list.clear();
        long startTime = System.nanoTime();
        for (int i = 0; i < NUM_OPERACOES; i++) {
            list.add(i);
        }
        long endTime = System.nanoTime();
        System.out.printf("Adicionar no FINAL: \t%d ms\n", (endTime - startTime) / 1000000);
    }

    private static void testarAdicaoNoInicio(List<Integer> list) {
        list.clear();
        long startTime = System.nanoTime();
        for (int i = 0; i < NUM_OPERACOES; i++) {
            list.add(0, i);
        }
        long endTime = System.nanoTime();
        System.out.printf("Adicionar no INÍCIO: \t%d ms\n", (endTime - startTime) / 1000000);
    }

    // Implementar os outros testes: testarAcessoAleatorio, testarRemocaoDoInicio, testarRemocaoDoFinal

    private static void testarAcessoAleatorio(List<Integer> list){
        list.clear();
        long startTime = System.nanoTime();
        Random random = new Random();
        int limiteRamdom = random.nextInt(NUM_OPERACOES + 1);
        for (int i = 0; i < NUM_OPERACOES; i++) {
            if (limiteRamdom == i){
                System.out.print("Posição: " + i + "Conteúdo: " + list.get(i));
            }
        }
        long endTime = System.nanoTime();
        System.out.printf("Adicionar no INÍCIO: \t%d ms\n", (endTime - startTime) / 1000000);
    }

    private static void testarRemocaoDoInicio(List<Integer> list){
        list.clear();
        long startTime = System.nanoTime();
        list.removeFirst();
        long endTime = System.nanoTime();
        System.out.printf("Adicionar no INÍCIO: \t%d ms\n", (endTime - startTime) / 1000000);
    }

    private static void testarRemocaoDoFinal(List<Integer> list){
        list.clear();
        long startTime = System.nanoTime();
        list.removeLast();
        long endTime = System.nanoTime();
        System.out.printf("Adicionar no INÍCIO: \t%d ms\n", (endTime - startTime) / 1000000);
    }
}
