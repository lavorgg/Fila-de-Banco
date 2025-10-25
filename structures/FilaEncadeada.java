package structures;

public class FilaEncadeada<T> implements Fila<T> {
    private No<T> primeiro;
    private No<T> ultimo;
    private int tamanho;

    // Classe interna que representa cada nó da fila
    private static class No<T> {
        T dado;
        No<T> proximo;
        
        No(T dado) {
            this.dado = dado;
            this.proximo = null;
        }
    }

    public FilaEncadeada() {
        this.primeiro = null;
        this.ultimo = null;
        this.tamanho = 0;
    }

    @Override
    public void enqueue(T item) {
        No<T> novoNo = new No<>(item);
        if (isEmpty()) {
            // Se a fila está vazia, o novo nó é o primeiro e o último
            primeiro = novoNo;
        } else {
            // Se não está vazia, o último nó aponta para o novo nó
            ultimo.proximo = novoNo;
        }
        ultimo = novoNo;
        tamanho++;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            return null;
        }
        // Pega o dado do primeiro nó
        T dado = primeiro.dado;
        // O primeiro agora é o próximo nó
        primeiro = primeiro.proximo;
        // Se a fila ficou vazia, atualiza o último também
        if (primeiro == null) {
            ultimo = null;
        }
        tamanho--;
        return dado;
    }

    @Override
    public T peek() {
        return isEmpty() ? null : primeiro.dado;
    }

    @Override
    public boolean isEmpty() {
        return primeiro == null;
    }

    @Override
    public int size() {
        return tamanho;
    }
}