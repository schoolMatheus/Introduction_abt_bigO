//package model;
//
//public class MinhaTabelaHash<K, V> {
//    private HashEntry<K, V>[] buckets;
//    private int capacidade;
//    private int tamanho;
//
//    // Construtor
//    public MinhaTabelaHash() {
//        this.capacidade = 16; // Capacidade inicial padrão
//        this.buckets = new HashEntry[capacidade];
//        this.tamanho = 0;
//    }
//
//    // Classe interna para as entradas
//    class HashEntry<K, V> {
//        K key;
//        V value;
//        HashEntry<K, V> next;
//
//        public HashEntry(K key, V value) {
//            this.key = key;
//            this.value = value;
//            this.next = null;
//        }
//    }
//
//    // Retorna o tamanho atual da tabela
//    public int size() {
//        return tamanho;
//    }
//
//    // Verifica se a tabela está vazia
//    public boolean isEmpty() {
//        return tamanho == 0;
//    }
//
//    // Função de Hash para encontrar o índice do bucket
//    private int getBucketIndex(K key) {
//        int hashCode = key.hashCode();
//        return Math.abs(hashCode % capacidade);
//    }
//
//    public void put(K key, V value) {
//        int bucketIndex = getBucketIndex(key);
//        HashEntry<K, V> head = buckets[bucketIndex];
//
//        // Verifica se a chave já existe e atualiza o valor
//        HashEntry<K, V> current = head;
//        while (current != null) {
//            if (current.key.equals(key)) {
//                current.value = value;
//                return;
//            }
//            current = current.next;
//        }
//
//        // Se a chave não existe, adiciona uma nova entrada no início da lista
//        tamanho++;
//        HashEntry<K, V> novaEntrada = new HashEntry<>(key, value);
//        novaEntrada.next = head;
//        buckets[bucketIndex] = novaEntrada;
//    }
//
//    public V get(K key) {
//        int bucketIndex = getBucketIndex(key);
//        HashEntry<K, V> head = buckets[bucketIndex];
//
//        HashEntry<K, V> current = head;
//        while (current != null) {
//            if (current.key.equals(key)) {
//                return current.value;
//            }
//            current = current.next;
//        }
//
//        return null; // Chave não encontrada
//    }
//
//    public V remove(K key) {
//        int bucketIndex = getBucketIndex(key);
//        HashEntry<K, V> head = buckets[bucketIndex];
//        HashEntry<K, V> prev = null;
//
//        HashEntry<K, V> current = head;
//        while (current != null) {
//            if (current.key.equals(key)) {
//                break;
//            }
//            prev = current;
//            current = current.next;
//        }
//
//        // Se a chave não foi encontrada
//        if (current == null) {
//            return null;
//        }
//
//        // Remove a entrada
//        tamanho--;
//        if (prev != null) {
//            prev.next = current.next;
//        } else {
//            buckets[bucketIndex] = current.next;
//        }
//
//        return current.value;
//    }
//
//}
