package model;

public class Produto {
    //Variáveis
    private String sku;
    private String nome;
    private Double preco;
    private Integer quantidadeEmEstoque;

    //Construtor
    public Produto() {}

    public Produto(String sku, String nome, Double preco, Integer quantidadeEmEstoque) {
        this.sku = sku;
        this.nome = nome;
        this.preco = preco;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    //GET
    public String getSku() {
        return sku;
    }

    public String getNome() {
        return nome;
    }

    public Double getPreco() {
        return preco;
    }

    public Integer getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    //SET
    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public void setQuantidadeEmEstoque(Integer quantidadeEmEstoque) {
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    //Métodos
    @Override
    public String toString() {
        return "Pooduto: [SKU: " +
                this.sku +
                ", Nome: " +
                this.nome +
                ", Preço: R$" +
                this.preco +
                ", Quantidade no estoque: " +
                this.quantidadeEmEstoque;
    }

}
