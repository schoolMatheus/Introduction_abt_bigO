package model;

public class ListaEncadeada<T> {
    No<T> inicio;

    public ListaEncadeada() {
        this.inicio = null;
    }

    //Métodos

    /**
     * Adiciona um novo nó no início da lista.
     * Complexidade: O(1)
     */

    public void inserirNoInicio(T dado) {
        No<T> novoNo = new No<>(dado);
        novoNo.proximo = this.inicio;
        this.inicio = novoNo;
    }

    /**
     * Verifica se um elemento 'alvo' existe na lista.
     * Complexidade: O(n)
     */

    public boolean buscar(T alvo) {
        No<T> atual = this.inicio;
        while (atual != null) {
            if (alvo.equals(atual.dado)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Remove elementos duplicados da lista usando um método simples.
     * Complexidade: O(n^2)
     */

    public void removerDuplicatasSimples() {
        No<T> noExterno = this.inicio;
        while (noExterno != null) {
            No<T> corredor = noExterno;
            while (corredor != null) {
                if (corredor.proximo.dado.equals(noExterno.dado)) {
                    corredor.proximo = corredor.proximo.proximo;
                } else {
                    corredor = corredor.proximo;
                }
            }
            noExterno = noExterno.proximo;
        }
    }

    /**
     * Método auxiliar para exibir a lista.
     * Complexidade: O(n)
     */

    public void exibir(){
        if(this.inicio == null){
            System.out.println("Lista vazia");
            return;
        }
        No<T> atual = this.inicio;
        StringBuilder sb = new StringBuilder();
        while (atual != null) {
            sb.append(String.valueOf(atual.dado)).append(" -> ");
            atual = atual.proximo;
        }
        sb.append("null");
        System.out.println(sb.toString());
    }

    // Novos Métodos Atividade01

    /**
     * Complexidade: O(1), pois a operação envolve apenas a atualização do 'inicio' para o próximo nó,
     * independentemente do tamanho da lista. Não há necessidade de percorrer a lista.
     */
    public void removerDoInicio(){
        if(this.inicio == null){
            System.out.println("Lista vazia");
            return;
        }
        this.inicio = this.inicio.proximo;
    }

    /**
     * Complexidade: O(n), onde n é o número de nós na lista, pois pode ser necessário
     * percorrer toda a lista para alcançar o índice pedido.
    */
    public T obterEm(int indice){
        if (indice < 0){
            throw new IndexOutOfBoundsException("Índice inválido: " + indice);
        }

        int posicao = 0;
        No<T> noExterno = this.inicio;

        while (noExterno != null && posicao < indice) {
            noExterno = noExterno.proximo;
            posicao++;
        }
        if (noExterno == null){
            throw new IndexOutOfBoundsException("Índice maio que a lista: " + indice);
        }

        return noExterno.dado;
    }

    /**
     * Complexidade: O(n), onde n é o número de nós na lista, pois pode ser necessário
     * percorrer toda a lista para encontrar o valor ou dizer que ele não está.
     */
    public void removerValor(T dado){
        if(this.inicio.dado.equals(dado)){
            this.inicio = this.inicio.proximo;
            return;
        }

        No<T> noExterno = this.inicio;
        while (noExterno != null) {

            if (noExterno.proximo.dado.equals(dado)) {
                noExterno.proximo = noExterno.proximo.proximo;
                return;
            }
            noExterno = noExterno.proximo;
        }
    }

    /**
     * Complexidade: O(n), onde n é o número de nós na lista, pois pode ser necessário
     * percorrer toda a lista para encontrar o último nó.
     */
    public void inserirNoFim(T dado){
        No<T> novoNo = new No<>(dado);
        if(this.inicio == null){
            novoNo.proximo = this.inicio;
            this.inicio = novoNo;
            return;
        }
        No<T> noExterno = this.inicio;
        while (noExterno.proximo != null){
            noExterno = noExterno.proximo;
        }
        noExterno.proximo = novoNo;
    }

    /**
     * Complexidade: O(n), onde n é o número de nós na lista, pois o método percorre toda a lista,
     * contando cada nó até chegar no final.
     */
    public int tamanho(){
        int tamanho = 0;
        No<T> noExterno = this.inicio;
        while (noExterno != null){
            tamanho++;
            noExterno = noExterno.proximo;
        }
        return tamanho;
    }


}
