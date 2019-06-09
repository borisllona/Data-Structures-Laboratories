public class IntArraySorter {
    private final int[] array;
    private int numComparisons;
    private int numSwaps;

    public IntArraySorter(int[] array) {
        this.array = array;
    }

    public int getNumComparisons() {
        return numComparisons;
    }
    public int getNumSwaps() {
        return numSwaps;
    }

    public boolean isSorted() {
        for (int i = 0; i < array.length-1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public void swap(int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
        numSwaps += 1;
    }

    public boolean lessThanOrEqual(int i1, int i2) {
        numComparisons += 1;
        return i1 <= i2;
    }

    public void bubbleSort() {
        for(int s =0;s<array.length-1;s++){
            for (int i=array.length-1; i>s;i--){
                if(lessThanOrEqual(array[i],array[i-1])){
                    swap(i, i-1);
                }
            }
        }
    }

    public void selectionSort() {
        for (int s = 1; s < array.length; s++) {
            int menor = s - 1;
            for (int i = s; i < array.length; i++) {
                if (lessThanOrEqual(array[i], array[menor])) {
                    menor = i;             //Guardo el index de la posició del menor dins l'array, no del numero en si, ja que a la funció swap() ens interesa l'index.
                }
            }
            if(menor!=s-1) {
                swap(s - 1, menor);
            }
        }
    }

    public void insertionSort() {
        for (int s = 1; s < array.length; s++) {
            int insert = s;
            for (int i = s - 1; i >= 0; i--) {
                if (!lessThanOrEqual(array[i], array[insert])) {
                    swap(i, insert);
                    insert = i;
                } else {
                    break;
                }
            }
        }
    }
}


