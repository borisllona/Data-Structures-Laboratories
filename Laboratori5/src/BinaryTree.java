/**
 * @author Boris Llona Alonso
 * @author Flor Martinez Malaret
 */
public interface BinaryTree<E> {
    /**
     * @return True si el arbre binari és buit, false altrament
     */
    boolean isEmpty();
    /**
     * @return retorna l'arrel de l'arbre binari
     */
    E root();
    /**
     * @return retorna subarbre esquerra
     */
    BinaryTree<E> left();
    /**
     * @return retorna subarbre dret
     */
    BinaryTree<E> right();
}

