/**
 * @author Boris Llona Alonso
 * @author Flor Martinez Malaret
 */

import java.util.Comparator;
import java.util.Objects;

/**
 * @param <K> key, ordena el ABB
 * @param <V> Valor que emmagatzemem al ABB
 */
public class LinkedBinarySearchTree<K, V> implements BinarySearchTree<K, V>, BinaryTree<Pair<K, V>> {

    private final Node<K, V> root;
    private final Comparator<K> comparator;

    private static class Node<K, V> {
        private final K key;
        private final V value;
        private final Node<K, V> left;
        private final Node<K, V> right;

        private Node(K key, V value, Node<K, V> left, Node<K, V> right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }

        private Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node<?, ?> node = (Node<?, ?>) o;
            return Objects.equals(key, node.key) &&
                    Objects.equals(value, node.value) &&
                    Objects.equals(left, node.left) &&
                    Objects.equals(right, node.right);
        }
    }

    public LinkedBinarySearchTree(Comparator<K> comparator) {
        this.comparator = comparator;
        this.root = null;
    }

    private LinkedBinarySearchTree(Comparator<K> comparator, Node<K, V> root) {
        this.comparator = comparator;
        this.root = root;
    }

    /**
     * Retorna true si el ABB està buit i false en cas contrari.
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * @return Retorna l'arrel del BinaryTree
     */
    @Override
    public Pair<K, V> root() {
        return new Pair<>(root.key, root.value);
    }

    /**
     * @return Retorna el fill esquerra
     */
    @Override
    public LinkedBinarySearchTree<K, V> left() {
        return new LinkedBinarySearchTree<>(this.comparator, this.root.left);
    }

    /**
     * @return Retorna el fill dret
     */
    @Override
    public LinkedBinarySearchTree<K, V> right() {
        return new LinkedBinarySearchTree<>(this.comparator, this.root.right);
    }

    /**
     * Retorna true si el ABB conté la clau key
     *
     * @param key
     * @return
     */
    @Override
    public boolean containsKey(K key) {
        return contains(key, root);
    }

    private boolean contains(K key, Node<K, V> node) {
        if (node == null) {
            return false;
        } else if (comparator.compare(key, node.key) == 0) {
            return true;
        } else {
            if (comparator.compare(key, node.key) > 0) {
                return contains(key, node.right);
            } else {
                return contains(key, node.left);
            }

        }
    }

    /**
     * retorna el valor associat a la key, si no existeix retorna NULL.
     *
     * @param key
     * @return
     * @throws NullPointerException
     */
    @Override
    public V get(K key) {
        if (key == null)
            throw new NullPointerException();
        return get(key, root);
    }

    private V get(K key, Node<K, V> node) {
        if (node == null) {
            return null;
        } else if (comparator.compare(key, node.key) == 0) {
            return node.value;
        } else {
            if (comparator.compare(key, node.key) > 0) {
                return get(key, node.right);
            } else {
                return get(key, node.left);
            }
        }
    }

    /**
     * @param key   la key és la que busquem per aconseguir el valor
     * @param value valor emmagatzemat en el ABB
     * @return retorna un nou ABB duplicant tots els elements en el nou ABB d'aquell desde que es reaitza la crida
     * @throws NullPointerException si key o value són null retorna NullPointerException
     */
    @Override
    public LinkedBinarySearchTree<K, V> put(K key, V value) {
        if (key == null || value == null) {
            throw new NullPointerException(); //Fer un test que comprovi si torna la excepció al pasarli un valor o key null
        }
        return new LinkedBinarySearchTree<K, V>(comparator, newRoot(root, key, value));
    }

    private Node<K, V> newRoot(Node<K, V> node, K key, V value) {
        if (node == null) {
            return new Node<>(key, value);
        } else if (node.key == key) {
            return new Node<>(key, value, node.left, node.right);
        } else if (comparator.compare(node.key, key) < 0) {
            return new Node<>(node.key, node.value, node.left, newRoot(node.right, key, value));
        } else {
            return new Node<>(node.key, node.value, newRoot(node.left, key, value), node.right);
        }
    }

    /**
     * @param key la key és la que busquem per aconseguir el valor
     * @return retorna un nou ABB duplicant tots els elements excepte aquell que volem eliminar en el nou ABB d'aquell
     * desde que es reaitza la crida
     * @throws NullPointerException si key o value són null retorna NullPointerException
     */
    @Override
    public LinkedBinarySearchTree<K, V> remove(K key) {
        if (key == null)
            throw new NullPointerException();
        if (containsKey(key)) {
            return new LinkedBinarySearchTree<K, V>(this.comparator, remove(this.root, key));
        } else {
            return this;
        }
    }

    /**
     * @param node quan arriba al node a eliminar, se li assigna valor null
     * @param key  la key és la que busquem per aconseguir el valor
     * @return retorna null en cas que no trobi la key corresponent
     */
    private Node<K, V> remove(Node<K, V> node, K key) {
        if (node == null) {
            return null;
        } else if (comparator.compare(node.key, key) > 0) {
            return new Node<>(node.key, node.value, remove(node.left, key), node.right);
        } else if (comparator.compare(node.key, key) < 0) {
            return new Node<>(node.key, node.value, node.left, remove(node.right, key));
        } else {  //En cas de que trobi la key que volem fer el remove
            if (node.left != null && node.right != null) {    //Cas que tingui 2 fills
                Node<K, V> rightMin = minKey(node.right);
                return new Node<>(rightMin.key, rightMin.value, node.left, remove(node.right, rightMin.key));
            } else if (node.left != null) {     //Cas que tingui 1 fill
                return node.left;
            } else if (node.right != null) {
                return node.right;
            } else {     //Cas no te fills
                return null;
            }
        }
    }

    public Node<K, V> minKey(Node<K, V> node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public int size() {
        return size(root);
    }

    private int size(Node<K, V> node) {
        if (node == null) {
            return 0;
        } else {
            return size(node.left) + size(node.right) + 1;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinkedBinarySearchTree<?, ?> that = (LinkedBinarySearchTree<?, ?>) o;
        return Objects.equals(root, that.root) &&
                Objects.equals(comparator, that.comparator);
    }
}




