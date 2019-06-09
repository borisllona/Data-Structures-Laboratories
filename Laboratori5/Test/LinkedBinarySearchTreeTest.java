/**
 * @author Boris Llona Alonso
 * @author Flor Martinez Malaret
 */
import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.*;

public class LinkedBinarySearchTreeTest {
    /**
     * Inicialitzem els arbres.
     */
    private LinkedBinarySearchTree<Integer,Integer> bst;
    private LinkedBinarySearchTree<Integer,Integer> bstnull;
    private LinkedBinarySearchTree<Integer,String> bsts;
    private LinkedBinarySearchTree<Integer,String> bstsnull;


    @Before
    public void initialize(){
        bst =  new LinkedBinarySearchTree<Integer, Integer>(Comparator.naturalOrder());
        bstnull = new LinkedBinarySearchTree<Integer, Integer>(Comparator.naturalOrder());
        bsts =  new LinkedBinarySearchTree<Integer,String>(Comparator.naturalOrder());
        bstsnull = new LinkedBinarySearchTree<Integer, String>(Comparator.naturalOrder());

        createIntBinaryTree();
        createStringBinaryTree();
    }

    public void createIntBinaryTree(){
       /*
           5
        /     \
       3        7
      /  \     /  \
     2   4    6    8    */

        bst = bst.put(5,50);
        bst = bst.put(3,30);
        bst = bst.put(2,20);
        bst = bst.put(4,40);
        bst = bst.put(7,70);
        bst = bst.put(6,60);
        bst = bst.put(8,80);
    }

    public void createStringBinaryTree(){
       /*
           "a"
        /     \
      "aa"     "ab"
      /  \     /  \
 "aaa"  "aab""aba" "abb"     */

        bsts = bsts.put(1,"a");
        bsts = bsts.put(2,"aa");
        bsts = bsts.put(3,"ab");
        bsts = bsts.put(4,"aaa");
        bsts = bsts.put(5,"aab");
        bsts = bsts.put(6,"aba");
        bsts = bsts.put(7,"abb");

    }
    @Test
    public void isEmpty() {
        assertTrue("Test With Tree complete",bstnull.isEmpty());
        assertFalse("Test with empty tree",bst.isEmpty());
    }

    @Test
    public void containsKey() {
        assertTrue("Test with key ",bst.containsKey(5));
        assertFalse("Test with empty tree",bstnull.containsKey(5));
    }

    @Test
    public void putIntegers() {
        LinkedBinarySearchTree<Integer,Integer> bstsaux = new LinkedBinarySearchTree<Integer, Integer>(Comparator.naturalOrder());
        assertEquals(bstsaux,bstnull);
        bstnull = bstnull.put(5,1999);
        assertNotEquals(bstsaux,bstnull);
        bstsaux = bstsaux.put(5,1999);
        assertEquals(bstsaux,bstnull);
    }
    @Test
    public void putStrings(){
        LinkedBinarySearchTree<Integer,String> bstsaux = new LinkedBinarySearchTree<Integer, String>(Comparator.naturalOrder());
        assertEquals(bstsaux,bstsnull);
        bstsnull = bstsnull.put(5,"Denmark");
        assertNotEquals(bstsaux,bstsnull);
        bstsaux = bstsaux.put(5,"Denmark");
        assertEquals(bstsaux,bstsnull);
    }
    @Test
    public void get() {
        int val1 = bst.get(5);
        int val2 =  bst. get(8);
        String vals1 = bsts.get(1);
        String vals2 = bsts.get(4);
        assertEquals(50,val1);
        assertEquals(80,val2);
        assertEquals("a",vals1);
        assertEquals("aaa",vals2);

    }

    @Test
    public void remove() {  //No va el remove
        LinkedBinarySearchTree<Integer,Integer> bstaux = new LinkedBinarySearchTree<Integer, Integer>(Comparator.naturalOrder());
       /*
           5
        /     \
       3        7
      /  \     /  \
     2   4    6       */

        bstaux = bstaux.put(5,50);
        bstaux= bstaux.put(3,30);
        bstaux = bstaux.put(2,20);
        bstaux = bstaux.put(4,40);
        bstaux = bstaux.put(7,70);
        bstaux = bstaux.put(6,60);

        //Borrar node sense fills
        bst = bst.remove(8);
        assertEquals(bstaux,bst);
        //Borrar node amb un fill
        bst = bst.remove(7);
        bstaux = bstaux.remove(7);
        assertEquals(bstaux,bst);
        //Borrar node amb dos fills
        bst = bst.remove(3);
        bstaux = bstaux.remove(3);
        assertEquals(bstaux,bst);

       /* Arbre resultant
              5
            /     \
           4        6
          /
         2
        */

    }
}


