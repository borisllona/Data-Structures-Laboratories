/**
 * @author Boris Llona Alonso
 * @author Flor Martinez Malaret
 */
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class InOrderTest {
    private LinkedBinarySearchTree<Integer, Integer> intArbre;
    private LinkedBinarySearchTree<Integer, String> stringArbre;
    private ArrayList<Integer> intList;
    private ArrayList<Integer> stringList;
    private ArrayList<Pair<Integer,Integer>> intListordered;
    private ArrayList<Pair<Integer,String>> stringListordered;
    private final int X = 30; //Mida arbre

    @Before
    public void initial(){
        initialIntTree();
        initialStringTree();
    }

    public void initialIntTree(){

        //Creo un arbre binari de manera aleatoria
        intArbre = new LinkedBinarySearchTree<Integer, Integer>(Comparator.naturalOrder());
        intList = new ArrayList<>();
        intListordered = new ArrayList<>();

        for (int i=1; i<=X; i++) {
            intList.add(i);
            intListordered.add(new Pair<>(i,i*10));
        }

        Collections.shuffle(intList);

        for (int i = 0; i<X; i++){
            intArbre = intArbre.put(intList.get(i),intList.get(i)*10);
        }
    }
    public void initialStringTree(){

        stringArbre = new LinkedBinarySearchTree<Integer, String>(Comparator.naturalOrder());
        stringList = new ArrayList<>();
        stringListordered = new ArrayList<>();

        for (int i=1; i<=X; i++) {
            stringList.add(i);
            stringListordered.add(new Pair<>(i,String.valueOf(i*10)));
        }

        Collections.shuffle(stringList);

        for (int i = 0; i<X; i++){
            stringArbre = stringArbre.put(stringList.get(i),String.valueOf(stringList.get(i)*10));
        }
    }

    @Test
    public void testSize(){
        assertEquals(X,intArbre.size());
        assertEquals(X,stringArbre.size());
    }

    @Test
    public void inOrder(){
        //Test InOrder LinkedBinarySearchTree<Pair<Integer,Integer>>
        ArrayList<Pair<Integer, Integer>> ordered = InOrder.inorder(intArbre);
        assertTrue(intListordered.equals(ordered));
        //Test InOrder LinkedBinarySearchTree<Pair<Integer,String>>
        ArrayList<Pair<Integer, String>> ordered2 = InOrder.inorder(stringArbre);
        assertTrue(stringListordered.equals(ordered2));
    }


}

