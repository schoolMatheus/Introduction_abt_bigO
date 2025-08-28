package model;

public class No<T>{
    //Tipo "T" é o tipo genérico qualquer tipo de dado

    T dado;
    No<T> proximo;

    public No(T dado) {
        this.dado = dado;
        this.proximo = null;
    }
}
