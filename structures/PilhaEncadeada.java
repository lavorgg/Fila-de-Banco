package structures;

public class PilhaEncadeada<T> implements Pilha<T> {
    private No<T> topo;
    private int tamanho;

    // Classe interna que representa cada nó da pilha
    private static class No<T> {
        T dado;
        No<T> proximo;
        
        No(T dado) {
            this.dado = dado;
            this.proximo = null;
        }
    }

    public PilhaEncadeada() {
        this.topo = null;
        this.tamanho = 0;
    }

    @Override
    public void push(T item) {
        No<T> novoNo = new No<>(item);
        // O novo nó aponta para o antigo topo
        novoNo.proximo = topo;
        // O novo nó se torna o novo topo
        topo = novoNo;
        tamanho++;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            return null;
        }
        // Pega o dado do topo
        T dado = topo.dado;
        // O topo agora é o próximo nó
        topo = topo.proximo;
        tamanho--;
        return dado;
    }

    @Override
    public T peek() {
        return isEmpty() ? null : topo.dado;
    }

    @Override
    public boolean isEmpty() {
        return topo == null;
    }

    @Override
    public int size() {
        return tamanho;
    }
}