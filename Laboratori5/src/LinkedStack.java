/**
 * @author Boris Llona Alonso
 * @author Flor Martinez Malaret
 */
import java.util.NoSuchElementException;
import java.util.Objects;

public class LinkedStack<E> implements Stack<E> {
    private Node<E> top;

    private static class Node<E> {
        E elem;
        Node<E> next;

        private Node(E elem, Node<E> next) {
            this.elem = elem;
            this.next = next;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node<?> node = (Node<?>) o;
            return Objects.equals(elem, node.elem) &&
                    Objects.equals(next, node.next);
        }

    }

    /**
     * Creem una LinkedStack buida.
     */
    public LinkedStack() {
        top = null;
    }

    /**
     * @return Retorna si la pila és buida.
     */
    @Override
    public boolean isEmpty() {
        return top == null;
    }

    /**
     * Elimina l'ultim element de la pila.
     */
    @Override
    public void pop() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("Pila buida");
        } else {
            top = top.next;
        }
    }

    /**
     * @return Retorna l'ultim element de la pila.
     */
    @Override
    public E top() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("Pila buida");
        } else {
            return top.elem;
        }
    }

    /**
     * @param e Afegeix l'element e al top de la pila.
     */
    @Override
    public void push(E e) {
        top = new Node<>(e, top);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinkedStack<?> that = (LinkedStack<?>) o;
        return Objects.equals(top, that.top);
    }

}


