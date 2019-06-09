import org.junit.Before
import org.junit.Assert
import org.junit.Test;

import java.util.Random;


class IntArraySorterTest extends GroovyTestCase {
    private int[] arrayordered = new int[50];
    private int[] arraydisordered = new int[50];
    private int[] arrayreverse = new int[50];
    private int[] arrayverydisordered = new int[50];
    private IntArraySorter sorter;

    @Test
    public void ordered(){
        for (int i=0;i<50;i++) {
            arrayordered[i] = i;
        }
    }
    @Test
    public void reverseOrdered(){
        int j=0;
        for (int i=50;i>0;i--) {
            arrayreverse[j] = i;
            j++;
        }
    }
    @Test
    public void disordered(){
        Random rand = new Random();
        for (int i=0;i<50;i++) {
            arraydisordered[i] = rand.nextInt(50) + 0;
        }
    }
    @Test
    public void veryDisordered(){
       Random rand = new Random();
        for (int i=0;i<50;i++) {  //Creem un array ordenat i la funció del algoritme de Fisher-Yates es desordenarlo
            arrayverydisordered[i] = i;
        }
        for (int i = arrayverydisordered.length-1;i>0;i--){
            int j = rand.nextInt(i);
            int temp = arrayverydisordered[j];              //Metodo de la burbuja
            arrayverydisordered[j]=arrayverydisordered[i];
            arrayverydisordered[i]=temp;
        }
    }
    @Test
    public void createArrays(){
        ordered();
        reverseOrdered();
        disordered();
        veryDisordered();
    }
    @Test
    public void testBubbleSort() {
        createArrays();
        System.out.print("\nBUBLE SORT: \n\n")
        testb(arrayordered);
        testb(arrayreverse);
        testb(arraydisordered);
        testb(arrayverydisordered);
    }
    @Test
    public void testSelectionSort() {
        createArrays();
        System.out.print("SELECTION SORT: \n\n")
        tests(arrayordered);
        tests(arrayreverse);
        tests(arraydisordered);
        tests(arrayverydisordered);
    }
    @Test
    public void testInsertionSort() {
        createArrays();
        System.out.print("\nINSERTION SORT: \n\n")
        testi(arrayordered);
        testi(arrayreverse);
        testi(arraydisordered);
        testi(arrayverydisordered);
    }
    @Test
    public void testb(int[] array){
        sorter = new IntArraySorter(array);
        sorter.bubbleSort();
        int comparisons = sorter.getNumComparisons();
        int swaps = sorter.getNumSwaps();
        System.out.printf("Canvis: %d Comparacions:%d \n",swaps,comparisons) ;
        assertTrue(sorter.isSorted());
    }
    @Test
    public void tests(int[] array){
        sorter = new IntArraySorter(array);
        sorter.selectionSort();
        int comparisons = sorter.getNumComparisons();
        int swaps = sorter.getNumSwaps();
        System.out.printf("Canvis: %d Comparacions:%d \n",swaps,comparisons) ;
        assertTrue(sorter.isSorted());
    }
    @Test
    public void testi(int[] array){
        sorter = new IntArraySorter(array);
        sorter.insertionSort();
        int comparisons = sorter.getNumComparisons();
        int swaps = sorter.getNumSwaps();
        System.out.printf("Canvis: %d Comparacions:%d \n",swaps,comparisons) ;
        assertTrue(sorter.isSorted());
    }

}
