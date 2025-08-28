import model.ListTester;
import model.ListaEncadeada;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // ... (código do menu para escolher entre 1-ArrayList, 2-LinkedList, 3-Vector, 4-Stack) ...
        System.out.print("### Escolha o tipo de Lista ###\n");
        System.out.print("1-ArrayList, 2-LinkedList, 3-Vector, 4-Stack: ");
        int op = sc.nextInt();

        while (op > 4 || op < 1) {
            System.out.print("### Escolha uma opção válida ###\n");
            System.out.print("1-ArrayList, 2-LinkedList, 3-Vector, 4-Stack: ");
            op = sc.nextInt();
        }

        List<Integer> listaEscolhida = null;
        String nomeDaLista = "";

        // ... (switch case para instanciar a lista escolhida) ...
        switch (op){
            case 1:
                listaEscolhida = new ArrayList<>();
                nomeDaLista = "ArrayList";
                break;
            case 2:
                listaEscolhida = new LinkedList<>();
                nomeDaLista = "LinkedList";
                break;
            case 3:
                listaEscolhida = new Vector<>();
                nomeDaLista = "Vector";
                break;
            default:
                listaEscolhida = new Stack<>();
                nomeDaLista = "Stack";
        }

        System.out.println("\n--- Iniciando testes com " + nomeDaLista + " ---");
        ListTester.runAllTests(listaEscolhida);
        System.out.println("--- Testes finalizados ---");

        sc.close();

    }
}
