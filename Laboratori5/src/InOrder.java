import java.util.ArrayList;

/**
 * @author Boris Llona Alonso
 * @author Flor Martinez Malaret
 */
public class InOrder{

    public static <K, V> ArrayList<Pair<K, V>> inorder(LinkedBinarySearchTree<K, V> tree) {
        ArrayList<Pair<K, V>> array = new ArrayList<>();
        LinkedStack<LinkedBinarySearchTree<K, V>> stack = new LinkedStack<>();
        stackLeft(stack, tree);
        while(!stack.isEmpty()) {
            LinkedBinarySearchTree<K, V> node = stack.top();
            stack.pop();
            stackLeft(stack, node.right());
            array.add(node.root());
        }
        return array;
    }

    private static <K, V> void stackLeft(LinkedStack<LinkedBinarySearchTree<K, V>> stack, LinkedBinarySearchTree<K, V> tree) {
        LinkedBinarySearchTree<K,V> node = tree;
        while(!node.isEmpty()) {
            stack.push(node);
            node = node.left();
        }
    }


}


