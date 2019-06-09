/**
 * @author Boris Llona Alonso
 * @author Flor Martinez Malaret
 */

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Random;
import static org.junit.Assert.*;

/**
 * Creació de tests per comprovar que l'algoritme HeapSort funciona adequadament.
 * Treballem amb arrayList de tipus integer i String.
 */
public class HeapSortTest {
    private ArrayList arraybuit;
    private ArrayList arrayOrdenat;
    private ArrayList arrayInvertit;
    private ArrayList arrayFisher;
    private ArrayList arrayStringsDesord;
    private ArrayList arrayStringsOrdenat;
    private final int N = 10;

    @Before
    public void init(){
        arraybuit = new ArrayList();
        arrayOrdenat = new ArrayList();
        arrayInvertit = new ArrayList();
        arrayFisher = new ArrayList();
        arrayStringsDesord = new ArrayList();
        arrayStringsOrdenat = new ArrayList();


        crearArrayOrdenat();
        crearArrayOrdenatInv();
        crearArrayOrdenat(); //Omplenem l'array ordenat i el passem a la funcio crearShuffleArray per barrejarlo.
        crearShuffleArray(arrayOrdenat);
        crearArrayOrdenat(); //Tornem a ordenarlo
        crearStrings();

    }

    /**
     * Creació array ordenat
     */
    public void crearArrayOrdenat (){
        arrayOrdenat.clear();
        for(int i = 0; i < 10; i++){
            arrayOrdenat.add(i);
        }
    }

    /**
     * Creació array ordenat invertit
     */
    public void crearArrayOrdenatInv (){
        for(int n = 9 ; n >= 0; n--){
            arrayInvertit.add(n);
        }
    }

    /**
     * Array desordenar(Utilitzem l'algoritme de Fisher-Yates i desordenem un array ordenat)
     * @param array
     */
    public void crearShuffleArray (ArrayList<Integer> array){
        int index,temp;
        Random random = new Random();
        //A la i posem 10 perque nomes desordeni unes posicions de l'array
        for (int i = 5; i > 0; i--) {
            index = random.nextInt(i + 1);
            temp = array.get(index);
            array.set(index, array.get(i));
            array.set(i, temp);
        }
        arrayFisher = array;
    }
    public void crearStrings() {
        /**
         * Afegim elements al arraylist de strings ordenat per despres poder fer la comparació.
         */
        arrayStringsOrdenat.add("A");
        arrayStringsOrdenat.add("B");
        arrayStringsOrdenat.add("C");
        arrayStringsDesord.add("C");
        arrayStringsDesord.add("A");
        arrayStringsDesord.add("B");
    }
    /*public void printArray (ArrayList<Integer> array){
        Iterator<Integer> itr = array.iterator();
        while (itr.hasNext()) {
            int element = itr.next();
            System.out.print(element + " ");
        }
        System.out.println();
    }*/
    @Test
    public void sortllistavuida(){
        ArrayList arr = new ArrayList();
        HeapSort.sort(arraybuit);
        assertEquals(arr, arraybuit);
    }
    @Test
    public void sortArrayOrdenat(){
        HeapSort.sort(arrayOrdenat);
        assertEquals(arrayOrdenat, arrayOrdenat);
    }
    @Test
    public void sortArrayInvertit(){
        HeapSort.sort(arrayInvertit);
        assertEquals(arrayOrdenat, arrayInvertit);
    }
    @Test
    public void sortArrayFisher(){
        HeapSort.sort(arrayFisher);
        assertEquals(arrayOrdenat, arrayFisher);
    }
    @Test
    public void sortArrayStrings(){
        HeapSort.sort(arrayStringsDesord);
        assertEquals(arrayStringsOrdenat, arrayStringsDesord);
    }

}