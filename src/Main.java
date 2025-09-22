import model.Produto;
import persistence.Estoque;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Estoque estoque = new Estoque();

        Produto p1 = new Produto("CEL-001", "Celular X", 1500.00, 20);
        Produto p2 = new Produto("NOT-002", "Notebook Pro", 3500.00, 5);
        Produto p3 = new Produto("TAB-003", "Tablet Z", 800.00, 15);
        Produto p4 = new Produto("CAM-004", "Câmera Y", 1200.00, 3);

        estoque.adicionarProduto(p1);
        estoque.adicionarProduto(p2);
        estoque.adicionarProduto(p3);
        estoque.adicionarProduto(p4);

        Produto pDuplicado = new Produto("CEL-001", "Smartphone Y", 1600.00, 10);
        estoque.adicionarProduto(pDuplicado);

        System.out.println("\n--- Listagem inicial dos produtos ---");
        estoque.listarTodosProdutos();

        System.out.println("\n--- Busca por SKU CEL-001 ---");
        Produto encontrado = estoque.buscarProduto("CEL-001");
        System.out.println(encontrado != null ? encontrado : "Produto não encontrado");

        System.out.println("\n--- Busca por SKU inexistente ---");
        encontrado = estoque.buscarProduto("XXX-999");
        System.out.println(encontrado != null ? encontrado : "Produto não encontrado");

        System.out.println("\n--- Atualizando quantidade do produto NOT-002 ---");
        estoque.atualizarQuantidade("NOT-002", 10);

        System.out.println("\n--- Removendo produto TAB-003 ---");
        estoque.removerProduto("TAB-003");

        System.out.println("\n--- Produtos com estoque baixo (limite 10) ---");
        estoque.listarProdutosEstoqueBaixo(10);

        System.out.println("\n--- Listagem final dos produtos ---");
        estoque.listarTodosProdutos();
    }
}
