import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    private static int i, j;
    private static int[] numeros;
    private static String line;

    public static void main(String[] args) {
        sort();
    }

    private static void sort() {

        //Introducir el array por teclado
        //int[] array = insertArray();
        //Introducir el array en el codigo
        int[] array = new int[]{3,2,1};

        IntArraySorter sorter = new IntArraySorter(array);

        //Metode amb el que es vol ordenar

        //sorter.insertionSort();
        //sorter.bubbleSort();
        sorter.selectionSort();

        //Comprovacions finals

        if (sorter.isSorted()) {
            System.out.printf("Esta ordenat, s'han fet %d canvis i %d comparacions", sorter.getNumSwaps(), sorter.getNumComparisons());
        } else {
            System.out.printf("No esta ordenat, s'han fet %d canvis i %d comparacions", sorter.getNumSwaps(), sorter.getNumComparisons());
        }
    }

    private static void printArray() {
        for (int j = 0; j < i; j++) {
            System.out.printf("%d", numeros[i]);
        }
        System.out.printf("Hi ha un total de %d numeros a ordenar", i);
    }

    private static int[] insertArray() {
        System.out.print("Introdueix els numeros a ordenar separats per comes: ");
        Scanner scanner = new Scanner(System.in);
        line = scanner.nextLine();
        StringTokenizer tokenizer = new StringTokenizer(line, ",");
        numeros = new int[tokenizer.countTokens()];
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            numeros[i] = Integer.parseInt(token);
            i++;
        }
        return numeros;
    }

}




