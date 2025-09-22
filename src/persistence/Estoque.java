package persistence;

import model.Produto;

import java.util.HashMap;
import java.util.Map;

public class Estoque {
    //Variáveis
    Map<String, Produto> produtos;

    public Estoque() {
        this.produtos = new HashMap<>();
    }

    //Métodos
    public void adicionarProduto(Produto produto){
        if (produtos.containsKey(produto.getSku())) {
            System.out.println("Erro: Produto com SKU " + produto.getSku() + " já está cadastrado.");
        } else {
            produtos.put(produto.getSku(), produto);
            System.out.println("Produto " + produto.getNome() + " adicionado com sucesso.");
        }
    }
    public Produto buscarProduto(String sku){
        return produtos.get(sku);
    }
    public void atualizarQuantidade(String sku, int novaQuantidade){
        Produto produto = produtos.get(sku);
        if (produto != null) {
            produto.setQuantidadeEmEstoque(novaQuantidade);
            System.out.println("Quantidade do produto " + produto.getNome() + " atualizada para " + novaQuantidade);
        } else {
            System.out.println("Erro: Produto com SKU " + sku + " não encontrado.");
        }
    }
    public void removerProduto(String sku){
        Produto produto = produtos.remove(sku);
        if (produto != null) {
            System.out.println("Produto " + produto.getNome() + " removido com sucesso.");
        } else {
            System.out.println("Erro: Produto com SKU " + sku + " não encontrado.");
        }
    }
    public void listarTodosProdutos(){
        if (produtos.isEmpty()) {
            System.out.println("O estoque está vazio.");
        } else {
            System.out.println("Lista de todos os produtos:");
            for (Produto produto : produtos.values()) {
                System.out.println(produto);
            }
        }
    }
    public void listarProdutosEstoqueBaixo(int limite){
        boolean encontrado = false;
        System.out.println("Produtos com estoque baixo (limite: " + limite + "):");
        for (Produto produto : produtos.values()) {
            if (produto.getQuantidadeEmEstoque() <= limite) {
                System.out.println(produto);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("Nenhum produto com estoque baixo encontrado.");
        }
    }

}
