package structures;

public interface Pilha<T> {
  void push(T item);

  T pop();

  T peek();

  boolean isEmpty();

  int size();
}