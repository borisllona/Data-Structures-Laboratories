
import java.util.Objects;

public class SharedStack<E> implements Stack<E> {
    private final Node<E> topOfStack;

    @Override
    public int hashCode() {
        return Objects.hash(topOfStack);
    }

    private static class Node<E> {
        private final E elem;
        private final Node<E> next;


        private Node(E elem, Node<E> next) {
            this.elem = elem;
            this.next = next;
        }
    }

    public SharedStack() {
        this.topOfStack = new Node<>(null, null);
    }

    private SharedStack(E elem, Node<E> next) {
        this.topOfStack = new Node<>(elem, next);
    }

    private SharedStack(Node<E> topOfStack) {
        this.topOfStack = topOfStack;
    }

    //mètode push, crea una nova pila quan li afegim un nou element
    @Override
    public SharedStack<E> push(E elem) {
        return new SharedStack<>(elem, topOfStack);
    }

    //Mètode pop, crea una pila nova sense l'ultim element de la pila a la que li fem .pop()
    @Override
    public SharedStack<E> pop() throws StackError {
        if (isEmpty()) {
            throw new StackError("La pila es buida");
        } else {
            return new SharedStack<>(topOfStack.next);  //retornem una nova pila, pero sense el element superor, per tant de topOfStack sols agafem el next
        }
    }
    //Mètode top, retorna la cima de la pila a la que li passem el mètode
    @Override
    public E top() throws StackError {
        if (isEmpty()) {
            throw new StackError("La pila es buida");
        } else {
            return topOfStack.elem; //Al contrari que al metode pop(), a top() sols ens interesa l'element superior per tant al node topOfStack l'indiquem que volem el element superior elem.
        }
    }
    //Mètode is empty, comprova si la pila és buida o no
    @Override
    public boolean isEmpty() {
        return (topOfStack.next) == null;
    }
    //Mètode equals
    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object obj) {
        try {
            Stack<E> stack = (Stack<E>) obj;
            SharedStack<E> actual = this;
            while (!(stack.isEmpty() || actual.isEmpty())) {//comprobem que no esta buida la pila i si no ho esta comparem
                E e1 = stack.top();
                E e2 = actual.top();
                if (e1 == null || !(e1.equals(e2))) {
                    return false;
                }
                //esborrem els ultims elements i fins que la pila no estigui buida anem comparant
                stack = stack.pop();
                actual = actual.pop();
            }
            return stack.isEmpty() && actual.isEmpty();
        } catch (StackError err) {
            return false;
        }
    }
}
