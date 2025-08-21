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






}
