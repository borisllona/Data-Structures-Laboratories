/**
 * @author Boris Llona Alonso
 * @author Flor Martinez Malaret
 */

import java.util.ArrayList;
import java.util.Comparator;

public class HeapSort {

    private static class Heap<E> {

        private final ArrayList<E> elements;
        private final Comparator<? super E> comparator;
        private int heapSize = 0;

        /**
         * Constructor Heap
         * @param elements
         * @param comparator
         */
        private Heap(ArrayList<E> elements, Comparator<? super E> comparator) {
            this.elements = elements;
            this.comparator = comparator;
        }
        /**
         * El pare de un index el calculem restant-li un al index i dividint-lo entre 2, ja que, si és un numero parell
         * li restem 1 i dividim entre 2 i queda senar, pero al ser enter serà arrodonit retornant-nos la posició correcta
         * @param index
         * @return
         */
        private static int parent(int index) {
            return (index-1)/2;
        }
        /**
         * El fill esquerra de l'index es trobarà en la posició de l'index multiplicat per dos i sumant 1.
         * @param index
         * @return
         */
        private static int left(int index) {
            return index * 2 + 1;
        }
        /**
         * El fill esquerra de l'index es trobarà en la posició de l'index multiplicat per dos i sumant 2.
         * @param index
         * @return
         */
        private static int right(int index) {
            return index * 2 + 2;
        }
        /**
         * L'index tindrà fill esquerra si left(index) és mes petit que la mida del heap, ja que si és més gran o igual
         * no es trobarà dins del nostre arbre.
         * @param index
         * @return
         */
        private boolean hasLeft(int index) {
            return left(index) < heapSize;
        }
        /**
         * L'index tindrà fill dret si right(index) és mes petit que la mida del heap, ja que si és més gran o igual
         * no es trobarà dins del nostre arbre.
         * @param index
         * @return
         */
        private boolean hasRight(int index) {
            return right(index) < heapSize;
        }
        /**
         * Tot index diferent de l'arrel tindrà pare. Si no en te, voldra dir que es l'arrel.
         * @param index
         * @return
         */
        private boolean hasParent(int index) {
            return index != 0;
        }

        /**
         * A l'afegir un element al Heap hem de sumar un a heapSize.
         * @param elm
         */
        private  void addElement(E elm){
            heapSize++;
            pos(heapSize-1);
        }

        /**
         * Comprovem que l'element que hem afegit té pare i és més petit que el seu pare, si no ho és els intercambiem
         * @param inel
         */
        public void pos(int inel){
            while(hasParent(inel) && comparator.compare(elements.get(inel),elements.get(parent(inel))) > 0){
                swap(inel,parent(inel));
                inel = parent(inel);
            }
        }

        /**
         * A l'hora d'eliminar l'arrel l'hem d'intercanviar per l'ultim element del Heap restar 1 al heapSize
         * i reordenar tot l'arbre un altre cop.
         */
        public void deleteRoot(){
            swap(0,heapSize-1);
            heapSize--;

            E elm = elements.get(0);
            int indexparent = elements.indexOf(elm);
            while (hasLeft(indexparent) && comparator.compare(elements.get(left(indexparent)), elements.get(indexparent)) > 0 ||
                    hasRight(indexparent) && comparator.compare(elements.get(right(indexparent)), elements.get(indexparent)) > 0){
                if(hasLeft(indexparent) && hasRight(indexparent)){
                    int bigger = bigger(left(indexparent), right(indexparent));
                    swap(indexparent,bigger);
                    indexparent = bigger;
                }else if (hasLeft(indexparent)){
                    swap(indexparent,left(indexparent));
                    indexparent = left(indexparent);
                }else if(hasRight(indexparent)){
                    swap(indexparent,right(indexparent));
                    indexparent = right(indexparent);
                }
            }
        }

        /**
         * Aquest mètode intercanvia els elements que es troben en els index.
         * @param index1
         * @param index2
         */
        public void swap(int index1, int index2){
            E aux = elements.get(index1);
            elements.set(index1,elements.get(index2));
            elements.set(index2,aux);
        }

        /**
         * Comprova passant-li dos indexs, quin és el que té l'element més gran i el retorna.
         * @param index1
         * @param index2
         * @return
         */
        private int bigger(int index1, int index2) {
            if(comparator.compare(elements.get(index1), elements.get(index2))>0){
                return index1;
            } else {
                return index2;
            }
        }

    }

    public static <E> void sort(ArrayList<E> list, Comparator<? super E> cmp){
        Heap<E> heap = new Heap<>(list,cmp);
        for(int i = 0; i<list.size();i++){
            heap.addElement(list.get(i));
        }
        for(int i = 0; i<list.size();i++){
            heap.deleteRoot();
        }
    }

    public static <E extends Comparable<? super E>> void sort(ArrayList<E> list) {
        sort(list, new Comparator<E>(){
            public int compare(E o1, E o2) {
                return o1.compareTo(o2);
            }
        });
        //També podriem fer-ho per a java8 amb sort(list,Comparator.naturalOrder()), quedaría millor,
        //pero queda mes entendible pasarli un comparator  que utilitzara la funció anterior
    }
}