package model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FilaDePrioridade<T> {
    //Variáveis
    private List<T> fila;
    private Comparator<T> comparator;
    private int tamanhoTotal = 0;

    //Construtor
    public FilaDePrioridade() {
        this.fila = new ArrayList<T>();
        this.comparator = null;
    }
    public FilaDePrioridade(Comparator<T> comparator) {
        this.fila = new ArrayList<T>();
        this.comparator = comparator;
    }

    //Métodos
    public void enfileirar(T elemento){
        tamanhoTotal++;
        for (int i = 0; i < fila.size(); i++) {
            int comparacao;
            if (comparator != null) {
                comparacao = comparator.compare(elemento, fila.get(i));
            } else {
                comparacao = ((Comparable<T>) elemento).compareTo(fila.get(i));
            }

            if (comparacao > 0) {
                fila.add(i, elemento);
                return;
            }
        }
        fila.add(elemento);
    }

    public T desenfileirar(){
        if(estaVazia()){
            throw new IllegalStateException("Fila vazia");
        }
        tamanhoTotal--;
        return fila.remove(0);
    }

    public T espiar(){
        return fila.get(0);
    }

    public boolean estaVazia(){
        return tamanhoTotal == 0;
    }

    public int tamanho(){
        return tamanhoTotal;
    }

    private int comparar(T a, T b){
        if (comparator != null) {
            return comparator.compare(a, b);
        } else {
            return ((Comparable<T>) a).compareTo(b);
        }
    }

}
